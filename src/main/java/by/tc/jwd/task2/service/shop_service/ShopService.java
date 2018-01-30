package by.tc.jwd.task2.service.shop_service;

import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;

public interface ShopService {

    Shop read() throws WorkWithDataSourceException;

    void write(Shop shop) throws WorkWithDataSourceException;

}
