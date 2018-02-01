package by.tc.jwd.task2.factory.customer_factory;

import by.tc.jwd.task2.entity.Customer;

public interface CustomerCreator {

    Customer create(String name, int money);

}
