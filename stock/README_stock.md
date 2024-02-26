# 재고 관리 프로그램

commit msg -> "yymmdd 일별 커밋수 : 변경 내용"


<br>
 
# Backend

## table

- table명 > stock
- sequence 객체명 > stock_seq

  
<br>
<pre>
create table stock(
    pid number constraint stock_id_pk primary key
    ,pname  varchar2(100) constraint stock_name_nn not null
    ,unit_price number constraint stock_price_nn not null
    ,pnum number default 1
    ,category varchar2(10) -- enum 타입
);
</pre>


<br>

## entity > Stock.java
long pid\
String pname\
int price\
int stock\
Category category  : enum

<br>

## util > ConnectionManager.java


<br>

## ui > StockUI.java
<pre>
  public void menu() {
      System.out.println(" <재고 관리 프로그램>");
      System.out.println("=====================");
      System.out.println("1. 물품 등록");
      System.out.println("2. 물품 검색 ");
      System.out.println("3. 물품 전체 보기");
      System.out.println("4. 물품 입고 / 출고 ");
      System.out.println("5. 물품 가격 변경");
      System.out.println("6. 물품 삭제");
      System.out.println("0. 프로그램 종료");
      System.out.println("=====================");
      System.out.print("선택 > ");
  }
</pre>


<br>

## service > StockService.java

<br/>

- 재고관리 관련 함수  (CRUD)
  - insert : 물품 등록
  - select : 물품 검색
  - update : 입고/출고, 가격 변동 
  - delete : 물품 삭제

<br/>
<pre>

public Products search(Long pid);

public boolean insert(Stock stock);

public Products selectOne(String pname);

public List<Product> selectAll();

// 입고 시 양수, 출고 시 음수 전달
public boolean updateStock(Long pid, int pnum); 

// 변경할 가격 전달
public boolean updatePrice(Long pid, int pric); 

public boolean delete(Long pid); 
</pre>


<br/>

## Main.java



# Frontend

## stock.html
## stock.css
## stock.js

