package classes;

import java.util.ArrayList;
import java.util.List;

public class Lead {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private static int leadIdCounter = 1;
    private static List<Lead> leadList = new ArrayList<>();

    // When instantiating a Lead Object, it is automatically added to the List leadList.
    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.id = Lead.leadIdCounter++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        leadList.add(this);
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