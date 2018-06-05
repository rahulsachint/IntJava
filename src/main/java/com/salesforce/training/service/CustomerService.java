package com.salesforce.training.service;

import com.salesforce.training.dao.InMemoryCustomerDao;
import com.salesforce.training.model.Customer;

import java.util.Map;

/**
 * Created by rmadan on 6/4/18.
 */
public class CustomerService {

    private InMemoryCustomerDao customerDao = new InMemoryCustomerDao();

    public Customer getCustomerById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    public Map<Integer, Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer addCustomer(Customer customer) {
        return customerDao.insert(customer);
    }
}
