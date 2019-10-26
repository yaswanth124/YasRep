package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.student.model.Student;
import com.student.service.IService;
import com.validator.StudentValidator;

@Controller
public class StudentController {
	
	@Autowired
	private IService ser;
	@Autowired
	private StudentValidator vld;
	
	
	@RequestMapping("/index")
	public ModelAndView IndexPage()
	{
		System.out.println("this is from index");
		return new ModelAndView("studentform","command",new Student());
	}
	@RequestMapping("/save")
	public ModelAndView  insert( @ModelAttribute("std") Student std,BindingResult results,Model mod)
	{
		
		
		vld.validate(std, results);
		
		if(!results.hasErrors())
		{

			System.out.println("im in save"+std.getName());
			ser.insert(std);	
			return new ModelAndView("redirect:/viewform");
		}
		else
		{
			System.out.println(results);
			mod.addAttribute("results",results.getFieldErrors());
			return new ModelAndView("studentform","command",std);
		}
	}
	
	@RequestMapping("/viewform")
	public ModelAndView viewpage()
	{
		System.out.println("im in view map");
		List<Student> studentDetails=ser.viewpage();
		System.out.println("am in controller"+studentDetails);
	return new ModelAndView("viewform","studentDetails",studentDetails);	
	}
	
	  @RequestMapping(value="/deletestd/{id}",method = RequestMethod.GET)
	  public ModelAndView delet(@PathVariable int id)
	  {
		  System.out.println("im in delete");
		  ser.delet(id);
		  return new ModelAndView("redirect:/viewform");
	  }

	  
	  
	  @RequestMapping(value="/editstd/{id}")  
	  public ModelAndView getById(@PathVariable int id) {
		  System.out.println("im in edit emp");
		  Student std=ser.getById(id);  
		 
		  System.out.println(std);
		return  new ModelAndView("editform","command",std);
	}
	  
	  
	    @RequestMapping(value="/editsave",method = RequestMethod.POST) 
		  public ModelAndView editsave(Student std){  
		    	System.out.println("check in edit save");
			  ser.update1(std);  
		        return new ModelAndView("redirect:/viewform");  
		    } 
	    
	  
	  
}


