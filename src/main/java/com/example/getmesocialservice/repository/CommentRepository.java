package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Comment;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllById(String id);
}
