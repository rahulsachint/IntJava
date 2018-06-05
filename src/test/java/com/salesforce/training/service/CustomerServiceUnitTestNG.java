package com.salesforce.training.service;

import com.salesforce.training.model.Customer;
import com.salesforce.training.service.CustomerService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

/**
 * Created by rmadan on 6/4/18.
 */
public class CustomerServiceUnitTestNG {

    @Test
    public void testCustomerService() throws Exception {
        CustomerService service = new CustomerService();
        Customer rahul = new Customer(1, "Rahul", Customer.Status.PRIVILEGED);
        Customer rithy = new Customer(2, "Rithy", Customer.Status.NORMAL);
        Customer test = new Customer(3, "Test", Customer.Status.RESTRICTED);
        Customer duplicate = new Customer(1, "RahulDuplicate", Customer.Status.RESTRICTED);

        // Check if customers can be inserted
        Assert.assertEquals(service.addCustomer(rahul), service.getCustomerById(1), "Failed to add customers");
        Assert.assertEquals(service.addCustomer(rithy), service.getCustomerById(2), "Failed to add customers");
        Assert.assertEquals(service.addCustomer(test), service.getCustomerById(3), "Failed to add customers");
        // Make sure customer with same id cannot be inserted
        Assert.assertNull(service.addCustomer(duplicate), "Able to add duplicate customer");

        // Validate if all customers can be retrieved
        Map<Integer, Customer> allCustomers = service.getAllCustomers();
        Assert.assertEquals(allCustomers.size(), 3, "Unable to get all customers");




    }

    @Test
    public void lambdaSandbox () {
        Customer rahul = new Customer(1, "Rahul", Customer.Status.PRIVILEGED);
        Customer rithy = new Customer(2, "Rithy", Customer.Status.NORMAL);
        Customer test = new Customer(3, "Test", Customer.Status.RESTRICTED);
        List<Customer> customers = new ArrayList<>();
        customers.add(test);
        customers.add(rithy);
        customers.add(rahul);

        // LAMBDA 1
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        System.out.println("=========================================");
        customers.forEach(c -> System.out.println(c));

        Collections.shuffle(customers);
        Collections.sort(customers, (Customer c1, Customer c2) -> {
            return c1.getName().compareTo(c2.getName());
        });
        System.out.println("=========================================");
        // Method Reference
        customers.forEach(System.out::println);

        Collections.shuffle(customers);
        Collections.sort(customers, (c1, c2) -> c1.getName().compareTo(c2.getName()));
        System.out.println("=========================================");
        // Method Reference
        customers.forEach(this::easyPrint);
        customers.forEach(CustomerServiceUnitTestNG::easyStaticPrint);


        // LAMBDA 2
        System.out.println("=========================================");
        doIt(new MyInterface() {
            @Override
            public String fun(String s) {
                return "did " + s;
            }
        });

        doIt((String s) -> {
                return "did " + s;
            }
        );

        doIt(s -> "did " + s);
    }


    // FUNCTIONAL INTERFACE - has only one method
    interface MyInterface {
        public String fun(String s);
    }

    public void doIt(MyInterface mi) {
        String s = mi.fun("xyz");
        System.out.println("s is " + s);
    }

    public void easyPrint(Object o) {
        System.out.println(o);
    }

    public static void easyStaticPrint(Object o) {
        System.out.println(o);
    }

}