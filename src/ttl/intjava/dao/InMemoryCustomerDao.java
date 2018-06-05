package ttl.intjava.dao;

import ttl.intjava.domain.Customer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmadan on 6/4/18.
 */
public class InMemoryCustomerDao {
    private Map<Integer, Customer> customerMap = new HashMap<>();

    public synchronized Customer getCustomerById(Integer id) {
        return customerMap.get(id);
    }

    public synchronized  Map<Integer, Customer> getAllCustomers() {
        return customerMap;
    }

    public synchronized Customer insert(Customer customer) {
        Integer id = customer.getId();
        if (!customerMap.containsKey(id)) {
            customerMap.put(id, customer);
            return customer;
        }
        System.out.println("Customer with this id:[" + id + "] already exists");
        return null;
    }
}
