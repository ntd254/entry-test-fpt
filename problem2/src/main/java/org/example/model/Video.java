package org.example.model;

public class Video extends Thing{

    public Video(String serialNumber, String name, int price) {
        super(serialNumber, name, price);
    }

    @Override
    public String getDescription() {
        return String.format("Video [Serial number: %s Name: %s Price: %d]",
                this.getSerialNumber(), this.getName(), this.getPrice());

    }
}
