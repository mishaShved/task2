package by.tc.jwd.task2.entity;

import by.tc.jwd.task2.exception.EquipmentIsNotAvailableException;

import java.io.Serializable;
import java.util.*;

public class Shop implements Serializable {

    private Map<SportEquipment, Integer> goods;
    private List<Customer> customers;

    public Shop(){
        goods = new HashMap<>();
        customers = new ArrayList<>();
    }


    public Set<SportEquipment> getKeySet(){
        return goods.keySet();
    }

    public void addEquipment(SportEquipment sportEquipment, int count){
        goods.put(sportEquipment, count);
    }

    public int getEquipmentsCount(SportEquipment sportEquipment){
        return goods.get(sportEquipment);
    }

    public void giveEquipment(SportEquipment sportEquipment) throws EquipmentIsNotAvailableException{
        if (goods.get(sportEquipment) == 0){
            throw new EquipmentIsNotAvailableException();
        }
        goods.put(sportEquipment, goods.get(sportEquipment) - 1);
    }


    public void returnEquipment(SportEquipment sportEquipment){
        goods.put(sportEquipment, goods.get(sportEquipment) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(goods, shop.goods) &&
                Objects.equals(customers, shop.customers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(goods, customers);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        for (SportEquipment key: goods.keySet()) {
            res.append(key.getTitle()).append(" -- ").append(goods.get(key)).append("\n");
        }

        return "Shop{" +
                "goods=" + res +

                '}';
    }
}
