package com.wellsfargo.swmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class DashboardController {
	/*http://localhost:9090/springWebMVCDemo
	 * http://localhost:9090/springWebMVCDemo/
	 * http://localhost:9090/springWebMVCDemo/home
	 */
	@RequestMapping(value= {"","/","/home"},method =RequestMethod.GET)
	public String getHome() {
		return "home";
	}
}
