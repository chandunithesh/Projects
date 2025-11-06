package apps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Billing {

    public static void main(String[] args) {
        int quantity;
        double pricePerUnit;
        double totalAmount = 0.0; // Initialize total amount to 0
        System.out.println("            ");
        LocalDate today = LocalDate.now();
        //
        System.out.println("----------KGR Book Store----------");
        // Print the current date
        System.out.println("Current Date: " + today);
        
        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> shoppingList = new ArrayList<>();
        ArrayList<Double> itemPrices = new ArrayList<>();
        ArrayList<Integer> itemQuantities = new ArrayList<>();

        System.out.println("Enter items for your shopping list:");
        System.out.println("Type 'done' to finish the List");
        String item;
        while (true) {
            System.out.print("Enter item: ");
            item = scanner.nextLine();
            if (item.equalsIgnoreCase("done")) {
                break;
            }
            shoppingList.add(item);

            // Ask for the price and quantity for each item
            System.out.print("Enter the price per unit for " + item + ": ");
            pricePerUnit = scanner.nextDouble();
            itemPrices.add(pricePerUnit);

            System.out.print("Enter the quantity for " + item + ": ");
            quantity = scanner.nextInt();
            itemQuantities.add(quantity);

            // Consume the leftover newline character after nextInt()
            scanner.nextLine(); 
        }

        // Calculate the total amount and display the shopping list
        System.out.println("\nYour Shopping List:");
        if (shoppingList.isEmpty()) {
            System.out.println("No items entered.");
        } else {
            for (int i = 0; i < shoppingList.size(); i++) {
                System.out.println((i + 1) + ". " + shoppingList.get(i) 
                                   + " | Price per unit: " + itemPrices.get(i) 
                                   + " | Quantity: " + itemQuantities.get(i) 
                                   + " | Total: " + (itemPrices.get(i) * itemQuantities.get(i)));
                totalAmount += itemPrices.get(i) * itemQuantities.get(i); // Add the item's total to the totalAmount
            }
        }

        // Display the calculated total amount
        System.out.println("\nThe total amount for your shopping list is: " + totalAmount);

        scanner.close();
    }
}
