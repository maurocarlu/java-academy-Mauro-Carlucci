package com.academy.cic;

import java.sql.SQLException;
import com.academy.cic.Model.*;
import com.academy.cic.Util.JdbcUtil;

public class Main {
	public static void main(String[] args) throws SQLException {
		Dao dao = new Dao();

		Student student1 = new Student(1, "Mauro","Carlucci",20);
		Student student2 = new Student(2, "Gianni","Rossi",30);
		
		Course corso1 = new Course(1,"Matematica");
		Course corso2 = new Course(2,"Informatica");
		
		Registration reg1 = new Registration(1, 1, 1, 22);
		Registration reg2 = new Registration(2, 1, 2, 25);
		Registration reg3 = new Registration(3, 2, 1, 27);
		Registration reg4 = new Registration(4, 2, 2, 30);
		
		
		dao.insertStudent(student1);
		dao.insertStudent(student2);
		
		dao.insertCourse(corso1);
		dao.insertCourse(corso2);
		
		dao.registryStudentCourse(reg1);
		dao.registryStudentCourse(reg2);
		dao.registryStudentCourse(reg3);
		dao.registryStudentCourse(reg4);
		

		System.out.println(dao.selectByNameSurname("Mauro", "Carlucci"));
		dao.updateCourseGradeById(1, 27);
		System.out.println(dao.findStudentCourses(1));
		System.out.println(dao.findStudentIdNumCourses());
		System.out.println(dao.findStudentDataNumCourses());
		dao.close();
    }
}
