package by.tc.jwd.task2.main;

import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.criteria.Category;
import by.tc.jwd.task2.exception.*;
import by.tc.jwd.task2.factory.customer_factory.CustomerCreator;
import by.tc.jwd.task2.factory.customer_factory.CustomerFactory;
import by.tc.jwd.task2.factory.equipment_factory.EquipmentCreator;
import by.tc.jwd.task2.factory.equipment_factory.EquipmentFactory;
import by.tc.jwd.task2.service.ServiceFactory;
import by.tc.jwd.task2.service.ShopService;


public class Main {

    public static void main(String[] args) {


        ServiceFactory factory = ServiceFactory.getInstance();
        ShopService shopService = factory.getShopService();

        CustomerCreator customerCreator = CustomerFactory.getOurInstance().getCreator();
        EquipmentCreator equipmentCreator = EquipmentFactory.getInstance().getCreator();


        Customer misha = customerCreator.create("Misha", 200);
        Customer oleg = customerCreator.create("Oleg", 200);

        SportEquipment equipment = equipmentCreator.create(Category.BALL, "Football ball", 50);
        SportEquipment equipment1 = equipmentCreator.create(Category.SKATES, "Volleyball ball", 60);

        try {
           // shopService.createShop();
            shopService.openShop();
        } catch (WorkWithDataSourceException e) {
            System.out.println("файл");
        } catch (PropertyFileNotFoundException e) {
            System.out.println("проперти");
        }

        try {
           // shopService.addEquipment(equipment, 5);
            //shopService.addEquipment(equipment1, 1);

            PrintShopInfo.printSearchResult(shopService.findEquipments(Category.BALL));
            PrintShopInfo.printInfoAboutIssuesGoods(shopService.getInfoAboutIssuesGoods());

            PrintShopInfo.printInfoAboutAvailableGoods(shopService.getInfoAboutAvailableGoods());



            //System.out.println(misha);



            shopService.closeShop();
        } catch (ShopIsNotOpenException e) {
            System.out.println("магазин не открыт");
        } catch (WorkWithDataSourceException e) {
            System.out.println("файл");
        } catch (PropertyFileNotFoundException e) {
            System.out.println("проперти");
        }



//        try {
//            service.serialization();
//        } catch (WorkWithDataSourceException e) {
//            e.printStackTrace();
//        }


    }
}
