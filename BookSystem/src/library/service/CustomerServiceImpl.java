package BookSystem.src.library.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import BookSystem.src.library.vo.Book;
import BookSystem.src.library.vo.Customer;

public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers = new ArrayList<>();
    //BookServiceImpl bs = new BookServiceImpl();

    @Override
    public Customer search(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean insert(Customer customer) {
        customers.add(customer);
        return true;
    }

    @Override
    public List<Customer> selectAll() {
        return customers;
    }

    @Override
    public boolean update(Customer customer) {
        for (Customer c : customers) {
            if (c.getId().equals(customer.getId())) {
                c.setPwd(customer.getPwd());
                c.setName(customer.getName());
            }
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        Customer c = search(id);
        customers.remove(c);
        return true;
    }

    @Override
    public int getCount() {
        return customers.size();
    }

    // ++++++++++++++ Book 관련 함수 +++++++++++++++++++++++

    @Override
    public Book borrowBook(String id, Book book) {
        Customer customer = search(id);
        //대출 날짜 설정
        book.setBorrow_date(LocalDate.now());
        
        // 대출 중인 도서 목록에 추가
        Book[] booklists = customer.getBorringBooks();
        if (booklists == null) {
            // 대출 중인 도서가 없는 경우 새 배열을 생성합니다.
            booklists = new Book[1];
            booklists[0] = book;
        }else {
            // 대출 중인 도서가 있는 경우 배열을 확장하고 새 도서를 추가합니다.
            Book[] newBooklists = new Book[booklists.length + 1];
            System.arraycopy(booklists, 0, newBooklists, 0, booklists.length);
            newBooklists[booklists.length] = book;
            booklists = newBooklists;
        }

        customer.setBorringBooks(booklists);

        // 대출 불가능으로 변경 & 대출 중인 회원 아이디 저장
        book.setAvailable(false);
        book.setBorrowingCusId(id);

        // 회원, 도서 모두 대출 횟수 + 1
        customer.setBorrowCount(customer.getBorrowCount() + 1);
        book.setBorrowCount(book.getBorrowCount() + 1);

        return book;
    }
    

    @Override
    public boolean returnBook(String id, String bookid) {
        Customer customer = search(id);
        Book book = new BookServiceImpl().search(bookid);

        // 대출 중인 도서 목록에서 책 아이디가 같은 책 배열의 위치 저장
        int index = -1;
        Book[] booklists = customer.getBorringBooks();
        for (int i = 0; i < booklists.length; i++) {
            if (booklists[i].getBookID().equals(bookid)) {
                index = i;
                break;
            }
        }
        // 도서 목록에서 제거 후 저장
        for (int i = index; i < booklists.length - 1; i++) {
            booklists[i] = booklists[i + 1];
        } 
        customer.setBorringBooks(booklists);

        // 책 대출 가능으로 변경 & 대출 중인 회원 아이디 리스트에서 회원 아이디 제거
        book.setAvailable(true);
        book.removeBorrowingCusId(id);

        return true;
    }

    @Override
    public int customerBorrowCount(String id) {
        Customer customer = search(id);
        return customer.getSize();
    }

    @Override
    public Book[] returnBorrowingBooklist(String id) {
        Customer customer = search(id);
        return customer.getBorringBooks();
    }

    @Override
    public boolean isBookidExist(String id, String bookid) {
        Customer customers = search(id);
        // 현재 대출 중인 책 리스트
        Book[] books = customers.getBorringBooks();

        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookID().equals(bookid)) {
                return true;
            }
        }
        return false;
    }

}
