package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void payment() {

        when(paymentService.processPayment(1250,2000)).thenReturn(3250);// real answer

        // assertEquals() to check if a call went to processPayment(1250,2000) for verifying verify()
        assertEquals(3250,bookingService.payment(1250,2000));

        // verify() to check if a call went to BookingService
        verify(paymentService).processPayment(1250,2000);





    }
}