package com.academy.cic;

import java.util.Calendar;

import com.academy.cic.model.Course;
import com.academy.cic.model.Module;

public class Main {
	
	public static void main(String[] args) {
		Dao dao = new Dao();
		
		Calendar startDate = Calendar.getInstance();
		startDate.set(2023, Calendar.JANUARY, 1);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2023, Calendar.DECEMBER, 31);
		
		Module mod1 = new Module("Dati","Rossi");
		Module mod2 = new Module("Basi","Rossi");
		Module mod3 = new Module("Correnti","Verdi");
		Module mod4 = new Module("Vettori","Blu");
		
		Course c1 = new Course("Informatica",startDate.getTime(), endDate.getTime());
		Course c2 = new Course("Fisica",startDate.getTime(), endDate.getTime());
		
		dao.insertCourse(c1);
		dao.insertCourse(c2);
		dao.insertModule(mod1);
		dao.insertModule(mod2);
		dao.insertModule(mod3);
		dao.insertModule(mod4);
		
		
		System.out.println(dao.findCourseByName("Informatica"));
		
		dao.addModuleToCourse(mod4, 1);
		
		//System.out.println(dao.findCourseModules(1));
		
		
		
		

	}

}
