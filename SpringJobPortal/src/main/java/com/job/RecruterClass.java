package com.job;

public class RecruterClass implements JobInterface {
	RecruterClass(){
		System.out.println("this is recruter class constructor");
	}

	@Override
	public void jobInfo() {
		// TODO Auto-generated method stub
		System.out.println("this is jobinfo method from recruter class");
	}

}
