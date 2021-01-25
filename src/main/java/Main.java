package com.ironhack.main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please write a order: ");
        String order = scan.nextLine();
        String[] orderSplit = order.split(" ");

        String[] keyPhrases = new String[]{"NEW LEAD", "CONVERT", "LOOKUP", "SHOW", "CLOSE-LOST", "CLOSE-WON"};

        while (!order.toUpperCase().equals("EXIT")){
            if((order.toUpperCase().equals(keyPhrases[0]))){
                System.out.println("Crear contact con la info de lead, me pide meter intereses y cantidad y se crea oportunity con contacto y status open");
                System.out.println("Please specify your interests: (Options: 'HYBRID TRUCK', 'FLATBED TRUCK', 'BOX TRUCK')");
                String typeTruck = scan.nextLine();
                while (!typeTruck.toUpperCase().equals("HYBRID TRUCK") && !typeTruck.toUpperCase().equals("FLATBED TRUCK") && !typeTruck.toUpperCase().equals("BOX TRUCK")){
                    System.out.println("NOT AVAILABLE TYPE HAS BEEN INTRODUCED (Valid options: 'HYBRID TRUCK', 'FLATBED TRUCK', 'BOX TRUCK')");
                    typeTruck = scan.nextLine();
                }
                System.out.println("Please specify quantity of trucks you need: (Introduce a number)");
                String trucksQuantity = scan.nextLine();
                int trucksNum = Integer.parseInt(trucksQuantity);

                order = whatNext();
                orderSplit = order.split(" ");
            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[1])){
                System.out.println("Convert Lead to opportunity");

                order = whatNext();
                orderSplit = order.split(" ");
            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[2])){
                System.out.println("Check info about");

                order = whatNext();
                orderSplit = order.split(" ");
            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[3])){
                System.out.println("Check general info");

                order = whatNext();
                orderSplit = order.split(" ");
            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[4])){
                System.out.println("Close-lost an opportunity");

                order = whatNext();
                orderSplit = order.split(" ");
            }
            else if (orderSplit[0].toUpperCase().equals(keyPhrases[5])){
                System.out.println("Close-win an opportunity");

                order = whatNext();
                orderSplit = order.split(" ");
            }
            else {
                System.out.println("COMAND NOT FOUND");
                order = whatNext();
                orderSplit = order.split(" ");
            }

        }}

    public static String whatNext(){
        String[] keyPhrases = new String[]{"NEW LEAD", "CONVERT", "LOOKUP", "SHOW", "CLOSE-LOST", "CLOSE-WON"};
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do next? " + Arrays.toString(keyPhrases));
        System.out.println("(Write 'EXIT' to close terminal)");
        String order = scan.nextLine();
        String[] orderSplit = order.split(" ");
        return order;
    }
}

