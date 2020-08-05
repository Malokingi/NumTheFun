package com.matthewsgrand;
import java.util.Scanner;

public final class NumTheFun {
    private NumTheFun() {}
    
    final static TempFakeDatabase fakeDB = new TempFakeDatabase();
    final static Scanner scan = new Scanner(System.in);

        public static void main(final String[] args) {
            boolean loop = true;
            String userInput;
            System.out.print(fakeDB.getIntroDialogue("Main"));
        while(loop){
            System.out.print(fakeDB.getMenuDialogue("Main"));
            userInput = scan.nextLine();
            System.out.print(fakeDB.getIntroDialogue(userInput + "Intro"));
            switch (userInput) {
                case "11": start1_1(); break;
                case "00":
                    loop = false;
                    scan.close();
                    break;
                default:
                    //System.err.println("Sorry, " + userInput + " isn't a valid Menu option.");
                    break;
            }
        }
    }

    private static void start1_1() {
        System.out.print(fakeDB.getMenuDialogue("Theo"));
    }
}
