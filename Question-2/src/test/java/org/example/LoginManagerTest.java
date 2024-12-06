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
class LoginManagerTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private LoginManager loginManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void login() {
    }

    // Question - 3
    @Test
    void TestingAuthenticatedUser() throws Exception{
        when(authenticationService.authenticate("momita","momita@")).thenReturn(true);

        boolean result = loginManager.login("momita", "momita@");

        // verifying here
        verify(authenticationService).authenticate("momita", "momita@");
    }

    @Test
    void TestingUnauthenticatedUser() throws Exception{
        // no user under this hatori name
        when(authenticationService.authenticate("hatori","hatori*")).thenReturn(false);

        boolean result = loginManager.login("hatori", "hatori*");

        verify(authenticationService).authenticate("hatori", "hatori*");
    }

    @Test
    void TestingNullInputs() throws Exception{
        // null password
        assertThrows(Exception.class,()->loginManager.login("nusrat",null));

        // null name
        assertThrows(Exception.class,()->loginManager.login(null,"nusrat@"));

        // null name and password
        assertThrows(Exception.class,()->loginManager.login(null,null));


    }
}