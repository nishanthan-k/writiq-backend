package com.writiq.blog.domain.entities;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Field
    @Indexed(unique = true)
    private String email;

    @Field
    private String password;

    @Field
    private String name;

    @DBRef
    private List<Post> posts;

    @Field
    @CreatedDate
    private Instant createdAt;

    @Field
    @LastModifiedDate
    private Instant updatedAt;
}
