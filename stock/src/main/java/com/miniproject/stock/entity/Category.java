package com.miniproject.stock.entity;

public enum Category {
    OUTER("아우터"), TOP("상의"), BOTTOM("하의"), ACC("잡화"), SHOES("신발");
    // 아우터("OUTER"), 상의("TOP"), 하의("BOTTOM"), 잡화("ACC"), 신발("SHOES");

    private String category;

    private Category(String category){
        this.category = category;
    }

    public String geCategory(){
        return this.category;
    }

}
