package com.project.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
