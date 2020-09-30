package com.wellsfargo.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scdx.conf.Appconf;
import com.wellsfargo.scdx.service.GreetService;
import com.wellsfargo.scdx.service.GreetServiceImpl;

public class GreetApplication1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconf.class);
		GreetService gs = (GreetService) context.getBean("gsb");	
		System.out.println(gs.greet("Manvith"));
		
		GreetService gsa = (GreetService) context.getBean("gsab");	
		System.out.println(gsa.greet("Manvith"));
		
		GreetService gse = (GreetService) context.getBean("gseb");	
		System.out.println(gse.greet("Manvith"));
		
		System.out.println(context.getBean("today"));
	}

}
