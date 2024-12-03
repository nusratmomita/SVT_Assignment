package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestingAnnotationTest {

    private TestingAnnotation testingAnnotation;

    @BeforeAll
    static void printingBeforeAll(){
        System.out.println("An(@BeforeAll) annotation that executes before all methods");
    }

    @BeforeEach
    void printingBeforeEach(){

        testingAnnotation = new TestingAnnotation();

        System.out.println("An(@BeforeEach) annotation that executes before every methods execution");
    }

    @AfterAll
    static void printingAfterAll(){
        System.out.println("An(@AfterAll) annotation that executes after all methods");
    }

    @AfterEach
    void printingAfterEach(){
        System.out.println("An(@AfterEach) annotation that executes after every methods execution");
    }

    @Test
    void subtraction() {
        assertEquals(3,testingAnnotation.subtraction(5,2));
    }
}