package com.xsakon.travelproject.customer;

import java.util.Optional;

public interface CustomerDAO {
    Optional<Customer> selectCustomerByEmail(String email);
    boolean existsCustomerWithEmail(String email);
    int enableCustomerWithEmail(String email);
    void insertCustomer(Customer customer);
}
