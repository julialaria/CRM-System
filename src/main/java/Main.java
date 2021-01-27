import classes.*;
import enums.Product;
import enums.Status;
import styles.ConsoleColors;

import java.util.*;

public class Main {

    private Product product;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE_BACKGROUND + "\n WELCOME TO CRM-SYSTEM \n");
        System.out.println(ConsoleColors.BLUE + "Please write a order: ");
        String order = scan.nextLine();
        String[] orderSplit = order.split(" ");

        String[] keyPhrases = new String[]{"NEW LEAD", "CONVERT", "LOOKUP OPPORTUNITY", "LOOKUP LEAD", "SHOW LEADS", "CLOSE-LOST", "CLOSE-WON"};
        Map<Integer, Lead> leads = new HashMap<>();
        Map<Integer, Contact> contacts = new HashMap<>();
        Map<Integer, Opportunity> opportunities = new HashMap<>();
        Map<Integer, Account> accounts = new HashMap<>();

        while (!order.toUpperCase().equals("EXIT")){
            if((order.toUpperCase().equals(keyPhrases[0]))){

                System.out.println("Introduce name of the Lead");
                String nameLead = scan.nextLine();
                String phoneNumber;
                String email;
                while(true){
                    System.out.println("Introduce phone number of the Lead");
                    phoneNumber = scan.nextLine();
                    try{
                        Lead.isPhoneNumberValid(phoneNumber);
                        break;
                    } catch(IllegalArgumentException e){
                        System.err.println("Phone number not valid, introduce it with the following format: " +
                                "612345678 / 612-345-678 / 612 345 678 / 612 34 56 78");
                    }
                }

                while(true){
                    System.out.println("Introduce email of the Lead");
                    email = scan.nextLine();
                    try{
                        Lead.isEmailValid(email);
                        break;
                    }catch (IllegalArgumentException e){
                        System.err.println("Introduce a valid email address");
                    }

                }

                System.out.println("Introduce company name of the Lead");
                String companyName = scan.nextLine();
                Lead lead = new Lead(nameLead, phoneNumber, email, companyName);
                leads.put(lead.getId(), lead);

            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[1])){
                System.out.println("Convert Lead to opportunity");
                int idLead = Integer.parseInt(orderSplit[1]);
                if (leads.containsKey(idLead)){
                String name = leads.get(idLead).getName();
                String phoneNumber = leads.get(idLead).getPhoneNumber();
                String email = leads.get(idLead).getEmail();
                String companyName = leads.get(idLead).getCompanyName();

                Contact contact = new Contact(name, phoneNumber, email, companyName);
                contacts.put(contact.getId(), contact);

                System.out.println("Please specify your interests: (Options: 'HYBRID TRUCK', 'FLATBED TRUCK', 'BOX TRUCK')");
                String typeTruck = scan.nextLine();
                while (!typeTruck.toUpperCase().equals("HYBRID TRUCK") && !typeTruck.toUpperCase().equals("FLATBED TRUCK") && !typeTruck.toUpperCase().equals("BOX TRUCK")){
                    System.out.println("NOT AVAILABLE TYPE HAS BEEN INTRODUCED (Valid options: 'HYBRID TRUCK', 'FLATBED TRUCK', 'BOX TRUCK')");
                    typeTruck = scan.nextLine();
                }

                System.out.println("Please specify quantity of trucks you need: (Introduce a number)");
                String trucksQuantity = scan.nextLine();
                int trucksNum = Integer.parseInt(trucksQuantity);

                Opportunity opportunity;
                if (typeTruck.equals("HYBRID TRUCK")){
                    opportunity = new Opportunity(Product.HYBRID, trucksNum, contact);
                } else if (typeTruck.equals("FLATBED TRUCK")){
                    opportunity = new Opportunity(Product.FLATBED, trucksNum, contact);
                } else {
                    opportunity = new Opportunity(Product.BOX, trucksNum, contact);
                }
                opportunities.put(opportunity.getId(), opportunity);

                Account account = CreateAccount.create(contact,opportunity);
                accounts.put(account.getId(),account);

                leads.remove(idLead);}
                else{
                    System.out.println("This Lead id is not valid, please check Leads with command 'SHOW LEADS'");
                }

            }
            else if ((orderSplit[0]+" "+orderSplit[1]).toUpperCase().equals(keyPhrases[2])){
                    int idOportunity = Integer.parseInt(orderSplit[2]);
                    if (opportunities.containsKey(idOportunity)){
                    System.out.println(opportunities.get(idOportunity).toString());}
                    else {
                        System.out.println("Opportunity Id is not valid");
                    }
            }

            else if ((orderSplit[0]+" "+orderSplit[1]).toUpperCase().equals(keyPhrases[3])){
                    int idLead = Integer.parseInt(orderSplit[2]);
                    if (leads.containsKey(idLead)){
                    System.out.println(leads.get(idLead).toString());}
                    else {
                        System.out.println("Lead Id is not valid");
                    }
            }

            else if (order.toUpperCase().equals(keyPhrases[4])){
                for (int idLead : leads.keySet()){
                    System.out.println(leads.get(idLead).toString());
                }

            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[5])){
                int idOpportunity = Integer.parseInt(orderSplit[1]);
                if (opportunities.containsKey(idOpportunity)){
                opportunities.get(idOpportunity).setStatus(Status.CLOSED_LOST);}
                else {
                    System.out.println("Opportunity id is not valid");
                }
            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[6])){
                int idOpportunity = Integer.parseInt(orderSplit[1]);
                if (opportunities.containsKey(idOpportunity)){
                opportunities.get(idOpportunity).setStatus(Status.CLOSED_WON);}
                else {
                    System.out.println("Opportunity id is not valid");
                }
            }
            else {
                System.out.println("COMAND NOT FOUND");
            }
            order = whatNext();
            orderSplit = order.split(" ");
        }
    }

    public static String whatNext(){
        String[] keyPhrases = new String[]{"NEW LEAD", "CONVERT + ID", "LOOKUP LEAD + ID", "LOOKUP OPPORTUNITY + ID", "SHOW LEADS", "CLOSE-LOST + ID", "CLOSE-WON + ID"};
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do next? " + Arrays.toString(keyPhrases));
        System.out.println("(Write 'EXIT' to close terminal)");
        String order = scan.nextLine();
        String[] orderSplit = order.split(" ");
        return order;
    }
}

