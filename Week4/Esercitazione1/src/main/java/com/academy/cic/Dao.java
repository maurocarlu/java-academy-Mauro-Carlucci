package com.academy.cic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.academy.cic.Model.*;
import com.academy.cic.Util.JdbcUtil;


public class Dao {
    private Connection connection;

    public Dao() {
        try {
            connection = JdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student student) throws SQLException {
        String query = "INSERT INTO STUDENT (id, first_name, last_name, age) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try {
        	stmt = connection.prepareStatement(query);
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getLastName());
            stmt.setInt(4, student.getAge());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(stmt);
        }
    }

    public void insertCourse(Course course) throws SQLException {
        String query = "INSERT INTO COURSE (id, name) VALUES (?, ?)";
        PreparedStatement stmt = null;
        try{
        	stmt = connection.prepareStatement(query);
            stmt.setInt(1, course.getId());
            stmt.setString(2, course.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(stmt);
        }
    }

    public void registryStudentCourse(Registration registration) throws SQLException {
        String query = "INSERT INTO REGISTRATION (id, student_id, course_id, grade) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try{
        	stmt = connection.prepareStatement(query);
            stmt.setInt(1, registration.getId());
            stmt.setInt(2, registration.getStudentId());
            stmt.setInt(3, registration.getCourseId());
            stmt.setInt(4, registration.getGrade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(stmt);
        }
    }

    public Student selectByNameSurname(String name, String surname) throws SQLException {
        String query = "SELECT * FROM STUDENT WHERE first_name = ? AND last_name = ?";
        PreparedStatement stmt = null;
        try{
        	stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, surname);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                return new Student(id, firstName, lastName, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(stmt);
        }
        return null;
    }

    public void updateCourseGradeById(int registrationId, int grade) throws SQLException {
        String query = "UPDATE REGISTRATION SET grade = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try{
        	stmt = connection.prepareStatement(query);
            stmt.setInt(1, grade);
            stmt.setInt(2, registrationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(stmt);
        }
    }

    public List<Course> findStudentCourses(int studentId) throws SQLException {
        String query = "SELECT c.* FROM COURSE c " +
                "JOIN REGISTRATION r ON c.id = r.course_id " +
                "WHERE r.student_id = ?";
        List<Course> courses = new ArrayList<Course>();
        PreparedStatement stmt = null;
        try{
        	stmt = connection.prepareStatement(query);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Course course = new Course(id, name);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(stmt);
        }
        return courses;
    }

    public List<StudentNumCourses> findStudentIdNumCourses() throws SQLException {
        String query = "SELECT r.student_id, COUNT(r.course_id) AS numCourses " +
                "FROM REGISTRATION r " +
                "GROUP BY r.student_id";
        List<StudentNumCourses> students = new ArrayList<StudentNumCourses>();
        PreparedStatement stmt = null;
        try{
        	stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                int numCourses = rs.getInt("numCourses");
                StudentNumCourses student = new StudentNumCourses(studentId, numCourses,"","");
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	JdbcUtil.closePreparedStatement(stmt);
        }
        return students;
    }

    public List<StudentNumCourses> findStudentDataNumCourses() throws SQLException {
        String query = "SELECT s.id, s.first_name, s.last_name, COUNT(r.course_id) AS numCourses " +
                "FROM STUDENT s " +
                "JOIN REGISTRATION r ON s.id = r.student_id " +
                "GROUP BY s.id";
        List<StudentNumCourses> students = new ArrayList<StudentNumCourses>();
        PreparedStatement stmt = null;
        try{
        	stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int numCourses = rs.getInt("numCourses");
                StudentNumCourses student = new StudentNumCourses(studentId, numCourses,firstName, lastName);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(stmt);
        }
        return students;
    }

    public void close() {
        try {
			JdbcUtil.closeConnection(connection);
		} catch (SQLException e) {
			System.out.println("Errore chiusura connessione");
		}
    }
}

