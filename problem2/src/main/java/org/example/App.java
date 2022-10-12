package org.example;

import org.example.controller.RentalSystemController;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        RentalSystemController rentalSystemController = new RentalSystemController();
        boolean run = true;
        while (run) {
            System.out.println("""
                    ***********************************************
                    Enter function:
                    1. Input data
                    2. Show all information of furniture
                    3. Show information of a item
                    4. Quit
                    ***********************************************
                    """);
            int function = Integer.parseInt(scanner.nextLine());
            switch (function) {
                case 1:
                    rentalSystemController.inputData();
                    break;
                case 2:
                    rentalSystemController.showInfoFurniture();
                    break;
                case 3:
                    rentalSystemController.showInfoItem();
                    break;
                default:
                    run = false;
            }
        }
    }
}
