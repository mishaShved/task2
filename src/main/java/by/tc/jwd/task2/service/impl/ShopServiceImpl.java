package by.tc.jwd.task2.service.impl;

import by.tc.jwd.task2.dao.DAOFactory;
import by.tc.jwd.task2.dao.shop_dao.ShopDAO;
import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.category.Category;
import by.tc.jwd.task2.exception.*;
import by.tc.jwd.task2.service.ShopService;

import java.util.List;

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
    public List<SportEquipment> findEquipments(Category category) throws ShopIsNotOpenException {
        return shopDAO.findEquipments(category);
    }

    @Override
    public List<SportEquipment> getInfoAboutIssuesGoods() throws ShopIsNotOpenException {
        return null;
    }

    @Override
    public void closeShop() throws ShopIsNotOpenException, WorkWithDataSourceException, PropertyFileNotFoundException {
        shopDAO.closeShop();
    }
}
