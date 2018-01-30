package by.tc.jwd.task2.service.customers_service;

import by.tc.jwd.task2.entity.CustomersJournal;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;

public interface CustomersService {

    CustomersJournal read() throws WorkWithDataSourceException;

    void write(CustomersJournal journal) throws WorkWithDataSourceException;
}
