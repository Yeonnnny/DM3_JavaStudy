import java.sql.Date;
import java.util.Arrays;

public class Customer {
    
    private String name; 
    private String id; 
    private String pwd;
    private int borrowCount;

    private final int MAX_BOOKNUM = 5;
    private Book[] borringBook = new Book[MAX_BOOKNUM];
    private int delayDay ;
    
    public Customer() {}

    public Customer(String name, String id, String pwd, int borrowCount, int delayDay, Book[] borringBook) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        this.borrowCount = borrowCount;
        this.delayDay = delayDay;
        this.borringBook = borringBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public int getDelayDay() {
        return delayDay;
    }

    public void setDelayDay(int delayDay) {
        this.delayDay = delayDay;
    }

    public int getMAX_BOOKNUM() {
        return MAX_BOOKNUM;
    }

    public Book[] getBorringBook() {
        return borringBook;
    }

    public void setBorringBook(Book[] borringBook) {
        this.borringBook = borringBook;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", id=" + id + ", pwd=" + pwd + ", borrowCount=" + borrowCount
                + ", MAX_BOOKNUM=" + MAX_BOOKNUM + ", borringBook=" + Arrays.toString(borringBook) + ", delayDay="
                + delayDay + "]";
    }


}