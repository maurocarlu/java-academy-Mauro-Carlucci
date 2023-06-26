package com.academy.cic.Model;

public class StudentNumCourses {
    private int studentId;
    private String firstName;
    private String lastName;
    private int numCourses;

    public StudentNumCourses(int studentId, int numCourses,String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numCourses = numCourses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

	@Override
	public String toString() {
		return "StudentNumCourses [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", numCourses=" + numCourses + "]";
	}
    
    
}
