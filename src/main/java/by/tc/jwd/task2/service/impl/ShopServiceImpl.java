package by.tc.jwd.task2.service.impl;

import by.tc.jwd.task2.dao.DAOFactory;
import by.tc.jwd.task2.dao.shop_dao.ShopDAO;
import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.criteria.Category;
import by.tc.jwd.task2.entity.criteria.Criteria;
import by.tc.jwd.task2.exception.*;
import by.tc.jwd.task2.service.ShopService;

import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    private static final DAOFactory factory = DAOFactory.getInstance();
    private static final ShopDAO shopDAO = factory.getShopDAO();


    @Override
    public void createShop() throws WorkWithDataSourceException, PropertyFileNotFoundException {
        shopDAO.createShop();
    }

    @Override
    public void openShop() throws WorkWithDataSourceException, PropertyFileNotFoundException {
        shopDAO.openShop();
    }

    @Override
    public void addEquipment(SportEquipment sportEquipment, int count) throws ShopIsNotOpenException {
        shopDAO.addEquipment(sportEquipment, count);
    }

    @Override
    public SportEquipment leaseEquipment(SportEquipment sportEquipment, Customer customer)
            throws ShopIsNotOpenException, EquipmentIsNotAvailableException,
                NotEnoughtMoneyException, ExcessMaximumQuantityEquipmentsException {
        return shopDAO.leaseEquipment(sportEquipment, customer);
    }

    @Override
    public void returnEquipment(Customer customer, int equipmentIndex) throws ShopIsNotOpenException {
        shopDAO.returnEquipment(customer, equipmentIndex);
    }

    @Override
    public List<SportEquipment> findEquipments(Criteria criteria) throws ShopIsNotOpenException {
        return shopDAO.findEquipments(criteria);
    }

    @Override
    public Map<SportEquipment, Integer> getInfoAboutIssuesGoods() throws ShopIsNotOpenException {
        return shopDAO.getInfoAboutIssuesGoods();
    }

    @Override
    public Map<SportEquipment, Integer> getInfoAboutAvailableGoods() throws ShopIsNotOpenException {
        return shopDAO.getInfoAboutAvailableGoods();
    }

    @Override
    public void closeShop() throws ShopIsNotOpenException, WorkWithDataSourceException, PropertyFileNotFoundException {
        shopDAO.closeShop();
    }
}
