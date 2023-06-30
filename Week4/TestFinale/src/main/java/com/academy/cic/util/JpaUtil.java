package com.academy.cic.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
    private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
    
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("orders_final");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
