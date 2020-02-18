package com.ideabeam.mobilephone.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String userRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<MobilePhoneUser> mobilePhoneUsers;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Set<MobilePhoneUser> getMobilePhoneUsers() {
        return mobilePhoneUsers;
    }

    public void setMobilePhoneUsers(Set<MobilePhoneUser> mobilePhoneUsers) {
        this.mobilePhoneUsers = mobilePhoneUsers;
    }
}
