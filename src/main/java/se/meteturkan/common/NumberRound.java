package se.meteturkan.common;

public class NumberRound {
    // Method to round a float number to 2 decimal places using Math.round
    public float roundToTwoDecimals(float number) {
        return Math.round(number * 100.0f) / 100.0f;
    }
}
