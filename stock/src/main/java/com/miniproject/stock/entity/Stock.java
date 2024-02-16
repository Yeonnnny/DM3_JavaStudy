package com.miniproject.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity

public class Stock {

    @SequenceGenerator(    
        name = "stock_seq_gen",
        sequenceName = "stock_seq",
        initialValue = 1,
        allocationSize = 1
    )
    @Id
    @GeneratedValue(generator = "stock_seq_gen")
    private long pid;
    
    @Column(name="pname", nullable = false)
    private String pname;
    
    @Column(name="unit_price", nullable = false)
    private int price ;

    @Column(name ="pnum")
    private int stock;
    
    @Column(name ="category")
    @Enumerated (EnumType.STRING)
    private Category category;

    public Stock(String pname, int price, int stock, Category category) {
        this.pname = pname;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
}

// pid number constraint stock_id_pk primary key
// ,pname  varchar2(100) constraint stock_name_nn not null
// ,unit_price number constraint stock_price_nn not null
// ,pnum number default 1
// ,category varchar2(10) -- enum 타입
