# 도서 관리 시스템 

** commit msg : 'ㅛymmdd '수정한파일경로' : 수정한 내용 , ...'

## vo

- Customer.java
- Book.java

- 인당 대출가능 책 수 : 5 권
- 책 대출 기간 : 14일

[Customer]
- name : 회원 이름
- id (pk) : 회원 아이디 
- pwd : 회원 비밀번호
- borringBook : 현재 대출 중인 책 (Book 객체 로 저장)
- borrowCount : 총 대출 횟수 -> 독서왕
- final MAX_BOOKNUM : 1인당 대출 가능 권 수 = 5
// delayDay : 연체 일자 -> 책마다 존재했으면 좋겠음... 

[Book]
- bookID (pk): 책 아이디 (pk)
- bookName : 책 제목
- author : 책 저자
- genre : 책 장르
- available : 대출 가능 여부
- borrowCount : 대출 횟수 -> 베스트 셀러
- borrow_date : 
- return_date :


## service (인터페이스 & 구현클래스)

- CustomerService.java
- CustomerServiceImpl.java
- BookService.java
- BookServiceImpl.java
 
### Customer 인터페이스
<pre>
- boolean insert(Customer customer) : 회원 가입
- int searchIndex(String id) : 회원 id 조회
- Customer selectOne(String id) : 회원 정보 조회
- boolean update(String id) : 회원 정보 수정
- boolean delete(String id) :  회원 삭제
- boolean borrow(String bookid) : 책 대출
- boolean return(String bookid) : 책 반납
- int getCount()  : 회원 수
</pre>

### Book 인터페이스
<pre>
- boolean addbook(String bookid) : 도서 추가
- int searchIndex(String bookid) : 책 id 조회
- Book selectOne(String bookid) : 책 정보 조회
- boolean update(String id) : 책 정보 수정
- boolean delete(String id) : 책 삭제
- int getBookCount()  :  도서 수
</pre>


## ui
- BookSystemUI.java


## main
- BookSystemMain.java



