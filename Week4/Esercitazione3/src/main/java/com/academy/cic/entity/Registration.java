package com.academy.cic.entity;

import javax.persistence.*;

@Entity
@Table(name = "REGISTRATION")
@NamedQuery(name = "Registration.findAvgGradeByStudentId", query = "SELECT AVG(r.grade) FROM Registration r WHERE r.student.id = :studentId")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@Column(name = "grade")
	private int grade;

	public Registration() {
	}

	public Registration(Student student, Course course, int grade) {
		this.student = student;
		this.course = course;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", student=" + student + ", course=" + course + ", grade=" + grade + "]";
	}
	
	
}
