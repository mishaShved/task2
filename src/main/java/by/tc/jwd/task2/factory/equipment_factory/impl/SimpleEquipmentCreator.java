package by.tc.jwd.task2.factory.equipment_factory.impl;

import by.tc.jwd.task2.entity.SportEquipment;
import by.tc.jwd.task2.entity.category.Category;
import by.tc.jwd.task2.factory.equipment_factory.EquipmentCreator;

public class SimpleEquipmentCreator implements EquipmentCreator {

    @Override
    public SportEquipment create(Category category, String title, int price) {
        return new SportEquipment(category, title, price);
    }

}
