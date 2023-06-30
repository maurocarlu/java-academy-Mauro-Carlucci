package com.academy.cic;

import java.util.List;

import com.academy.cic.entity.Order;
import com.academy.cic.entity.OrderItem;

public class Service {
	
	private Dao dao;
	
	public Service(Dao dao) {
		this.dao = dao;
	}
	
	public double closeOrder(int orderId) {
		double total = 0.0;

		Order order = dao.findOrderWithProducts(orderId);
		if (order == null)
			throw new RuntimeException("Order not found");
		
		if ("CLOSED".equals(order.getStatus()))
			throw new RuntimeException("Order already closed");
		
		dao.updateOrderStatus(orderId, "CLOSED");
		
		List<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem orderItem: orderItems)
			total += orderItem.getProduct().getPrice()*orderItem.getQuantity();

		return total;
	}
	
	

}
