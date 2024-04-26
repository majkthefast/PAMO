package com.example.bmicalculator;

public class BmiCalculator {

    public static float computeBMI(float weight, float heightInCentimeters) {
        if (heightInCentimeters == 0) return 0;  // Zapobieganie dzieleniu przez zero
        float heightInMeters = heightInCentimeters / 100;
        return weight / (heightInMeters * heightInMeters);
    }
}
