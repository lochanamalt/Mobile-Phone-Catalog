package com.ideabeam.mobilephone.repository;

import com.ideabeam.mobilephone.entity.MobilePhoneUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobilePhoneUserRepository extends JpaRepository<MobilePhoneUser,Integer> {
    List<MobilePhoneUser> findByUserId(int Id);
    MobilePhoneUser findById(int Id);
}
