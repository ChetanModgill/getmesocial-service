package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List <User> findAllById(String id);
    List <User> findAllByEmailAddress(String email);
    List <User> findAllByName(String name);
}
