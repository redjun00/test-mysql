package hello.controller;

import hello.domain.Customer;
import hello.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public void putCustomer(Customer customer){
        customerRepository.save(customer);
    }

    @Transactional
    public Iterable<Customer> getCustomerList(){
        Iterable<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

    public long getCount(){
        long count = customerRepository.count();
        return count;
    }

    public void printCount(){
        System.out.println("=============count=" + getCount());
    }
}