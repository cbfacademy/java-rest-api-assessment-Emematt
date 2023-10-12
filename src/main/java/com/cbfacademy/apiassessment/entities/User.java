package com.cbfacademy.apiassessment.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import jakarta.persistence.Entity;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "User Class to handle user data")
public class User {



}
