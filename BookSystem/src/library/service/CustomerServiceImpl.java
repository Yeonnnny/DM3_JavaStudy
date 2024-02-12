package BookSystem.src.library.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import BookSystem.src.library.vo.Book;
import BookSystem.src.library.vo.Customer;

public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers = new ArrayList<>();
    // BookServiceImpl bs = new BookServiceImpl();

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

    // 대출
    @Override
    public Book borrowBook(String id, Book book) {
        Customer customer = search(id);
        // 대출 날짜 설정
        book.setBorrow_date(LocalDate.now());

        // 대출 중인 도서 목록에 추가
        List<Book> booklists = customer.getBorrowingBooks();
        if (booklists == null) {
            booklists = new ArrayList<>();
        }
        booklists.add(book);
        customer.setBorrowingBooks(booklists);

        // 대출 불가능으로 변경 & 대출 중인 회원 아이디 저장
        book.setAvailable(false);
        book.setBorrowingCusId(id);

        // 회원, 도서 모두 대출 횟수 + 1
        customer.setBorrowCount(customer.getBorrowCount() + 1);
        book.setBorrowCount(book.getBorrowCount() + 1);

        return book;
    }

    // 반납
    @Override
    public boolean returnBook(String id, Book book) {
        Customer customer = search(id);

        // // 대출 중인 도서 목록에서 책 아이디가 같은 책 배열의 위치 저장
        // int index = -1;
        // Book[] booklists = customer.getBorrowingBooks();

        // for (int i = 0; i < booklists.length; i++) {
        // if (booklists[i].getBookID().equals(book.getBookID())) {
        // index = i;
        // break;
        // }
        // }

        // // 도서 목록에서 제거 후 저장
        // for (int i = index; i < booklists.length - 1; i++) {
        // booklists[i] = booklists[i + 1];
        // }
        // customer.setBorrowingBooks(booklists);

        List<Book> booklists = customer.getBorrowingBooks();

        for (int i = 0; i < booklists.size(); i++) {
            if (booklists.get(i).getBookID().equals(book.getBookID())) {
                booklists.remove(i);
                break;
            }
        }
        customer.setBorrowingBooks(booklists);

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
    public boolean isBookidExist(String id, String bookid) {
        Customer customers = search(id);
        // 현재 대출 중인 책 리스트
        List<Book> books = customers.getBorrowingBooks();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookID().equals(bookid)) {
                return true;
            }
        }
        return false;
    }

}
