package by.tc.jwd.task2.entity;

import by.tc.jwd.task2.entity.criteria.Category;

import java.io.Serializable;
import java.util.Objects;

public class SportEquipment implements Serializable {

    private Category category;
    private String title;
    private int price;

    public SportEquipment() {
    }

    public SportEquipment(Category category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportEquipment that = (SportEquipment) o;
        return price == that.price &&
                category == that.category &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, title, price);
    }

    @Override
    public String toString() {
        return "SportEquipment{" +
                "category=" + category +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
