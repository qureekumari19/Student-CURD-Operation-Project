package com.psl.entity;

public class Student {

	private int id;
	private String name;
	private long phone;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	public Student(int id, String name, long phone, String address) {		
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public Student() {	
		// TODO Auto-generated constructor stub
	}
	
}
