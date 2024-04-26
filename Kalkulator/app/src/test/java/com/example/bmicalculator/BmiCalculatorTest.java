package com.example.bmicalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class BmiCalculatorTest {

    @Test
    public void testComputeBMI_normal() {
        assertEquals(22.86, BmiCalculator.computeBMI(70, 175), 0.01);
    }

    @Test
    public void testComputeBMI_zeroHeight() {
        assertEquals(0, BmiCalculator.computeBMI(70, 0), 0);
    }
}



