package com.writiq.blog.posts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.writiq.blog.global.apiresponse.ApiResponse;
import com.writiq.blog.posts.dto.CreatePost;
import com.writiq.blog.user.User;
import com.writiq.blog.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final UserRepository userRepository;

  public ApiResponse<?> createPost(CreatePost request) {

    Optional<User> taggegUser = userRepository.findById(request.getUserId());

    if (taggegUser.isEmpty()) {
      ApiResponse<?> response = new ApiResponse<>(ApiResponse.FAILURE, "User Not Found");
      return response;
    }

    Posts postMap = Posts.builder()
        .title(request.getTitle())
        .content(request.getContent())
        .userId(request.getUserId())
        .categoryList(request.getCategoryList())
        .tags(request.getTags())
        .build();

    Posts post = postRepository.insert(postMap);

    Map<String, String> dataMap = new HashMap<>();
    dataMap.put("postId", post.getId());

    ApiResponse<?> response = new ApiResponse<>(ApiResponse.SUCCESS, "User created successfully", dataMap);
    return response;
  }

}
