package com.rats.forum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rats.forum.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
