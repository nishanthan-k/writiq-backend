package com.writiq.blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.writiq.blog.domain.entities.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    boolean existsByNameIgnoreCase(String name);
}
