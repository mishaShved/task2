package by.tc.jwd.task2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomersJournal implements Serializable {


    private List<Customer> journal;

    public CustomersJournal(){
        journal = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        journal.add(customer);
    }

    public Customer getCustomer(int i){
        return journal.get(i);
    }

    public void deleteCustomer(int i){
        journal.remove(i);
    }

    public void deleteCustomer(Customer customer){
        journal.remove(customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersJournal that = (CustomersJournal) o;
        return Objects.equals(journal, that.journal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(journal);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        for (Customer customer : journal) {
            res.append(customer).append("\n");
        }

        return "CustomersJournal{" +
                "journal=" + res +
                '}';
    }
}
