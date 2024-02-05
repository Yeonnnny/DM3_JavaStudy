package BookSystem.src.library.service;

import java.util.ArrayList;
import java.util.List;

import BookSystem.src.library.vo.Book;
import BookSystem.src.library.vo.Customer;

public class CustomerServiceImpl implements CustomerService{
    private List<Customer> customers = new ArrayList<>();
    BookServiceImpl bs = new BookServiceImpl();

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
            if(c.getId().equals(customer.getId())){
                c.setPwd(customer.getPwd());
                c.setName(customer.getName());
            }        
        }
        return true;
    }
    
    @Override
    public boolean delete(String id) {
        Customer c  = search(id);
        customers.remove(c);
        return true;
    }
    
    /*
     * 책 id를 입력 받아 book의 대출 여부 값을 변경하고 
     * customer의 대출 중인 책 리스트에 삽입하는 함수이다. 
     * 그리고 customer의 borrowCount, book의 borrowCount 모두 1을 증가시켜줘야 함
     */
    @Override
    public Book borrowBook(String id ,String bookid) {
        Customer customer = search(id);
        Book book = bs.search(bookid);

        // 대출중인 도서 목록에 추가
        customer.setBorringBook(book);

        // 대출 불가능으로 변경
        book.setAvailable(false);

        // 회원, 도서 모두 대출 횟수 +1
        customer.setBorrowCount(customer.getBorrowCount()+1);
        book.setBorrowCount(book.getBorrowCount()+1);

        return book;
    }

    @Override
    public boolean returnBook(String bookid) {
        return false;
    }

    @Override
    public int getCount() {
        return customers.size();
    }

    @Override
    public int customerBorrowCount(String id) {
        Customer customer = search(id);
        return customer.getSize();
    }

}
