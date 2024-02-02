import java.time.LocalDate;
import java.time.Period;

public class Book {

    private String bookID;  
    private String bookName;
    private String author;
    private String genre;
    private boolean available; // 대출 가능 여부
    private int borrowCount;
    // 대출 날짜 
    private LocalDate borrow_date ; // 대출한 날
    private LocalDate return_date ; // 반납해야할 날
    //private int delayDay; // (return_date-현재날짜  <0 )? 연체 : 연체x

    //생성자
    public Book() {}

    public Book(String bookID, String bookName, String author, String genre) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        
        this.available = false;
        this.borrowCount +=1;
        this.borrow_date = LocalDate.now();
        this.return_date= borrow_date.plusDays(14);
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

    // 기간관련된 변수는 set 불가능
    public boolean isAvailable() {
        return available;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

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
     * @param : 없음
     * @return  남은 반납기한
     **/
    public int remainigPeriod(){
        return Period.between(LocalDate.now(), return_date).getDays();
    }

    @Override
    public String toString() {
        return "Book [bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", genre=" + genre
                + ", available=" + available + ", borrowCount=" + borrowCount + ", borrow_date=" + borrow_date
                + ", return_date=" + return_date + ", 남은 반납기한=" + remainigPeriod() + "]";
    }

    

  


    



}
