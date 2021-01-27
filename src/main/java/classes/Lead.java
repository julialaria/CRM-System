package classes;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;
import java.util.List;

public class Lead {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private static int leadIdCounter = 1;
    private static List<classes.Lead> leadList = new ArrayList<>();

    // When instantiating a Lead Object, it is automatically added to the List leadList.
    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.id = Lead.leadIdCounter++;
        this.name = name;
        if (isPhoneNumberValid(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
        if(EmailValidator.getInstance().isValid(email)){
            this.email = email;
        } else{
            throw new IllegalArgumentException("The email address format is not valid.");
        }
        this.companyName = companyName;
        leadList.add(this);
    }

    public static boolean isPhoneNumberValid(String phoneNumber){
        boolean result = true;
            if (phoneNumber.matches("\\d{9}")) {
                result = true;
            } else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}")) {
                result = true;
            } else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}")){

            } else {
                throw new IllegalArgumentException("The phone number must be 9 digits in accordance with the following format:" +
                        " 612345678 / 612-345-678 / 612 345 678 / 612 34 56 78");
            }
        return result;
    }

    public static void showLead(){
        for(int i = 0; i<leadList.size();i++){
            System.out.println("ID: " +leadList.get(i).getId() + " name: " + leadList.get(i).getName() + "\n");
        }

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
        return "Lead{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}