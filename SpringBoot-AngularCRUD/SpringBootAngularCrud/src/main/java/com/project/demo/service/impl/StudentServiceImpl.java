package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Student;
import com.project.demo.repo.StudentRepository;
import com.project.demo.service.StudentService;
import com.project.demo.util.StudentUtil;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	//@Autowired
	//private StudentUtil util;
	
	public int saveStudent(Student s) {
		//util.calculate(s);
		StudentUtil.calculate(s);
		s=repo.save(s);
		return s.getSid(); 
	}

	
	public void updateStudent(Student s) {
		StudentUtil.calculate(s);
		repo.save(s);

	}
	
	public void deleteStudent(int id) {
		repo.deleteById(id);
	}

	
	public Student getOneStudent(int id) {
		Optional<Student> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	
	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}
	
	public boolean isExist(int id) {
		return repo.existsById(id);
		
	}

}
