package com.cbfacademy.apiassessment.services;


import com.cbfacademy.apiassessment.entities.user.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@ApiModel(description = "User service houses CRUD operations for user objects")

public class UserService {

    private static final String FILE_PATH= "src/main/resources/users.json";


    @Autowired
    ObjectMapper objectMapper;

    public User createUser(User user) {
        String userId = UUID.randomUUID().toString();

        user.setUserId(userId);
        List<User> listOfUsers = readAllFromFile();
        listOfUsers.add(user);
        saveAllToFile(listOfUsers);

        return  user;
    }


    public  List<User>  readAllFromFile()  {
        List <User> listOfUsers = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile(FILE_PATH);
            listOfUsers = objectMapper.readValue(file, new TypeReference<List<User>>() {
            });
        } catch  (IOException e) {e.printStackTrace();}

        return listOfUsers;
    }


    public void saveAllToFile(List<User> users){

        try {
            objectMapper.writeValue(new File(FILE_PATH), users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public User updateUser(User user){

        this.deleteUserById(user.getUserId());
        List<User> listOfUsers = readAllFromFile();
        listOfUsers.add(user);
        saveAllToFile(listOfUsers);

        return user;
        //1. read all  2.operation ( loop, find , delete, add)  3. save
    }

    public void deleteAllUsers(){

        this.saveAllToFile(new ArrayList<>());

    }

    public void deleteUserById(String userId){

        User userToBeDeleted = new User();
        userToBeDeleted.setUserId(userId);

        List<User> listOfUsers = readAllFromFile();
        listOfUsers.remove(userToBeDeleted);
        this.saveAllToFile(listOfUsers);

        //1. read all  2.operation ( loop, find , delete)  3. save

    }

    public User getUserById(String userId){

        List<User> listOfUsers = readAllFromFile();
        for (User user: listOfUsers) {
            if (user.getUserId().equals(userId)){
                return user;}
        }
        throw new RuntimeException("No user found");
    }

    public List<User> getAllUsers(){
        return this.readAllFromFile();
    }



}
