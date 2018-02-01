package by.tc.jwd.task2.service;

import by.tc.jwd.task2.service.impl.ShopServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory ourInstance = new ServiceFactory();
    private final ShopService shopService = new ShopServiceImpl();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
    }
    public ShopService getShopService() {
        return shopService;
    }

}
