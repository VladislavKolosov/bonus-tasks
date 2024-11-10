package restaurant;

import java.util.Set;

public class Customer {
    private String name;
    private Set<String> order;
    private int numberOfTable;

    public Customer(String name, Set<String> order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getOrder() {
        return order;
    }

    public void setOrder(Set<String> order) {
        this.order = order;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", order='" + order + '\'' +
                ", numberOfTable=" + numberOfTable +
                '}';
    }
}
