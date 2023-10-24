package com.job;

public class AdminClass implements JobInterface {
	public AdminClass()
	{
		System.out.println("it is Admin class Constructor");
	}

	@Override
	public void jobInfo() {
		// TODO Auto-generated method stub
		System.out.println("this is jobinfo method from Admin  class");
	}

}
