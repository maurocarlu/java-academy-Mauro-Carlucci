package com.academy.cic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.function.Executable;

import com.academy.cic.entity.Course;
import com.academy.cic.entity.Module;
import com.academy.cic.exception.*;

public class ServiceTest {

private static Dao dao;
	
	private static Service service;
	
	@BeforeAll
	static void init() {
		// creazione mock dao
		dao = Mockito.mock(Dao.class);
		service = new Service(dao);
	}
	
	@Test
	void should_ReturnException_When_NotFoundCourse() {
		Mockito.when(dao.findCourse(Mockito.anyInt())).thenReturn(null);
		Module modulo = new Module();
		Executable executable = () -> service.insertModuleInCourse(1,modulo);
		
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		assertEquals(""
				+ "course with id 1 not found", e.getMessage());
	}
	
	@Test
	void should_ReturnBadRequest_when_adding() {
        Module module = new Module();
        Course course = new Course();
        Mockito.when(dao.findCourse(Mockito.anyInt())).thenReturn(course);
        List<Module> modules = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            modules.add(new Module());
        }
        course.setModules(modules);
        Executable executable = () -> service.insertModuleInCourse(1,module);
        BadRequestException exception = assertThrows(BadRequestException.class, executable);
        assertEquals("Ci sono già 10 moduli!", exception.getMessage());
	}
	
	@Test
    public void should_execute_correctly() throws EntityNotFoundException, BadRequestException {
        int courseId = 1;
        Module module = new Module();
        Course course = new Course();
        List<Module> modules = new ArrayList<>();
        course.setModules(modules);

        Mockito.when(dao.findCourse(courseId)).thenReturn(course);

        int result = service.insertModuleInCourse(courseId, module);

        assertEquals(1, result);
    }
}
