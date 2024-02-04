package BookManagementProject.service;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public Customer search(String id) {
        return null;
    }

    @Override
    public boolean insert(Customer customer) {
        return false;
    }

    @Override
    public ArrayList<Customer> selectAll() {
        return customers;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
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
