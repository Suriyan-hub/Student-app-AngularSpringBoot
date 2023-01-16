package com.project.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Message;
import com.project.demo.model.Student;
import com.project.demo.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins="http://localhost:4200/")
public class StudentRestController {

	@Autowired
	private StudentService service;
	//1.save
	
	@PostMapping("/create")
	public ResponseEntity<Message> saveStudent(@RequestBody Student student)
	{
		ResponseEntity<Message> resp=null;
		try {
		int id=service.saveStudent(student);
		resp=new ResponseEntity<Message>(new
		Message("SUCCESS",id+"-saved"),HttpStatus.OK);
		} catch (Exception e) {
		resp=new ResponseEntity<Message>(new
		Message("FAIL","Unable to Save"),HttpStatus.OK);
		e.printStackTrace();}
		
		//String msg="Student saved with id:"+id ;
		//return ResponseEntity.ok(msg);
		return resp;
		
	}

	//2.fetch all
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents(){
		
		List<Student> list = service.getAllStudents();
		return ResponseEntity.ok(list);
	}
	//3.fetch
	@GetMapping("/one/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable int id){
		Student std = service.getOneStudent(id);
		return ResponseEntity.ok(std);
		
	}
	//4.delete
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		service.deleteStudent(id);
		String msg="Student deleted with id:" +id;
		return ResponseEntity.ok(msg);
		
	}
	//5.update
	@PutMapping("/update")
	public ResponseEntity<Message> updateStudent(@RequestBody Student student ){
		ResponseEntity<Message> resp=null;
		try {
		boolean exist=service.isExist(student.getSid());
		if(exist) {
		service.saveStudent(student);
		resp=new ResponseEntity<Message>(new
		Message("OK",student.getSid()+"-Updated"),HttpStatus.OK);
		}else {
		resp=new ResponseEntity<Message>(new
		Message("OK",student.getSid()+"-Not Exist"),HttpStatus.BAD_REQUEST);
		}
		} catch (Exception e) {
		resp=new ResponseEntity<Message>(new
		Message("OK","Unable to Update"),HttpStatus.INTERNAL_SERVER_ERROR);
		e.printStackTrace();
		}
		return resp;
		
		
		
		//service.updateStudent(student);
		//String msg="Student Updated:" +student.getSid();
		//return ResponseEntity.ok(msg);
		
	}
	
}
