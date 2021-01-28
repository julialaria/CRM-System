package classes;

import enums.Product;
import enums.Status;
import styles.ConsoleColors;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class MainMethods {

    public static Lead newLead(){

        Scanner scan = new Scanner(System.in);
        String nameLead="";
        String phoneNumber;
        String email;
        boolean isValid = false;

        while(!isValid){
            System.out.println(ConsoleColors.BLUE+"Please specify the name of the lead");
            nameLead = scan.nextLine();
            isValid = nameLead.matches("[a-zA-Z]+");
            if(!isValid){
                System.out.println(ConsoleColors.RED+"The name of the lead is not valid. Can contain only letters");
            }
        }

        while(true){
            System.out.println(ConsoleColors.BLUE+ "Introduce phone number of the Lead");
            phoneNumber = scan.nextLine();
            try{
                Lead.isPhoneNumberValid(phoneNumber);
                break;
            } catch(IllegalArgumentException e){
                System.err.println(ConsoleColors.RED +"Phone number not valid, introduce it with the following format: " +
                        "612345678 / 612-345-678 / 612 345 678 / 612 34 56 78");
            }
        }

        while(true){
            System.out.println(ConsoleColors.BLUE+"Introduce email of the Lead");
            email = scan.nextLine();
            try{
                Lead.isEmailValid(email);
                break;
            }catch (IllegalArgumentException e){
                System.err.println(ConsoleColors.RED +"Introduce a valid email address");
            }

        }

        System.out.println(ConsoleColors.BLUE+"Introduce company name of the Lead");
        String companyName = scan.nextLine();
        Lead lead = new Lead(nameLead, phoneNumber, email, companyName);
        return lead;
    }

    public static Contact convertLeadToContact(Map<Integer, Lead> leads, int idLead){

        String name = leads.get(idLead).getName();
        String phoneNumber = leads.get(idLead).getPhoneNumber();
        String email = leads.get(idLead).getEmail();
        String companyName = leads.get(idLead).getCompanyName();

        Contact contact = new Contact(name, phoneNumber, email, companyName);
        return contact;
    }

    public static void lookupOpportunity(String[] orderSplit, Map<Integer, Opportunity> opportunities){
        int idOportunity=Integer.parseInt(orderSplit[2]);

        System.out.println(ConsoleColors.RED + "You must introduce an Id");

        if (opportunities.containsKey(idOportunity)){
            System.out.println(opportunities.get(idOportunity).toString());}
        else {
            System.out.println(ConsoleColors.RED +"Opportunity Id is not valid");
        }
    }

    public static void lookupLead(String[] orderSplit, Map<Integer, Lead> leads){
        int idLead = Integer.parseInt(orderSplit[2]);
        if (leads.containsKey(idLead)){
            System.out.println(leads.get(idLead).toString());}
        else {
            System.out.println(ConsoleColors.RED +"Lead Id is not valid");
        }
    }

    public static void showLeads(Map<Integer, Lead> leads){
        for (int idLead : leads.keySet()){
            System.out.println(leads.get(idLead).toString());
        }
    }

    public static void closeLost(String[] orderSplit, Map<Integer, Opportunity> opportunities){
        int idOpportunity = Integer.parseInt(orderSplit[1]);
        if (opportunities.containsKey(idOpportunity)){
            opportunities.get(idOpportunity).setStatus(Status.CLOSED_LOST);}
        else {
            System.out.println(ConsoleColors.RED +"Opportunity id is not valid");
        }
    }

    public static void closeWon(String[] orderSplit, Map<Integer, Opportunity> opportunities){
        int idOpportunity = Integer.parseInt(orderSplit[1]);
        if (opportunities.containsKey(idOpportunity)){
            opportunities.get(idOpportunity).setStatus(Status.CLOSED_WON);}
        else {
            System.out.println(ConsoleColors.RED +"Opportunity id is not valid");
        }
    }

    public static String whatNext(){
        String[] keyPhrases = new String[]{"NEW LEAD", "CONVERT + ID", "LOOKUP LEAD + ID", "LOOKUP OPPORTUNITY + ID", "SHOW LEADS", "CLOSE-LOST + ID", "CLOSE-WON + ID"};
        Scanner scan = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE +"What do you want to do next? " + Arrays.toString(keyPhrases));
        System.out.println(ConsoleColors.GREEN + "(Write 'EXIT' to close terminal)");
        String order = scan.nextLine();
        String[] orderSplit = order.split(" ");
        return order;
    }
}
