package by.tc.jwd.task2.dao.shop_dao.impl;

import by.tc.jwd.task2.dao.shop_dao.ShopDAO;
import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.criteria.Category;
import by.tc.jwd.task2.exception.*;
import by.tc.jwd.task2.serialization.ShopSerialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopDAOImpl implements ShopDAO {

    private Shop shop;


    @Override
    public void createShop() throws WorkWithDataSourceException, PropertyFileNotFoundException {

        shop = new Shop();
        ShopSerialization.write(shop);
    }


    @Override
    public void openShop() throws WorkWithDataSourceException, PropertyFileNotFoundException {

        shop = ShopSerialization.read();
    }

    @Override
    public void addEquipment(SportEquipment sportEquipment, int count) throws ShopIsNotOpenException {

        if (shop == null){
            throw new ShopIsNotOpenException();
        }
        shop.addEquipment(sportEquipment, count);
    }


    @Override
    public SportEquipment leaseEquipment(SportEquipment sportEquipment, Customer customer)
            throws ShopIsNotOpenException, EquipmentIsNotAvailableException,
                NotEnoughtMoneyException, ExcessMaximumQuantityEquipmentsException {

        if (shop == null) {
            throw new ShopIsNotOpenException();
        }
        if (shop.getEquipmentsCount(sportEquipment) == 0) {
            throw new EquipmentIsNotAvailableException();
        }

        if (customer.getCountOfRentedEquipment() == 3) {
            throw new ExcessMaximumQuantityEquipmentsException();
        }
        if (!shop.isRecorded(customer)){
            shop.addCustomer(customer);
        }
        customer = shop.getCustomer(customer.getName());
        if (sportEquipment.getPrice() > customer.getMoney()) {
            throw new NotEnoughtMoneyException();
        }


        customer.addEquipment(sportEquipment);
        customer.setMoney(customer.getMoney() - sportEquipment.getPrice());
        shop.setEquipmentsValue(sportEquipment, shop.getEquipmentsCount(sportEquipment) - 1);

        return sportEquipment;
    }

    @Override
    public void returnEquipment(Customer customer, int equipmentIndex) throws ShopIsNotOpenException {
        if (shop == null) {
            throw new ShopIsNotOpenException();
        }

        customer = shop.getCustomer(customer.getName());
        customer.returnEquipment(equipmentIndex);

        if(customer.getCountOfRentedEquipment() == 0){
            shop.deleteCustomer(customer);
        }
    }


    @Override
    public List<SportEquipment> findEquipments(Category category) throws ShopIsNotOpenException {

        if (shop == null){
            throw new ShopIsNotOpenException();
        }

        List<SportEquipment> searchResult = new ArrayList<SportEquipment>();

        for (SportEquipment equipment : shop.getKeySet()) {
            if (equipment.getCategory() == category) {
                searchResult.add(equipment);
            }
        }

        return searchResult;
    }

    @Override
    public Map<SportEquipment, Integer> getInfoAboutIssuesGoods() throws ShopIsNotOpenException {

        if (shop == null){
            throw new ShopIsNotOpenException();
        }
        Map<SportEquipment, Integer> info = new HashMap<>();

        int i = 0;

        while (i < shop.getCostumersCount()){

            for (int j = 0; j < shop.getCustomer(i).getCountOfRentedEquipment(); j++) {
                //info.add(shop.getCustomer(i).getEquipment(j));
                if (info.containsKey(shop.getCustomer(i).getEquipment(j))){
                    info.put(shop.getCustomer(i).getEquipment(j), info.get(shop.getCustomer(i).getEquipment(j)) + 1);
                }else{
                    info.put(shop.getCustomer(i).getEquipment(j), 1);
                }
            }
            i++;
        }
        return info;
    }

    @Override
    public Map<SportEquipment, Integer> getInfoAboutAvailableGoods() throws ShopIsNotOpenException {
        if (shop == null){
            throw new ShopIsNotOpenException();
        }
        Map<SportEquipment, Integer> info = new HashMap<>();

        for(SportEquipment sportEquipment : shop.getKeySet()){
            info.put(sportEquipment, shop.getEquipmentsCount(sportEquipment));
        }
        return info;
    }

    @Override
    public void closeShop() throws ShopIsNotOpenException,
            WorkWithDataSourceException, PropertyFileNotFoundException {

        if (shop == null){
            throw new ShopIsNotOpenException();
        }

        ShopSerialization.write(shop);


    }
}
