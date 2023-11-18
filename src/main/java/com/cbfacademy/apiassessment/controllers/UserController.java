package com.cbfacademy.apiassessment.controllers;


import com.cbfacademy.apiassessment.entities.user.User;
import com.cbfacademy.apiassessment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userController")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user = this.userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user = this.userService.createUser(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User user)  {
        user = this.userService.updateUser(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
        this.userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<HttpStatus> deleteAllUsers(){
        this.userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
