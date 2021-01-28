package classes;

import enums.Industry;
import styles.ConsoleColors;

import java.util.Locale;
import java.util.Scanner;

import static java.util.List.of;

public class CreateAccount {

    private static final Scanner sc = new Scanner(System.in);

    public static Account create(Contact contact, Opportunity opportunity) {
        System.out.println(ConsoleColors.BLUE+"We are going to create an Account");

        Industry industry = enterCorrectIndustry(sc);
        int employees = getEmployees(sc);

        String city = getCity(sc);
        String country = getCountry(sc);

        return new Account(industry, employees, city, country, of(contact), of(opportunity));
    }

    public static String getCountry(Scanner scanner) {

        String country="";
        boolean aux = true;

        while(aux){
            System.out.println(ConsoleColors.BLUE+"Please specify your country");
            country = scanner.nextLine();
            aux = false;

            if (country.indexOf('1')!=-1 || country==""){
                aux=true;
            }
            if (country.indexOf('2')!=-1){
                aux=true;
            }
            if (country.indexOf('3')!=-1){
                aux=true;
            }
            if (country.indexOf('4')!=-1){
                aux=true;
            }
            if (country.indexOf('5')!=-1){
                aux=true;
            }
            if (country.indexOf('6')!=-1){
                aux=true;
            }
            if (country.indexOf('7')!=-1){
                aux=true;
            }
            if (country.indexOf('8')!=-1){
                aux=true;
            }
            if (country.indexOf('9')!=-1){
                aux=true;
            }
            if (country.indexOf('0')!=-1){
                aux=true;
            }
            if (aux==true){
                System.out.println(ConsoleColors.RED+"The country must be written and can not have numbers");
            }
        }

        return country;

    }

    public static String getCity(Scanner scanner) {

        String city="";
        boolean aux = true;

        while(aux){
            System.out.println(ConsoleColors.BLUE+"Please specify your city");
            city = scanner.nextLine();
            aux = false;

            if (city.indexOf('1')!=-1 || city==""){
                aux=true;
            }
            if (city.indexOf('2')!=-1){
                aux=true;
            }
            if (city.indexOf('3')!=-1){
                aux=true;
            }
            if (city.indexOf('4')!=-1){
                aux=true;
            }
            if (city.indexOf('5')!=-1){
                aux=true;
            }
            if (city.indexOf('6')!=-1){
                aux=true;
            }
            if (city.indexOf('7')!=-1){
                aux=true;
            }
            if (city.indexOf('8')!=-1){
                aux=true;
            }
            if (city.indexOf('9')!=-1){
                aux=true;
            }
            if (city.indexOf('0')!=-1){
                aux=true;
            }
            if (aux==true){
                System.out.println(ConsoleColors.RED+"The city must be written and can not have numbers");
            }
        }

        return city;

    }

    public static int getEmployees(Scanner scanner) {
        System.out.println(ConsoleColors.BLUE+ "Please specify your employee count");
        int employees = 0;
        boolean isValidemployees = false;
        while (!isValidemployees) {
            try {
                employees = Integer.parseInt(scanner.nextLine());
                isValidemployees = isValidEmployees(employees);
            } catch (Exception e) {
            }
            if (!isValidemployees) {
                System.out.println(ConsoleColors.RED+ "Specify a correct number > 0");
            }
        }
        return employees;
    }

    public static Industry enterCorrectIndustry(Scanner scanner) {
        System.out.println(ConsoleColors.BLUE+"Please specify your industry: (Options: 'PRODUCE', 'ECOMMERCE', 'MANUFACTURING','MEDICAL','OTHER')");
        String typeAccount = scanner.nextLine().toUpperCase(Locale.ROOT);
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
        System.out.println(ConsoleColors.RED +"Incorrect value, Correct values are: 'PRODUCE', 'ECOMMERCE', 'MANUFACTURING','MEDICAL','OTHER'");
        return false;
    }

    public static boolean isValidEmployees(int value) {
        return value > 0;
    }
}
