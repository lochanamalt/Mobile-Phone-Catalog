package com.ideabeam.mobilephone.controller;

import com.ideabeam.mobilephone.dto.MobilePhoneDTO;
import com.ideabeam.mobilephone.entity.MobilePhone;
import com.ideabeam.mobilephone.service.MobilePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MobilePhoneController {

    @Autowired
    private MobilePhoneService mobilePhoneService;

    @PostMapping("/mobiles")
    public MobilePhoneDTO saveModel(@RequestBody MobilePhoneDTO mobilePhoneDTO){
        return mobilePhoneService.saveModel(mobilePhoneDTO);
    }

    @GetMapping("/mobiles")
    public List<MobilePhoneDTO> getAllModels(){
        return mobilePhoneService.getAllModels();
    }

    @GetMapping("/mobiles/{id}")
    public MobilePhoneDTO getModel(@PathVariable int id){
        return mobilePhoneService.getMobilePhone(id);
    }

    @GetMapping("/mobiles/brand/{brand}")
    public List<MobilePhoneDTO> getAllModels(@PathVariable String brand){
        return mobilePhoneService.getMobilePhoneByBrand(brand);
    }
}
