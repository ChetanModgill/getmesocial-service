package com.example.getmesocialservice.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;
    private String name;
    private String Email;
    private String profilePhotoUrl;

    public User(String name, String email, String profilePhotoUrl) {
        this.name = name;
        this.Email = email;
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
}
