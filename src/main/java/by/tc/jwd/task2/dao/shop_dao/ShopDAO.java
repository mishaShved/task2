package by.tc.jwd.task2.dao.shop_dao;

import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.criteria.Category;
import by.tc.jwd.task2.exception.*;

import java.util.List;
import java.util.Map;

public interface ShopDAO {

    void createShop() throws WorkWithDataSourceException, PropertyFileNotFoundException;

    void openShop() throws WorkWithDataSourceException, PropertyFileNotFoundException;

    void addEquipment(SportEquipment sportEquipment, int count) throws ShopIsNotOpenException;
    SportEquipment leaseEquipment(SportEquipment sportEquipment, Customer customer)
            throws ShopIsNotOpenException, EquipmentIsNotAvailableException,
            NotEnoughtMoneyException, ExcessMaximumQuantityEquipmentsException;

    void returnEquipment(Customer customer, int equipmentIndex) throws ShopIsNotOpenException;

    List<SportEquipment> findEquipments(Category category) throws ShopIsNotOpenException;

    Map<SportEquipment, Integer> getInfoAboutIssuesGoods() throws ShopIsNotOpenException;

    Map<SportEquipment, Integer> getInfoAboutAvailableGoods() throws ShopIsNotOpenException;

    void closeShop() throws ShopIsNotOpenException, WorkWithDataSourceException, PropertyFileNotFoundException;

}
