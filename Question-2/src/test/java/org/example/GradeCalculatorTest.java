package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {
    private GradeCalculator gradeCalculator;

    @BeforeEach
    void setUp() {
        gradeCalculator = new GradeCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    // Question - 5
    // using @ParameterizedTest
    @ParameterizedTest
    @CsvFileSource(resources = "/Vals.csv")
    void getGrade(int score,String expectedGrade) throws IllegalAccessException {
        // using assertEquals for testing the Vals.csv file
        assertEquals(expectedGrade,gradeCalculator.getGrade(score));
    }

    @Test
    void getGradeRes() throws IllegalAccessException {
        // assertEquals
        assertEquals("A",gradeCalculator.getGrade(99));

        // assertThrows() -> if score is less than 0 or more than 100 then the getGrade() will throw exception
        assertThrows(Exception.class,()->gradeCalculator.getGrade(190));
    }
}
