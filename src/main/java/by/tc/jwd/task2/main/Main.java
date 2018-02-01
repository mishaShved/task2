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


public class Main {

    public static void main(String[] args) {


        ServiceFactory factory = ServiceFactory.getInstance();
        ShopService shopService = factory.getShopService();

        CustomerCreator customerCreator = CustomerFactory.getOurInstance().getCreator();
        EquipmentCreator equipmentCreator = EquipmentFactory.getInstance().getCreator();


        Customer misha = customerCreator.create("Misha", 200);
        Customer oleg = customerCreator.create("Oleg", 200);

        SportEquipment equipment = equipmentCreator.create(Category.BALL, "Football ball", 50);
        SportEquipment equipment1 = equipmentCreator.create(Category.ROCKET, "Volleyball ball", 60);

        Criteria criteria = new Criteria();
//        criteria.add(SearchCriteria.simpleEquipment.PRICE, 60);
        criteria.add(SearchCriteria.simpleEquipment.CATEGORY, Category.ROCKET);
//        criteria.add(SearchCriteria.simpleEquipment.TITLE, "adf");

        System.out.println(Validator.criteriaValidator(criteria));

        try {
            shopService.createShop();
            shopService.openShop();

            shopService.addEquipment(equipment, 5);
            shopService.addEquipment(equipment1, 4);

            System.out.println(shopService.findEquipments(criteria));

        } catch (WorkWithDataSourceException e) {
            e.printStackTrace();
        } catch (PropertyFileNotFoundException e) {
            e.printStackTrace();
        } catch (ShopIsNotOpenException e) {
            e.printStackTrace();
        }


    }
}
