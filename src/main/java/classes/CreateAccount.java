package classes;

import enums.Industry;

import java.util.Locale;
import java.util.Scanner;

import static java.util.List.of;

public class CreateAccount {

    private static final Scanner sc = new Scanner(System.in);

    public static Account create(Contact contact, Opportunity opportunity) {
        System.out.println("We are going to create an Account");

        Industry industry = enterCorrectIndustry(sc);
        int employees = getEmployees(sc);

        String city = getCity(sc);
        String country = getCountry(sc);

        return new Account(industry, employees, city, country, of(contact), of(opportunity));
    }

    public static String getCountry(Scanner scanner) {
        System.out.println("Please specify your country");
        return scanner.nextLine();
    }

    public static String getCity(Scanner scanner) {
        System.out.println("Please specify your city");
        return scanner.nextLine();
    }

    public static int getEmployees(Scanner scanner) {
        System.out.println("Please specify your employee count");
        int employees = 0;
        boolean isValidemployees = false;
        while (!isValidemployees) {
            try {
                employees = Integer.parseInt(scanner.nextLine());
                isValidemployees = isValidEmployees(employees);
            } catch (Exception e) {
            }
            if (!isValidemployees) {
                System.out.println("Specify a correct number > 0");
            }
        }
        return employees;
    }

    public static Industry enterCorrectIndustry(Scanner scanner) {
        System.out.println("Please specify your industry: (Options: 'PRODUCE', 'ECOMMERCE', 'MANUFACTURING','MEDICAL','OTHER')");
        String typeAccount = scanner.nextLine();
        while (!isCorrectIndustry(typeAccount)){
            typeAccount = scanner.nextLine();
        }
        return Industry.valueOf(typeAccount);

    }

    public static boolean isCorrectIndustry(String test) {
        for (Industry industry : Industry.values()) {
            if (industry.name().equals(test)) {
                return true;
            }
        }
        System.out.println("Incorrect value, Correct values are: 'PRODUCE', 'ECOMMERCE', 'MANUFACTURING','MEDICAL','OTHER'");
        return false;
    }

    public static boolean isValidEmployees(int value) {
        return value > 0;
    }
}
