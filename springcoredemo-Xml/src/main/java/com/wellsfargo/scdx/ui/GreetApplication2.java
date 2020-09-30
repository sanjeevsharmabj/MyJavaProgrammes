package com.wellsfargo.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scdx.service.GreetService;
import com.wellsfargo.scdx.service.GreetServiceAdvancedImpl;

public class GreetApplication2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*GreetService gs = new GreetServiceImpl();
		System.out.println(gs.greet("Manvith"));*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		
		
		GreetService gsa = (GreetService) context.getBean("gsab");	
		System.out.println(gsa.greet("Manvith"));
		((GreetServiceAdvancedImpl)gsa).setGreeting("Hai");
		System.out.println(gsa.greet("Manvith"));
		gsa = (GreetService) context.getBean("gsab");	
		System.out.println(gsa.greet("Manvith"));
		
	}

}
