package by.tc.jwd.task2.entity;

import by.tc.jwd.task2.entity.category.Category;
import by.tc.jwd.task2.exception.EquipmentIsNotAvailableException;

import java.io.Serializable;
import java.util.*;

public class Shop implements Serializable {

    private Map<SportEquipment, Integer> goods;
    private List<Customer> customersJournal;

    public Shop(){
        goods = new HashMap<>();
        customersJournal = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        customersJournal.add(customer);
    }

    public Customer getCustomer(int i){
        return customersJournal.get(i);
    }

    public Customer getCustomer(String name){

        for (Customer shopClient : customersJournal ) {
            if (shopClient.getName().equalsIgnoreCase(name)){
                return shopClient;
            }
        }
        return null;
    }

    public boolean isRecorded(Customer customer){

        boolean exist = true;

        for (Customer shopClient : customersJournal ) {
            if (shopClient.getName().equalsIgnoreCase(customer.getName())){
                exist = false;
                break;
            }
        }

        return exist;
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


    public void setEquipmentsValue(SportEquipment sportEquipment, int coount){
        goods.put(sportEquipment, goods.get(sportEquipment) - 1);
    }


    public void returnEquipment(SportEquipment sportEquipment){
        goods.put(sportEquipment, goods.get(sportEquipment) + 1);
    }


    public List<Customer> getInfoAboutCustomers(){

        List<Customer> info = new ArrayList<>();

        for(Customer customer : customersJournal){
            info.add(customer);
        }

        return info;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(goods, shop.goods) &&
                Objects.equals(customersJournal, shop.customersJournal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(goods, customersJournal);
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
