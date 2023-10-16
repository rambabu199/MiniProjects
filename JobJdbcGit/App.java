package com.bitlabs.jobportaljdbc;

import java.sql.SQLException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
	JobDaoInterface jdi=new JobDaoImpl();
	/*public void loginModule()
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("welcome to jobportal  \n 1.signin  2.signup \n please enter choice ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("login as 1.recurter  2.job_seeker 3.Admin \n enter your choice");
			int ch=sc.nextInt();
			switch(ch) 
			{
			case 1:
				System.out.println("enter credentials to login");
				System.out.println("enter username");
				String username=sc.next();
				System.out.println("enter password");
				String password=sc.next();
				if(jdi.recruterLogin(username,password))
				{
					App a=new App();
					a.recruterMenu();
				}
				else
				{
					System.out.println("invalid userid or password");
				}
				break;
			case 2:
				System.out.println("enter credentials to login");
				System.out.println("enter username");
				String jusername=sc.next();
				System.out.println("enter password");
				String jpassword=sc.next();
				if(jdi.jobseekerLogin(jusername,jpassword))
				{
					App a1=new App();
					a1.jobSeekerMenu();
				}
				else
				{
					System.out.println("invalid userid or password");
				}
				break;
			case 3:
				System.out.println("enter credentials to login");
				System.out.println("enter username");
				String ausername=sc.next();
				System.out.println("enter password");
				String apassword=sc.next();
				if(jdi.AdminLogin(jusername,jpassword))
				{
					App a1=new App();
					a1.adminMenu();
				}
				else
				{
					System.out.println("invalid userid or password");
				}
				break;
			default:
				System.out.println("wrong choice");
				break;
			}
			break;
		case 2:
			System.out.println("signup as 1.recurter or 2.job_seeker \n enter your choice");
			int ch1=sc.nextInt();
			switch(ch1)
			{
			case 1:
				//String name,String company_name,String designation,String mail_ID,Long mobile_number
				System.out.println("enter your name");
				String rname=sc.nextLine();
				System.out.println("enter your company name");
				String companyName=sc.nextLine();
				System.out.println("enter your designation");
				String designation=sc.next();
				System.out.println("enter your mainId");
				String email=sc.next();
				System.out.println("enter mobile number");
				long mobile=sc.nextLong();
				
			}
			
		}
		
		
	}*/
    private void jobSeekerMenu() throws SQLException {
    	Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
    	System.out.println("welcome to jobseeker module 1.search jobs \n 2.apply \n 3.save jobs \n 4.delete jobs \n enter your choice");
    	int ch=sc.nextInt();
    	switch(ch)
    	{
    		case 1:
    			System.out.println("search by(1.jobrole 2.keyskills 3.location 4.company ) \n enter your choice");
    			int cho=sc.nextInt();
    			switch(cho)
    			{
    				case 1:
    					System.out.println("enter jobrole");
    					String jsjobrole=sc.next();
    					jdi.searchByJobRole(jsjobrole);
    					break;
    				case 2:
    					System.out.println("enter key skill");
    					String jskeyskill=sc.next();
    					jdi.searchByKeyskills(jskeyskill);
    					break;
    				case 3:
    					System.out.println("enter location");
    					String jslocation=sc.next();
    					jdi.searchByLocation(jslocation);
    					break;
    				case 4:
    					System.out.println("enter company name");
    					String jscompanyname=sc.next();
    					jdi.searchByCompany(jscompanyname);
    					break;
    				case 5:
    					System.out.println("enter salary");
    					double jssalary=sc.nextDouble();
    					jdi.searchBySalary(jssalary);
    					break;
    				case 6:
    					System.out.println("enter jobtype");
    					String jsjobtype=sc.next();
    					jdi.searchByJob_type(jsjobtype);
    					break;
    				case 7:
    					System.out.println("enter experience");
    					float jsexp = sc.nextFloat();
    					jdi.searchByExperince(jsexp);
    					break;
    				case 8:
    					System.out.println("enter qualification");
    					String jsqualification=sc.next();
    					jdi.searchByQualification(jsqualification);
    					break;
    				case 9:
    					System.out.println("enter date");
    					String jsdate=sc.next();
    					jdi.searchByDate(jsdate);
    					break;
    				default:
    					System.out.println("wrong choice");
    					break;
    					
    			}
    	}
		
	}
	private void adminMenu() {
		// TODO Auto-generated method stub
		
	}      
//	private void recruterMenu() {
		// TODO Auto-generated method stub
		
	//}
	public void recruterMenu() throws SQLException {
		Scanner sc=new Scanner(System.in);
		JobClass jc=new JobClass();
		
		System.out.println("elcome to recruter Menu \n 1.post a job 2.update  job details \n 3.delete post \n 4.view post \n please enter your choice");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("enter jobId");
			int id=sc.nextInt();
			jc.setJobid(id);
			System.out.println("enter job role");
			String role=sc.next();
			jc.setJobrole(role);
			System.out.println("enter company name");
			String company_name=sc.nextLine();
			jc.setCompanyname(company_name);
			sc.nextLine();
			System.out.println("enter Job description");
			String description=sc.nextLine();
			jc.setJob_description(description);
			sc.nextLine();
			System.out.println("enter required qualification");
			String qualification=sc.nextLine();
			jc.setQualification(qualification);
			sc.nextLine();
			System.out.println("enter required key skills");
			String keyskills=sc.nextLine();
			jc.setKeyskill(keyskills);
			sc.nextLine();
			System.out.println("enter work location");
			String location=sc.nextLine();
			jc.setLocation(location);
			sc.nextLine();
			System.out.println("enter required experince");
			float experince=sc.nextFloat();
			jc.setExperience(experince);
			System.out.println("enter post date");
			String postdate=sc.next();
			jc.setPostdate(postdate);
			System.out.println("enter type of job(full time/part time)");
			String typeofjob=sc.next();
			jc.setType_of_job(typeofjob);
			System.out.println("enter domain(IT/non-IT)");
			String domain=sc.next();
			jc.setDomain(domain);
			jdi.postJob(jc);
			break;
		case 2:
			System.out.println("enter post id");
			int postid=sc.nextInt();
			System.out.println("what do tou want to update in the post \n 1.jobrole \t 2.company_name \t 3.job_description \t 4.qualification \n 5.keyskill \t 6.location \t 7.experience \t 8.postdate \t 9.type_of_job \t  10.domain \t 11. entire post \n enter your choice");
			int ch2=sc.nextInt();
			switch(ch2)
			{
				case 1:
					System.out.println("enter updated jobrole");
					String urole=sc.nextLine();
					jdi.updateRole(postid,urole);
					break;
				case 2:
					System.out.println("enter updated location");
					String ulocation=sc.next();
					jdi.updateLocation(postid,ulocation);
					break;
				case 3:
					System.out.println("enter updated experience");
					float uexp=sc.nextFloat();
					jdi.updateExperience(postid,uexp);
					break;
				case 4:
					System.out.println("enter updated post date");
					String udate=sc.next();
					jdi.updatePostdate(postid,udate);
					break;
				case 5:
					System.out.println("enter updated type of job");
					String utype=sc.next();
					jdi.updateType_of_job(postid,utype);
					break;
				case 6:
					System.out.println("enter updated domian");
					String udomain=sc.next();
					jdi.updateDomain(postid,udomain);
					break;
				case 7:
					System.out.println("enter jobId");
					int uid=sc.nextInt();
					jc.setJobid(uid);
					System.out.println("enter job role");
					String uprole=sc.next();
					jc.setJobrole(uprole);
					System.out.println("enter company name");
					String ucompany_name=sc.nextLine();
					jc.setCompanyname(ucompany_name);
					sc.nextLine();
					System.out.println("enter Job description");
					String udescription=sc.nextLine();
					jc.setJob_description(udescription);
					sc.nextLine();
					System.out.println("enter required qualification");
					String uqualification=sc.nextLine();
					jc.setQualification(uqualification);
					sc.nextLine();
					System.out.println("enter required key skills");
					String ukeyskills=sc.nextLine();
					jc.setKeyskill(ukeyskills);
					sc.nextLine();
					System.out.println("enter work location");
					String uplocation=sc.nextLine();
					jc.setLocation(uplocation);
					sc.nextLine();
					System.out.println("enter required experince");
					float upexperince=sc.nextFloat();
					jc.setExperience(upexperince);
					System.out.println("enter post date");
					String uppostdate=sc.next();
					jc.setPostdate(uppostdate);
					System.out.println("enter type of job(full time/part time)");
					String uptypeofjob=sc.next();
					jc.setType_of_job(uptypeofjob);
					System.out.println("enter domain(IT/non-IT)");
					String updomain=sc.next();
					jc.setDomain(updomain);
					jdi.updateAllDetails(postid,jc);
					break;
					
					
					
					
				
			}
		case 3:
			System.out.println("do you want to delete by \n 1. postID  2. Job role 3.location 4.postdate  \n enter your choice");
			int ch1=sc.nextInt();
			switch(ch1)
			{
			case 1:
				System.out.println("enter post id");
				int pid=sc.nextInt();
				jdi.deletePost(pid);
				break;
			case 2:
				System.out.println("enter jobrole");
				String jrole=sc.next();
				jdi.deletePost(jrole);
				break;
			case 3:
				System.out.println("enter location");
				String jlocation=sc.next();
				jdi.deletePostL(jlocation);
				break;
			case 4:
				System.out.println("enter postdate");
				String date=sc.next();
				jdi.deletePostdate(date);
				break;
			default:
				System.out.println("wrong choice");
				break;					
				
			}
			break;
		case 4:
			System.out.println("view by  1.jobrole \\t 2.company_name \\t 3.job_description \\t 4.qualification \\n 5.keyskill \\t 6.location \\t 7.experience \\t 8.postdate \\t 9.type_of_job \\t  10.domain \\t 11. entire post 12.jobid \\n enter your choice");
			int ch4=sc.nextInt();
			switch(ch4)
			{
				case 1:
					System.out.println("enter jobrole");
					String drole=sc.next();
					jdi.displayByJobRole(drole);
					break;
				case 2:
					System.out.println("enter companyname");
					String cname=sc.next();
					jdi.displayByCompanyName(cname);
					break;
				case 3:
					System.out.println("enter job_description");
					String jdes=sc.nextLine();
					jdi.displayByJob_description(jdes);
					break;
				case 4:
					System.out.println("enter qualification");
					String qua=sc.nextLine();
					jdi.displayByQualification(qua);
					break;
				case 5:
					System.out.println("enter keyskills");
					String dkeyskills=sc.nextLine();
					jdi.displayByKeyskill(dkeyskills);
					break;
				case 6:
					System.out.println("enter location");
					String dlocation=sc.nextLine();
					jdi.displayByLocation(dlocation);
					break;
				case 7:
					System.out.println("enter Experience");
					float dexp=sc.nextFloat();
					jdi.displayByExperience(dexp);
					break;
				case 8:
					System.out.println("enter postdate");
					String dpostdate=sc.next();
					jdi.displayByPostdate(dpostdate);
					break;
				case 9:
					System.out.println("enter type of job");
					String dtypeofjob=sc.next();
					jdi.displayByType_of_job(dtypeofjob);
					break;
				case 10:
					System.out.println("enter type of domain");
					String ddomain=sc.next();
					jdi.displayByDomain(ddomain);
					break;
				case 11:
					jdi.displayAll();
					break;
				case 12:
					System.out.println("enter jobid");
					int djobid=sc.nextInt();
					jdi.displayByJobid(djobid);
					break;
				default:
					System.out.println("wrong choice");
					break;
				}
			
			
			
			
			
			
			
		}
		
		
		
		
		
	}

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
