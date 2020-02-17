package com.ideabeam.mobilephone.repository;

import com.ideabeam.mobilephone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findById(int id);
    List<User> findAllByUserRole(String userRole);

}
