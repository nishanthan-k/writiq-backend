package com.writiq.blog.posts;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.writiq.blog.global.apiresponse.ApiResponse;
import com.writiq.blog.posts.dto.CreatePost;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/posts")
public class PostsController {

  private final PostService postService;

  @PostMapping("/create")
  public ResponseEntity<ApiResponse<?>> create(@Valid @RequestBody CreatePost request) {
    ApiResponse<?> response = postService.createPost(request);
    return ResponseEntity.ok(response);
  }

}
