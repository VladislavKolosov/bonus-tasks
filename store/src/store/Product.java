package store;

import java.io.Serial;
import java.io.Serializable;

public class Product implements Serializable {
    @Serial
    private static final  long serialVersionUID = 1;

    private int id;
    private String name;
    private String description;
    private double perice;

    public Product(int id, String name, String description, double perice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.perice = perice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPerice() {
        return perice;
    }

    public void setPerice(double perice) {
        this.perice = perice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", perice=" + perice +
                '}';
    }
}
