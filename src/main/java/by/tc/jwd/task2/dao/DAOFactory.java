package by.tc.jwd.task2.dao;

import by.tc.jwd.task2.dao.customers_dao.CustomersDAO;
import by.tc.jwd.task2.dao.customers_dao.impl.CustomersDAOImpl;
import by.tc.jwd.task2.dao.shop_dao.impl.ShopDAOImpl;
import by.tc.jwd.task2.dao.shop_dao.ShopDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final ShopDAO shopDAO = new ShopDAOImpl();
    private final CustomersDAO customersDAO = new CustomersDAOImpl();


    private DAOFactory(){}

    public ShopDAO getShopDAO(){
        return shopDAO;
    }

    public CustomersDAO getCustomersDAO() {
        return customersDAO;
    }

    public static DAOFactory getInstance(){
        return instance;
    }
}
