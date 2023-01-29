package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList<>();
    public User getUser(){
        User user = new User("Chetan", "Canada", 27, "https://www.linkedin.com/in/iamchetansharma/");
        return user;
    }

    public User saveUser(User user) {
        user.setUserId(userList.size() + 1);
        userList.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(int userId) {
        for (User user:userList){
            if (user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }
}
