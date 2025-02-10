package com.writiq.blog.user;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.writiq.blog.global.apiresponse.ApiResponse;
import com.writiq.blog.user.dto.CreateUser;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  @PostMapping("/create")
  public ResponseEntity<ApiResponse<?>> createUser(@Valid @RequestBody CreateUser user) {
    ApiResponse<?> response = userService.createUser(user);
    return ResponseEntity.ok(response);
  }

}
