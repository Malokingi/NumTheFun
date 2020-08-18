package com.matthewsgrand;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mwgMethods {
    final static Scanner scan = new Scanner(System.in);
    // final static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());

    public static int pow(int a, int b) { // a power function that doesn't need Doubles
        int r = 1;
        for (int i = 0; i < b; i++)
            r *= a;
        return r;
    }

    public static String arrToString(int[] arr) { // Takes Int Arrays and makes them Human-Fathomable
        String r = "{ ";
        for (int i = 0; i < arr.length - 1; i++)
            r += arr[i] + ", ";
        return r + arr[arr.length - 1] + " }";
    }

    public static int sqrtInt(int i) { return ((int) Math.floor(Math.sqrt((double) i))); }

    public static int readInt(int... args) { // gets the next Int input, with the option to specify min and max.
        int r = 0;
        int min = -2147483648;
        int max = 2147483647;
        if (args.length > 0)
            min = args[0];
        if (args.length > 1)
            max = args[1];
        if (args.length > 2) {
            System.err.printf("readInt() takes up to two args. %d is too many!\n", args.length);
            return min;
        }
        try {
            r = scan.nextInt();
            scan.nextLine(); // to clear the rest of the line after the expected Int value
            if (r < min || r > max) {
                System.err.printf("Sorry, only an integer i, such that %d <= i <= %d is allowed here: ", min, max);
                r = readInt(min, max);
            }
        } catch (InputMismatchException e) {
            scan.nextLine(); // to clear the rest of the line since the other call to nextLine was skipped
            System.err.print("Your input must be an integer.\n"
                    + "If it's outside the range [-2147483648, 2147483647], it won't count as an integer.\n"
                    + "Try again: ");
            r = readInt(min, max);
        }
        return r;
    }

    public static void clearConsole() { // Clears the Console so as to reduce visual clutter for the user
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException e) {
            System.out.println("Failed to clear console due to IOException.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Failed to clear console due to InterruptedException.");
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) {
        try {
            Scanner printFile = new Scanner(new FileInputStream(fileName));
            System.out.println();
            while (printFile.hasNext()) {
                System.out.println(printFile.nextLine());
            }
            printFile.close();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to find that file.");
            e.printStackTrace();
        }
    }
}