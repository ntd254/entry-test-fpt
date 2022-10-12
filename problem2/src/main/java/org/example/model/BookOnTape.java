package org.example.model;

public class BookOnTape extends Thing{

    public BookOnTape(String serialNumber, String name, int price) {
        super(serialNumber, name, price);
    }

    @Override
    public String getDescription() {
        return String.format("Book on tape [Serial number: %s Name: %s Price: %d]",
                this.getSerialNumber(), this.getName(), this.getPrice());
    }
}
