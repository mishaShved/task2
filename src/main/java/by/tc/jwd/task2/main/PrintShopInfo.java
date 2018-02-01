package by.tc.jwd.task2.main;

import by.tc.jwd.task2.entity.Customer;
import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.entity.SportEquipment;

import java.util.List;
import java.util.Map;

public class PrintShopInfo {

    public static void printMessage(String msg) {
        System.out.println(msg);
    }

    public static void printCustomer(Customer customer) {
        System.out.println("\nClient");
        System.out.println("Name -- " + customer.getName());
        System.out.println("Money -- " + customer.getMoney());
    }

    public static void printSportEquipment(SportEquipment sportEquipment) {
        System.out.println("\nCategory -- " + sportEquipment.getCategory().name());
        System.out.println("Title -- " + sportEquipment.getTitle());
        System.out.println("Price -- " + sportEquipment.getPrice());
    }

    public static void printInfoAboutAvailableGoods(Map<SportEquipment, Integer> goods) {
        System.out.println("\nAvaiable goods");

        for (SportEquipment equipment : goods.keySet()) {
            System.out.println(equipment.getTitle() + " -- " + goods.get(equipment));
        }
    }

    public static void printInfoAboutIssuesGoods(Map<SportEquipment, Integer> goods) {
        System.out.println("\nIssues goods");

        for (SportEquipment equipment : goods.keySet()) {
            System.out.println(equipment.getTitle() + " -- " + goods.get(equipment));
        }
    }

    public static void printSearchResult(List<SportEquipment> sportEquipments){

        System.out.println("\nSearch result");

        for (SportEquipment equipment: sportEquipments) {
            printSportEquipment(equipment);
        }
    }

}

