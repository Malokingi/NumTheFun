package com.matthewsgrand;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class NumTheFun {
    private NumTheFun() {}

    final static TempFakeDatabase fakeDB = new TempFakeDatabase();
    final static Scanner scan = new Scanner(System.in);

    private static int pow(int a, int b){ // a power function that doesn't need Doubles
        int r = 1;
        for (int i = 0; i < b; i++) r *= a;
        return r;
    }
    private static String arrToString(int[] arr){ // Taks Int Arrays and makes them Human-Fathomable
        String ret = "{ ";
        for (int i = 0; i < arr.length - 1; i++) ret += arr[i] + ", ";
        return ret + arr[arr.length - 1] + " }";
    }
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
                        case "11": learn11(); break;
                        case "12": learn12(); break;
                        case "13": learn13(); break;
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

    private static void learn11() {
        int n;
        int theOutput;
        System.out.print("Okay. Enter a Natural Number, n = ");
        try {
            n = scan.nextInt();
            scan.nextLine(); // to clear the rest of the line after the expected Int value
            if ((n < 1)) {
                System.err.println("Sorry, " + n + " must be > 0.");
            } else {
                theOutput = the11(n, true);
                System.out.println("Either way, The sum is " + theOutput);
                // Testing whether the Non-User version works
                System.out.println("If you had entered 36, the sum would have been " + the11(36, false));
            }
        } catch (final InputMismatchException e) {
            System.err.println("Sorry, a Natural Number is an Integer that is > 0.");
        }
    }

    private static int the11(final int n, final boolean slow) {
        final int returnValue = ((n * (n + 1)) / 2);
        if (slow) {
            System.out.println("\nIf you have enough free time, you can add:");
            if (n > 10){
                for(int i = 1; i <= 10 - 1; i++) System.out.print(i + " + ");
                System.out.printf("... + ");
            }else{
                for(int i = 1; i <= n - 1; i++) System.out.print(i + " + ");
            }
            System.out.printf("%d = %d\n", n, returnValue);
            System.out.printf("Or ((%d x (%d + 1)) / 2) = %d\n", n, n, returnValue);
        }
        return returnValue;
    }
    
    private static void learn12() {
        int x;
        int n;
        int theOutput;
        System.out.print("Okay. Enter an Integer (!= 1), x = ");
        x = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        System.out.print("Okay. Enter a Natural Number, n = ");
        n = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        theOutput = the12(x, n, true);
        System.out.println("Either way, The sum is " + theOutput);
        // Testing whether the Non-User version works
        System.out.println("If you had entered 36 and 5, the sum would have been " + the12(5, 36, false));
    }

    private static int the12(final int x, final int n, final boolean slow) {
        final int returnValue =  ((pow(x, n)) - 1) / (x - 1);
        if (slow) {
            System.out.println("\nIf you have enough free time, you can add:");
            for(int i = 0; i < n - 1; i++) System.out.printf("(%d ^ %d) + ", x, i);
            System.out.printf("(%d ^ %d) = \n", x, n - 1);
            for(int i = 0; i < n - 1; i++) System.out.printf("(%d) + ", pow(x, i));
            System.out.printf("(%d) = %d\n", pow(x, n - 1), returnValue);
            System.out.printf("Or ((%d ^ %d) - 1) / (%d - 1) = %d\n", x, n, x, returnValue);
            System.out.printf("Or (%d) / (%d) = %d\n", pow(x, n) - 1, x - 1, returnValue);
        }
        return returnValue;
    }

    private static void learn13() {
        int k;
        int n;
        int[] theOutput;
        System.out.print("Okay. Enter a Natural Number, k = ");
        k = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        System.out.print("Okay. Enter a Natural Number, n = ");
        n = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        theOutput = the13(k, n, true);
        System.out.println("The result is " + arrToString(theOutput));
        // Testing whether the Non-User version works
        System.out.println("If you had entered 2 and 3000 (aka find the binary value of 3000), the array would have been " + arrToString(the13(2, 3000, false)));
    }

    private static int[] the13(final int k, final int n, final boolean slow) {
        int[] returnValue;
        int numRemaining = n;
        int maxPow;
        for (maxPow = 0; pow(k, maxPow) <= n; maxPow++);
        //maxPow--; // Find the maximum Power of k we can have
        if (slow) System.out.printf("First, we determine that the value of s, or the size of the array of a values, is %d. Since (%d ^ %d) = %d, which is > %d\n", maxPow, k, maxPow - 1, pow(k, maxPow - 1), n);
        returnValue = new int[maxPow]; // Set the, now known, size of return array.
        for (int i = 0; i < returnValue.length; i++) { // Go thru retArray
            for (returnValue[i] = 0; (returnValue[i] * pow(k, maxPow - i - 1)) <= numRemaining; returnValue[i]++);
            returnValue[i]--; // Find the largest a[i] value
            if (slow) System.out.printf("Then we then find that the largest a[%d] can be is %d since %d * %d > %d\n", i, returnValue[i], returnValue[i] + 1, pow(k, maxPow - i - 1), numRemaining);
            numRemaining -= returnValue[i] * pow(k, maxPow - i - 1); // Prep the numRemain for the next a[i] value
        }
        // if (slow) System.out.printf();
        return returnValue;
    }
}
