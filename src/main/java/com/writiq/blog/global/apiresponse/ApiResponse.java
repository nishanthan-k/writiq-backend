package com.writiq.blog.global.apiresponse;

public class ApiResponse<T> {

  public static final String SUCCESS = "success";
  public static final String FAILURE = "failure";
  public static final String ERROR = "error";

  private final String status;
  private final String message;
  private T data; // Not final to allow setting it to null when not needed

  // Constructor without data
  public ApiResponse(String status, String message) {
    this.status = status;
    this.message = message;
    this.data = null; // No data passed, so set it as null
  }

  // Constructor with data
  public ApiResponse(String status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data; // Data passed, so assign it
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }

  @Override
  public String toString() {
    if (data == null) {
      return "ApiResponse{" +
          "status='" + status + '\'' +
          ", message='" + message + '\'' +
          '}';
    } else {
      return "ApiResponse{" +
          "status='" + status + '\'' +
          ", message='" + message + '\'' +
          ", data=" + data +
          '}';
    }
  }
}
