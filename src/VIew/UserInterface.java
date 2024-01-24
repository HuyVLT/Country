/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIew;

import Controller.ManageEastAsiaCountries;
import Model.EastAsiaCountries;

import java.util.Scanner;

/**
 *
 * @author ninza
 */
public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private ManageEastAsiaCountries controller;

    public UserInterface(ManageEastAsiaCountries controller) {
        this.controller = controller;
    }
    public void run(){
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        addCountry(controller);
                        break;
                    case 2:
                        getCountry(controller);
                        break;
                    case 3:
                        searchbyName(controller);
                        break;
                    case 4:
                        sortbyOrder(controller);
                        break;
                    case 5:
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);
    }

    private static void displayMenu() {
        System.out.println("1. Add country information");
        System.out.println("2. Display recently entered information");
        System.out.println("3. Search information by country name");
        System.out.println("4. Sort information by ascending order of country name");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addCountry(ManageEastAsiaCountries controller) {
 
        System.out.print("Enter country code: ");
        String code = sc.next();
        System.out.print("Enter country name: ");
        String name = sc.next();
        System.out.print("Enter total area: ");
        float area = sc.nextFloat();
        System.out.print("Enter terrain: ");
        String terrain = sc.next();

        EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);

        try {
    
            controller.addcountry(country);
            System.out.println("Country information added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getCountry(ManageEastAsiaCountries controller) {
        try {
            EastAsiaCountries country = controller.getCountry();
            System.out.println("Recently entered country information:");
            country.display();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchbyName(ManageEastAsiaCountries controller) {
        System.out.print("Enter country name to search: ");
        String name = sc.next();

        try {
            EastAsiaCountries[] result = controller.searchbyName(name);
            System.out.println("Search result:");
            for (EastAsiaCountries country : result) {
                country.display();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void sortbyOrder(ManageEastAsiaCountries controller) {
        try {
            EastAsiaCountries[] sortedList = controller.sortbyOrder();
            System.out.println("Sorted information by ascending order of country name:");
            for (EastAsiaCountries country : sortedList) {
                country.display();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
