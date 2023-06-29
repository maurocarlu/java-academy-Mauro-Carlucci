package com.academy.cic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.Arrays;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import com.academy.cic.exception.*;
import com.academy.cic.entity.*;

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
	void should_return_menouno_when_uguale_zero() {
		Apartment apartment = new Apartment();
        apartment.setArea(0.0);


        Executable executable = () -> service.rateApartment(apartment.getId());
        assertEquals(-1, executable, "Rating dovrebbe essere -1");
	}
	
	@Test
	void should_return_zero_when_CheapThreshold_MinDizero() {
		
		Apartment apartment = new Apartment();
        apartment.setArea(50.0);
        apartment.setPrice(new BigDecimal("50"));
        
        Executable executable = () -> service.rateApartment(apartment.getId());
        assertEquals(0, executable, "Rating dovrebbe essere 0");
	}
	
	@Test
	void should_return_uno_when_compreso() throws EntityNotFoundException {
		Apartment apartment = new Apartment();
		apartment.setArea(5.0);
        apartment.setPrice(new BigDecimal("35000"));

        int rating = service.rateApartment(apartment.getId());
        assertEquals(1, rating, "Rating dovrebbe essere 1");
	}
	
	@Test
	void should_return_due_when_maggiore() {
		Apartment apartment = new Apartment();
		apartment.setArea(5.0);
        apartment.setPrice(new BigDecimal("100000"));

        Executable executable = () -> service.rateApartment(apartment.getId());
        assertEquals(2, executable, "Rating dovrebbe essere 2");
		
	}

	@Test
	void should_ReturnException_When_NotFoundApartment() {
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(null);
		
		Executable executable = () -> service.rateApartment(10);
		
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		assertEquals("Apartment with id 10 not found", e.getMessage());
	}
	
	@Test
	void should_return_AreaError() {
		Apartment apartment = new Apartment();
		apartment.setArea(10.0);
		Executable executable = () -> service.updateArea(1,1001);
		
		BadRequestException exception = assertThrows(BadRequestException.class, executable);
		assertEquals("Cannot update area to a value greater than 1000", exception.getMessage());
	}
	
	@Test
	void should_ReturnException_When_ApartmentDontExist() {
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(null);
		
		Executable executable = () -> service.updateArea(100,10);
		
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		assertEquals("Apartment with id 100 not found", e.getMessage());
	}
	
	
}