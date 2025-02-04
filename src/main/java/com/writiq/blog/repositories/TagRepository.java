package com.writiq.blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.writiq.blog.domain.entities.Tag;

@Repository
public interface TagRepository extends MongoRepository<Tag, String> {

}
