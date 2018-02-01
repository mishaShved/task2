package by.tc.jwd.task2.dao;

import by.tc.jwd.task2.dao.shop_dao.impl.ShopDAOImpl;
import by.tc.jwd.task2.dao.shop_dao.ShopDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final ShopDAO shopDAO = new ShopDAOImpl();

    private DAOFactory(){}

    public ShopDAO getShopDAO(){
        return shopDAO;
    }

    public static DAOFactory getInstance(){
        return instance;
    }
}
