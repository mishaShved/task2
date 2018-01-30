package by.tc.jwd.task2.service.shop_service.impl;

import by.tc.jwd.task2.dao.DAOFactory;
import by.tc.jwd.task2.dao.shop_dao.ShopDAO;
import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;
import by.tc.jwd.task2.service.shop_service.ShopService;

public class ShopServiceImpl implements ShopService {

    @Override
    public Shop read() throws WorkWithDataSourceException {

        DAOFactory factory = DAOFactory.getInstance();
        ShopDAO shopDAO = factory.getShopDAO();

        Shop shop = shopDAO.read();

        return shop;
    }

    @Override
    public void write(Shop shop) throws WorkWithDataSourceException {

        DAOFactory factory = DAOFactory.getInstance();
        ShopDAO shopDAO = factory.getShopDAO();

        shopDAO.write(shop);

    }
}
