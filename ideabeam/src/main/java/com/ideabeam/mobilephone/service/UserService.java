package com.ideabeam.mobilephone.service;

import com.ideabeam.mobilephone.dto.UserDTO;
import com.ideabeam.mobilephone.entity.User;
import com.ideabeam.mobilephone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setUserRole(userDTO.getUserRole());

        User saveUser = userRepository.save(user);

        return new UserDTO(saveUser.getId(),saveUser.getName(), saveUser.getUsername(), saveUser.getEmail(), saveUser.getPassword(), saveUser.getUserRole());
    }

    public UserDTO findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return new UserDTO(user.getId(), user.getName(),user.getUsername(), user.getEmail(), user.getPassword(), user.getUserRole());

    }

    public UserDTO findUserByUId(int id) {
        User user = userRepository.findById(id);
        return new UserDTO(user.getId(), user.getName(),user.getUsername(), user.getEmail(), user.getPassword(), user.getUserRole());

    }

    public List<UserDTO> getAllStores(){
        List<User> allStores = userRepository.findAllByUserRole("STORE");
        List<UserDTO> allStoreDTOs = new ArrayList<>();

        if(!allStores.isEmpty()){
            for (User store: allStores) {
                allStoreDTOs.add(new UserDTO(store.getId(), store.getName(),store.getUsername(),store.getEmail()));
            }
            return allStoreDTOs;
        } else {
            return null;
        }
    }
}
