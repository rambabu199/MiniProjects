package bitlabs123.patientJDBC;

import java.sql.SQLException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
	public void  menu() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		PatientDao pdi= new PatientDaoImpl();
		
		char cj;
		do {
			System.out.println("*************MENU**************");
			System.out.println("1) add patient \n 2) delete patient \n 3) update patient \n 4) dispaly all \n  5)exit \n enter your choice");
			int choice=sc.nextInt();
		int id,age;
		long mobile;
		String name,address,gender,date_of_joining;
		
			switch(choice)
			{
			case 1:
				System.out.println("enter patient details \n \n");
				System.out.println("enter patient id");
				id=sc.nextInt();
				sc.nextLine();
				System.out.println("enter patient name");
				name=sc.nextLine();
				System.out.println("enter patient gender");
				gender=sc.next();
				
				System.out.println("enter patient age");
				age=sc.nextInt();
				System.out.println("enter patient mobile number");
				mobile=sc.nextLong();				
				sc.nextLine();
				System.out.println("enter patient address");				
				address=sc.nextLine();	
				//sc.nextLine();
				
				System.out.println("enter patient date of joining");
				date_of_joining=sc.nextLine();
				//sc.nextLine();
				pdi.addPatient(id, name, gender, age, mobile, address, date_of_joining);
				break;
			case 2:
				System.out.println("enter patient mobile number");
				long dmobile=sc.nextLong();
				pdi.deletePatient(dmobile);
				break;
			case 3:
				System.out.println("enter patient mobile number");
				long umobile=sc.nextLong();
				System.out.println("what do you want to update 1.name \n 2.age \n 3.mobilenumber \n 4.gender \n 5.address \n 6.date_of_joining \n enter your choice");
				int ch=sc.nextInt();
				switch(ch)
				{
					case 1:
						System.out.println("enter updated name");
						String uname=sc.next();
						pdi.updateName(umobile,uname);
						break;
					case 2:
						System.out.println("enter updated age");
						int uage=sc.nextInt();
						pdi.updateAge(umobile,uage);
						break;
					case 3:
						System.out.println("enter updated mobilenumber");
						int updatedmobilenumber=sc.nextInt();
						pdi.updateMobile(umobile,updatedmobilenumber);
						break;
					case 4:
						System.out.println("enter updated gender");
						String ugender=sc.next();
						pdi.updateGender(umobile,ugender);
						break;
					case 5:
						System.out.println("enter updated Address");
						String uaddress=sc.nextLine();
						pdi.updateAddress(umobile,uaddress);
						break;
					case 6:
						System.out.println("enter updated Date_of_joining");
						String uDOJ=sc.next();
						pdi.updateDOJ(umobile,uDOJ);
						break;
					default:
						System.out.println("wrong choice");
						break;
					}
				break;
				
			case 4:
				pdi.dispalyAll();
				break;
				
			case 5:
				System.exit(0);
				break;
			}
			System.out.println("do you want to continue");
			cj=sc.next().charAt(0);
		}while(cj!='n');
		sc.close();
		}	
		
	
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
       // System.out.println( "Hello World!" );
    	App a=new App();
    	a.menu();
    }
}
