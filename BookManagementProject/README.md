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
- bookID (pk): 책 아이디 (pk)
- bookName : 책 제목
- author : 책 저자
- genre : 책 장르
- available : 대출 가능 여부
- borrowCount : 대출 횟수 -> 베스트 셀러
- borrow_date : 대출일
- return_date : 반납일


## service (인터페이스 & 구현클래스)

- CustomerService.java
- CustomerServiceImpl.java
- BookService.java
- BookServiceImpl.java
 
### Customer 인터페이스

<pre>
    public Customer search(String id);           // 회원 검색
    public boolean insert(Customer customer);    // 회원 가입
    public ArrayList<Customer> selectAll();      // 회원 리스트 반환
    public boolean update(Customer customer);    // 회원 정보 수정(이름, 비밀번호) 
    public boolean delete(String id);            // 회원 삭제
    public boolean borrowBook(String bookid);    // 책 대출
    public boolean returnBook(String bookid);    // 책 반납
    public int getCount();                       // 회원 수 반환
</pre>

### Book 인터페이스
<pre>
    public Book search(String bookID);       // 도서 검색
    public boolean addBook(Book book);       // 도서 추가
    public boolean update(Book book);        // 도서 정보 수정 (저자, 장르)
    public boolean delete(String bookID);    // 도서 삭제
    public int getBookCount();               // 도서 수
    public ArrayList<Book> selectAll();      // 도서 리스트 반환
</pre>


## ui
- BookSystemUI.java


## main
- BookSystemMain.java



