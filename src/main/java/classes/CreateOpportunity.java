package classes;

import enums.Product;
import styles.ConsoleColors;

import java.util.Locale;
import java.util.Scanner;

public class CreateOpportunity {

    public static Opportunity create(Contact contact) {
        Scanner scan = new Scanner(System.in);
        Product typeTruck = enterCorrectType(scan);
        int trucksNum = getTruckNumber(scan);

        return new Opportunity(typeTruck, trucksNum, contact);
    }

    public static int getTruckNumber(Scanner scanner) {
        System.out.println(ConsoleColors.BLUE + "Please specify quantity of trucks you need: (Introduce a number)");
        int employees = 0;
        boolean isValidemployees = false;
        while (!isValidemployees) {
            try {
                employees = Integer.parseInt(scanner.nextLine());
                isValidemployees = isValidTruckNumber(employees);
            } catch (Exception e) {
            }
            if (!isValidemployees) {
                System.out.println(ConsoleColors.RED + "Please introduce a valid number");
            }
        }
        return employees;
    }

    public static Product enterCorrectType(Scanner scanner) {
        System.out.println(ConsoleColors.BLUE + "Please specify your interests: (Options: 'HYBRID', 'FLATBED', 'BOX')");
        String typeTruck = scanner.nextLine().toUpperCase(Locale.ROOT);
        while (!isCorrectTruck(typeTruck)) {
            typeTruck = scanner.nextLine().toUpperCase(Locale.ROOT);
        }
        return Product.valueOf(typeTruck);
    }

    public static boolean isCorrectTruck(String test) {
        for (Product product : Product.values()) {
            if (product.name().equals(test)) {
                return true;
            }
        }
        System.out.println(ConsoleColors.RED + "NOT AVAILABLE TYPE HAS BEEN INTRODUCED (Valid options: 'HYBRID', 'FLATBED', 'BOX')");
        return false;
    }

    public static boolean isValidTruckNumber(int value) {
        return value > 0;
    }

}
