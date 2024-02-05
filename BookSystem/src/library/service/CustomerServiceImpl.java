package BookSystem.src.library.service;

import java.util.ArrayList;
import java.util.List;
 
import BookSystem.src.library.vo.Customer;

public class CustomerServiceImpl implements CustomerService{
    private List<Customer> customers = new ArrayList<>();

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
    
    @Override
    public boolean borrowBook(String bookid) {
        return false;
    }

    @Override
    public boolean returnBook(String bookid) {
        return false;
    }

    @Override
    public int getCount() {
        return customers.size();
    }

}
