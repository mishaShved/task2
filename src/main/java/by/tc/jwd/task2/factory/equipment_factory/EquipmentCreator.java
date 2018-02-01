package by.tc.jwd.task2.factory.equipment_factory;

import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.criteria.Category;

public interface EquipmentCreator {

    SportEquipment create(Category category, String title, int price);

}
