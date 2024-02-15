package org.it.svil.model;

public class Alimento {
    private String name;
    private double price;

    public Alimento(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
