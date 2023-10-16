package com.bitlabs.jobportaljdbc;

import java.sql.*;



public class JobDaoImpl implements JobDaoInterface {
	Connection con;
	Statement statement;
	public JobDaoImpl()
	{
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal","root","Rambabu@123$");
			statement=con.createStatement();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean recruterLogin(String username, String password) throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from reg_table where username='"+username+"' and password='"+password+"'");
		if(rs.next())
		{
			System.out.println("logined successfully");
			return true;
		}
		else {
		return false;
		}
	}
	public void postJob(JobClass jc) throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("insert into jobtable values(?,?,?,?,?,?,?,?,?,?,?)");
		pst.setInt(1, jc.getJobid());
		pst.setString(2, jc.getCompanyname());
		pst.setString(3, jc.getJobrole());
		pst.setString(4, jc.getJob_description());
		pst.setString(5,jc.getQualification());
		pst.setString(6,jc.getKeyskill());
		pst.setString(7, jc.getLocation());
		pst.setFloat(8,jc.getExperience());
		pst.setString(9, jc.getPostdate());
		pst.setString(10, jc.getType_of_job());
		pst.setString(11, jc.getDomain());
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println(i+" job posted successfully");
		}
		else
		{
			System.out.println(" job posting failed");
		}
		
	}
	public void deletePost(int pid) throws SQLException
	{
		int i=statement.executeUpdate("delete * from jobtable where jobid='"+pid+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	public void deletePost(String jrole)throws SQLException
	{
		int i=statement.executeUpdate("delete * from jobtable where jobrole='"+jrole+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	public void deletePostL(String jlocation)throws SQLException
	{
		int i=statement.executeUpdate("delete * from jobtable where location='"+jlocation+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	public void deletePostdate(String date)throws SQLException
	{
		int i=statement.executeUpdate("delete * from jobtable where postdate='"+date+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	public void updateRole(int postid, String urole)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set jobrole=? where jobid=?");
		pst.setInt(1, postid);
		pst.setString(2, urole);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println(i+" post updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateLocation(int postid, String ulocation)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set location=? where jobid=?");
		pst.setInt(1, postid);
		pst.setString(2, ulocation);
		int f=pst.executeUpdate();
		if(f>0)
		{
			System.out.println(f+" post updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateExperience(int postid, String uexperience)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set experience=? where jobid=?");
		pst.setInt(1, postid);
		pst.setString(2, uexperience);
		int g=pst.executeUpdate();
		if(g>0)
		{
			System.out.println(g+" post updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updatePostdate(int postid, String upostdate)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set postdate=? where jobid=?");
		pst.setInt(1, postid);
		pst.setString(2, upostdate);
		int h=pst.executeUpdate();
		if(h>0)
		{
			System.out.println(h+" post updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateType_of_job(int postid, String utype_of_job)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set type_of_job=? where jobid=?");
		pst.setInt(1, postid);
		pst.setString(2, utype_of_job);
		int j=pst.executeUpdate();
		if(j>0)
		{
			System.out.println(j+" post updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateDomain(int postid, String udomain)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set jobdomain=? where jobid=?");
		pst.setInt(1, postid);
		pst.setString(2, udomain);
		int k=pst.executeUpdate();
		if(k>0)
		{
			System.out.println(k+" post updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateAllDetails(int postid,JobClass jc)throws SQLException
	{
		//String companyname, String jobrole,String job_description, String qualification, String keyskill, String location,float experience, String postdate, String type_of_job, String domain
		String updateQuery = "UPDATE jobclass SET companyname=?, jobrole=?, job_description=?, qualification=?, keyskill=?, location=?, experience=?, postdate=?, type_of_job=?, domain=? WHERE jobid=?";
		
		//PreparedStatement pst=con.prepareStatement("update jobclass set companyname=?  where jobid=?");
	}
	
	
	
	
	
	public void displayByJobRole(String drole)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where jobrole='"+drole+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByCompanyName(String dcompany_name)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where company_name='"+dcompany_name+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,String qualification, String keyskill, String location,float experience,String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByJob_description(String djob_description)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where job_description='"+djob_description+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByQualification(String dqualification)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where qualification='"+dqualification+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByKeyskill(String dkeyskill)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where keyskill='"+dkeyskill+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByLocation(String dlocation)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where location='"+dlocation+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByExperience(String dexperience)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where experience='"+dexperience+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByPostdate(String dpostdate)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where postdate='"+dpostdate+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByType_of_job(String dtype_of_job)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where type_of_job='"+dtype_of_job+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByDomain(String ddomain)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where domain='"+ddomain+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayAll()throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass ");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByJobid(String djobid)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where jobid='"+djobid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchByJobRole(String jsjobrole)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where jobrole='"+jsjobrole+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchByKeyskills(String jskeyskill)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where keyskills='"+jskeyskill+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchByLocation(String jslocation)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where location='"+jslocation+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchByCompany(String jscompany)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where company='"+jscompany+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchBySalary(double jssalary)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where salary='"+jssalary+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchByJob_type(String jsjob_type)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where job_type='"+jsjob_type+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchByExperince(float jsExperince)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where Experince='"+jsExperince+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchByQualification(String jsqualification)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where qualification='"+jsqualification+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void searchByDate(String date)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where date='"+date+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}

	@Override
	public void displayByExperience(float dexp) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayByJobid(int djobid) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateExperience(int postid, float uexp) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
		
	}



	
	







