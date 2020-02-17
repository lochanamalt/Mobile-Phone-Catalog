package com.ideabeam.mobilephone.service;

import com.ideabeam.mobilephone.dto.MobilePhoneDTO;
import com.ideabeam.mobilephone.entity.MobilePhone;
import com.ideabeam.mobilephone.repository.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MobilePhoneService {

    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    public MobilePhoneDTO saveModel(MobilePhoneDTO mobilePhoneModelDTO){
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setId(mobilePhoneModelDTO.getId());
        mobilePhone.setModel(mobilePhoneModelDTO.getModel());
        mobilePhone.setBrand(mobilePhoneModelDTO.getBrand());
        mobilePhone.setColor(mobilePhoneModelDTO.getColor());
        MobilePhone savedMobile = mobilePhoneRepository.save(mobilePhone);

        return new MobilePhoneDTO(savedMobile.getId(), savedMobile.getBrand(), savedMobile.getModel(), savedMobile.getColor());
    }

    public List<MobilePhoneDTO> getAllModels(){
        List<MobilePhone> allModels = mobilePhoneRepository.findAll();
        List<MobilePhoneDTO> allModelDTOs = new ArrayList<>();

        if(!allModels.isEmpty()){
            for (MobilePhone model:allModels) {
                allModelDTOs.add(new MobilePhoneDTO(model.getId(), model.getBrand(), model.getModel(), model.getColor()));
            }
            return allModelDTOs;
        } else {
            return null;
        }
    }

    public MobilePhoneDTO getMobilePhone(int id){
        MobilePhone mobilePhoneModel = mobilePhoneRepository.findById(id).orElse(null);
        if(mobilePhoneModel != null)
            return new MobilePhoneDTO(mobilePhoneModel.getId(), mobilePhoneModel.getBrand(), mobilePhoneModel.getModel(), mobilePhoneModel.getColor());
        else
            return null;
    }

    public List<MobilePhoneDTO> getMobilePhoneByBrand(String brand){
        List<MobilePhone> mobilePhoneModel = mobilePhoneRepository.findByModel(brand);
        List<MobilePhoneDTO>  modelsByBrand = new ArrayList<>();

        if(!mobilePhoneModel.isEmpty()){
            for (MobilePhone model:mobilePhoneModel) {
                modelsByBrand.add(new MobilePhoneDTO(model.getId(), model.getBrand(), model.getModel(), model.getColor()));
            }
            return modelsByBrand;
        } else {
            return null;
        }
    }


}
