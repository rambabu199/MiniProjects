package com.example.demo.services;


import java.util.Iterator;
import java.util.TreeSet;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component
public class StudentImpl implements StudentImplInterFace {
	TreeSet<Student> students=new TreeSet<Student>();
	public void addStudent(Student stu)
	{
		students.add(stu);
		System.out.println("student added successfully \n");
	}
	public void removeStudentById(int studentid) throws StudentNotFoundxception
	{
		 Iterator<Student> iterator = students.iterator();
		 boolean studentFound=false;
		    while (iterator.hasNext()) {
		        Student s = iterator.next();
		        if (s.getId() == studentid) {
		            iterator.remove(); // Safely remove the student
		            studentFound = true;
		            System.out.println("removed successfully");
		            break; // Exit the loop once the student is found and removed
		        }
		    }
		    if(!studentFound)
		    {
		    	throw new StudentNotFoundxception("Student not found");
		    }
	}
	public	void displayAll()throws StudentNotFoundxception
	{
		if(students!=null) {
		System.out.println("displaying all students details");
		for(Student s:students)
		{
			System.out.println(s);
		}
		}
		else
		{
			throw new StudentNotFoundxception("no records found");
		}
	}
	public	void displayById(int id) throws StudentNotFoundxception
	{
		if(students!=null) {
			boolean found=false;
			System.out.println("displaying  student details");
			for(Student s:students)
			{
				if(s.getId()==id) {
				System.out.println(s);
				found=true;
				}
				
			}
			if(found==false)
			{
				throw new StudentNotFoundxception("no records found");
			}
			}
			else
			{
				throw new StudentNotFoundxception("no records found");
			}
	}
	public void displayByBranch(String branch) throws StudentNotFoundxception
	{
		
		if(students!=null) {
			boolean found=false;
			System.out.println("displaying  student details by branch ");
			for(Student s:students)
			{
				if(s.getBranch().equalsIgnoreCase(branch)) {
				System.out.println(s);
				found=true;
				}
				
			}
			if(found==false)
			{
				throw new StudentNotFoundxception("no records found");
			}
			}
			else
			{
				throw new StudentNotFoundxception("no records found");
			}
		
	}
	
	public void updateByStu_Id(int id,String name,Long mobile,String address,String branch) throws StudentNotFoundxception
	{
		if(students!=null) {
			boolean found=false;
			
			System.out.println("updating student details");
			for(Student s:students)
			{
				if(s.getId()==id)
				{
					s.setName(name);
					s.setAddress(address);
					s.setBranch(branch);
					s.setMobilenumber(mobile);
					
					System.out.println("details updated successfully");
					found=true;
				}
			}
			if(found==false)
			{
				throw new StudentNotFoundxception("no records found");
			}
		}
			else
			{
				throw new StudentNotFoundxception("no records found");
			}
	}
	//String name; mobilenumber; address; branch;
	public void updateStu_Name(int id,String name) throws StudentNotFoundxception
	{
		if(students!=null) {
			boolean found=false;
			
			System.out.println("updating student details");
			for(Student s:students)
			{
				if(s.getId()==id)
				{
					s.setName(name);
					System.out.println("Name updated successfully");
					found=true;
				}
			}
			if(found==false)
			{
				throw new StudentNotFoundxception("no records found");
			}
		}
			else
			{
				throw new StudentNotFoundxception("no records found");
			}
	}
	public void updateStu_Mobile(int id,Long mobilenumber) throws StudentNotFoundxception
	{
		if(students!=null) {
			boolean found=false;
			
			System.out.println("updating student details");
			for(Student s:students)
			{
				if(s.getId()==id)
				{
					s.setMobilenumber(mobilenumber);
					System.out.println("mobile number updated successfully");
					found=true;
				}
			}
			if(found==false)
			{
				throw new StudentNotFoundxception("no records found");
			}
		}
			else
			{
				throw new StudentNotFoundxception("no records found");
			}
	}
	//address; branch;
	
	public void updateStu_Address(int id,String address) throws StudentNotFoundxception
	{
		if(students!=null) {
			boolean found=false;
			
			System.out.println("updating student details");
			for(Student s:students)
			{
				if(s.getId()==id)
				{
					s.setAddress(address);
					System.out.println("address updated successfully");
					found=true;
				}
			}
			if(found==false)
			{
				throw new StudentNotFoundxception("no records found");
			}
		}
			else
			{
				throw new StudentNotFoundxception("no records found");
			}
	}
	
	public void updateStu_Branch(int id,String branch) throws StudentNotFoundxception
	{
		if(students!=null) {
			boolean found=false;
			
			System.out.println("updating student details");
			for(Student s:students)
			{
				if(s.getId()==id)
				{
					s.setBranch(branch);
					System.out.println("branch updated successfully");
					found=true;
				}
			}
			if(found==false)
			{
				throw new StudentNotFoundxception("no records found");
			}
		}
			else
			{
				throw new StudentNotFoundxception("no records found");
			}
	}
	

}
