package com.techelevator;

import java.math.BigDecimal;

public class StuffedAnimals {
    private String name;
    private String type;
    private String sound = "";


    public StuffedAnimals() {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }


    // Regular Colors


    public static final String Pink = "\033[38;5;206m";   // PINK
    static String Black = "\u001b[30m";
    static String Red = "\u001b[31m";
    static String Green = "\u001b[32m";
    static String Yellow = "\u001b[33m";
    static String Blue = "\u001b[34m";
    static String Magenta = "\u001b[35m";
    static String Cyan = "\u001b[36m";
    static String White = "\u001b[37m";
    static String BrightBlack = "\u001b[30;1m";
    static String BrightRed = "\u001b[31;1m";
    static String BrightGreen = "\u001b[32;1m";
    static String BrightYellow = "\u001b[93m";
    static String BrightBlue = "\u001b[34;1m";
    static String BrightMagenta = "\u001b[35;1m";
    static String BrightCyan = "\u001b[36;1m";
    static String BrightWhite = "\u001b[37;1m";
    static String Reset = "\u001b[0m";

    public String getSound(){
        if(getType().equalsIgnoreCase("duck"))
            System.out.println(BrightYellow+"Quack, Quack, Quackers!"+Reset);
        if(getType().equalsIgnoreCase("penguin"))
            System.out.println(BrightBlue+"Squawk, Squawk, Squawkers"+Reset);
        if(getType().equalsIgnoreCase("cat"))
            System.out.println(Pink+"Meow, Meow, Meowers!"+Reset);
        if(getType().equalsIgnoreCase("pony"))
            System.out.println(BrightRed+"Neigh, Neigh, Neighbors!"+Reset);
        return sound;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setType (String type) {
        this.type = type;
    }
}

