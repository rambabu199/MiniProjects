package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.controller.AdminController;
import com.example.demo.model.Student;
import com.example.demo.services.StudentNotFoundxception;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) throws StudentNotFoundxception {
		ApplicationContext c= SpringApplication.run(StudentManagementSystemApplication.class, args);
		StudentManagementSystemApplication sms=new StudentManagementSystemApplication();
		sms.menu(c);
		
	}
	
	void menu(ApplicationContext c) throws StudentNotFoundxception
	{
		Student student;
		Scanner sc=new Scanner(System.in);
		AdminController ac=c.getBean(AdminController.class);
		int id;
		String name,address,branch;
		long mobile;
		char con;
		System.out.println("welcome to Student management system");
		do{
		System.out.println("1.Add new Student \n 2.update studentdetails \n 3.remove student \n 4.dispaly student details \n 5.exit \n enter your choice");
		int choice =sc.nextInt();
		switch(choice)
		{
			case 1:
				student=new Student();
				System.out.println("enter student id");
				id=sc.nextInt();
				student.setId(id);
				System.out.println("enter student name");
				name=sc.next();
				student.setName(name);
				System.out.println("enter student mobiel number ");
				mobile=sc.nextLong();
				student.setMobilenumber(mobile);
				System.out.println("enter student address");
				address=sc.nextLine();
				student.setAddress(address);
				sc.nextLine();
				System.out.println("enter student branch");
				branch=sc.next();
				student.setBranch(branch);	
				ac.addstu(student);
				break;
			case 2:
				System.out.println("what do you want to update \n 1.name \n 2.address\n 3.mobilenumber \n 4.branch \n5.all details \n enter your choice");
				int ch=sc.nextInt();
				switch(ch) {
					case 1:
					System.out.println("enter student id");
					int nid=sc.nextInt();
					System.out.println("enter updated name");
					String uname=sc.next();
					try {
					ac.updatestname(nid, uname);
					}
					catch(StudentNotFoundxception e)
					{
						System.out.println("Exception occured"+e.getStackTrace());
					}
					break;
					case 2:
						System.out.println("enter student id");
						int uaid=sc.nextInt();
						System.out.println("enter updated address");
						String uaddress=sc.nextLine();
						try
						{
							ac.updatestaddress(uaid, uaddress);
						}
						catch(StudentNotFoundxception e)
						{
							System.out.println("Exception occured"+e.getStackTrace());
						}
						break;
					case 3:
						System.out.println("enter student id");
						int uid=sc.nextInt();
						System.out.println("enter updated mobiel number");
						long umobile=sc.nextLong();
						try
						{
							ac.updatestmob(uid, umobile);
						}
						catch(StudentNotFoundxception e)
						{
							System.out.println("Exception occured"+e.getStackTrace());
						}
						break;
					case 4:
						System.out.println("enter student id");
						int bid=sc.nextInt();
						System.out.println("enter updated branch");
						String ubranch=sc.nextLine();
						try
						{
							ac.updatestbranch(bid, ubranch);
						}
						catch(StudentNotFoundxception e)
						{
							System.out.println("Exception occured"+e.getStackTrace());
						}
						break;
					case 5:
						
						System.out.println("enter student id");
						int u_id=sc.nextInt();
						
						System.out.println("enter student name");
						String u_name=sc.next();
						
						System.out.println("enter student mobiel number ");
						long u_mobile=sc.nextLong();
						
						System.out.println("enter student address");
						String u_address=sc.nextLine();
						sc.nextLine();
						
						System.out.println("enter student branch");
						String u_branch=sc.next();
						try {
							ac.updateall(u_id,u_name,u_mobile,u_address,u_branch);
						}
						catch(StudentNotFoundxception e)
						{
							System.out.println("Exception occured"+e.getStackTrace());
						}
						break;
					default:
						System.out.println("wrong choice");
						break;						
						
				}
				break;
			case 3:
				System.out.println("enter student id to remove");
				int did=sc.nextInt();
				try {
					ac.removestu(did);
				}
				catch(StudentNotFoundxception e)
				{
					System.out.println("Exception occured"+e.getStackTrace());
				}
				break;
			case 4:
				System.out.println("1.display by id \n 2.display by branch 3.display all \n enter your choice ");
				int cho=sc.nextInt();
				switch(cho)
				{
					case 1:
						System.out.println("enter student id");
						int ddid=sc.nextInt();
						try {
							ac.dispalystu(ddid);
						}
						catch(StudentNotFoundxception e)
						{
							System.out.println("Exception occured"+e.getStackTrace());
						}
						break;
					case 2:
						System.out.println("enter branch");
						String r_branch=sc.next();
						try
						{
							ac.dispalybranch(r_branch);
						}
						catch(StudentNotFoundxception e)
						{
							System.out.println("Exception occured"+e.getStackTrace());
						}
						break;
					case 3:
						try {
							ac.displauAllStu();
						}
						catch(StudentNotFoundxception e)
						{
							System.out.println("Exception occured"+e.getStackTrace());
						}
						break;
					default:
						System.out.println("wrong choice");
						break;
							
						
				}
				break;
			case 5:
				System.out.println("exiting the program");
				System.exit(0);
				break;
			default:
					System.out.println("wrong choice");
					break;
				
				
		}
		System.out.println("do you want to continue(y/n)");
		con=sc.next().charAt(0);
		}while(con!='n');
		
		sc.close();
		
	}

}
