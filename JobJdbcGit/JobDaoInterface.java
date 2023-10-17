package com.bitlabs.jobportaljdbc;

import java.sql.SQLException;

public interface JobDaoInterface {
	void addJobSeeker(JobSeeker jsk) throws SQLException;

	void postJob(JobClass jc) throws SQLException;

	void deletePost(int pid) throws SQLException;

	void deletePost(String jrole)throws SQLException;

	void deletePostL(String jlocation)throws SQLException;

	void deletePostdate(String date)throws SQLException;

	void updateRole(int postid, String urole)throws SQLException;

	void displayByJobRole(String drole)throws SQLException;

	void displayByCompanyName(String cname)throws SQLException;

	void displayByJob_description(String jdes)throws SQLException;

	void displayByQualification(String qua)throws SQLException;

	void displayByKeyskill(String dkeyskills)throws SQLException;

	void displayByLocation(String dlocation)throws SQLException;

	void displayByExperience(float dexp)throws SQLException;

	void displayByPostdate(String dpostdate)throws SQLException;

	void displayByType_of_job(String dtypeofjob)throws SQLException;

	void displayByDomain(String ddomain)throws SQLException;

	void displayAll()throws SQLException;

	void displayByJobid(int djobid)throws SQLException;

	void searchByJobRole(String jsjobrole)throws SQLException;

	void searchByKeyskills(String jskeyskill)throws SQLException;

	void searchByLocation(String jslocation)throws SQLException;

	void searchByCompany(String jscompanyname)throws SQLException;

	void searchBySalary(double jssalary)throws SQLException;

	void searchByJob_type(String jsjobtype)throws SQLException;

	void searchByExperince(float jsexp)throws SQLException;

	void searchByQualification(String jsqualification)throws SQLException;

	void searchByDate(String jsdate)throws SQLException;

	void updateLocation(int postid, String ulocation)throws SQLException;

	void updateExperience(int postid, float uexp)throws SQLException;

	void updatePostdate(int postid, String udate)throws SQLException;

	void updateType_of_job(int postid, String utype)throws SQLException;

	void updateDomain(int postid, String udomain)throws SQLException;

	void updateAllDetails(int postid,JobClass jc,int rid)throws SQLException;

	//boolean recruterLogin(String username, String password) throws SQLException;
	//boolean recruterLogin(String username, String password);

	//boolean AdminLogin(String jusername, String jpassword);

	//boolean jobseekerLogin(String jusername, String jpassword);


}
