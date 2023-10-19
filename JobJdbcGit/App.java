package bitlabs123.jobportal_JDBC;

import java.sql.SQLException;
import java.util.*;


public class App 
 {
		JobDaoInterface jdi=new JobDaoImpl();
		JobSeeker jsk=new JobSeeker();
		Recruter rec=new Recruter();
		public void loginModule() throws SQLException

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
					 int rid=jdi.recruterLogin(username,password);
					if(rid>0)
					{
						System.out.println("logined successfully");
						App a=new App();
						a.recruterMenu(rid);
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
					int jid=jdi.jobseekerLogin(jusername,jpassword);
					if(jid>0)
					{
						App a1=new App();
						a1.jobSeekerMenu(jid);
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
					if(jdi.AdminLogin(ausername,apassword))
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
					
					System.out.println("enter your name");
					String rname=sc.nextLine();
					rec.setName(rname);
					System.out.println("enter your company name");
					String companyName=sc.nextLine();
					rec.setCompany_name(companyName);
					System.out.println("enter your designation");
					String designation=sc.next();
					rec.setDesignation(designation);
					System.out.println("enter your mailId");
					String email=sc.next();
					rec.setMail_ID(email);
					System.out.println("enter mobile number");
					long mobile=sc.nextLong();
					rec.setMobile_number(mobile);
					jdi.addRecruter(rec);
					break;
				case 2:
			 
					System.out.println("enter your name");
					String jsname=sc.nextLine();
					jsk.setJsname(jsname);
					System.out.println("enter your mailId");
					String jemail=sc.next();
					jsk.setMail_ID(jemail);
					System.out.println("enter mobile number");
					long jmobile=sc.nextLong();
					jsk.setMobile_number(jmobile);
					System.out.println("enter your key skills");
					String jskeyskills=sc.nextLine();
					jsk.setKey_skills(jskeyskills);
					System.out.println("enter your age");
					int jsage=sc.nextInt();
					jsk.setAge(jsage);
					System.out.println("enter your education qualification");
					String jsqua=sc.nextLine();
					jsk.setEducation(jsqua);
					System.out.println("enter your address");
					String jsaddress=sc.nextLine();
					jsk.setAddress(jsaddress);
					jdi.addJobSeeker(jsk);
					break;
					
					
				}
				
			}
			sc.close();
			
		}
	    private void adminMenu() {
			
			
		}
		public void jobSeekerMenu(int jsid) throws SQLException {
	    	Scanner sc=new Scanner(System.in);
	    	
	    	System.out.println("welcome to jobseeker module 1.search jobs \n 2.apply  \n 3.delete applied jobs \n 4.update profile \n 5.view applied jobs \n enter your choice");
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
	    		case 2:
	    			System.out.println("enter jobid to apply");
	    			int jobid=sc.nextInt();
	    			jdi.applyJob(jsid,jobid);
	    			break;
	    		case 3:
	    			System.out.println("enter jobid to delete");
	    			int djobid=sc.nextInt();
	    			jdi.deleteAppliedJob(jsid,djobid);
	    			break;
	    		case 4:
	    			
	    			System.out.println("what dou you want to update \n 1.name \n 2.mail_ID \n 3.mobilenumber  \n 4.keyskills \n 5.age \n 6.education \n 7.address \n 8. All details \n enter your choice");
	    			int ch6=sc.nextInt();
	    			switch(ch6)
	    			{
	    				case 1:
	    					System.out.println("enter updated name");
	    					String ujsname=sc.next();
	    					jdi.updateJSName(jsid,ujsname);
	    					break;
	    				case 2:
	    					System.out.println("enter updated mail_id");
	    					String ujsmail=sc.next();
	    					jdi.updateJSMail_Id(jsid,ujsmail);
	    					break;
	    				case 3:
	    					System.out.println("enter updated mobile number");
	    					long ujsmobile=sc.nextLong();
	    					jdi.updateJSMobile(jsid,ujsmobile);
	    					break;
	    				case 4:
	    					System.out.println("enter updated keyskills");
	    					String ujskeyskills=sc.nextLine();
	    					jdi.updateJSKeyskills(jsid,ujskeyskills);
	    					break;
	    				case 5:
	    					System.out.println("enter updated age");
	    					int ujsage=sc.nextInt();
	    					jdi.updateJSAge(jsid,ujsage);
	    					break;
	    				case 6:
	    					System.out.println("enter updated education");
	    					String ujseducation=sc.next();
	    					jdi.updateJSEducation(jsid,ujseducation);
	    					break;
	    				case 7:
	    					System.out.println("enter updated address");
	    					String ujsaddress=sc.nextLine();
	    					jdi.updateJSAddress(jsid,ujsaddress);
	    					break;
	    				case 8:
	    					System.out.println("enter updated name");
	    					 ujsname=sc.next();
	    					System.out.println("enter updated mail_id");
	    					 ujsmail=sc.next();
	    					System.out.println("enter updated mobile number");
	    					ujsmobile=sc.nextLong();
	    					System.out.println("enter updated keyskills");
	    					 ujskeyskills=sc.nextLine();
	    					System.out.println("enter updated age");
		    				ujsage=sc.nextInt();
		    				System.out.println("enter updated education");
	    					ujseducation=sc.next();
	    					System.out.println("enter updated address");
	    					ujsaddress=sc.nextLine();
	    					jdi.updateAllJobSeekerDetails(jsid,ujsname,ujsmail,ujsmobile,ujskeyskills,ujsage,ujseducation,ujsaddress);
	    					break;
	    				default:
	    					System.out.println("wrong choice");
	    			}
	    			break;
	    		case 5:
	    			jdi.viewAllAppliedJobs(jsid);
	    			break;
	    		default:
	    			System.out.println("wrong choice");
	    			break;
	    			
	    	}
	    	sc.close();
			
		}
		//private void adminMenu() {
			
			
		//}      
//		private void recruterMenu() {
			
			
		//}
		public void recruterMenu(int rid) throws SQLException {
			Scanner sc=new Scanner(System.in);
			JobClass jc=new JobClass();
			
			
			System.out.println("Welcome to recruter Menu \n 1.post a job \n 2.update  job details \n 3.delete post \n 4.view post  \n 5. update profile \n 6. view applicants \n 7.delete profile \n please enter your choice");
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
				jdi.postJob(rid,jc);
				break;
			case 2:
				System.out.println("enter post id");
				int postid=sc.nextInt();
				System.out.println("what do tou want to update in the post \n 1.jobrole \t 2.company_name \t 3.job_description \t 4.qualification \n 5.keyskill \t 6.location \t 7.experience \t 8.postdate \t 9.type_of_job \t  10.domain \t 11. updateAll post_details \n enter your choice");
				int ch2=sc.nextInt();
				switch(ch2)
				{
					case 1:
						System.out.println("enter updated jobrole");
						String urole=sc.nextLine();
						jdi.updateRole(rid,postid,urole);
						break;
					case 2:
						System.out.println("enter updated company name");
						String ucompanyname=sc.next();
						jdi.updateCompanyName(rid,postid,ucompanyname);
						break;
					case 3:
						System.out.println("enter updated job_description");
						String ujob_desc=sc.next();
						jdi.updateJob_Desc(rid,postid,ujob_desc);
						break;
					case 4:
						System.out.println("enter updated qualification");
						String uqualification=sc.next();
						jdi.updateQualification(rid,postid,uqualification);
						break;
					case 5:
						System.out.println("enter updated key skills");
						String ukeyskills=sc.next();
						jdi.updateKeySkills(rid,postid,ukeyskills);
						break;						
						
					case 6:
						System.out.println("enter updated location");
						String ulocation=sc.next();
						jdi.updateLocation(rid,postid,ulocation);
						break;
					case 7:
						System.out.println("enter updated experience");
						float uexp=sc.nextFloat();
						jdi.updateExperience(rid,postid,uexp);
						break;
					case 8:
						System.out.println("enter updated post date");
						String udate=sc.next();
						jdi.updatePostdate(rid,postid,udate);
						break;
					case 9:
						System.out.println("enter updated type of job");
						String utype=sc.next();
						jdi.updateType_of_job(rid,postid,utype);
						break;
					case 10:
						System.out.println("enter updated domian");
						String udomain=sc.next();
						jdi.updateDomain(rid,postid,udomain);
						break;
					case 11:
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
						String uaqualification=sc.nextLine();
						jc.setQualification(uaqualification);
						sc.nextLine();
						System.out.println("enter required key skills");
						String uakeyskills=sc.nextLine();
						jc.setKeyskill(uakeyskills);
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
						jdi.updateAllDetails(rid,postid,jc);
						break;
						}
				break;
			case 3:
				System.out.println("do you want to delete by \n 1. postID  2. Job role 3.location 4.postdate 5.delete all posts \n enter your choice");
				int ch1=sc.nextInt();
				switch(ch1)
				{
				case 1:
					System.out.println("enter post id");
					int pid=sc.nextInt();
					jdi.deletePost(rid,pid);
					break;
				case 2:
					System.out.println("enter jobrole");
					String jrole=sc.next();
					jdi.deletePost(rid,jrole);
					break;
				case 3:
					System.out.println("enter location");
					String jlocation=sc.next();
					jdi.deletePostL(rid,jlocation);
					break;
				case 4:
					System.out.println("enter postdate");
					String date=sc.next();
					jdi.deletePostdate(rid,date);
					break;
				case 5:
					jdi.deleteAllPosts(rid);
					break;
				default:
					System.out.println("wrong choice");
					break;					
					
				}
				break;
			case 4:
				System.out.println("view by  1.jobrole \\t 2.company_name \\t 3.job_description \\t 4.qualification \\n 5.keyskill \\t 6.location \\t 7.experience \\t 8.postdate \\t 9.type_of_job \\t  10.domain \\t 11. all posts \t 12.jobid \\n enter your choice");
				int ch4=sc.nextInt();
				switch(ch4)
				{
					case 1:
						System.out.println("enter jobrole");
						String drole=sc.next();
						jdi.displayByJobRole(rid,drole);
						break;
					case 2:
						System.out.println("enter companyname");
						String cname=sc.next();
						jdi.displayByCompanyName(rid,cname);
						break;
					case 3:
						System.out.println("enter job_description");
						String jdes=sc.nextLine();
						jdi.displayByJob_description(rid,jdes);
						break;
					case 4:
						System.out.println("enter qualification");
						String qua=sc.nextLine();
						jdi.displayByQualification(rid,qua);
						break;
					case 5:
						System.out.println("enter keyskills");
						String dkeyskills=sc.nextLine();
						jdi.displayByKeyskill(rid,dkeyskills);
						break;
					case 6:
						System.out.println("enter location");
						String dlocation=sc.nextLine();
						jdi.displayByLocation(rid,dlocation);
						break;
					case 7:
						System.out.println("enter Experience");
						float dexp=sc.nextFloat();
						jdi.displayByExperience(rid,dexp);
						break;
					case 8:
						System.out.println("enter postdate");
						String dpostdate=sc.next();
						jdi.displayByPostdate(rid,dpostdate);
						break;
					case 9:
						System.out.println("enter type of job");
						String dtypeofjob=sc.next();
						jdi.displayByType_of_job(rid,dtypeofjob);
						break;
					case 10:
						System.out.println("enter type of domain");
						String ddomain=sc.next();
						jdi.displayByDomain(rid,ddomain);
						break;
					case 11:
						jdi.displayAll();
						break;
					case 12:
						System.out.println("enter jobid");
						int djobid=sc.nextInt();
						jdi.displayByJobid(rid,djobid);
						break;
					default:
						System.out.println("wrong choice");
						break;
					}
				break;
			case 5:
				//String name,String company_name,String designation,String mail_ID,Long mobile_number
				System.out.println("what do you want to update in your profile:\n 1.name \n 2. company name \n 3.designation \n 4.mail_ID \n 5.mobile_number \n 6.All details \n enter your choice");
				int ch5=sc.nextInt();
				switch(ch5)
				{
					case 1:
						System.out.println("enter updated name");
						String urname=sc.next();
						jdi.updateRname(rid,urname);
						break;
					case 2:
						System.out.println("enter updated company_name");
						String urcompanyname=sc.next();
						jdi.updateRcompanyname(rid,urcompanyname);
						break;
					case 3:
						System.out.println("enter updated designation");
						String urdesignation=sc.next();
						jdi.updateRdesignation(rid,urdesignation);
						break;
					case 4:
						System.out.println("enter updated mail_ID");
						String urmail=sc.next();
						jdi.updateRmail(rid,urmail);
						break;
					case 5:
						System.out.println("enter updated mobile number");
						long urmobile=sc.nextLong();
						jdi.updateRMobile(rid,urmobile);
						break;
					case 6:
						System.out.println("enter your name");
						String rname=sc.nextLine();
						rec.setName(rname);
						System.out.println("enter your company name");
						String companyName=sc.nextLine();
						rec.setCompany_name(companyName);
						System.out.println("enter your designation");
						String designation=sc.next();
						rec.setDesignation(designation);
						System.out.println("enter your mailId");
						String email=sc.next();
						rec.setMail_ID(email);
						System.out.println("enter mobile number");
						long mobile=sc.nextLong();
						rec.setMobile_number(mobile);
						jdi.updateRAll_Details(rid,rec);
						break;
					default:
						System.out.println("wrong choice");
				}
				break;
			case 6:
				System.out.println("displaying the applicants");
				jdi.viewApplicants(rid);
				break;
			case 7:
				jdi.deleteRecruter(rid);
				break;
			default:
				System.out.println("wrong choice");
				break;
			
			}		
			
			
			sc.close();
			
		}

	    public static void main( String[] args ) throws SQLException
	    {
	       // System.out.println( "welcome to jobportal" );
	        App a=new App();
	        a.loginModule();
	    }
	}

