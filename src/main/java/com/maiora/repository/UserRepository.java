package com.maiora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maiora.entity.User;

public interface UserRepository  extends JpaRepository<User,Integer> {
    public User findByUserId(int id);
}
