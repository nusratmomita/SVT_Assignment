package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    private TemperatureConverter temperatureConverter;

    @BeforeEach
    void setUp() {
        temperatureConverter = new TemperatureConverter();
    }

    @AfterEach
    void tearDown() {
    }


    // Question - 2
    static Stream<Double> getTemp() {
        return Stream.of(32.0);
    }
    @ParameterizedTest
    @MethodSource("getTemp")
    void celsiusTooFahrenheit(double celsius) throws IllegalAccessException {
        assertEquals(celsius, temperatureConverter.celsiusToFahrenheit(0.0));
    }

    @Test
    void celsiusToFahrenheit() throws IllegalAccessException {
        assertEquals(77,temperatureConverter.celsiusToFahrenheit(25));
        assertThrows(Exception.class,()->temperatureConverter.celsiusToFahrenheit(-274));
    }

}