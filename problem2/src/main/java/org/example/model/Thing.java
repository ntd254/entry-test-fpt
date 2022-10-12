package org.example.model;

public abstract class Thing {

    private String serialNumber;
    private String name;
    private int price;

    public Thing(String serialNumber, String name, int price) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract String getDescription();
}
