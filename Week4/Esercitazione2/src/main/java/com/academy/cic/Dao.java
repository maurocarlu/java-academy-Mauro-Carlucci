package com.academy.cic;

import com.academy.cic.model.*;
import com.academy.cic.model.Module;
import com.academy.cic.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

public class Dao {

    public void insertCourse(Course course) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
	   
		try {
			tx = session.beginTransaction();
			session.persist(course); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
    }
        
    public void insertModule(Module modulo){
    	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
	   
		try {
			tx = session.beginTransaction();
			session.persist(modulo); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

    public Course findCourseByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course course = null;
        try {
        	course = session.get(Course.class, name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return course;
    }

    public void addModuleToCourse(Module module, int courseId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                course.addModules(module);
                session.save(course);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Set<Module> findCourseModules(int courseId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Set<Module> modules = null;
        try {
        	TypedQuery<Module> query = session.createQuery("FROM Module WHERE course_id = :courseId", Module.class);
        	query.setParameter("courseId", courseId);
			modules = (Set<Module>) query.getResultList(); 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return modules;
    }
    
    public List<Course> findStartingCourseInRange(Date from, Date to) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courses = null;
        try {
        	TypedQuery<Course> query = session.createQuery("FROM Course WHERE startDate >= :from AND startDate <= :to", Course.class);
			query.setParameter("from",from);
			query.setParameter("to",to);
			courses = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return courses;
    }

    public void updateStartDate(Date startDate, int courseId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                course.setStart_date(startDate);
                session.saveOrUpdate(course);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteCourse(int courseId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                session.delete(course);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
