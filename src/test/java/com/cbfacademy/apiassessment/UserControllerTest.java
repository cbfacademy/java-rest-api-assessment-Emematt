package com.cbfacademy.apiassessment;

import com.cbfacademy.apiassessment.controllers.UserController;
import com.cbfacademy.apiassessment.entities.user.Role;
import com.cbfacademy.apiassessment.entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    private UserController controller;
    @BeforeEach
    void setUp() {  controller = new UserController();
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUser() {
    }

    @Test
    void addUser() {

        User user = new User("10101","Emem Attah", Role.FinanceUser);
        ResponseEntity<User> response = controller.addUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user,response.getBody());
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteAllUsers() {
    }
}