package by.tc.jwd.task2.factory.equipment_factory;

import by.tc.jwd.task2.factory.equipment_factory.impl.SimpleEquipmentCreator;

public class EquipmentFactory {
    private static EquipmentFactory ourInstance = new EquipmentFactory();

    public static EquipmentFactory getInstance() {
        return ourInstance;
    }

    private EquipmentFactory() {
    }

    public EquipmentCreator getCreator(){
        return new SimpleEquipmentCreator();
    }
}
