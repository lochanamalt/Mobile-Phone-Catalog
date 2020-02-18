package com.ideabeam.mobilephone.controller;

import com.ideabeam.mobilephone.dto.UserDTO;
import com.ideabeam.mobilephone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @GetMapping("/stores")
    public List<UserDTO> getAllStores(){
        return userService.getAllStores();
    }

    @GetMapping("/stores/{id}")
    public UserDTO getStore(@PathVariable int id){
        return userService.findUserByUId(id);
    }

    @GetMapping("/stores/{name}")
    public UserDTO getStore(@PathVariable String username){
        return userService.findUserByUsername(username);
    }
}
