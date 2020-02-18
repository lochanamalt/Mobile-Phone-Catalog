package com.ideabeam.mobilephone.repository;

import com.ideabeam.mobilephone.entity.MobilePhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobilePhoneRepository extends JpaRepository<MobilePhone,Integer>{
    List<MobilePhone> findByBrand(String brand);
    List<MobilePhone> findByModel(String model);
}
