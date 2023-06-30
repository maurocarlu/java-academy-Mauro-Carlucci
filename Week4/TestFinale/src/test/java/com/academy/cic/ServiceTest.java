package com.academy.cic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.ArgumentMatchers.nullable;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

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
		void should_ReturnException_When_NotFoundOrder() {
			Mockito.when(dao.findOrderWithProducts(Mockito.anyInt())).thenReturn(null);
			
			Executable executable = () -> service.closeOrder(0);
			
			RuntimeException e = assertThrows(RuntimeException.class, executable);
			assertEquals("Order not found", e.getMessage());
		}
		
		@Test
		void should_ReturnException_When_OrderIsClosed() {
			int orderId = 1;
	        String status = "CLOSED";
	        Order order = new Order();
	        order.setStatus(status);
	        Mockito.when(dao.findOrderWithProducts(orderId)).thenReturn(order);
	        Mockito.when(order.getStatus()).thenReturn(status);

	        Executable executable = () -> service.closeOrder(1);
	        RuntimeException e = assertThrows(RuntimeException.class, executable);
			assertEquals("Order already closed", e.getMessage());
		}
		
		@Test
	    public void shouldReturnTotaleGiusto() {
	        int orderId = 1;
	        String status = "OPEN";
	        
	        double totaleDaRicevere = 25.0;

	        OrderItem orderItem = new OrderItem();
	        orderItem.setQuantity(1);

	        Product product = new Product();
	        product.setPrice(25.0);
	        orderItem.setProduct(product);
	        List<OrderItem> items = null;
	        items.add(orderItem);

	        Order order = new Order();
	        order.setStatus(status);
	        order.setOrderItems(Arrays.asList(orderItem));

	        Mockito.when(dao.findOrderWithProducts(orderId)).thenReturn(order);

	        double totaleRicevuto = service.closeOrder(orderId);
	        assertEquals(totaleDaRicevere, totaleRicevuto);
	    }
		
		

}
