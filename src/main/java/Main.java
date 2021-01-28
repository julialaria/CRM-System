import classes.*;
import enums.Product;
import styles.ConsoleColors;

import java.util.*;

public class Main {

    private Product product;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE_BACKGROUND + "\n WELCOME TO CRM-SYSTEM \n");
        System.out.println(ConsoleColors.BLUE + "Please write a order: \"NEW LEAD\", \"CONVERT\", \"LOOKUP OPPORTUNITY\", \"LOOKUP LEAD\", \"SHOW LEADS\", \"CLOSE-LOST\", \"CLOSE-WON\" ");
        String order = scan.nextLine();
        String[] orderSplit = order.split(" ");

        String[] keyPhrases = new String[]{"NEW LEAD", "CONVERT", "LOOKUP OPPORTUNITY", "LOOKUP LEAD", "SHOW LEADS", "CLOSE-LOST", "CLOSE-WON"};
        Map<Integer, Lead> leads = new HashMap<>();
        Map<Integer, Contact> contacts = new HashMap<>();
        Map<Integer, Opportunity> opportunities = new HashMap<>();
        Map<Integer, Account> accounts = new HashMap<>();

        while (!order.toUpperCase().equals("EXIT")){
            if(orderSplit.length>1){
            if((order.toUpperCase().equals(keyPhrases[0]))){

                Lead lead = MainMethods.newLead();
                leads.put(lead.getId(), lead);

            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[1])){
                try{
                    int idLead = Integer.parseInt(orderSplit[1]);

                    if (leads.containsKey(idLead) && orderSplit.length == 2){

                        Contact contact = MainMethods.convertLeadToContact(leads, idLead);
                        contacts.put(contact.getId(), contact);

                        Opportunity opportunity = CreateOpportunity.create(contact);
                        opportunities.put(opportunity.getId(), opportunity);

                        Account account = CreateAccount.create(contact,opportunity);
                        accounts.put(account.getId(),account);

                        leads.remove(idLead);}

                    else{
                        System.out.println(ConsoleColors.RED +"This Lead id is not valid, please check Leads with command 'SHOW LEADS'");
                    }
                }catch (NumberFormatException ex) {
                    System.err.println(ConsoleColors.RED +"Introduce a valid Lead id");
                }

            }
            else if ((orderSplit[0]+" "+orderSplit[1]).toUpperCase().equals(keyPhrases[2])&&orderSplit.length>2){

                MainMethods.lookupOpportunity(orderSplit, opportunities);
            }

            else if ((orderSplit[0]+" "+orderSplit[1]).toUpperCase().equals(keyPhrases[3])&&orderSplit.length>2){

                MainMethods.lookupLead(orderSplit, leads);
            }

            else if (order.toUpperCase().equals(keyPhrases[4])){

                MainMethods.showLeads(leads);

            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[5])){

                MainMethods.closeLost(orderSplit, opportunities);
            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[6])){

                MainMethods.closeWon(orderSplit, opportunities);
            }
            else {
                System.out.println(ConsoleColors.RED +"COMAND NOT FOUND");
            }}
            else{
                System.out.println(ConsoleColors.RED +"COMAND NOT FOUND");
            }
            order = MainMethods.whatNext();
            orderSplit = order.split(" ");
        }
    }
}

