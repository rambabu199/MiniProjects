package com.job;

public class JobseekerClass implements JobInterface {

	JobseekerClass(){
		System.out.println("this is job seeker class constructor");
	}
	@Override
	public void jobInfo() {
		// TODO Auto-generated method stub
		System.out.println("this is jobinfo method from job seeker class");
	}

}
