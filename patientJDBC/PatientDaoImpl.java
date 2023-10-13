package bitlabs123.patientJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDaoImpl implements PatientDao {
	Connection con;
	Statement statement;
	public PatientDaoImpl() throws ClassNotFoundException, SQLException
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patient","root","sespl!@3");
		 statement=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void addPatient(int id,String name,String gender,int age,long mobile,String address,String date_of_joining) throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
		pst.setInt(1,id );
		pst.setString(2, name);
		pst.setString(3, gender);
		pst.setInt(4,age);
		pst.setLong(5, mobile);
		pst.setString(6,address);
		pst.setString(7, date_of_joining);
		int i=pst.executeUpdate();
		System.out.println(i+" row(s) are inserted ");
	}
	public void dispalyAll() throws SQLException
	{
		ResultSet rs=statement.executeQuery("select * from patient");
		while(rs.next())
		{
			System.out.println("id: "+rs.getInt(1)+" name:"+rs.getString(2)+" gender:"+rs.getString(3)+" age:"+rs.getInt(4)+" mobile:"+rs.getLong(5)+" address:"+rs.getString(6)+" date of joining:"+rs.getString(7));
		}
		
	}
	public void deletePatient(long dmobile) throws SQLException
	{
		int i=statement.executeUpdate("delete from patient where mobile='"+dmobile+"'");
		System.out.println(i+" rows are effected");
	}
	public void updateName(long umobile,String uname) throws SQLException
	{
		String sql = "UPDATE patient SET name = ? WHERE mobile = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, uname);
		preparedStatement.setLong(2, umobile);
		preparedStatement.executeUpdate();
		System.out.println("name updated successfully ");

		//statement.executeUpdate("update patient set name='"+uname+"' where mobile='"+umobile+"'");
	}
	public void updateAge(long umobile,int uage) throws SQLException
	{
		String sql = "UPDATE patient SET age = ? WHERE mobile = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, uage);
		preparedStatement.setLong(2, umobile);
		preparedStatement.executeUpdate();
		System.out.println("age updated successfully ");
		
		//statement.executeUpdate("update patient set age='"+uage+"' where mobile='"+umobile+"'");
	}
	public void updateMobile(long umobile, long updatedmobilenumber) throws SQLException
	{
		String sql = "UPDATE patient SET mobile = ? WHERE mobile = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setLong(1,updatedmobilenumber );
		preparedStatement.setLong(2, umobile);
		preparedStatement.executeUpdate();
		System.out.println("mobile updated successfully ");
		//statement.executeUpdate("update patient set mobile='"+updatedmobilenumber+"' where mobile='"+umobile+"'");
	}
	public void updateGender(long umobile, String ugender)throws SQLException
	{
		String sql = "UPDATE patient SET gender = ? WHERE mobile = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, ugender);
		preparedStatement.setLong(2, umobile);
		preparedStatement.executeUpdate();
		System.out.println("gender updated successfully ");
	}
	public void updateAddress(long umobile, String uaddress)throws SQLException
	{
		String sql = "UPDATE patient SET address = ? WHERE mobile = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, uaddress);
		preparedStatement.setLong(2, umobile);
		preparedStatement.executeUpdate();
		System.out.println("address updated successfully ");
	}
	public void updateDOJ(long umobile,String uDOJ) throws SQLException
	{
		String sql = "UPDATE patient SET date_of_joining = ? WHERE mobile = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, uDOJ);
		preparedStatement.setLong(2, umobile);
		preparedStatement.executeUpdate();
		System.out.println("date_of_joining updated successfully ");
	}
	

}




