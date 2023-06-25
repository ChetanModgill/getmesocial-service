package com.example.getmesocialservice.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {

    @Id
    private String id;
    private String name;
    @Email(message = "Use proper Email Format")
    private String emailAddress;
    @NotEmpty(message = "ProfilePhotoUrl can not be empty")
    private String profilePhotoUrl;

    public User(String id, String name, String emailAddress, String profilePhotoUrl) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
}
