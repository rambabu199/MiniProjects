package bitlabs123.jobportal_JDBC;

import java.sql.SQLException;

public interface JobDaoInterface {
	void addJobSeeker(JobSeeker jsk) throws SQLException;

	void postJob(int rid, JobClass jc) throws SQLException;

	void deletePost(int rid, int pid) throws SQLException;

	void deletePost(int rid,String jrole)throws SQLException;

	void deletePostL(int rid,String jlocation)throws SQLException;

	void deletePostdate(int rid,String date)throws SQLException;

	void updateRole(int rid,int postid, String urole)throws SQLException;

	void displayByJobRole(int rid, String drole)throws SQLException;

	void displayByCompanyName(int rid, String cname)throws SQLException;

	void displayByJob_description(int rid, String jdes)throws SQLException;

	void displayByQualification(int rid,String qua)throws SQLException;

	void displayByKeyskill(int rid,String dkeyskills)throws SQLException;

	void displayByLocation(int rid,String dlocation)throws SQLException;

	void displayByExperience(int rid,float dexp)throws SQLException;

	void displayByPostdate(int rid,String dpostdate)throws SQLException;

	void displayByType_of_job(int rid,String dtypeofjob)throws SQLException;

	void displayByDomain(int rid,String ddomain)throws SQLException;

	void displayAll()throws SQLException;

	void displayByJobid(int rid,int djobid)throws SQLException;

	void searchByJobRole(String jsjobrole)throws SQLException;

	void searchByKeyskills(String jskeyskill)throws SQLException;

	void searchByLocation(String jslocation)throws SQLException;

	void searchByCompany(String jscompanyname)throws SQLException;

	void searchBySalary(double jssalary)throws SQLException;

	void searchByJob_type(String jsjobtype)throws SQLException;

	void searchByExperince(float jsexp)throws SQLException;

	void searchByQualification(String jsqualification)throws SQLException;

	void searchByDate(String jsdate)throws SQLException;

	void updateLocation(int rid,int postid, String ulocation)throws SQLException;

	void updateExperience(int rid,int postid, float uexp)throws SQLException;

	void updatePostdate(int rid,int postid, String udate)throws SQLException;

	void updateType_of_job(int rid,int postid, String utype)throws SQLException;

	void updateDomain(int rid,int postid, String udomain)throws SQLException;

	void updateAllDetails(int rid,int postid,JobClass jc)throws SQLException;

	int recruterLogin(String username, String password) throws SQLException;
	//boolean recruterLogin(String username, String password);

	boolean AdminLogin(String jusername, String jpassword)throws SQLException;

	int jobseekerLogin(String jusername, String jpassword)throws SQLException;

	void updateCompanyName(int rid, int postid, String ucompanyname)throws SQLException;

	void updateJob_Desc(int rid, int postid, String ujob_desc)throws SQLException;

	void updateQualification(int rid, int postid, String uqualification)throws SQLException;

	void updateKeySkills(int rid, int postid, String ukeyskills)throws SQLException;

	void deleteAllPosts(int rid) throws SQLException;

	void addRecruter(Recruter rec)throws SQLException;

	void updateRname(int rid, String urname)throws SQLException;

	void updateRcompanyname(int rid, String urcompanyname)throws SQLException;

	void updateRdesignation(int rid, String urdesignation)throws SQLException;

	void updateRMobile(int rid, long urmobile)throws SQLException;

	void updateRmail(int rid, String urmail)throws SQLException;

	void updateRAll_Details(int rid, Recruter rec)throws SQLException;

	void viewApplicants(int rid)throws SQLException;

	void deleteRecruter(int rid)throws SQLException;

	void applyJob(int jsid, int jobid)throws SQLException;

	void deleteAppliedJob(int jsid, int djobid)throws SQLException;

	void updateJSName(int jsid, String ujsname)throws SQLException;

	void updateJSMail_Id(int jsid, String ujsmail)throws SQLException;

	void updateJSMobile(int jsid, long ujsmobile)throws SQLException;

	void updateJSKeyskills(int jsid, String ujskeyskills)throws SQLException;

	void updateJSAge(int jsid, int ujsage)throws SQLException;

	void updateJSEducation(int jsid, String ujseducation)throws SQLException;

	void updateJSAddress(int jsid, String ujsaddress)throws SQLException;

	void updateAllJobSeekerDetails(int jsid, String ujsname, String ujsmail, long ujsmobile, String ujskeyskills,
			int ujsage, String ujseducation, String ujsaddress)throws SQLException;

	void viewAllAppliedJobs(int jsid)throws SQLException;

	void displayAllRecruters()throws SQLException;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}