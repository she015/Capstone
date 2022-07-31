package com.sumit.playjava.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumit.playjava.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
