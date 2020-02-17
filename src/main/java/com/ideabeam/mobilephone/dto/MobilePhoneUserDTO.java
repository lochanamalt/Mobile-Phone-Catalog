package com.ideabeam.mobilephone.dto;
import com.ideabeam.mobilephone.entity.MobilePhone;
import com.ideabeam.mobilephone.entity.User;


public class MobilePhoneUserDTO {

    private int id;
    private int userId;
    private int mobilePhoneId;
    private double price;

    public MobilePhoneUserDTO(int id, int userId, int mobilePhoneId, double price) {
        this.id = id;
        this.userId = userId;
        this.mobilePhoneId = mobilePhoneId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMobilePhoneId() {
        return mobilePhoneId;
    }

    public void setMobilePhoneId(int mobilePhoneId) {
        this.mobilePhoneId = mobilePhoneId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
