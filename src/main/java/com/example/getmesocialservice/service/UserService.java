package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public List<User> getByName(String name) {
        return userRepository.findAllByName(name);
    }

    public List <User> getUserById(String id) {
        return userRepository.findAllById(id);
    }

    public List <User> getUserByEmail(String email) {
        return userRepository.findAllByEmailAddress(email);
    }
    /*
    public User getUser(){
        return userRepository.getUser();
    }





    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }*/
}
