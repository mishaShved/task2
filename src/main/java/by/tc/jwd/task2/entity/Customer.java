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

    public RentUnit getRentUnit() {
        return rentUnit;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void rentEquipment(Shop shop, SportEquipment sportEquipment)
            throws ExcessMaximumQuantityEquipmentsException, NotEnoughtMoneyException,
                EquipmentIsNotAvailableException{

        if(sportEquipment.getPrice() > money){
            throw new NotEnoughtMoneyException();
        }else if(rentUnit.getLength() == 3){
            throw new ExcessMaximumQuantityEquipmentsException();
        }
        shop.giveEquipment(sportEquipment);
        rentUnit.addUnit(sportEquipment);
        money = money - sportEquipment.getPrice();

    }

    public void returnEquipment(int i){
        rentUnit.removeUnit(i);
    }

    public void returnEquipment(SportEquipment sportEquipment, Shop shop){
        rentUnit.removeUnit(sportEquipment);
        shop.returnEquipment(sportEquipment);
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
