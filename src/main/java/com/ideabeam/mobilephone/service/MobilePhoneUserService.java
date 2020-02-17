package com.ideabeam.mobilephone.service;

import com.ideabeam.mobilephone.dto.MobilePhoneDTO;
import com.ideabeam.mobilephone.dto.MobilePhoneUserDTO;
import com.ideabeam.mobilephone.entity.MobilePhoneUser;
import com.ideabeam.mobilephone.entity.User;
import com.ideabeam.mobilephone.repository.MobilePhoneRepository;
import com.ideabeam.mobilephone.repository.MobilePhoneUserRepository;
import com.ideabeam.mobilephone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MobilePhoneUserService {

    @Autowired
    private MobilePhoneUserRepository mobilePhoneUserRepository;

    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    @Autowired
    private UserRepository userRepository;

    public MobilePhoneUserDTO saveMobileUser(MobilePhoneUserDTO mobilePhoneUserDTO){
        MobilePhoneUser mobilePhoneUser = new MobilePhoneUser();
        mobilePhoneUser.setId(mobilePhoneUserDTO.getId());
        mobilePhoneUser.setPrice(mobilePhoneUserDTO.getPrice());
        mobilePhoneUser.setMobilePhone(mobilePhoneRepository.findById(mobilePhoneUserDTO.getMobilePhoneId()).orElse(null));
        mobilePhoneUser.setUser(userRepository.findById(mobilePhoneUserDTO.getUserId()));

        MobilePhoneUser saveMobilePhoneUser = mobilePhoneUserRepository.save(mobilePhoneUser);
        return new MobilePhoneUserDTO(saveMobilePhoneUser.getId(), saveMobilePhoneUser.getUser().getId(), saveMobilePhoneUser.getMobilePhone().getId(), saveMobilePhoneUser.getPrice());
    }

    public List<MobilePhoneUser> getAllStoreMobiles(){
        List<User> stores = userRepository.findAllByUserRole("STORE");
        List<MobilePhoneUser> allMobileswithStores =  new ArrayList<>();
        if(!stores.isEmpty()){
            for (User model:stores) {
                List<MobilePhoneUser> oneStrore = getAllMobilesByUser(model.getId());
                Stream.concat(allMobileswithStores.stream(), oneStrore.stream())
                        .collect(Collectors.toList());
            }
            return allMobileswithStores;
        } else {
            return null;
        }
    }

    public List<MobilePhoneUser> getAllMobilesByUser(int id) {
        List<MobilePhoneUser> modelsByUserId = mobilePhoneUserRepository.findByUserId(id);
        if (modelsByUserId != null){
            return modelsByUserId;
        }
        else
            return null;
    }

    public MobilePhoneUser getAllMobilesById(int id) {
        MobilePhoneUser mobilePhoneUser = mobilePhoneUserRepository.findById(id);
        if (mobilePhoneUser != null){
            return mobilePhoneUser;
        }
        else
            return null;
    }

    public void deleteStoreModel(int id){
        mobilePhoneUserRepository.deleteById(id);
    }

}
