package com.matthewsgrand;

import java.util.InputMismatchException;
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

            switch (userInput) {
                case "00":
                    System.out.print(fakeDB.getIntroDialogue("Outro"));
                    loop = false;
                    scan.close();
                    break;
                case "11": case "12": case "13": // If any of these are the case, call theMenu()
                case "21": case "22": case "23":
                case "24": case "25":
                    theMenu(userInput);
                    break;
                default:
                    System.err.println("Sorry, " + userInput + " isn't a valid Menu option.");
                    break;
            }
        }
    }

    // Theorem_Menu(String Theorem) - Prints out some more dialogue and, depending on
    // the theorem selected in main(), either prints the educational dialogue or
    // lets the user test some values and see what they evaluate to.
    private static void theMenu(final String the) {
        String userInput;
        boolean loop = true;
        System.out.print(fakeDB.getIntroDialogue(the + "Intro"));
        while (loop) {
            System.out.print(fakeDB.getMenuDialogue("Theo"));
            
            userInput = scan.nextLine();

            switch (userInput) {
                case "1":
                    System.out.println(fakeDB.getEduDialogue(the + "Edu"));
                    System.out.println();
                    break;
                case "2":
                    switch (the) {
                        case "11": start11(); break;
                        default:
                            System.err.println("Sorry, " + the + " is either yet to be implimented or invalid.");
                            break;
                    }
                    break;
                case "0":
                    loop = false;
                    break;
                default:
                    System.err.println("Sorry, " + userInput + " isn't a valid Menu option.");
                    break;
            }
        }
    }

    private static void start11() {
        int theInput;
        int theOutput;
        System.out.print("Okay. Enter a Natural Number: ");
        try {
            theInput = scan.nextInt();
            scan.nextLine(); // to clear the rest of the line after the expected Int value
            if ((theInput < 1)) {
                System.err.println("Sorry, " + theInput + " must be > 0.");
            } else {
                theOutput = the11(theInput, true);
                System.out.println("Either way, The sum is " + theOutput);
                // Testing whether the Non-User version works
                System.out.println("If you had entered 36, the sum would have been " + the11(36, false));
            }
        } catch (final InputMismatchException e) {
            System.err.println("Sorry, a Natural Number is an Integer that is > 0.");
        }
    }

    private static int the11(final int theInput, final boolean slow) {
        final int returnValue = ((theInput * (theInput + 1)) / 2);
        if (slow) {
            System.out.println("\nIf you have enough free time, you can add:");
            if (theInput > 10){
                for(int i = 1; i <= 10 - 1; i++) System.out.print(i + " + ");
                System.out.printf("... + ");
            }else{
                for(int i = 1; i <= theInput - 1; i++) System.out.print(i + " + ");
            }
            System.out.printf("%d = %d\n", theInput, returnValue);
            
            System.out.printf("Or ((%d x (%d + 1)) / 2) = %d\n", theInput, theInput, returnValue);
        }
        return returnValue;
    }
}
