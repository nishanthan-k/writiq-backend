package com.writiq.blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.writiq.blog.domain.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
