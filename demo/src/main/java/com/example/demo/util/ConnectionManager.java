package com.example.demo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionManager {
    private static EntityManagerFactory factory;

    static{
        factory = Persistence.createEntityManagerFactory("javastudy");
    }

    public static EntityManager getManager(){
        return factory.createEntityManager();
    }

    public static void close(){
        factory.close();
    }
}
