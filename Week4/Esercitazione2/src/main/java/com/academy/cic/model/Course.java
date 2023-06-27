package com.academy.cic.model;

import java.util.Date;
import java.util.Set;

public class Course {
	private int course_id;
	private String name;
	private Date start_date;
	private Date end_date;
	private Set<Module> modules;

	public Course(String name, Date start_date, Date end_date) {
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	
	public void addModules(Module module) {
		this.modules.add(module);
	}

	
	
	
}
