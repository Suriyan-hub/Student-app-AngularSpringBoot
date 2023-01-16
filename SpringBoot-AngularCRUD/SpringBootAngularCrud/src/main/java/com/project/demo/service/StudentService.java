package com.project.demo.service;

import java.util.List;

import com.project.demo.model.Student;

public interface StudentService {
	int saveStudent(Student s);
	void updateStudent(Student s);
	void deleteStudent(int id);
	Student getOneStudent(int id);
	List<Student> getAllStudents();
	public boolean isExist(int sid);

}
