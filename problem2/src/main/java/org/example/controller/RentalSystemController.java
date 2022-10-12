package org.example.controller;

import org.example.model.BookOnTape;
import org.example.model.Furniture;
import org.example.model.Thing;
import org.example.model.Video;
import org.example.repository.RentalSystemRepository;

import java.util.List;
import java.util.Scanner;

public class RentalSystemController {

    private final RentalSystemRepository rentalSystemRepository = new RentalSystemRepository();

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of item do you want to input: (1=Video, 2=Book on tape, 3=Furniture)");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter serial number");
        String serialNumber = scanner.nextLine();
        System.out.println("Enter name item");
        String name = scanner.nextLine();
        System.out.println("Enter price item");
        int price = Integer.parseInt(scanner.nextLine());
        if (type == 1) {
            rentalSystemRepository.save(new Video(serialNumber, name, price));
        } else if (type == 2) {
            rentalSystemRepository.save(new BookOnTape(serialNumber, name, price));
        } else {
            rentalSystemRepository.save(new Furniture(serialNumber, name, price));
        }
    }

    public void showInfoFurniture() {
        List<Furniture> furniture = rentalSystemRepository.findAllFurniture();
        furniture.forEach(item -> System.out.println(item.getDescription()));
    }

    public void showInfoItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter serial number:");
        String serialNumber = scanner.nextLine();
        Thing item = rentalSystemRepository.findById(serialNumber);
        System.out.println(item.getDescription());
    }
}
