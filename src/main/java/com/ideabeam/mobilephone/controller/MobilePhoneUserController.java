package com.ideabeam.mobilephone.controller;

import com.ideabeam.mobilephone.dto.MobilePhoneUserDTO;
import com.ideabeam.mobilephone.entity.MobilePhoneUser;
import com.ideabeam.mobilephone.service.MobilePhoneUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MobilePhoneUserController {

    @Autowired
    private MobilePhoneUserService mobilePhoneUserService;

    @PostMapping("/storemobiles")
    public MobilePhoneUserDTO saveStoreModel(@RequestBody MobilePhoneUserDTO storeModelDTO){
        return mobilePhoneUserService.saveMobileUser(storeModelDTO);
    }

    @GetMapping("/storemobiles")
    public List<MobilePhoneUser> getAllStoreModels(){
        return mobilePhoneUserService.getAllStoreMobiles();
    }

    @GetMapping("/storemobiles/{id}")
    public MobilePhoneUser getStoreModel(@PathVariable int id){
        return mobilePhoneUserService.getAllMobilesById(id);
    }


    @GetMapping("/storemobiles/store/{id}")
    public List<MobilePhoneUser> getStoreModelByStore(@PathVariable int id) {
        return mobilePhoneUserService.getAllMobilesByUser(id);
    }

    @DeleteMapping("/storemobiles/{id}")
    public void deleteStoreModel(@PathVariable int id){
        mobilePhoneUserService.deleteStoreModel(id);
    }

}