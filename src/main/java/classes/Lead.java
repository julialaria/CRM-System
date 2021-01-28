package classes;

import org.apache.commons.validator.routines.EmailValidator;
import styles.ConsoleColors;

public class Lead {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private static int leadIdCounter = 1;

    // When instantiating a Lead Object, it is automatically added to the List leadList.
    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.id = Lead.leadIdCounter++;
        this.name = name;
        if (isPhoneNumberValid(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
        if(isEmailValid(email)) {
            this.email = email;
        }
        this.companyName = companyName;
    }

    public static boolean isEmailValid(String email){
        if(!EmailValidator.getInstance().isValid(email)){
            throw new IllegalArgumentException(ConsoleColors.RED+ "The email address format is not valid.");
        } else{
            return true;
        }
    }

    public static boolean isPhoneNumberValid(String phoneNumber){
        boolean result = true;
            if (phoneNumber.matches("\\d{9}")) {
                result = true;
            } else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}")) {
                result = true;
            } else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}")){

            } else {
                throw new IllegalArgumentException(ConsoleColors.RED + "The phone number must be 9 digits in accordance with the following format:" +
                        " 612345678 / 612-345-678 / 612 345 678 / 612 34 56 78");
            }
        return result;
    }

    public void printInfo(){
        System.out.println("Lead with id= " + id +
                ",with name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                " and companyName='" + companyName + '\'' +
                '}');

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Lead with id = " + id +
                " whose name is '" + name + '\'' +
                " has the following phone number '" + phoneNumber + '\'' +
                ", email address'" + email + '\'' +
                " and belongs to the company '" + companyName + '\'' +
                '}';
    }
}