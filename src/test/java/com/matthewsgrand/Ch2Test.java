package com.matthewsgrand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for Chapter 2 functions.
 */
public class Ch2Test extends mwgMethods {
    @Test
    public void the21Test(){
        final int input_j = 500;
        final int input_k = 66;
        final int[] exOutput = {7, 38};
        final int[] output = Chapter2.longDivide(input_k, input_j, false);
        assertEquals(arrToString(exOutput), arrToString(output));
    }
    @Test
    public void the22Test(){
        final int input_a = 500;
        final int input_b = 66;
        final int exOutput = 2;
        final int output = Chapter2.gcd(input_a, input_b, false);
        assertEquals(exOutput, output);
    }
    @Test
    public void the24Test(){
        final int input_a = 1123;
        final int input_b = 1990;
        final int input_c = 1702;
        final int[] exOutput = {744, -419};
        final int[] output = Chapter2.the24(input_a, input_b, input_c, false);
        assertEquals(arrToString(exOutput), arrToString(output));
    }
    @Test
    public void the25Test(){
        final int input = 1024;
        final int[] exOutput = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        final int[] output = Chapter2.the25(input, false);
        assertEquals(arrToString(exOutput), arrToString(output));
    }
}