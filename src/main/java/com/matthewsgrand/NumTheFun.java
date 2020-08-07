package com.matthewsgrand;

import java.io.Console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class NumTheFun {
    //#region
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
    //#endregion
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
                        case "21": learn21(); break;
                        case "22": learn22(); break;
                        case "23": learn23(); break;
                        case "24": learn24(); break;
                        case "25": learn25(); break;
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
    //#region
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
        int retArrSize;
        int powOfK;
        for (retArrSize = 0; pow(k, retArrSize) <= n; retArrSize++); // Find the size of our return array
        if (slow) System.out.printf("First, we determine that the value of s, or the size of the array of a values, is %d. Since (%d ^ %d) = %d, which is > %d\n", retArrSize, k, retArrSize - 1, pow(k, retArrSize - 1), n);
        returnValue = new int[retArrSize]; // Set the, now known, size of return array.
        for (int i = 0; i < returnValue.length; i++) { // Go thru retArray
            powOfK = retArrSize - i - 1;
            for (returnValue[i] = 0; (returnValue[i] * pow(k, powOfK)) <= numRemaining; returnValue[i]++);
            returnValue[i]--; // Find the largest a[i] value
            if (slow) System.out.printf("Then we then find that the largest a[%d] can be is %d since %d * %d > %d\n", i, returnValue[i], returnValue[i] + 1, pow(k, powOfK), numRemaining);
            numRemaining -= returnValue[i] * pow(k, powOfK); // Prep the numRemain for the next a[i] value
        }
        // if (slow) System.out.printf();
        return returnValue;
    }
    private static void learn21() {
        int k;
        int j;
        int[] theOutput;
        System.out.print("Okay. Enter a Natural Number, k = ");
        k = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        System.out.print("Next, Enter an Integer, j = ");
        j = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        theOutput = longDivide(k, j, true);
        System.out.println("The result is " + arrToString(theOutput));
        System.out.printf("In other words, %d = (%d x %d) + %d\n", j, theOutput[0], k, theOutput[1]);
        // Testing whether the Non-User version works
        System.out.println("If you had entered 59 and 2300, the array would have been " + arrToString(longDivide(59, 2300, false)));
    }
    private static int[] longDivide(final int k, final int j, final boolean slow) {
        if (slow) System.out.printf("\nNow finding (q, r) for (j, k) = (%d, %d)\n", j, k);
        int[] returnValue = new int[2];
        int q;
        int r;
        for (q = 0; (q * k) <= j; q++);
        q--;
        if (slow) System.out.printf("So, we determined that q = %d since (%d * %d) = %d > %d.\n", q, q + 1, k, (q + 1) * k, j);
        r = j - q * k;
        if (slow) System.out.printf("This means r = %d which is (%d - %d)\n", r, j, q * k);
        // if (slow) System.out.printf();
        returnValue[0] = q;
        returnValue[1] = r;
        return returnValue;
    }
    private static void learn22() {
        int a;
        int b;
        int theOutput;
        System.out.print("Okay. Enter an Integer, a = ");
        a = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        System.out.print("Next, Enter another Integer, b = ");
        b = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        theOutput = gcd(a, b, true);
        System.out.println("The result is " + theOutput + ". Pull out a calculator and check, if you don't believe me.");
        // Testing whether the Non-User version works
        System.out.println("If you had entered 60 and 320, the gcd would have been " + gcd(60, 320, false));
    }
    private static int gcd(final int a, final int b, final boolean slow) {
        if (slow) System.out.printf("\nNow finding gcd(%d, %d)\n", a, b);
        int returnValue = 0;
        for (int i = 1; (i <= a) && (i <= b); i++) {
            if ((longDivide(i, a, false)[1] == 0) && (longDivide(i, b, false)[1] == 0)) { // If the r value of the21 = 0, that means k|j
                if (slow) System.out.printf("%d|%d && %d|%d, so the new returnValue = %d.\n", i, a, i, b, i);
                returnValue = i;
            }
        }
        // if (slow) System.out.printf("\n");
        return returnValue;
    }
    private static void learn23() {
        int a;
        int b;
        int c;
        boolean[] theOutput;
        System.out.print("Okay. Enter an Integer, a = ");
        a = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        System.out.print("Next, Enter another Integer, b = ");
        b = scan.nextInt();
        scan.nextLine();
        System.out.print("Next, Enter a third Integer, c = ");
        c = scan.nextInt();
        scan.nextLine();
        theOutput = the23(a, b, c, true);
        if (theOutput[0]) {
            System.out.printf("\nIt looks like, indeed, gcd(%d, %d) = 1.\n", a, c);
            if (theOutput[1]) {
                System.out.printf("It looks like the other assumption is true, %d | %d.\n", c, a * b);
                System.out.printf("\nTherefore, it must be true that %d | %d. Double check if you'd like.\n", c, b);
            } else {
                System.out.printf("Oh, %d !| (%d * %d). That was a waste of time, it turns out.\n", c, a, b);
            }
        }else{
            System.out.printf("Oh, gcd(%d, %d) != 1. That was a waste of time.\n", a, c);
        }
        // Testing whether the Non-User version works
        System.out.println("If you had entered 5, 49 and 7, the result would have been " + the23(5, 49, 7, false)[0] + ", " + the23(5, 49, 7, false)[1]);
    }

    private static boolean[] the23(final int a, final int b, final int c, final boolean slow) {
        boolean[] returnValue = {false, false};
        if (gcd(a, c, slow) == 1) {
            returnValue[0] = true;
        }
        if (longDivide(c, a * b, slow)[1] == 0) {
            returnValue[1] = true;
        }
        // if (slow) System.out.printf("\n");
        return returnValue;
    }
    private static void learn24() {
        int a;
        int b;
        int c;
        int d;
        int[] theOutput;
        System.out.print("Okay. Enter an Integer, a = ");
        a = scan.nextInt();
        scan.nextLine(); // to clear the rest of the line after the expected Int value
        System.out.print("Next, Enter another Integer, b = ");
        b = scan.nextInt();
        scan.nextLine();
        System.out.print("Next, Enter a third Integer, c = ");
        c = scan.nextInt();
        scan.nextLine();
        d = gcd(a, b, false);
        if (longDivide(d, c, false)[1] == 0) {
            theOutput = the24(a, b, c, true);
            if ((a * theOutput[0] + b * theOutput[1]) == c) {
                System.out.printf("There's good news. All the assumptions were met, so I found a solution: (x, y) = (%d, %d)\n", theOutput[0], theOutput[1]);
                System.out.printf("\tSo, (%d x %d) + (%d x %d) = %d\n", a, theOutput[0], b, theOutput[1], c);
                System.out.printf("\tThat is, (%d) + (%d) = %d\n", a * theOutput[0], b * theOutput[1], c);
                System.out.println("Furthermore, all conceivable solutions for this equation take the form of:");
                System.out.printf("\t(x, y) = (%d + (t x %d), (%d + (t x %d)))\nfor any integer, t.\n", theOutput[0], b / d, theOutput[1], a / d);
            }else{
                System.out.println("It looks like, although the solution must exist, It's too complicated for me to find at my current skill level.");
            }
        }else{
            System.out.printf("It looks like gcd(%d, %d) = %d and %d !| %d. So there's no point in going forward.\n", a, b, d, d, c);
        }
        // Testing whether the Non-User version works
        theOutput = the24(14, 49, 91, false);
        System.out.printf("If you had entered 14, 49 and 91, the result would have been (%d, %d)", theOutput[0], theOutput[1]);
    }
    private static int[] the24(final int a, final int b, final int c, final boolean slow) {
        int[] returnValue = new int[2];
        int d = gcd(a, b, false);
        int magnitude = 0;
        final int magnitudeLimit = 3000;
        boolean noSolve = true;
        if (longDivide(d, c, false)[1] == 0) {
            if (slow) System.out.printf("About to start Brute forcing magnitude, ");
            while (magnitude <= magnitudeLimit) {
                if (slow) System.out.printf("m = %d ", magnitude);
                for (int x = -magnitude; x <= magnitude; x++) {
                    for (int y = -magnitude; y <= magnitude; y++) {
                        if (((x * a) + (y * b)) == c) {
                            returnValue[0] = x;
                            returnValue[1] = y;
                            magnitude = magnitudeLimit;
                            x = magnitudeLimit + 1;
                            y = magnitudeLimit + 1;
                            noSolve = false;
                        }
                    }
                }
                magnitude++;
            }
            if (slow) System.out.printf("\n");
            if (noSolve) {
                System.err.printf("I couldn't find a solution! I checked all possible combinations for x and y where both |x| and |y| are <= %d... :/\n", magnitudeLimit);
            }
        }else{
            System.err.printf("%d !| %d, so there are no solutions.\n", d, c);
        }
        // if (slow) System.out.printf("\n");
        return returnValue;
    }
    //#endregion
    private static void learn25() {
        int n;
        int[] theOutput;
        System.out.print("Enter a Natural Number, n = ");
        n = scan.nextInt();
        scan.nextLine();
        theOutput = the25(n, true);
        System.out.printf("The Prime Factorization of %d is ", n);
        System.out.println(arrToString(theOutput));
        // Testing whether the Non-User version works
        System.out.println("If you had entered 1000000, the Prime Factorization would have been: " + arrToString(the25(1000000, false)));
    }

    private static int[] the25(final int n, final boolean slow) {
        int[] returnValue;
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        int number = n;
        int maxFact;
        int[] qAndR;
        boolean pFound;
        while (number > 0) {
            maxFact = (int) Math.floor(Math.sqrt((double)number)); // Calculating Maximum Possible Factor
            pFound = false;
            for (int i = 2; i <= maxFact; i++) {
                qAndR = longDivide(i, number, false);
                if (qAndR[1] == 0) {
                    tempArr.add(i);
                    number = qAndR[0];
                    i = maxFact;
                    pFound = true;
                }
            }
            if (!pFound) {
                tempArr.add(number);
                number = 0;
            }
        }
        returnValue = new int[tempArr.size()];
        for (int i = 0; i < returnValue.length; i++) {
            returnValue[i] = tempArr.remove(0);
        }
        // if (slow) System.out.printf("\n");
        return returnValue;
    }
}
