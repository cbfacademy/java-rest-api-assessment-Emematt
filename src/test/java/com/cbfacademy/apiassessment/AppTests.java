package com.cbfacademy.apiassessment;

import com.cbfacademy.apiassessment.controllers.UserController;
import com.cbfacademy.apiassessment.entities.user.Role;
import com.cbfacademy.apiassessment.entities.user.User;
import com.cbfacademy.apiassessment.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@LocalServerPort
	private int port;

    @Autowired
    UserService userService;

    @Autowired
    UserController controller;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {

        controller = new UserController(userService);

	}


	@Test
	@Description("/User endpoint returns expected response for addUser")
	public void ExpectedResponseWithUserSuccessfullyAdded() {
        User user = new User("1010101","Jennifer Lopez", Role.ReadOnly);
		ResponseEntity<User> response = controller.addUser(user);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(user, response.getBody());
	}
}
