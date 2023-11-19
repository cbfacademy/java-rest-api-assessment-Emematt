package com.cbfacademy.apiassessment;

import com.cbfacademy.apiassessment.controllers.TransactionController;
import com.cbfacademy.apiassessment.controllers.UserController;
import com.cbfacademy.apiassessment.entities.accounts.Transaction;
import com.cbfacademy.apiassessment.entities.user.Role;
import com.cbfacademy.apiassessment.entities.user.User;
import com.cbfacademy.apiassessment.services.TransactionService;
import com.cbfacademy.apiassessment.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {


    @Autowired
    UserService userService;

    @Autowired
    UserController controller;

	@Autowired
	TransactionController transactionController;
	@Autowired
	TransactionService transactionService;


	@BeforeEach
	public void setUp() throws Exception {

        controller = new UserController(userService);

	}


	@Test
	@Description("/User endpoint returns expected response for addUser")
	public void ExpectedResponseWithUserSuccessfullyAdded() {
        User user = new User("1010101","John Doe", Role.ReadOnly);
		ResponseEntity<User> response = controller.addUser(user);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(user, response.getBody());
	}

	@Test
	@Description("/User endpoint returns expected response for getUser")
	public void ExpectedResponseWithUserRead() {

		List<User> listofUsers = this.userService.readAllFromFile();
		User user = new User("bcfb819f-49e7-4a1b-abe3-b76cd7c984fe","Emem Attah",Role.FinanceUser);
		ResponseEntity<User> response = controller.getUser("bcfb819f-49e7-4a1b-abe3-b76cd7c984fe");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(user, response.getBody());
	}


}
