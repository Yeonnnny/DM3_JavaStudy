# 재고 관리 프로그램

commit msg -> "yymmdd 일별 커밋수 : 변경 내용"


<br/>

## table

- table명 > products
- sequence 객체명 > products_seq


<br/>
<pre>
pid number constraints products_id_ pk primary key
pname  varchar2(100) constraints products_name_nn not null
unit_price number constraints products_price_nn not null
stock number default 1
category enum ('outer','top','bottom','acc','shoes')
</pre>


<br/>

## entity > Products.java
int pId\
String pName\
int price\
int stock\
Category category  : enum

<br/>

## util > ConnectionManager.java


<br/>

## service > ProductsService.java

<br/>

- 재고관리 관련 함수  (CRUD)
  - insert : 물품 등록
  - select : 물품 검색
  - update : 입고/출고, 가격 변동 
  - delete : 물품 삭제

<br/>
<pre>

public Products search(int pid);

public boolean insert(Products products);

public Products selectOne(int pid);

public boolean updateStock(int pid, int stock); // 입고 시 양수, 출고 시 음수 전달
public boolean updatePrice(int pid, int price); // 변경할 가격 전달

public boolean delete(int pid); 
</pre>

<br/>

## ui > ProductsUI.java

<br/>

## Main.java