package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws")
public class Controller {

	@Autowired
	private Repositary rpo;

	@PostMapping("/save")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void save(@RequestBody Student std) {
		rpo.save(std);
	}

	@GetMapping("/getall")
	public List<Student> getall() {
		return rpo.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		
		
		Student emp=rpo.getOne(id);
		if(emp==null) {
			 ResponseEntity.notFound().build();
		}
		rpo.delete(emp);
		
		 ResponseEntity.ok().build();
		

	}
	
	

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Optional<Student>> getbyid(@PathVariable(value = "id") long id) {

		Optional<Student> emp = rpo.findById(id);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);

	}

	@PutMapping("/update/{id}")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public ResponseEntity<Student> updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid @RequestBody Student empDetails) {

		Student emp = rpo.getOne(empid);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}

		emp.setName(empDetails.getName());

		emp.setCity(empDetails.getName());
		Student updateEmployee = rpo.save(emp);
		return ResponseEntity.ok().body(updateEmployee);

	}

}
