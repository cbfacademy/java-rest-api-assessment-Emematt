package com.cbfacademy.apiassessment.services;

import com.cbfacademy.apiassessment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends JpaRepository<User,Long> {
    User findUsersByName(String name);

}
