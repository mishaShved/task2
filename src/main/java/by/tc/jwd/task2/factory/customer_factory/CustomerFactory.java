package by.tc.jwd.task2.factory.customer_factory;

import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.factory.customer_factory.impl.SimpleCustomerCreator;

public class CustomerFactory {

    private static final CustomerFactory ourInstance = new CustomerFactory();

    private CustomerFactory(){}

    public static CustomerFactory getOurInstance(){
        return ourInstance;
    }

    public CustomerCreator getCreator(){
        return new SimpleCustomerCreator();
    }

}
