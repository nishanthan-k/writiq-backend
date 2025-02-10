package com.writiq.blog.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.writiq.blog.global.apiresponse.ApiResponse;
import com.writiq.blog.global.services.PasswordService;
import com.writiq.blog.user.dto.CreateUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordService passwordService;

  public ApiResponse<?> createUser(CreateUser req) {

    try {
      User userMap = User.builder()
          .email(req.getEmail())
          .password(passwordService.hashPassword(req.getPassword()))
          .build();

      User user = userRepository.insert(userMap);

      Map<String, String> dataMap = new HashMap<>();
      dataMap.put("userId", user.getId());

      ApiResponse<?> response = new ApiResponse<>(ApiResponse.SUCCESS, "User created successfully", dataMap);
      return response;

    } catch (org.springframework.dao.DuplicateKeyException e) {
      ApiResponse<String> response = new ApiResponse<>(ApiResponse.FAILURE, "Error creating user: " + e.getMessage());
      return response;
    } catch (Exception e) {
      ApiResponse<String> response = new ApiResponse<>(ApiResponse.FAILURE, "Error creating user: " + e.getMessage());
      return response;
    }
  }
}
