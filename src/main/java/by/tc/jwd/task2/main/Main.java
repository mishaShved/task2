package by.tc.jwd.task2.main;

import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.CustomersJournal;
import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;
import by.tc.jwd.task2.service.ServiceFactory;
import by.tc.jwd.task2.service.customers_service.CustomersService;
import by.tc.jwd.task2.service.shop_service.ShopService;

public class Main {

    public static void main(String[] args) {


//        Shop shop = null;
//
//        ServiceFactory factory = ServiceFactory.getInstance();
//        ShopService service = factory.getShopService();
//
//        try {
//            shop = service.deserialization();
//        } catch (WorkWithDataSourceException e) {
//            e.printStackTrace();
//        }

        ServiceFactory factory = ServiceFactory.getInstance();

        CustomersService customersJournalService = factory.getCustomersService();

        CustomersJournal journal = null;

        try{
            journal = customersJournalService.read();
        } catch (WorkWithDataSourceException e) {
            e.printStackTrace();
        }

        Customer customer = new Customer("sd", 23);



        System.out.println(journal);

        try{
            customersJournalService.write(journal);
        } catch (WorkWithDataSourceException e) {
            e.printStackTrace();
        }





//        try {
//            service.serialization();
//        } catch (WorkWithDataSourceException e) {
//            e.printStackTrace();
//        }


    }
}
