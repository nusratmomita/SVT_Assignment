package org.example;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) throws IllegalAccessException {
        if(celsius < -273.15)
            throw new IllegalAccessException("Temp below zero");
        return (celsius*9/5) + 32;
    }
}