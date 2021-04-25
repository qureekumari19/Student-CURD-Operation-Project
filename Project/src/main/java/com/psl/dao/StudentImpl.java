package com.psl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.psl.entity.Student;

@Repository
public class StudentImpl implements IDaoStudent {

	@Autowired
    public JdbcTemplate template;
	
	@Override
	public List<Student> laodStudent() {	
//		System.out.println("------------Dao1");
		String sql="select * from student";
//		System.out.println("------------Dao2");
		List<Student> studentlist=template.query(sql,
				 new RowMapper<Student>() {
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student student=new Student();					 
					System.out.print(rs.getInt("id"));
					System.out.print(rs.getString("name"));
					System.out.print(rs.getInt("phone"));
					System.out.print(rs.getString("address"));
					System.out.println();
//					
					
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getInt("phone"));
					student.setAddress(rs.getString("address"));
					return student;
				}
				});
//		System.out.println("------------Dao3");				
		return studentlist;
	}

	@Override
	public void updateStudent(Student student) {
		System.out.println("----------------Updated");
		String sql="update student set name = ? , phone = ? , address = ? where id = ?";
//		System.out.println("----------------@");
		template.update(sql,student.getName(),student.getPhone(),student.getAddress(),student.getId());
//		System.out.println("----------------@");
	}
		

	@Override
	public void addStudent(Student student) {	
		System.out.println("Student added");		
		String sql="insert into student values("+student.getId()+",'"+student.getName()+"',"+student.getPhone()+",'"+student.getAddress()+"')";
		template.update(sql);
	}
	

	@Override
	public void deleteStudent(int id) {	
		System.out.println("Student deleted");
		String sql="delete from student where id=?";
		template.update(sql,id);
	}

	@Override
	public Student getStudent(int id) {		
		return template.queryForObject("select * from student where id ="+id,
				new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();					 
				System.out.print(rs.getInt("id"));
				System.out.print(rs.getString("name"));
				System.out.print(rs.getInt("phone"));
				System.out.print(rs.getString("address"));
				System.out.println();
//				
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getInt("phone"));
				student.setAddress(rs.getString("address"));
				return student;
			}
			});
	}
}
