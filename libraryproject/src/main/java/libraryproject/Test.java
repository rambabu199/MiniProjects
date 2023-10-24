package libraryproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {

	public static void main(String[] args) {
		ApplicationContext a=new ClassPathXmlApplicationContext("bean.xml");
		Library a1=a.getBean("lib",Library.class);
		System.out.println(a1.showBorrow());
		System.out.println(a1.showReturn());

	}

}
