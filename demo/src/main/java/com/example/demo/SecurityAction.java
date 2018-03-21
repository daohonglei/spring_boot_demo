package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityAction {
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		System.out.println("home");
		return "home";
	}
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String admin() {
		System.out.println("admin");
		return "admin";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		System.out.println("login");
		return "login";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		System.out.println("hello");
		return "hello";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		/*request.getSession().invalidate();*/
		System.out.println("logout");
		return "redirect:/home";
	}
}
