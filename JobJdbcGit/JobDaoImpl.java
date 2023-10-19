package bitlabs123.jobportal_JDBC;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public int recruterLogin(String username, String password) throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from reg_table where username='"+username+"' and password='"+password+"'");
		if(rs.next())
		{
			
			return rs.getInt(1);
		}
		else {
		return 0;
		}
	}
	public void addRecruter(Recruter rec)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("insert into recruter_table values(?,?,?,?,?)");
		//pst.setInt(1,rec.getRid());
		pst.setString(2,rec.getName());
		pst.setString(3,rec.getCompany_name());
		pst.setString(4, rec.getDesignation());
		pst.setString(5, rec.getMail_ID());
		pst.setLong(6, rec.getMobile_number());
	
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("  signup successfully");
		}
		else
		{
			System.out.println("signup failed");
		}
	}
	public void addJobSeeker(JobSeeker jsk) throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("insert into jobseekertable values(?,?,?,?,?,?,?)");
		pst.setString(1, jsk.getJsname());
		pst.setString(2, jsk.getMail_ID());
		pst.setLong(3, jsk.getMobile_number());
		pst.setString(4, jsk.getKey_skills());
		pst.setInt(5,jsk.getAge());
		pst.setString(6,jsk.getEducation());
		pst.setString(7, jsk.getAddress());
	
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println(i+" jobseeker added successfully");
		}
		else
		{
			System.out.println("  failed");
		}
		//statement.executeUpdate("insert into jobseeker values(?,?,?,?,?,?,?)");
		
	}
	
	public void displayAllRecruters()throws SQLException{
		PreparedStatement pst=con.prepareStatement("select * from recrutertable");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			//int rid,String name,String company_name,String designation,String mail_ID,Long mobile_number
			System.out.println("Recruter_ID: "+rs.getInt("rid")+" Recruter name: "+rs.getString("company_name")+" Recruter mail_ID: "+rs.getString("mail_ID")+" Recruter mobile number: "+rs.getLong("mobile_number"));
		}
	}
	
	
	
	public void postJob(int rid,JobClass jc) throws SQLException

	{
		PreparedStatement pst=con.prepareStatement("insert into jobtable values(?,?,?,?,?,?,?,?,?,?,?,?)");
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
		pst.setInt(12, rid);
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
	
	
	//delete post usecases
	public void deletePost(int rid,int pid) throws SQLException
	{
		int i=statement.executeUpdate("delete * from jobtable where jobid='"+pid+"' and rid='"+rid+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	public void deletePost(int rid,String jrole)throws SQLException
	{
		int i=statement.executeUpdate("delete * from jobtable where jobrole='"+jrole+"' and rid='"+rid+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	public void deletePostL(int rid,String jlocation)throws SQLException
	{
		int i=statement.executeUpdate("delete * from jobtable where location='"+jlocation+"' and rid='"+rid+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	public void deletePostdate(int rid,String date)throws SQLException

	{
		int i=statement.executeUpdate("delete * from jobtable where postdate='"+date+"' and rid='"+rid+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	public void deleteAllPosts(int rid) throws SQLException
	{
		int i=statement.executeUpdate("delete * from jobtable where rid='"+rid+"'");
		if(i>0)
		{
			System.out.println(i+" posts are deleted successfully. ");
		}
		else 
		{
			System.out.println("there is no such posts");
		}
	}
	
	
	
	//update post details usecases
	public void updateRole(int rid,int postid, String urole)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set jobrole=? where jobid=? and rid=?");
		pst.setInt(1, postid);
		pst.setString(2, urole);
		pst.setInt(3,rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println(i+" post_role updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateLocation(int rid,int postid, String ulocation)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set location=? where jobid=? and rid=?");
		pst.setInt(1, postid);
		pst.setString(2, ulocation);
		pst.setInt(3, rid);
		int f=pst.executeUpdate();
		if(f>0)
		{
			System.out.println(f+" post location updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateExperience(int rid,int postid, String uexperience)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set experience=? where jobid=? and rid=?");
		pst.setInt(1, postid);
		pst.setString(2, uexperience);
		pst.setInt(3, rid);
		int g=pst.executeUpdate();
		if(g>0)
		{
			System.out.println(g+" post experience updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updatePostdate(int rid,int postid, String upostdate)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set postdate=? where jobid=? and rid=?");
		pst.setInt(1, postid);
		pst.setString(2, upostdate);
		pst.setInt(3, rid);
		int h=pst.executeUpdate();
		if(h>0)
		{
			System.out.println(h+" postdate updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateType_of_job(int rid,int postid, String utype_of_job)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set type_of_job=? where jobid=? and rid=?");
		pst.setInt(1, postid);
		pst.setString(2, utype_of_job);
		pst.setInt(3, rid);
		int j=pst.executeUpdate();
		if(j>0)
		{
			System.out.println(j+" post updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateDomain(int rid,int postid, String udomain)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobclass set jobdomain=? where jobid=? and rid=?");
		pst.setInt(1, postid);
		pst.setString(2, udomain);
		pst.setInt(3, rid);
		int k=pst.executeUpdate();
		if(k>0)
		{
			System.out.println(k+" post updated succesfully");
		}
		else
			System.out.println("update failed");
	}
	public void updateAllDetails(int rid,int postid,JobClass jc)throws SQLException
	{
		
		String updateQuery = "UPDATE jobclass SET companyname=?, jobrole=?, job_description=?, qualification=?, keyskill=?, location=?, experience=?, postdate=?, type_of_job=?, domain=? WHERE jobid=? and rid=?";
		PreparedStatement pst=con.prepareStatement(updateQuery);
		pst.setString(1,jc.getCompanyname());
		pst.setString(2,jc.getJobrole());
		pst.setString(3,jc.getJob_description());
		pst.setString(4,jc.getQualification());
		pst.setString(5,jc.getKeyskill());
		pst.setString(6, jc.getLocation());
		pst.setFloat(7,jc.getExperience());
		pst.setString(8, jc.getPostdate());
		pst.setString(9, jc.getType_of_job());
		pst.setString(10, jc.getDomain());
		pst.setInt(11,jc.getJobid());
		pst.setInt(12, rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println(i+" job updated successfully");
		}
		else
		{
			System.out.println(" job posting failed");
		}
		
		
	}
	
	
	
	
	//view posted jobs by recruter usecases
	public void displayByJobRole(int rid,String drole)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where jobrole='"+drole+"' and rid='"+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByCompanyName(int rid,String dcompany_name)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where company_name='"+dcompany_name+"' and rid='"+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,String qualification, String keyskill, String location,float experience,String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByJob_description(int rid,String djob_description)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where job_description='"+djob_description+"' and rid='"+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByQualification(int rid,String dqualification)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where qualification='"+dqualification+"'and rid='"+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByKeyskill(int rid,String dkeyskill)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where keyskill='"+dkeyskill+"' and rid='"+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByLocation(int rid,String dlocation)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where location='"+dlocation+"' and rid='"+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByExperience(int rid,String dexperience)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where experience='"+dexperience+"'and rid='"+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByPostdate(int rid,String dpostdate)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where postdate='"+dpostdate+"'and rid="+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByType_of_job(int rid,String dtype_of_job)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where type_of_job='"+dtype_of_job+"'and rid="+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}
	public void displayByDomain(int rid,String ddomain)throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from jobclass where domain='"+ddomain+"'rid='"+rid+"'");
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
	public void displayByJobid(int rid,String djobid)throws SQLException

	{
		ResultSet rs=statement.executeQuery("select * from jobclass where jobid='"+djobid+"'and rid='"+rid+"'");
		while(rs.next())
		{
			                       //int jobid,String companyname, String jobrole,String job_description,                                                     String qualification, String keyskill, String location,float experience,                          String postdate, String type_of_job, String domain
			System.out.println("JobId: "+rs.getInt(1)+" company name: "+rs.getString(2)+" jobrole:"+rs.getString(3)+" job_description:"+rs.getString(4)+" qualification:"+rs.getString(5)+" keyskill:"+rs.getString(6)+" location:"+rs.getString(7)+" experience:"+rs.getFloat(8)+" postdate:"+rs.getString(9)+" type_of_job"+rs.getString(10)+" domain"+rs.getString(11));
		}
	}

	//update recruter details usecases
	public void updateRname(int rid,String urname)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update recruter_table set name=? where rid=?");
		pst.setString(1,urname);
		pst.setInt(2, rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("name updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateRcompanyname(int rid, String urcompanyname)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update recruter_table set company_name=? where rid=?");
		pst.setString(1,urcompanyname);
		pst.setInt(2, rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("company name updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateRdesignation(int rid, String urdesignation)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update recruter_table set designation=? where rid=?");
		pst.setString(1,urdesignation);
		pst.setInt(2, rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("designation updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateRmail(int rid, String urmail)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update recruter_table set mail_ID=? where rid=?");
		pst.setString(1,urmail);
		pst.setInt(2, rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("mail-ID updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateRMobile(int rid, long urmobile)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update recruter_table set mobile_number=? where rid=?");
		pst.setLong(1,urmobile);
		pst.setInt(2, rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("mobile number updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateRAll_Details(int rid, Recruter rec)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update recruter_table set name=?,company_name=?,designation=?,mobile_number=? where rid=?");
		pst.setString(1, rec.getName());
		pst.setString(2,rec.getCompany_name());
		pst.setString(3, rec.getDesignation());
		pst.setLong(4,rec.getMobile_number());
		pst.setInt(5, rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("All details updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	//displaying applicants of the jobs
	public void viewApplicants(int rid)throws SQLException

	{
		String query="select js.jsname as applicant_name,j.jobrole as title from jobseekertable js join applied_jobs aj on js.jsid=aj.jsid join jobtable j on aj.jobid=j.jobid join recruter r on j.rid=r.rid where r.rid=?";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			System.out.println("title: "+rs.getString("title")+"Applicant: "+rs.getString("applicant_name"));
		}
	}
	
	
	public void deleteRecruter(int rid)throws SQLException
	{
		String query="delete * from recruter_table where rid=? ";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, rid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("account deleted successfully");
		}
		else
		{
			System.out.println("account deleting failed");
		}
	}
	
	
	
	
	
	//search the jobs by jobseeker usecases
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

	public void applyJob(int jsid, int jobid)throws SQLException{
		String query="insert into applied_jobs values(?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, jsid);
		pst.setInt(2, jobid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println(i+" job applied successfully");
		}
		else
		{
			System.out.println(" failed");
		}
	}
	public void deleteAppliedJob(int jsid, int djobid)throws SQLException
	{
		String query="delete * from applied_jobs where jsid=? and jobid=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, jsid);
		pst.setInt(2, djobid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println(i+" job deleted successfully");
		}
		else
		{
			System.out.println(" failed");
		}
	}
	public void viewAllAppliedJobs(int jsid)throws SQLException
	{
		String query="SELECT * FROM jobtable j JOIN applied_jobs aj ON j.job_id = aj.job_id JOIN jobseekertable js ON aj.jobseeker_id = js.jsid JOIN recruter r ON j.rid = r.rid WHERE js.jsid = ?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, jsid);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			System.out.println("jobID: "+rs.getInt("jobid")+" jobrole: "+rs.getString("jobrole")+" Company name: "+rs.getString("companyname")+" job_description: "+rs.getString("job_description")+" qualification: "+rs.getString("qualification")+" keyskill: "+rs.getString("keyskill")+" location: "+rs.getString("location")+" experience:"+rs.getFloat("experience")+" postdate: "+rs.getString("postdate")+" type_of_job: "+rs.getString("type_of_job")+" domain: "+rs.getString("domain"));
			
		}
	}
	
	//updating jobseeker details usecases
	
	public void updateJSName(int jsid, String ujsname)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobseekertable set jsname=? where jsid=?");
		pst.setString(1,ujsname);
		pst.setInt(2, jsid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("name updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateJSMail_Id(int jsid, String ujsmail)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobseekertable set mail_ID=? where jsid=?");
		pst.setString(1,ujsmail);
		pst.setInt(2, jsid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("mail updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateJSMobile(int jsid, long ujsmobile)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobseekertable set mobile_number=? where jsid=?");
		pst.setLong(1,ujsmobile);
		pst.setInt(2, jsid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("mobile number updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateJSKeyskills(int jsid, String ujskeyskills)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobseekertable set key_skills=? where jsid=?");
		pst.setString(1,ujskeyskills);
		pst.setInt(2, jsid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("key skills updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateJSAge(int jsid, int ujsage)throws SQLException{
		PreparedStatement pst=con.prepareStatement("update jobseekertable set age=? where jsid=?");
		pst.setInt(1,ujsage);
		pst.setInt(2, jsid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("age  updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateJSEducation(int jsid, String ujseducation)throws SQLException{
		PreparedStatement pst=con.prepareStatement("update jobseekertable set education=? where jsid=?");
		pst.setString(1,ujseducation);
		pst.setInt(2, jsid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("education updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
		
	}
	public void updateJSAddress(int jsid, String ujsaddress)throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("update jobseekertable set address=? where jsid=?");
		pst.setString(1,ujsaddress);
		pst.setInt(2, jsid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("Address updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	public void updateAllJobSeekerDetails(int jsid, String ujsname, String ujsmail, long ujsmobile, String ujskeyskills,
			int ujsage, String ujseducation, String ujsaddress)throws SQLException{
		PreparedStatement pst=con.prepareStatement("update jobseekertable set jsname=?,mail_ID=?,mobile_number=?,key_skills=?,age=?,education=?,address=? where jsid=?");
		pst.setString(1, ujsname);
		pst.setString(2, ujsmail);
		pst.setLong(3, ujsmobile);
		pst.setString(4, ujskeyskills);
		pst.setInt(5, ujsage);
		pst.setString(6, ujseducation);
		pst.setString(7,ujsaddress);
		
		pst.setInt(8, jsid);
		int i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("All details  updated successfully");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	
	
	public void updateExperience(int rid, int postid, float uexp) throws SQLException {
		
		
	}

	@Override
	public boolean AdminLogin(String jusername, String jpassword) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int jobseekerLogin(String jusername, String jpassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void displayByExperience(int rid, float dexp) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayByJobid(int rid, int djobid) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCompanyName(int rid, int postid, String ucompanyname) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateJob_Desc(int rid, int postid, String ujob_desc) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQualification(int rid, int postid, String uqualification) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateKeySkills(int rid, int postid, String ukeyskills) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
		
	}