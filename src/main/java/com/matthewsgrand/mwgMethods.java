package com.matthewsgrand;

import java.io.IOException;
import java.util.Scanner;

public class mwgMethods {
    final static Scanner scan = new Scanner(System.in);
    public static int pow(int a, int b){ // a power function that doesn't need Doubles
        int r = 1;
        for (int i = 0; i < b; i++) r *= a;
        return r;
    }
    public static String arrToString(int[] arr){ // Takes Int Arrays and makes them Human-Fathomable
        String r = "{ ";
        for (int i = 0; i < arr.length - 1; i++) r += arr[i] + ", ";
        return r + arr[arr.length - 1] + " }";
    }
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException e) {
            System.out.println("Failed to clear console due to a IOException.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Failed to clear console due to a InterruptedException.");
            e.printStackTrace();
        }
    }
}