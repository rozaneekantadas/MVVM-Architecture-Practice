package com.suptodas.diu.mvvmarchitecturepractice.model;

import java.io.Serializable;

public class SignInUser implements Serializable {

    public String uId;
    public String name;
    public String email;
    public String imageUrl;
    public boolean isAuth;

    public SignInUser() {
    }

    public SignInUser(String uId, String name, String email, String imageUrl) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public String getuId() {
        return uId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
