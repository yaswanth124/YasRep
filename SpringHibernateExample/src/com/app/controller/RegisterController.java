package com.app.controller;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojo.RegisterPojo;
import com.app.service.RegisterService;




@Controller
public class RegisterController {

	@Autowired
	private RegisterService userService;

	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("user") RegisterPojo user, BindingResult result) {
		ArrayList<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("gender", gender);

		System.out.println("Register Form");
		return new ModelAndView("Register", "model", model);
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@Valid @ModelAttribute("user") RegisterPojo user, BindingResult result) {
		userService.addUser(user.getFirstName(), user.getLastName(), user.getDob(), user.getAge(), user.getGender(),
				user.getMobileNo(), user.getEmail(), user.getPwd(), user.getTempAdd(), user.getPermAdd()
				);
		System.out.println("Save User Data");
		return new ModelAndView("personalsuccess");
	}

	@RequestMapping("/updateUser1")
	public ModelAndView updateUserData(@Valid @ModelAttribute("user") RegisterPojo user, BindingResult result) {
		userService.updateUser(user);
		System.out.println("Save User Data");
		return new ModelAndView("redirect:/userList.html");
	}

	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("abc", userService.getUser());
		return new ModelAndView("personaldetails", model);

	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  RegisterPojo user,
			BindingResult result) {
		
		System.out.println("in delete controller");
		System.out.println(user.getId());
		userService.deleteEmployee(user);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("abc", userService.getUser());
		System.out.println("deleted");
		return new ModelAndView("personaldetails",model);
		
		
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  RegisterPojo user,
			BindingResult result) {
		System.out.println("am in update controller");
		System.out.println(user.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user",(userService.getEmployee(user.getId())));
		model.put("abc",  (userService.getUser()));
		System.out.println(user.getId());
		/*System.out.println(user.getUserId());
		System.out.println(user.getGender());*/
		System.out.println("updated");
		return new ModelAndView("update", model);
	}

	
	
	
}
