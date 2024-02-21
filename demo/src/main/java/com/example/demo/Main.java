package com.example.demo;

import com.example.demo.entity.Test;
import com.example.demo.util.ConnectionManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        
        try {
            tx.begin();
            Test test = new Test("yellow", 10);
            manager.persist(test);
            tx.commit();
            System.out.println("저장완료");
        } catch (Exception e) {
            tx.rollback();
        }finally{
            manager.close();
        }

    }

    
    

}
