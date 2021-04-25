package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.dao.IDaoStudent;
import com.psl.entity.Student;

@Service
public class StudentService {

	@Autowired
    private IDaoStudent dao;	
	public List<Student> laodStudent(){
	     return dao.laodStudent();
	}
	
	public void updateStudent(Student student) {
		dao.updateStudent(student);
	}
	public void addStudent(Student student)
	{
		dao.addStudent(student);
	}
	public void deleteStudent(int id) {
		dao.deleteStudent(id);
	}
	public Student getStudent(int id) {
		return dao.getStudent(id);
	}
}
