package by.tc.jwd.task2.service;

import by.tc.jwd.task2.service.customers_service.CustomersService;
import by.tc.jwd.task2.service.customers_service.impl.CustomServiceImpl;
import by.tc.jwd.task2.service.shop_service.ShopService;
import by.tc.jwd.task2.service.shop_service.impl.ShopServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory ourInstance = new ServiceFactory();
    private final ShopService shopService = new ShopServiceImpl();
    private final CustomersService customersService = new CustomServiceImpl();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
    }

    public ShopService getShopService() {
        return shopService;
    }

    public CustomersService getCustomersService() {
        return customersService;
    }
}
