package com.writiq.blog.global.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

  private final PasswordEncoder passwordEncoder;

  public PasswordService() {
    this.passwordEncoder = new BCryptPasswordEncoder();
  }

  public String hashPassword(String password) {
    return passwordEncoder.encode(password);
  }

  public boolean matchPassword(String rawPassword, String hashedPassword) {
    return passwordEncoder.matches(rawPassword, hashedPassword);
  }
}
