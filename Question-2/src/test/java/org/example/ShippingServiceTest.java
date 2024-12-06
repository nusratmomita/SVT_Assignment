package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShippingServiceTest {

    @Mock
    private ShippingService shippingService;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ship() {
    }

    // Question - 4
    @Test
    void shippingDone(){
        when(shippingService.ship("pen",1)).thenReturn(true);

        boolean result = orderService.placeOrder("pen",1);

        // verifying here
        verify(shippingService).ship("pen", 1);
    }


    @Test
    void shippingNotDone() {
        boolean result = orderService.placeOrder("pen", -100);

        // Verify that the ship method is not called when quantity and item are invalid
        verify(shippingService,never()).ship(anyString(), anyInt());
    }

}