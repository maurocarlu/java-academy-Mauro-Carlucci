package com.academy.cic;

import com.academy.cic.util.JpaUtil;
import com.academy.cic.entity.*;
import com.academy.cic.entity.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class Dao {

    private EntityManagerFactory entityManagerFactory;

    public Dao() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    public void insertStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void insertCourse(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void registryStudentCourse(Registration registration) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(registration);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void insertModule(Module modulo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(modulo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Student> findByNameSurname(String name, String surname) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Student> query = entityManager.createNamedQuery("Student.findByNameSurname", Student.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        List<Student> students = query.getResultList();
        entityManager.close();
        return students;
    }

    public void updateCourseGradeById(int registrationId, int grade) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Registration registration = entityManager.find(Registration.class, registrationId);
        if (registration != null) {
            registration.setGrade(grade);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Double findAvgGradeByStudentId(int studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Double> query = entityManager.createNamedQuery("Registration.findAvgGradeByStudentId", Double.class);
        query.setParameter("studentId", studentId);
        Double averageGrade = query.getSingleResult();
        entityManager.close();
        return averageGrade;
    }
    
    public void datiStudente(int studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, studentId);

        if (student != null) {
            System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Registrations:");

            List<Registration> registrations = student.getRegistrations();
            if (registrations.isEmpty()) {
                System.out.println("Non ha registrazioni.");
            } else {
                for (Registration registration : registrations) {
                    Course course = registration.getCourse();
                    System.out.println("Course: " + course.getName());

                    int grade = registration.getGrade();
                    if (grade >= 0) {
                        System.out.println("Grade: " + grade);
                    } else {
                        System.out.println("Grade: Non disponibile");
                    }
                }
            }
        } else {
            System.out.println("Studente con ID " + studentId + " non trovato.");
        }

        entityManager.close();
    }
    
    public Course findCourseWithModules(int courseId) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = entityManager.find(Course.class, courseId);
        if (course != null) {
            course.getModules().size();
        }
        entityManager.close();
        return course;
    }
    
    public List<Module> findModulesByCourseId(int courseId) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	List<Module> moduli;
        TypedQuery<Module> query = entityManager.createQuery("SELECT m FROM Module m WHERE m.course.id = :courseId", Module.class);
        query.setParameter("courseId", courseId);
        moduli = query.getResultList();
        entityManager.close();
        return moduli;
    }
    
    public Course findCourse(int courseid) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Course corso = null;
		try {
			corso = entityManager.find(Course.class, courseid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		return corso;
	}
    
    public Course updateCourse(Course corso) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Course updatedCourse = null;
		try {
			entityManager.getTransaction().begin();
			updatedCourse = entityManager.merge(corso);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		return updatedCourse;
	}

}
