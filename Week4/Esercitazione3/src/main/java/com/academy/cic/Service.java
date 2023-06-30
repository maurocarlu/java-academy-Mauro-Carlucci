package com.academy.cic;

import java.util.List;

import com.academy.cic.entity.Course;
import com.academy.cic.entity.Module;
import com.academy.cic.exception.BadRequestException;
import com.academy.cic.exception.EntityNotFoundException;

public class Service {
	private static final String COURSE_NOT_FOUND_MSG = "Course with id %d not found";
	private Dao dao;

	public Service(Dao dao) {
		this.dao = dao;
	}

	public int insertModuleInCourse(int courseid, Module modulo) throws EntityNotFoundException, BadRequestException {
		int numModuli;
		Course corso = dao.findCourse(courseid);
		List<Module> moduli = null;
		if (corso != null) {
			numModuli = corso.getModules().size();
			if (numModuli == 10) {
				throw new BadRequestException("Ci sono già 10 moduli!");
			} else {
				numModuli++;
				moduli = corso.getModules();
				moduli.add(modulo);
				corso.setModules(moduli);
				dao.updateCourse(corso);
			}
		} else
			throw new EntityNotFoundException(String.format(COURSE_NOT_FOUND_MSG, courseid));
		return numModuli;
	}
}
