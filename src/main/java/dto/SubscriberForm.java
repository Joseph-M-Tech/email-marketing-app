package com.example.landing.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class SubscriberForm {


@NotBlank(message = "Email is required")
@Email(message = "Enter a valid email")
private String email;


public SubscriberForm() {}


public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
}