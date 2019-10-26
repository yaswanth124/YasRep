package com.validator;

import java.util.regex.Pattern;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.student.model.Student;
@Component("vld")
public class StudentValidator implements Validator {

	
	private MessageSource messageSource;
	@Override
	public boolean supports(Class<?> clz) {
		// TODO Auto-generated method stub
		return Student.class.equals(clz);
	}

	@Override
	public void validate(Object ob, Errors err) {
		// TODO Auto-generated method stub
		Student s= (Student) ob;
		

		if(!Pattern.compile("[A-Z,a-z, ]{1,15}").matcher(s.getName()).matches()) {
			err.rejectValue("Name", null, "validName");
	}
		
		if(!Pattern.compile("[A-Z,a-z]{1,5}").matcher(s.getGrade()).matches()) {
			err.rejectValue("grade", null, "validGrade");
	}
		
		if(!Pattern.compile("[A-Z,a-z]{1,10}").matcher(s.getGroup()).matches()) {
			err.rejectValue("group", null, "validGroup");
			
	}
	
	}

		
}
