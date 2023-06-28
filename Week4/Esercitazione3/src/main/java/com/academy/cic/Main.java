package com.academy.cic;
import org.hibernate.mapping.List;

import com.academy.cic.entity.*;

public class Main {
    public static void main(String[] args) {
        Dao dao = new Dao();

        Student student = new Student("Mauro", "Carlucci", 20);
        Student student2 = new Student("Marco", "Rossi", 30);
        dao.insertStudent(student);
        dao.insertStudent(student2);

        Course course = new Course("Java");
        dao.insertCourse(course);

        Registration registration = new Registration(student, course, 90);
        dao.registryStudentCourse(registration);

        System.out.println("Studente con quel nome:");
        System.out.println(dao.findByNameSurname("Mauro", "Carlucci"));

        int registrationId = registration.getId();
        dao.updateCourseGradeById(registrationId, 22);
        dao.updateCourseGradeById(registrationId, 25);

        int studentId = student.getId();
        Double averageGrade = dao.findAvgGradeByStudentId(studentId);
        System.out.println("Media dei voti dello studente: " + averageGrade);
        
        dao.datiStudente(studentId);
    }
}

