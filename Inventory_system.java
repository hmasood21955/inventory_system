
package inventory_system;

import java.util.*;

/**
 *
 * @author Masood Hussain
 */
public class Inventory_system {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int choice;

        do {
            System.out.println("Main Menu");
            System.out.println("[1]. Add a new Timber record");
            System.out.println("[2]. Display all records for a given Zone");
            System.out.println("[3]. Display a particular record given the Kind");
            System.out.println("[4]. Analysis of record level");
            System.out.println("[5]. Sales update Report");
            System.out.println("[6]. Delete a particular Timber record");
            System.out.println("[7]. Update a particular Timber record");
            System.out.println("[8]. Exit");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inventory_store.addNewTimber(scanner);
                    break;
                case 2:
                    inventory_store.displayRecordsByZone(scanner);
                    break;
                case 3:
                    inventory_store.displayParticularRecord(scanner);
                    break;
                case 4:
                    inventory_store.analyzeRecords();
                    break;
                case 5:
                    inventory_store.salesUpdate(scanner);
                    break;
                case 6:
                    inventory_store.deleteRecord(scanner);
                    break;
                case 7:
                    inventory_store.updateRecord(scanner);
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 8.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
    

