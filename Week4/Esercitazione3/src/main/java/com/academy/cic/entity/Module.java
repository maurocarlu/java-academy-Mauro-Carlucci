package com.academy.cic.entity;

import javax.persistence.*;

@Entity
@Table(name = "MODULE")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", length = 64, nullable = false)
	private String name;

	@Column(name = "teacher", length = 64)
	private String teacher;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public Module() {
	}

	public Module(String name, String teacher, Course course) {
		this.name = name;
		this.teacher = teacher;
		this.course = course;
	}

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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + ", teacher=" + teacher + ", course=" + course + "]";
	}
}
