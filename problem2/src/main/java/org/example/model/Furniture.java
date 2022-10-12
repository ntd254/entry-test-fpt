package org.example.model;

public class Furniture extends Thing{

    public Furniture(String serialNumber, String name, int price) {
        super(serialNumber, name, price);
    }

    @Override
    public String getDescription() {
        return String.format("Furniture [Serial number: %s Name: %s Price: %d]",
                this.getSerialNumber(), this.getName(), this.getPrice());
    }
}
