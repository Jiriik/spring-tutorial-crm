package dao;

import entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
}