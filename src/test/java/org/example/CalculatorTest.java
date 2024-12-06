package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        // assertNull() and assertNotNull()
        assertNull(calculator.add(2,null));

        assertNotNull(calculator.add(2,3));

        // assertEquals() and assertNotEquals()
        assertEquals(10,calculator.add(5,5));

        assertNotEquals(90,calculator.add(9,0));

        // assertTrue() and assertFalse()
        assertTrue(calculator.add(2,3)>1);

        assertFalse(calculator.add(0,1)<-1);
    }



    @Test
    void divide() throws Exception {
        // assertNull() and assertNotNull()
        assertNull(calculator.divide(2,null));

        assertNotNull(calculator.divide(2,3));

        // assertEquals() and assertNotEquals()
        assertEquals(1,calculator.divide(5,5));

        assertNotEquals(90,calculator.divide(9,10));

        // assertTrue() and assertFalse()
        assertTrue(calculator.divide(2,3)<1);

        assertFalse(calculator.divide(0,1)<-1);

        // assertThrows and assertDoesNotThrow
        assertThrows(Exception.class,()->calculator.divide(1,0));

        assertDoesNotThrow(()->calculator.divide(1,10));
    }

    @Test
    void array(){
        // assertArrayEquals()
        assertArrayEquals(new int[]{1,2,3},calculator.array());

        // assertSame()
        Calculator c1;
        c1 = calculator;
        assertSame(c1,calculator);

        List<String> str1 = Arrays.asList("1","2");
        List<String> str2 = Arrays.asList("1","2");
        // assertLinesMatch()
        assertLinesMatch(str1,str2);
    }

    @Test
    void TimeOut(){
        //  assertTimeout()
        assertTimeout(Duration.ofMillis(10),()->calculator.add(1,2));
            //Thread.sleep(1);

    }


    // maybe do it only for add ()
    // ???
    // ok to code like this like not using add()
    @ParameterizedTest
    @ValueSource(ints = {5,9})
    void addTestWithVS(int res){
        assertEquals(res,calculator.add(2,3));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addition.csv")
    void addTestWithCSV(int res,int a,int b){
        assertEquals(res,calculator.add(a,b));
    }

    static Stream<Integer> getList() {
        return Stream.of(8,2,3);
    }
    @ParameterizedTest
    @MethodSource("getList")
    void addTestWithMSV(int res){
        assertEquals(res,calculator.add(2,3));
    }

    @ParameterizedTest
    @CsvSource({"2,1,1","4,2,2"})
    void addTestWithCS(int res,int a,int b){
        assertEquals(res,calculator.add(a,b));
    }

    @RepeatedTest(value = 5)
    void generate(){
        int mn = 1;
        int mx = 10;
        int generating = calculator.generate(mn,mx);

        assertEquals(generating,Math.random());
    }

}