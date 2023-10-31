package com.example.demo.services;

import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component
public interface StudentImplInterFace {
	public void addStudent(Student stu);
	public void removeStudentById(int studentid) throws StudentNotFoundxception;
	public	void displayAll()throws StudentNotFoundxception;
	public	void displayById(int id) throws StudentNotFoundxception;
	public void displayByBranch(String branch) throws StudentNotFoundxception;
	public void updateByStu_Id(int id,String name,Long mobile,String address,String branch) throws StudentNotFoundxception;
	public void updateStu_Name(int id,String name) throws StudentNotFoundxception;
	public void updateStu_Mobile(int id,Long mobilenumber) throws StudentNotFoundxception;
	public void updateStu_Address(int id,String address) throws StudentNotFoundxception;
	public void updateStu_Branch(int id,String branch) throws StudentNotFoundxception;
	

}
