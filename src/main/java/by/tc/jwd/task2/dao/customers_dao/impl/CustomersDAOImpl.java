package by.tc.jwd.task2.dao.customers_dao.impl;

import by.tc.jwd.task2.configuration.WorkerWithProperties;
import by.tc.jwd.task2.dao.customers_dao.CustomersDAO;
import by.tc.jwd.task2.entity.CustomersJournal;
import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;

import java.io.*;

public class CustomersDAOImpl implements CustomersDAO{

    @Override
    public CustomersJournal read() throws WorkWithDataSourceException {

        CustomersJournal journal = null;

        String file = "";

        try {
            file = WorkerWithProperties.getOurInstance().getCustumersJournalFileName();
        } catch (IOException e) {
            throw new WorkWithDataSourceException(e);
        }

        try(ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            journal = (CustomersJournal) stream.readObject();
        }catch (IOException | ClassNotFoundException e){
            throw new WorkWithDataSourceException(e);
        }


        return journal;
    }

    @Override
    public void write(CustomersJournal journal) throws WorkWithDataSourceException {

        String file = "";

        try {
            file = WorkerWithProperties.getOurInstance().getCustumersJournalFileName();
        } catch (IOException e) {
            throw new WorkWithDataSourceException(e);
        }


        try(ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            stream.writeObject(journal);
        }catch (IOException e){
            throw new WorkWithDataSourceException(e);
        }

    }
}
