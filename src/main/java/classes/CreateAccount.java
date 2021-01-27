package classes;

import enums.Industry;

import java.util.Scanner;

import static java.util.List.of;

public class CreateAccount {

    private static final Scanner scanner = new Scanner(System.in);

    public static Account create(Contact contact, Opportunity opportunity) {
        System.out.println("We are going to create an Account");

        Industry industry = enterCorrectIndustry();
        int employees = getEmployees();

        String city = getCity();
        scanner.nextLine();
        String country = getCountry();

        return new Account(industry, employees, city, country, of(contact), of(opportunity));
    }

    private static String getCountry() {
        System.out.println("Please specify your country");
        return scanner.nextLine();
    }

    private static String getCity() {
        System.out.println("Please specify your city");
        return scanner.nextLine();
    }

    private static int getEmployees() {
        System.out.println("Please specify your employee count");
        int employees = 0;
        boolean isValidemployees = false;
        while (!isValidemployees) {
            try {
                employees = scanner.nextInt();
                isValidemployees = isValidEmployees(employees);
            } catch (Exception e) {
            }
            if (!isValidemployees) {
                System.out.println("Specify a correct number > 0");
            }
        }
        return employees;
    }

    public static Industry enterCorrectIndustry() {
        System.out.println("Please specify your industry: (Options: 'PRODUCE', 'ECOMMERCE', 'MANUFACTURING','MEDICAL','OTHER')");
        String typeAccount = scanner.nextLine();
        while (!isCorrect(typeAccount)) {
            typeAccount = scanner.nextLine();
        }
        return Industry.valueOf(typeAccount);

    }

    public static boolean isCorrect(String test) {
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
