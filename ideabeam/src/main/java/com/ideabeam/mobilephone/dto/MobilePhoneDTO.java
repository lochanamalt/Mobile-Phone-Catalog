package com.ideabeam.mobilephone.dto;
import com.ideabeam.mobilephone.entity.MobilePhoneUser;

import java.util.Set;

public class MobilePhoneDTO {

    private int id;
    private String brand;
    private String model;
    private String color;
    private Set<MobilePhoneUser> mobilePhoneUsers;

    public MobilePhoneDTO(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<MobilePhoneUser> getMobilePhoneUsers() {
        return mobilePhoneUsers;
    }

    public void setMobilePhoneUsers(Set<MobilePhoneUser> mobilePhoneUsers) {
        this.mobilePhoneUsers = mobilePhoneUsers;
    }
}
