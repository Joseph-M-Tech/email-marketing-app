package com.example.landing.repository;


import com.example.landing.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
boolean existsByEmail(String email);
}