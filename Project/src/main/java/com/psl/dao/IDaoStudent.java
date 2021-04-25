package com.psl.dao;

import java.util.List;

import com.psl.entity.Student;

public interface IDaoStudent {

	public List<Student> laodStudent();
	public void updateStudent(Student student);
	public void addStudent(Student student);
	public void deleteStudent(int id) ;
	public Student getStudent(int id);
}
