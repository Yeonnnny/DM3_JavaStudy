package com.miniproject.stock.service;

import java.util.List;
   
import com.miniproject.stock.entity.Stock;
import com.miniproject.stock.util.ConnectionManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class StockServiceImpl implements StockService{


    @Override
    public Stock search(Long pid) {
        Stock stock = null;
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            stock = manager.find(Stock.class, pid);
        } catch (Exception e) {
            tx.rollback();
        }finally{
            manager.close();
        }
        return stock;
    }

    @Override
    public boolean insert(Stock stock) {
        boolean result = false;
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.persist(stock);
            tx.commit();
            System.out.println("저장 완료");
            result = true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println("-------등록 안됨-----");
        }finally{ 
            manager.close();
        }
        return result;
    }

    @Override
    public Stock selectOne(String pname) {
        Stock result = null;
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();
            String query = "select s from Stock s where s.pname like :pname";

            // TypedQuery<Stock> stock = manager.createQuery(query, Stock.class);
            // stock.setParameter("pname", pname);
            // result = stock.getSingleResult();

            result = manager.createQuery(query,Stock.class).setParameter("pname", pname).getSingleResult();

        } catch (Exception e) {
            tx.rollback();
        }finally{
            manager.close();
        }

        return result;
    }

    @Override
    public List<Stock> selectAll(){
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        List<Stock> stockList = null;
        try {
            tx.begin();
            String query = "select s from Stock s";
            
            TypedQuery<Stock> tq = manager.createQuery(query,Stock.class);
            stockList = tq.getResultList();
            
        } catch (Exception e) {
            tx.rollback();
        }finally{
            manager.close();
        }
        return stockList;
    }
    
    @Override
    public boolean updateNum(Long pid, int num) {
        boolean result;        
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            Stock target = manager.find(Stock.class, pid);
            target.setPnum(target.getPnum()+num);
            tx.commit();
            result = true;
        } catch (Exception e) {
            tx.rollback();
            result=false;
        }finally{
            manager.close();
        }
        return result;
    }
    
    @Override
    public boolean updatePrice(Long pid, int price) {
        boolean result=false;
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            Stock target = manager.find(Stock.class, pid);
            target.setPrice(price);
            tx.commit();
            result = true;
        } catch (Exception e) {
            tx.rollback();
        }finally{
            manager.close();
        }
        return result;
    }
    

    @Override
    public boolean delete(Long pid){
        boolean result=false;
        EntityManager manager = ConnectionManager.getManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();

            Stock stock = manager.find(Stock.class, pid);
            manager.remove(stock);
            tx.commit();
            result=true;
        } catch (Exception e) {
            tx.rollback();
        }finally{
            manager.close();
        }
        
        return result;
        
    }    
}
