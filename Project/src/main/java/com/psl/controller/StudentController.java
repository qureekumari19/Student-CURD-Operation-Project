package com.psl.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.psl.dao.IDaoStudent;
import com.psl.entity.Student;
import com.psl.service.StudentService;

@Controller
public class StudentController {

	@Autowired    
	private StudentService ser;
	
	@GetMapping({"/show","/"})
	public String showStudent(Model model) {
//		System.out.println("------------controller1");
		List<Student> studentlist=ser.laodStudent();
//		System.out.println("------------controller2");
//		for(Student temp:studentlist)
//		{
//			System.out.println("-----------------data");
//			System.out.println(temp);
//		}
//		System.out.println("------------controller3");		
		model.addAttribute("stulist",studentlist);
//		System.out.println("------------controller4");
		return "student-list";
	}
	
//	@RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
//	public String showStudent(@PathVariable int id,Model model) {
////		System.out.println("------------controller1");
//		dao.updateStudent(id);
////		System.out.println("------------controller2");								
//		return "student-list";
//	}
//	
	@RequestMapping(value = "/add" , method = RequestMethod.GET)	
	public String addStudent(Model model) {
//		System.out.println("------------controller1");		
//		System.out.println("------------controller2");
		model.addAttribute("student",new Student());
		return "add-student-list";
	}
//	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)	
	public String getStudent(@ModelAttribute Student student,Model model,BindingResult result) {
		System.out.println(student);
//		System.out.println("------------controller1");		
//		System.out.println("------------controller2");
		if(result.hasErrors() || student.getId()==0 || student.getPhone()==0 || student.getAddress()==null || student.getName()==null)
			return "add-student-list";
		ser.addStudent(student);
		return  "redirect:/add";
	}
//	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateStudent(@RequestParam int userID,Model model) {
		System.out.println(userID);
		Student student=ser.getStudent(userID);
		System.out.println(student);
		model.addAttribute("student", student);
//		System.out.println("------------controller2");								
		return "update-student-list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update1Student(@ModelAttribute Student student,Model model) {
		System.out.println(student);
		ser.updateStudent(student);
		System.out.println(student);
		model.addAttribute("student", student);
//		System.out.println("------------controller2");								
		return "redirect:/show";
	}
		
	
//	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam int userID,Model model) {
//		System.out.println("------------controller1");
		ser.deleteStudent(userID);
//		System.out.println("------------controller2");								
		return "redirect:/show";
	}
		
}
