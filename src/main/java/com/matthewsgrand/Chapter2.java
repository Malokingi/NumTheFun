package com.matthewsgrand;

import java.util.ArrayList;
// import org.apache.log4j.Logger;
// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;

public class Chapter2 extends mwgMethods {
    // private static Log log = LogFactory.getLog(Chapter2.class);
    // private static final Logger log = Logger.getLogger(Chapter2.class);
    public static void learn1() {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        int k;
        int j;
        int[] theOutput;
        System.out.print("Enter an Integer. This is the number we'll be splitting up, j = ");
        j = readInt();
        System.out.printf("Okay. Enter a Natural Number. It will serve as %d's divisor, k = ", j);
        k = readInt(1);
        clearConsole();
        theOutput = longDivide(k, j, true);
        System.out.println("The result is " + arrToString(theOutput));
        System.out.printf("In other words, %d = (%d x %d) + %d\n", j, theOutput[0], k, theOutput[1]);
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }
    protected static int[] longDivide(final int k, final int j, final boolean slow) {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(k = " + k + ", j = " + j + ", slow = " + ((slow) ? "true" : "false") +")");
        if (slow) System.out.printf("\nNow finding (q, r) for (j, k) = (%d, %d)\n", j, k);
        int[] returnValue = new int[2];
        int q;
        int r;
        for (q = 0; (q * k) <= j; q++);
        q--;
        if (slow) System.out.printf("So, we determined that q = %d since (%d * %d) = %d > %d.\n", q, q + 1, k, (q + 1) * k, j);
        r = j - q * k;
        if (slow) System.out.printf("This means r = %d which is (%d - %d)\n", r, j, q * k);
        returnValue[0] = q;
        returnValue[1] = r;
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "(q = " + returnValue[0] + ", j = " + returnValue[1] + ")");
        return returnValue;
    }
    public static void learn2() {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        int a;
        int b;
        int theOutput;
        System.out.print("Okay. Enter an Integer, a = ");
        a = readInt();
        System.out.print("Enter another Integer, b = ");
        b = readInt();
        clearConsole();
        theOutput = gcd(a, b, true);
        System.out.println("The result is " + theOutput + ". Pull out a calculator and check, if you don't believe me.");
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }
    protected static int gcd(final int a, final int b, final boolean slow) {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(a = " + a + ", b = " + b + ", slow = " + ((slow) ? "true" : "false") +")");
        if (slow) System.out.printf("\nNow finding gcd(%d, %d)\n", a, b);
        int returnValue = 0;
        for (int i = 1; (i <= a) && (i <= b); i++) {
            if ((longDivide(i, a, false)[1] == 0) && (longDivide(i, b, false)[1] == 0)) { // If the r value of the21 = 0, that means k|j
                if (slow) System.out.printf("%d|%d && %d|%d, so the new returnValue = %d.\n", i, a, i, b, i);
                returnValue = i;
            }
        }
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "(returnValue = " + returnValue + ")");
        return returnValue;
    }
    public static void learn3() {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        int a;
        int b;
        int c;
        boolean[] theOutput;
        System.out.print("Okay. Enter an Integer, a = ");
        a = readInt();
        System.out.print("Enter another Integer, b = ");
        b = readInt();
        System.out.print("Enter a third Integer, c = ");
        c = readInt();
        clearConsole();
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
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }
    protected static boolean[] the23(final int a, final int b, final int c, final boolean slow) {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(a = " + a + ", b = " + b + ", c = " + c + ", slow = " + ((slow) ? "true" : "false") +")");
        boolean[] returnValue = {false, false};
        if (gcd(a, c, slow) == 1) returnValue[0] = true;
        if (longDivide(c, a * b, slow)[1] == 0) returnValue[1] = true;
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        return returnValue;
    }
    public static void learn4() {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        int a;
        int b;
        int c;
        int d;
        int[] theOutput;
        System.out.print("Okay. Enter an Integer, a = ");
        a = readInt();
        System.out.print("Enter another Integer, b = ");
        b = readInt();
        System.out.print("Enter a third Integer, c = ");
        c = readInt();
        d = gcd(a, b, false);
        if (longDivide(d, c, false)[1] == 0) {
            clearConsole();
            theOutput = the24(a, b, c, true);
            if ((a * theOutput[0] + b * theOutput[1]) == c) {
                System.out.printf("There's good news. All the assumptions were met, so I found a solution: (x, y) = (%d, %d)\n", theOutput[0], theOutput[1]);
                System.out.printf("\tSo, (%d x %d) + (%d x %d) = %d\n", a, theOutput[0], b, theOutput[1], c);
                System.out.printf("\tThat is, (%d) + (%d) = %d\n", a * theOutput[0], b * theOutput[1], c);
                System.out.println("Furthermore, all conceivable solutions for this equation take the form of:");
                System.out.printf("\t(x, y) = (%d+%dt, %d-%dt)\nfor any integer, t.\n", theOutput[0], b / d, theOutput[1], a / d);
            }else{
                System.out.println("It looks like, although the solution must exist, It's too complicated for me to find at my current skill level.");
            }
        }else{
            System.out.printf("It looks like gcd(%d, %d) = %d and %d !| %d. So there's no point in going forward.\n", a, b, d, d, c);
        }
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }
    protected static int[] the24(final int a, final int b, final int c, final boolean slow) {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(a = " + a + ", b = " + b + ", c = " + c + ", slow = " + ((slow) ? "true" : "false") +")");
        int[] returnValue = new int[2];
        final int d = gcd(a, b, false);
        int magnitude = 0;
        final int magnitudeLimit = 3000; // to stop it from running forever when the answer's too hard
        boolean noSolve = true;
        if (longDivide(d, c, false)[1] == 0) {
            if (slow) System.out.printf("About to start Brute forcing magnitude,");
            while (magnitude <= magnitudeLimit) {
                if (slow) System.out.printf(" m = %d", magnitude);
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
            if (noSolve) System.err.printf("I couldn't find a solution! I checked all possible combinations for x and y where both |x| and |y| are <= %d... :/\n", magnitudeLimit);
        }else{
            System.err.printf("%d !| %d, so there are no solutions.\n", d, c);
        }
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "(returnValue.length = " + returnValue.length + ")");
        return returnValue;
    }
    public static void learn5() {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        int n;
        int[] theOutput;
        System.out.print("Enter a Natural Number, n = ");
        n = readInt(1);
        clearConsole();
        theOutput = the25(n, true);
        if (theOutput.length == 1) System.out.print("\nHey! you found a Prime Number!");
        System.out.printf("\nThe Prime Factorization of %d is %s", n, arrToString(theOutput));
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        //System.out.println(arrToString(theOutput));
    }
    protected static int[] the25(final int n, final boolean slow) {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(n = " + n + ", slow = " + ((slow) ? "true" : "false") +")");
        int[] returnValue;
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        int number = n;
        int maxFact;
        int[] qAndR;
        boolean pFound;
        while (number > 0) {
            maxFact = sqrtInt(number); // Calculating Maximum Possible Factor
            pFound = false;
            if(slow) System.out.printf("\nChecking:");
            for (int i = 2; i <= maxFact; i++) {
                if (slow && ((Math.log((double) i)/Math.log(2.0)) % 1 == 0.0)) System.out.printf(" i = %d...", i);
                qAndR = longDivide(i, number, false);
                if (qAndR[1] == 0) {
                    if(slow) System.out.printf("\nFound %d", i);
                    tempArr.add(i);
                    number = qAndR[0];
                    i = maxFact;
                    pFound = true;
                }
            }
            if (!pFound) {
                if(slow) System.out.printf("\nFound %d", number);
                tempArr.add(number);
                number = 0;
            }
        }
        returnValue = new int[tempArr.size()];
        for (int i = 0; i < returnValue.length; i++) {
            returnValue[i] = tempArr.remove(0);
        }
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "(returnValue.length = " + returnValue.length + ")");
        return returnValue;
    }
}