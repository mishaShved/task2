package by.tc.jwd.task2.dao.shop_dao;

import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;

public interface ShopDAO {

    Shop read() throws WorkWithDataSourceException;

    void write(Shop shop) throws WorkWithDataSourceException;

}
