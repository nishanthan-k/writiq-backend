package com.writiq.blog.posts.dto;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePost {

  @NotBlank(message = "Title must be provided")
  private String title;

  @NotBlank(message = "Content must be provided")
  private String content;

  @NotBlank(message = "User ID must be provided")
  @Indexed(unique = false)
  private String userId;

  private List<String> tags;

  private List<String> categoryList;

}
