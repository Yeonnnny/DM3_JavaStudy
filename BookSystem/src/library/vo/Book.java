package BookSystem.src.library.vo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String bookID;
    private String bookName;
    private String author;
    private String genre;
    private boolean available; // 대출 가능 여부
    private List<String> borrowingCusId;  // 대출 중인 회원 아이디
    private int borrowCount; // 대출 횟수 -> 베스트 셀러
    // 대출 날짜
    private LocalDate borrow_date; // 대출일
    private LocalDate return_date; // 반납일


    // 생성자
    public Book() {
    }

    public Book(String bookID, String bookName, String author, String genre) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.available = true; // 초기 값 : 대출 가능 -> true
        this.borrowingCusId = new ArrayList<>();
        this.borrowCount = 0;
        this.borrow_date = LocalDate.now();
        this.return_date = borrow_date.plusDays(14);
    }

    // getter/setter
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
   
    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount){
        this.borrowCount = borrowCount;
    }
    /**
     * @return List<String> return the borrowingCusId
     */
    public List<String> getBorrowingCusId() {
        return borrowingCusId;
    }
    /**
     * 대출 시 대출 중인 회원 아이디 리스트에 회원 아이디 추가
     * @param borrowingCusId
     */
    public void setBorrowingCusId(String borrowingCusId) {
        this.borrowingCusId.add(borrowingCusId);
    }

    /**
     * 반납 시 대출 중인 회원 아이디 리스트에서 회원 아이디 제거
     * @param borrowingCusId
     */
    public void removeBorrowingCusId(String borrowingCusId){
        this.borrowingCusId.remove(borrowingCusId);
    }
    
    // 기간관련된 변수는 set 불가능
    
    public LocalDate getBorrow_date() {
        return borrow_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    


    // 일반 메소드
    /**
     * 현재 날짜와 반납 날짜 간 차이 반환
     * (음수인 경우, 연체된 것임)
     * 
     * @param : 없음
     * @return 남은 반납기한
     **/
    public int remainigPeriod() {
        return Period.between(LocalDate.now(), return_date).getDays();
    }

    @Override
    public String toString() {
        return "책ID : " + bookID + ", 책 제목 : " + bookName + " (" + author + "), 장르 : " + genre
                + ", 대출날짜:" + borrow_date + ", 예상반납날짜:" + return_date + ", 남은 반납기한:" + remainigPeriod() + "]";
    }



}
