package by.tc.jwd.task2.main;

import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.criteria.Category;
import by.tc.jwd.task2.entity.criteria.Criteria;
import by.tc.jwd.task2.entity.criteria.SearchCriteria;
import by.tc.jwd.task2.exception.*;
import by.tc.jwd.task2.factory.customer_factory.CustomerCreator;
import by.tc.jwd.task2.factory.customer_factory.CustomerFactory;
import by.tc.jwd.task2.factory.equipment_factory.EquipmentCreator;
import by.tc.jwd.task2.factory.equipment_factory.EquipmentFactory;
import by.tc.jwd.task2.service.ServiceFactory;
import by.tc.jwd.task2.service.ShopService;
import by.tc.jwd.task2.service.validation.Validator;

import java.util.List;


public class Main {

    public static void main(String[] args) {


        ServiceFactory factory = ServiceFactory.getInstance();
        ShopService shopService = factory.getShopService();

        CustomerCreator customerCreator = CustomerFactory.getOurInstance().getCreator();
        EquipmentCreator equipmentCreator = EquipmentFactory.getInstance().getCreator();


        Customer misha = customerCreator.create("Misha", 2000);
        Customer oleg = customerCreator.create("Oleg", 2000);


        SportEquipment footballBall = equipmentCreator.create(Category.BALL,
                "Football ball", 50);
        SportEquipment volleyBall = equipmentCreator.create(Category.BALL,
                "Volleyball ball", 40);


        SportEquipment bigTennisRocket = equipmentCreator.create(Category.ROCKET,
                "Big tennis rocket", 70);
        SportEquipment tableTennisRocket = equipmentCreator.create(Category.ROCKET,
                "Table tennis rocket", 15);

        SportEquipment grassHockeyStick = equipmentCreator.create(Category.STICK,
                "Grass hockey Stick", 50);
        SportEquipment iceHockeyStick = equipmentCreator.create(Category.STICK,
                "Grass hockey Stick", 60);

        SportEquipment iceHockeySkates = equipmentCreator.create(Category.SKATES,
                "Ice hockey Skates", 100);

        SportEquipment goodBicycle = equipmentCreator.create(Category.BICYCLE,
                "Best bicycle", 300);
        SportEquipment badBicycle = equipmentCreator.create(Category.BICYCLE,
                "Common bicycle", 200);

        Criteria criteria = new Criteria();

        try {
            //shopService.createShop();
            shopService.openShop();
        } catch (WorkWithDataSourceException  | PropertyFileNotFoundException e) {
            PrintShopInfo.printMessage("Reading files error");
        }

        try{

//            shopService.addEquipment(footballBall, 10);
//            shopService.addEquipment(volleyBall, 10);
//
//            shopService.addEquipment(badBicycle, 10);
//            shopService.addEquipment(goodBicycle, 10);
//
//            shopService.addEquipment(grassHockeyStick, 10);
//            shopService.addEquipment(iceHockeyStick, 10);
//
//            shopService.addEquipment(iceHockeySkates, 10);
//
//            shopService.addEquipment(tableTennisRocket, 10);
//            shopService.addEquipment(bigTennisRocket, 10);


            criteria.add(SearchCriteria.simpleEquipment.PRICE, 15);
            criteria.add(SearchCriteria.simpleEquipment.CATEGORY, Category.ROCKET);

            PrintShopInfo.printSearchResult(shopService.findEquipments(criteria));

            criteria = new Criteria();
            criteria.add(SearchCriteria.simpleEquipment.CATEGORY, Category.BICYCLE);

            PrintShopInfo.printSearchResult(shopService.findEquipments(criteria));

            List<SportEquipment> equipments = shopService.findEquipments(criteria);

            try {
                shopService.leaseEquipment(equipments.get(0), misha);
            } catch (EquipmentIsNotAvailableException e) {
                PrintShopInfo.printMessage("Shop isn't have this equipment now");
            } catch (NotEnoughtMoneyException e) {
                PrintShopInfo.printMessage("You are have not enough money");
            } catch (ExcessMaximumQuantityEquipmentsException e) {
                PrintShopInfo.printMessage("You have 3 equipments, first return one of them");
            }

            criteria = new Criteria();
            criteria.add(SearchCriteria.simpleEquipment.CATEGORY, Category.BICYCLE);

            try {
                shopService.leaseEquipment(shopService.findEquipments(criteria).get(0), oleg);
            } catch (EquipmentIsNotAvailableException e) {
                PrintShopInfo.printMessage("Shop isn't have this equipment now");
            } catch (NotEnoughtMoneyException e) {
                PrintShopInfo.printMessage("You are have not enough money");
            } catch (ExcessMaximumQuantityEquipmentsException e) {
                PrintShopInfo.printMessage("You have 3 equipments, first return one of them");
            }

            PrintShopInfo.printInfoAboutAvailableGoods(shopService.getInfoAboutAvailableGoods());
            PrintShopInfo.printInfoAboutIssuesGoods(shopService.getInfoAboutIssuesGoods());

            shopService.returnEquipment(misha, 0);

            PrintShopInfo.printInfoAboutAvailableGoods(shopService.getInfoAboutAvailableGoods());
            PrintShopInfo.printInfoAboutIssuesGoods(shopService.getInfoAboutIssuesGoods());


        }catch (ShopIsNotOpenException e){
            PrintShopInfo.printMessage("You need to open shop");
        }

        try{
            shopService.closeShop();
        } catch (PropertyFileNotFoundException | WorkWithDataSourceException  e) {
            PrintShopInfo.printMessage("Reading files error");
        } catch (ShopIsNotOpenException e) {
            PrintShopInfo.printMessage("You need to open shop");
        }


    }
}
