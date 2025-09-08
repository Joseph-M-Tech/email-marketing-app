package com.example.landing.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "subscribers")
public class Subscriber {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false, unique = true)
private String email;


private LocalDateTime createdAt;


public Subscriber() {}


public Subscriber(String email) {
this.email = email;
}


@PrePersist
public void prePersist() {
this.createdAt = LocalDateTime.now();
}


// getters & setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }


public LocalDateTime getCreatedAt() { return createdAt; }
public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}