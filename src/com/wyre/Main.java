package com.wyre;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid number of arguements, 3 are required. 1 - The source language code 2- The target language code 3 - The text to be translated. Please try again");
            return;
        }

        Translater tans = new Translater();
        System.out.println(tans.translate(args[0], args[1], args[2]));
    }

}
