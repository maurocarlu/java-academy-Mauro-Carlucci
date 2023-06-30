package com.academy.cic;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import com.academy.cic.entity.*;
import com.academy.cic.util.*;

public class Dao {

	// Inserimento di un cliente
	public void insertCustomer(Customer customer) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

//	Inserimento di un prodotto
	public void insertProduct(Product product) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(product);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

//	Inserimento di un ordine
	public void insertOrder(Order order) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(order);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	// Trovo un cliente dato il suo codice
	public Customer findCustomerByID(int customerId) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Customer customer = null;
		try {
			customer = entityManager.find(Customer.class, customerId);
			if (customer != null)
				Hibernate.initialize(customer.getOrders());
			Hibernate.initialize(customer.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return customer;
	}

	// Aggiornamento dello stato di un ordine
	public void updateOrderStatus(int orderId, String status) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			Order order = entityManager.find(Order.class, orderId);
			if (status != null) {
				order.setStatus(status);
				entityManager.getTransaction().begin();
				entityManager.merge(order);
				entityManager.getTransaction().commit();
			}

		} catch (HibernateException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	// Trovo il prezzo massimo dei prodotti di una data categoria
	public Double findMaxPriceByProductCateogory(String category) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Double maxPrice = 0.0;

		try {
			TypedQuery<Double> query = entityManager.createNamedQuery("Product.findMaxPriceByCategory", Double.class);
			query.setParameter("category", category);
			maxPrice = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return maxPrice;
	}

	// Trovo gli ordini di un dato cliente
	public List<Order> findOrdersByCustomerId(int customerId) {
		List<Order> ordini = null;
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			TypedQuery<Order> query = entityManager.createNamedQuery("Order.findByCustomer", Order.class);
			query.setParameter("customer", customerId);
			ordini = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return ordini;
	}

	// Trovo un ordine dato il suo id
	public Order findOrderWithProducts(int orderId) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Order order = null;
		try {
			order = entityManager.find(Order.class, orderId);
			if (order != null)
				Hibernate.initialize(order.getCustomer());
			Hibernate.initialize(order.getOrderItems());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return order;
	}

	// Trovo i prodotti di un ordine
	public List<OrderItem> getOrderItemsByOrder(int orderId) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			TypedQuery<OrderItem> query = entityManager.createNamedQuery("OrderItem.getByOrderId", OrderItem.class);
			query.setParameter("order", orderId);
			return query.getResultList();
		} finally {
			entityManager.close();
		}
	}

}
