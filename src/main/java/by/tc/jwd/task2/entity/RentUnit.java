package by.tc.jwd.task2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentUnit implements Serializable {

    private List<SportEquipment> units;

    public RentUnit(){
        units = new ArrayList<>();
    }

    public SportEquipment getUnit(int i){
        return units.get(i);
    }

    public int getLength(){
        return units.size();
    }

    public void addUnit(SportEquipment sportEquipment){
        units.add(sportEquipment);
    }

    public void removeUnit(int i){
        units.remove(i);
    }

    public void removeUnit(SportEquipment sportEquipment){
        units.remove(sportEquipment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentUnit rentUnit = (RentUnit) o;
        return Objects.equals(units, rentUnit.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(units);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        for (SportEquipment el:units) {
            res.append(el).append("\n");
        }

        return "RentUnit{" +
                "units=" + res +
                '}';
    }
}
