package com.writiq.blog.domain.entities;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends MongoRepository<Tag, String> {

}
