package com.matthewsgrand;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class mwgMethods {
    final static Scanner scan = new Scanner(System.in);
    final static boolean CLEAR_CONSOLE_ACTIVE = true;
    private static final Logger log = Logger.getLogger(mwgMethods.class);

    public static int pow(int a, int b) { // a power function that doesn't need Doubles
    log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(a = " + a + ", b = " + b + ")");
        int r = 1;
        for (int i = 0; i < b; i++)
            r *= a;
        log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "(r = " + r + ")");
        return r;
    }

    public static String arrToString(int[] arr) { // Takes Int Arrays and makes them Human-Fathomable
        log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(arr.length = " + arr.length + ")");
        String r = "{ ";
        for (int i = 0; i < arr.length - 1; i++)
            r += arr[i] + ", ";
        r += arr[arr.length - 1] + " }";
        log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "(r = " + r + ")");
        return r;
    }

    public static int sqrtInt(int i) {
        log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(i = " + i + ")");
        int r = ((int) Math.floor(Math.sqrt((double) i)));
        log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "(r = " + r + ")");
        return r;
    }

    public static int readInt(int... args) { // gets the next Int input, with the option to specify min and max.
        log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(args.length = " + args.length + ")");
        int r = 0;
        int min = -2147483648;
        int max = 2147483647;
        if (args.length > 0)
            min = args[0];
        if (args.length > 1)
            max = args[1];
        if (args.length > 2) {
            System.err.printf("readInt() takes up to two args. %d is too many!\n", args.length);
            log.warn("Out " + new Throwable().getStackTrace()[0].getMethodName() + "() early due to bad args.");
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
        log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "(r = " + r + ")");
        return r;
    }

    public static void clearConsole() { // Clears the Console so as to reduce visual clutter for the user
        log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        if (!CLEAR_CONSOLE_ACTIVE){
            log.warn("Out " + new Throwable().getStackTrace()[0].getMethodName() + "() early due to being manually turned off.");
            return;
        }
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException e) {
            System.out.println("Failed to clear console due to IOException.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Failed to clear console due to InterruptedException.");
            e.printStackTrace();
        }
        log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }

    public static void readFile(String fileName) {
        log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(fileName = " + fileName + ")");
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
        log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }
}