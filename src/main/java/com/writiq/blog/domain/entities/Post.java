package com.writiq.blog.domain.entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.writiq.blog.domain.PostStatus;

import jakarta.validation.constraints.NotBlank;
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
@Document(collection = "posts")
public class Post {

    @Id
    private String Id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @Field
    private Integer readingTime;

    @Field
    private PostStatus status;

    @Field
    @CreatedDate
    private Instant createdAt;

    @Field
    @LastModifiedDate
    private Instant updatedAt;
}
