package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserManagerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserManager userManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerUser() {
    }

    // Question - 1
    @Test
    void TestingUserNameDoesExists(){
        // since we do not have nusrat as a user it should return false when usernameExists is called
        when(userService.usernameExists("nusrat")).thenReturn(false);
        // first saving the info then calling usernameExists
        when(userService.saveUser("nusrat", "nusrat@")).thenReturn(true);

        // saving the nusrat's info to check for verify()
        boolean result = userManager.registerUser("nusrat", "nusrat@");

        // checking if nusrat user is hre or not
        verify(userService).usernameExists("nusrat");
    }

    @Test
    void TestingUserNameExists(){
        // nusrat user already created before so now we can test it here
        when(userService.usernameExists("nusrat")).thenReturn(true);

        // saving the nusrat's info to check for verify()
        boolean result = userManager.registerUser("nusrat", "nusrat@");

        // checking if nusrat user is hre or not
        verify(userService).usernameExists("nusrat");
    }
}