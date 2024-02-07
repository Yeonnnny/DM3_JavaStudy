package BookSystem.src.library.service;

import java.util.ArrayList;
import java.util.List;

import BookSystem.src.library.vo.Book;
import BookSystem.src.library.vo.Customer;

public class BookServiceImpl implements BookService {
    private List<Book> books = new ArrayList<>();
    //CustomerServiceImpl cs = new CustomerServiceImpl();
    public final String MANAGER_NUM = "1013";

    @Override
    public Book search(String bookID) {
        for (Book book : books) {
            if(book.getBookID().equals(bookID))
                return book;   
        } 
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        books.add(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        for (Book b : books) {
            if (b.getBookID().equals(book.getBookID())) {
                b.setAuthor(book.getAuthor());
                b.setGenre(book.getGenre());
                break;
            }
        }
        // 책이 대출 중이라면, 찾아서 대출 중인 회원의 Book 리스트에서도 정보 바꿔줌
        if(book.isAvailable()==false){
            String cust_id = book.getBorrowingCusId().get(0);
            Customer customer = new CustomerServiceImpl().search(cust_id);
            Book[] booklist = customer.getBorringBooks();
            for(int i=0; i<booklist.length;i++){
                if(booklist[i].getBookID().equals(book.getBookID())){
                    booklist[i].setAuthor(book.getAuthor());
                    booklist[i].setGenre(book.getGenre());
                }
            }
        }

        return true;
    }

    @Override
    public boolean delete(String bookID) {
        Book book = search(bookID);
        books.remove(book);
        return true;
    }

    @Override
    public int getBookCount() {
        return books.size();
    }

    @Override
    public List<Book> selectAll() {
        return books;
    }

    
  

}
