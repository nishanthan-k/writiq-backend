package com.writiq.blog.user.dto;

import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.Email;
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
public class CreateUser {

  @Indexed(unique = true)
  @NotBlank(message = "Email must be provided")
  @Email(message = "Invalid email format")
  private String email;

  @NotBlank(message = "Password must be provided")
  private String password;

}
