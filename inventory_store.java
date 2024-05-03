
package inventory_system;

import java.util.*;

/**
 *
 * @author Masood Hussain
 */
public class inventory_store {
    static Timber[] timberList = new Timber[100];
    static int numTimbers = 0;
    
    static void addNewTimber(Scanner scanner) {
        System.out.println("Adding a new Timber record:");
        System.out.print("Zone(A,B,C,D): ");
        char zone = scanner.next().charAt(0);
        System.out.print("TimberID: ");
        int timberID = scanner.nextInt();
        System.out.print("Kind: ");
        String kind = scanner.next();        
        System.out.print("Weight: ");
        float weight = scanner.nextFloat();
        System.out.print("Height:");
        float height = scanner.nextFloat();
        System.out.print("Quantity:");
        int quantity = scanner.nextInt();
        System.out.print("Price: ");
        int price = scanner.nextInt();

        if (weight <0 || height<0 || quantity<0 || price<0  ) {
                System.out.println("Please enter correct values..");
                return;
            }
        // Check for duplicate TimberID
        for (int i = 0; i <  numTimbers; i++) {
            if (timberList[i].timberID == timberID) {
                System.out.println("TimberID already exists! Cannot add duplicate records.");
                return;
            }
        }
        

        // Create and add the timber
        Timber newTimber = new Timber(zone, timberID, kind, weight, height, quantity, price);
        timberList[numTimbers++] = newTimber;
        System.out.println("Timber record added successfully.");
        System.out.println("------------------------------------");
    }

    static void displayRecordsByZone(Scanner scanner) {
        System.out.print("Enter Zone (A, B, C, D): ");
        char zone = scanner.next().charAt(0);

        System.out.println("Timber records in Zone " + zone + ":");
        for (int i = 0; i < numTimbers; i++) {
            if (timberList[i].zone == zone) {
                displayTimber(timberList[i]);
            }
        }
         System.out.println("------------------------------------");
    }

    static void displayParticularRecord(Scanner scanner) {
        System.out.print("Enter Kind: ");
        String kind = scanner.next();

        System.out.println("Timber record with Kind " + kind + ":");
        for (int i = 0; i < numTimbers; i++) {
            if (timberList[i].kind.equals(kind)) {
                displayTimber(timberList[i]);
                System.out.println("------------------------------------");
                return;
            }
        }
        System.out.println("No record found with Kind " + kind);
    }

    static void analyzeRecords() {
        System.out.println("Timber records with quantity on hand lower than 100:");
        for (int i = 0; i < numTimbers; i++) {
            if (timberList[i].quantity < 100) {
                displayTimber(timberList[i]);
             System.out.println("------------------------------------");
            }
        }
    }

    static void salesUpdate(Scanner scanner) {
        System.out.print("Enter TimberID to be sold: ");
        int timberID = scanner.nextInt();

        for (int i = 0; i < numTimbers; i++) {
            if (timberList[i].timberID == timberID) {
                System.out.print("Enter Quantity to be sold: ");
                int soldQuantity = scanner.nextInt();

                if (soldQuantity > timberList[i].quantity) {
                    System.out.println("Error: Quantity to be sold exceeds quantity on hand.");
                    return;
                }

                timberList[i].quantity -= soldQuantity;
                System.out.println("Sales report:");
                displayTimber(timberList[i]);
                System.out.println("------------------------------------");
                return;
            }
        }
        System.out.println("TimberID not found.");
    }
static void deleteRecord(Scanner scanner) {
    System.out.print("Enter TimberID to be deleted: ");
    int timberID = scanner.nextInt();

    for (int i = 0; i < numTimbers; i++) {
        if (timberList[i].timberID == timberID) {
            timberList[i] = null; 
            numTimbers--; 
            System.out.println("Timber record deleted successfully.");
            System.out.println("------------------------------------");
            return;
        }
    }
    System.out.println("TimberID not found.");
}
    static void updateRecord(Scanner scanner) {
        System.out.print("Enter TimberID to be updated: ");
        int timberID = scanner.nextInt();

        for (int i = 0; i < numTimbers; i++) {
            if (timberList[i].timberID == timberID) {
                System.out.println("Updating Timber record:");
                System.out.print("Zone: ");
                timberList[i].zone = scanner.next().charAt(0);
                System.out.print("Kind: ");
                timberList[i].kind = scanner.next();
                System.out.print("Weight: ");
                timberList[i].weight = scanner.nextFloat();
                System.out.print("Height: ");
                timberList[i].height = scanner.nextFloat();
                System.out.print("Quantity: ");
                timberList[i].quantity = scanner.nextInt();
                System.out.print("Price: ");
                timberList[i].price = scanner.nextInt();
                System.out.println("Timber record updated successfully.");
                System.out.println("------------------------------------");
                return;
            }
        }
        System.out.println("TimberID not found.");
    }

    static void displayTimber(Timber timber) {
        System.out.println("Zone: " + timber.zone);
        System.out.println("TimberID: " + timber.timberID);
        System.out.println("Kind: " + timber.kind);
        System.out.println("Weight: " + timber.weight);
        System.out.println("Height: " + timber.height);
        System.out.println("Quantity: " + timber.quantity);
        System.out.println("Price: " + timber.price);
        System.out.println();
        System.out.println("*****************************");
    }

}
