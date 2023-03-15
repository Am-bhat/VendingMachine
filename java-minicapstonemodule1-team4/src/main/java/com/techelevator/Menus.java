package com.techelevator;

import java.util.Scanner;

public class Menus {

    private String mainMenu;
    private String purchaseMenu;
    Scanner scan = new Scanner(System.in);

    public String getMainMenu(){
        System.out.println("\n" +
                "What would you like to do?" +
                "\n 1.) Display Vending Machine Items" +
                "\n 2.) Purchase Item" +
                "\n 3.) Exit");
        return mainMenu;
    }

    public String getPurchaseMenu(){
        System.out.println("\n" +
                "What would you like to do?" +
                "\n 1.) Feed Money" +
                "\n 2.) Select Product" +
                "\n 3.) Finish Transaction");
        return purchaseMenu;
    }

}
