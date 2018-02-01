package by.tc.jwd.task2.entity;

import by.tc.jwd.task2.exception.EquipmentIsNotAvailableException;
import by.tc.jwd.task2.exception.ExcessMaximumQuantityEquipmentsException;
import by.tc.jwd.task2.exception.NotEnoughtMoneyException;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable{

    private String name;
    private RentUnit rentUnit;
    private int money;

    public Customer() {

    }

    public Customer(String name, int money) {
        this.name = name;
        this.rentUnit = new RentUnit();
        this.money = money;
    }

    public String getName() {
        return name;
    }


    public int getCountOfRentedEquipment() {
        return rentUnit.getLength();
    }


    public int getMoney() {
        return money;
    }


    public void setMoney(int money) {
        this.money = money;
    }


    public void returnEquipment(int i){
        rentUnit.removeUnit(i);
    }


    public void addEquipment(SportEquipment sportEquipment){
        rentUnit.addUnit(sportEquipment);
    }

    public SportEquipment getEquipment(int i){
        return rentUnit.getUnit(i);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return money == customer.money &&
                Objects.equals(name, customer.name) &&
                Objects.equals(rentUnit, customer.rentUnit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, rentUnit, money);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", rentUnit=" + rentUnit +
                ", money=" + money +
                '}';
    }
}
