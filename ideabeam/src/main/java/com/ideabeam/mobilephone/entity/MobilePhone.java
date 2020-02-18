package com.ideabeam.mobilephone.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="mobilephone")
public class MobilePhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String color;

    @OneToMany(mappedBy = "mobilePhone",cascade = CascadeType.ALL)
    private Set<MobilePhoneUser> mobilePhoneUsers;

    public MobilePhone() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        brand = brand;
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
