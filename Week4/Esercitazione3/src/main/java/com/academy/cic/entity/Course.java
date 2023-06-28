package com.academy.cic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Registration> registrations;

	public Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name +"]";
	}
	
	
}
