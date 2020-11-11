package com.in28minutes.springboot.web.springbootfirstapplication.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstapplication.model.Todo;
import com.in28minutes.springboot.web.springbootfirstapplication.service.LoginService;
import com.in28minutes.springboot.web.springbootfirstapplication.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	//LoginService loginservice = new  LoginService();
	@Autowired
	TodoService todoservice;
	
	@RequestMapping(value="/list-todos", method= RequestMethod.GET)
	//@RequestParam String name, 
	public String showTodos(ModelMap model) {
		//Previous String name = (String) model.get("name");
		String name = getLoggedInUserName(model);
		model.put("todos", todoservice.retrieveTodos(name));
//		model.put("name", name);
//		System.out.println("Name Is "+ name);
		System.out.println("Name Is "+ name);
		
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		return (String) model.get("name");
	}
	
	@RequestMapping(value="/add-todos", method= RequestMethod.GET)
	//@RequestParam String name, 
	public String ShowAddTodos(ModelMap model, Todo todo) {
//		String name = (String) model.get("name");
//		model.put("todos", todoservice.retrieveTodos(name));
////		model.put("name", name);
////		System.out.println("Name Is "+ name);
//		System.out.println("Name Is "+ name);
//		
		model.addAttribute("todoo", new Todo(0, getLoggedInUserName(model), "Default value", new Date(), false));
		
		return "todos";
	}
	
	@RequestMapping(value="/delete-todos", method= RequestMethod.GET)
	//@RequestParam String name, 
	public String DeleteTodo(@RequestParam int id) {
		todoservice.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	
	
	@RequestMapping(value="/add-todos", method= RequestMethod.POST)
	//@RequestParam String name, 
	public String addTodos(ModelMap model, @Valid Todo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todos";
		}
		
		todoservice.addTodo(getLoggedInUserName(model), todo.getDesc(), new Date(), false);
		
		return "redirect:/list-todos";
	}
	
}
