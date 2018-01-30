package by.tc.jwd.task2.service.customers_service.impl;

import by.tc.jwd.task2.dao.DAOFactory;
import by.tc.jwd.task2.dao.customers_dao.CustomersDAO;
import by.tc.jwd.task2.dao.shop_dao.ShopDAO;
import by.tc.jwd.task2.entity.CustomersJournal;
import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;
import by.tc.jwd.task2.service.customers_service.CustomersService;

public class CustomServiceImpl implements CustomersService{
    @Override
    public CustomersJournal read() throws WorkWithDataSourceException {

        DAOFactory factory = DAOFactory.getInstance();
        CustomersDAO customersDAO = factory.getCustomersDAO();

        CustomersJournal journal = customersDAO.read();

        return journal;
    }

    @Override
    public void write(CustomersJournal journal) throws WorkWithDataSourceException {

        DAOFactory factory = DAOFactory.getInstance();
        CustomersDAO customersDAO = factory.getCustomersDAO();

        customersDAO.write(journal);

    }
}
