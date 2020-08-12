package com.matthewsgrand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for Chapter 1 functions.
 */
public class Ch1Test extends mwgMethods {
    @Test
    public void the11Test() {
        final int input = 100;
        final int exOutput = 5050;
        final int output = Chapter1.the11(input, false);
        assertEquals(exOutput, output);
    }
    @Test
    public void the12Test() {
        final int input_x = 10;
        final int input_n = 4;
        final int exOutput = 1111;
        final int output = Chapter1.the12(input_x, input_n, false);
        assertEquals(exOutput, output);
    }
    @Test
    public void the13Test() {
        final int input_k = 2;
        final int input_n = 1023;
        final int[] exOutput = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        final int[] output = Chapter1.the13(input_k, input_n, false);
        assertEquals(arrToString(exOutput), arrToString(output));
    }
}
