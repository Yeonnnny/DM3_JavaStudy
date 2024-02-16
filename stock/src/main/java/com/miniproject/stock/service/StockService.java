package com.miniproject.stock.service;

import java.util.List;

import com.miniproject.stock.entity.Stock;

public interface StockService {

    public Stock search(int pid);

    public boolean insert(Stock product);

    public Stock selectOne(int pid);
    
    public List<Stock> selectAll();

    public boolean updateStock(int pid, int stock); // 입고 시 양수, 출고 시 음수 전달
    
    public boolean updatePrice(int pid, int price); // 변경할 가격 전달

}
