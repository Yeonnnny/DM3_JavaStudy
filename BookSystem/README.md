# 도서 관리 시스템 

** commit msg : 'yymmdd  파일명 : 수정한 내용 , ...'

## vo

- 인당 대출 가능 책 개수 : 5 권
- 책 대출 기간 : 14일

[Customer]
- String id (pk) : 회원 아이디 
- String pwd : 회원 비밀번호
- String name : 회원 이름
- Book[] borringBook : 현재 대출 중인 책 (Book 배열)
- int borrowCount : 총 대출 횟수 -> 독서왕
- final int MAX_BOOKNUM = 5 : 1인당 대출 가능 권 수

[Book]
- String bookID (pk): 책 아이디 (pk)
- String bookName : 책 제목
- String author : 책 저자
- String genre : 책 장르
- boolean available : 대출 가능 여부
- List<String> borrowingCusId : 대출 중인 회원 아이디
- int borrowCount : 대출 횟수 -> 베스트 셀러
- LocalDate borrow_date : 대출일
- LocalDate return_date : 반납일


## service (인터페이스 & 구현클래스)

- CustomerService.java
- CustomerServiceImpl.java
- BookService.java
- BookServiceImpl.java
 
### Customer 인터페이스

<pre>
    public Customer search(String id);           // 회원 검색
    public boolean insert(Customer customer);    // 회원 가입
    public List<Customer> selectAll();           // 회원 리스트 반환
    public boolean update(Customer customer);    // 회원 정보 수정(이름, 비밀번호) 
    public boolean delete(String id);            // 회원 삭제
    public int getCount();                       // 총 회원 수 반환
    // ++++++++++++++++++++++++++ 도서 관련 함수 ++++++++++++++++++++++++++++++++++++
    public Book borrowBook(String id,String bookid);          // 책 대출
    public boolean returnBook(String id,String bookid);       // 책 반납
    public int customerBorrowCount(String id);                // 현재 대출 중인 책 수 반환
    public Book[] returnBorrowingBooklist(String id);         // 현재 대출 중인 책 리스트 반환
    public boolean isBookidExist(String id, String bookid);   // 현재 대출 중인 책인지 확인

</pre>

### Book 인터페이스
<pre>
    public Book search(String bookID);        // 도서 검색
    public boolean addBook(Book book);        // 도서 추가
    public boolean update(Book book);         // 도서 정보 수정 (저자, 장르)
    public boolean delete(String bookID);     // 도서 삭제
    public int getBookCount();                // 도서 수
    public List<Book> selectAll();            // 도서 리스트 반환
    public boolean possibleBorrow(String id); // 도서 대출 가능 여부 확인
</pre>


## ui
- LibSystemUI.java

** 메인 메뉴
<pre>
        System.out.println("=============[MENU]==============");
        System.out.println("\n-----------[회원 관리]-----------");
        System.out.println("\t1. 회원 정보 입력");
        System.out.println("\t2. 회원 정보 삭제");
        System.out.println("\t3. 회원 정보 수정");
        System.out.println("\t4. 회원 정보 검색");
        System.out.println("\t5. 전체 회원 정보");
        System.out.println("\n-----------[도서 관리]-----------");
        System.out.println("\t6. 도서 등록");
        System.out.println("\t7. 도서 삭제");
        System.out.println("\t8. 도서 정보 수정");
        System.out.println("\n-----------[도서서비스]-----------");
        System.out.println("\t9. 전체 도서 정보");
        System.out.println("\t10. 도서 정보 검색");
        System.out.println("\t11. 도서 대출");
        System.out.println("\t12. 도서 반납");
        System.out.println("\n-------------[종료]--------------");
        System.out.println("\t0. 프로그램 종료");
        System.out.println("\n==================================");
        System.out.print(" ** 선택> ");
</pre>


## main
- LibSystemMain.java



