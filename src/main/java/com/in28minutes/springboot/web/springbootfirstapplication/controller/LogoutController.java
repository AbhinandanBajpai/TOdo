package com.in28minutes.springboot.web.springbootfirstapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstapplication.service.LoginService;

@Controller
@SessionAttributes("name")
public class LogoutController {

	//LoginService loginservice = new  LoginService();
	@Autowired
	LoginService loginservice;
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	//@RequestParam String name, 
	public String showLoginPage(ModelMap model) {
		model.put("name", "Abhi");
		
		return "welcome";
	}
	
//	@RequestMapping(value="/login", method= RequestMethod.POST)
//	//@RequestParam String name, 
//	public String showWelcomePage(ModelMap model, @RequestParam String password, @RequestParam String name) {
//	boolean isValid = loginservice.validateUser(name, password);
//	
//	if(!isValid) {
//		model.put("error", "Something is wrong");
//		return "login";
//	}
//		
//		model.put("name", name);
//		model.put("password", password);
////		model.addAttribute("name", name);
//		
//		return "welcome";
//	}
}
