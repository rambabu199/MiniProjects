package bitlabs123.patientJDBC;

import java.sql.SQLException;

public interface PatientDao  {
	
	void addPatient(int id,String name,String gender,int age,long mobile,String address,String date_of_joining) throws SQLException;	
	
	void dispalyAll() throws SQLException;
	
	void deletePatient(long dmobile)throws SQLException;
	
	void updateName(long umobile,String uname) throws SQLException;
	
	void updateAge(long umobile,int uage) throws SQLException;
	
	void updateMobile(long umobile, long updatedmobilenumber) throws SQLException;
	
	void updateGender(long umobile, String ugender) throws SQLException;
	
	void updateAddress(long umobile, String uaddress)throws SQLException;
	
	void updateDOJ(long umobile,String uDOJ) throws SQLException;
}
