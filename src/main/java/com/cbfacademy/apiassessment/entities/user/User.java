package com.cbfacademy.apiassessment.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@ApiModel(description = "User Class is object that handles user data.")

public class User{

    private String userId;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Organisation Role")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public void addUser(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
