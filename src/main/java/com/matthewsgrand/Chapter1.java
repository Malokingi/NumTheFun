package com.matthewsgrand;

public class Chapter1 extends mwgMethods {
    public static void learn11() {
        int n;
        int theOutput;
        System.out.print("Okay. Enter a Natural Number, n = ");
        n = readInt(1, pow(2, 16) - 1);
        theOutput = the11(n, true);
        System.out.println("Either way, The sum is " + theOutput);
    }
    private static int the11(final int n, final boolean slow) {
        int returnValue;
        if (n % 2 == 0) returnValue = ((n / 2) * (n + 1));
        else returnValue = (n * ((n + 1) / 2));
        if (slow) {
            System.out.println("\nIf you have enough free time, you can add:");
            if (n > 10){
                for(int i = 1; i <= 10 - 1; i++) System.out.print(i + " + ");
                System.out.printf("... + ");
            }else{
                for(int i = 1; i <= n - 1; i++) System.out.print(i + " + ");
            }
            System.out.printf("%d = %d\n", n, returnValue);
            System.out.printf("Or ((%d x (%d + 1)) / 2) = ", n, n, returnValue);
        }
        return returnValue;
    }
    public static void learn12() {
        int x;
        int n;
        int theOutput;
        System.out.print("Okay. Enter an Integer (!= 1), x = ");
        x = readInt();
        while (x == 1) {
            System.out.print("x must != 1. Please try again x = ");
            x = readInt();
        }
        System.out.print("Now enter a Natural Number, n = ");
        n = readInt(1);
        theOutput = the12(x, n, true);
        System.out.println("Either way, The sum is " + theOutput);
    }
    private static int the12(final int x, final int n, final boolean slow) {
        final int returnValue =  ((pow(x, n)) - 1) / (x - 1);
        if (slow) {
            System.out.println("\nIf you have enough free time, you can add:");
            for(int i = 0; i < n - 1; i++) System.out.printf("(%d ^ %d) + ", x, i);
            System.out.printf("(%d ^ %d) = \n", x, n - 1);
            for(int i = 0; i < n - 1; i++) System.out.printf("(%d) + ", pow(x, i));
            System.out.printf("(%d) = %d\n", pow(x, n - 1), returnValue);
            System.out.printf("Or:\n ((%d ^ %d) - 1) / (%d - 1) =\n", x, n, x);
            System.out.printf("(%d) / (%d) = %d\n", pow(x, n) - 1, x - 1, returnValue);
        }
        return returnValue;
    }
    public static void learn13() {
        int k;
        int n;
        int[] theOutput;
        System.out.print("Enter a Natural Number. This will be the base, k = ");
        k = readInt(1);
        System.out.printf("Enter another Natural Number. We'll find this number to base %d, n = ", k);
        n = readInt(1);
        theOutput = the13(k, n, true);
        System.out.println("The result is " + arrToString(theOutput));
    }
    private static int[] the13(final int k, final int n, final boolean slow) {
        int[] returnValue;
        int numRemaining = n;
        int retArrSize;
        int powOfK;
        for (retArrSize = 0; pow(k, retArrSize) <= n; retArrSize++); // Find the size of our return array
        if (slow) System.out.printf("\nFirst, we determine that the value of s, or the size of the array of a values, is %d. Since (%d ^ %d) = %d, which is > %d\n", retArrSize, k, retArrSize, pow(k, retArrSize), n);
        returnValue = new int[retArrSize]; // Set the, now known, size of return array.
        for (int i = 0; i < returnValue.length; i++) { // Go thru retArray
            powOfK = retArrSize - i - 1;
            for (returnValue[i] = 0; (returnValue[i] * pow(k, powOfK)) <= numRemaining; returnValue[i]++);
            returnValue[i]--; // Find the largest a[i] value
            if (slow) System.out.printf("Then we then find that the largest a[%d] can be is %d since %d * %d > %d\n", i, returnValue[i], returnValue[i] + 1, pow(k, powOfK), numRemaining);
            numRemaining -= returnValue[i] * pow(k, powOfK); // Prep the numRemain for the next a[i] value
        }
        return returnValue;
    }
}