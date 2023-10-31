package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;
import com.example.demo.services.StudentImpl;
import com.example.demo.services.StudentImplInterFace;
import com.example.demo.services.StudentNotFoundxception;



@Component
public class AdminController {
	@Autowired
	 private StudentImplInterFace s;
	public void addstu(Student st)
	{
		s.addStudent(st);
	}
	public void removestu(int id) throws StudentNotFoundxception
	{
		s.removeStudentById(id);
	}
	public void dispalystu(int id) throws StudentNotFoundxception
	{
		s.displayById(id);
	}
	public void displauAllStu() throws StudentNotFoundxception
	{
		s.displayAll();
	}
	public void dispalybranch(String branch) throws StudentNotFoundxception
	{
		s.displayByBranch(branch);
	}
	
	public void updatestname(int id,String name) throws StudentNotFoundxception
	{
		s.updateStu_Name(id, name);
	}
	public void updatestmob(int id,long mobile) throws StudentNotFoundxception
	{
		s.updateStu_Mobile(id,mobile);
	}
	public void updatestaddress(int id,String address) throws StudentNotFoundxception
	{
		s.updateStu_Address(id, address);
	}
	public void updatestbranch(int id,String branch) throws StudentNotFoundxception
	{
		s.updateStu_Branch(id, branch);
	}
	public void updateall(int id, String name, long mobile, String address, String branch) throws StudentNotFoundxception {
		// TODO Auto-generated method stub
		s.updateByStu_Id(id, name, mobile, branch, branch);
	}

	
	
	
}
