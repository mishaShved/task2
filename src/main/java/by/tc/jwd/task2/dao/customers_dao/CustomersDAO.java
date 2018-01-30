package by.tc.jwd.task2.dao.customers_dao;

import by.tc.jwd.task2.entity.CustomersJournal;
import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;

public interface CustomersDAO {

    CustomersJournal read() throws WorkWithDataSourceException;

    void write(CustomersJournal journal) throws WorkWithDataSourceException;

}
