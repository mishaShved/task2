package by.tc.jwd.task2.factory.customer_factory.impl;

import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.factory.customer_factory.CustomerCreator;

public class SimpleCustomerCreator implements CustomerCreator{

    @Override
    public Customer create(String name, int money) {
        return new Customer(name, money);
    }
}
