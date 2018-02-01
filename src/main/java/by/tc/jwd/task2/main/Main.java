package by.tc.jwd.task2.main;

import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.category.Category;
import by.tc.jwd.task2.exception.*;
import by.tc.jwd.task2.service.ServiceFactory;
import by.tc.jwd.task2.service.ShopService;

import java.util.List;


public class Main {

    public static void main(String[] args) {


        ServiceFactory factory = ServiceFactory.getInstance();
        ShopService shopService = factory.getShopService();


        Customer misha = new Customer("Misha", 100);
        Customer oleg = new Customer("Oleg", 200);

        SportEquipment equipment = new SportEquipment(Category.BALL, "Football ball", 50);
        SportEquipment equipment1 = new SportEquipment(Category.SKATES, "Volleyball ball", 60);

        try {
            //shopService.createShop();
            shopService.openShop();
        } catch (WorkWithDataSourceException e) {
            System.out.println("файл");
        } catch (PropertyFileNotFoundException e) {
            System.out.println("проперти");
        }

        try {
            //shopService.addEquipment(equipment, 5);
            //shopService.addEquipment(equipment1, 1);

            List<SportEquipment> equipmentList = shopService.findEquipments(Category.BALL);

            shopService.leaseEquipment(equipmentList.get(0), misha);

            System.out.println(shopService.getInfoAboutIssuesGoods());
            System.out.println(misha);



            shopService.closeShop();
        } catch (ShopIsNotOpenException e) {
            System.out.println("магазин не открыт");
        } catch (WorkWithDataSourceException e) {
            System.out.println("файл");
        } catch (PropertyFileNotFoundException e) {
            System.out.println("проперти");

        } catch (ExcessMaximumQuantityEquipmentsException e) {
            System.out.println("много взял");
        } catch (EquipmentIsNotAvailableException e) {
            System.out.println("нет в наличии");
        } catch (NotEnoughtMoneyException e) {
            System.out.println("маловато денежек");
        }


//        try {
//            service.serialization();
//        } catch (WorkWithDataSourceException e) {
//            e.printStackTrace();
//        }


    }
}
