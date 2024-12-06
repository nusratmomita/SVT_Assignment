package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void usernameExits() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void findUserById() {
        // why we are making an object of user?
        // since we are using UserRepository as a middleware between User class and UserService class
        User expectedUser = new User(10,"nusrat");

        // when() and theReturn()
        when(userRepository.findUserById(10)).thenReturn(expectedUser);

        User actualUser = userService.findUserById(10);

        // verify()
        verify(userRepository).findUserById(10);
    }
}