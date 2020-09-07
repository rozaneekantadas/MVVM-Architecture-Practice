package com.suptodas.diu.mvvmarchitecturepractice.repository;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.suptodas.diu.mvvmarchitecturepractice.model.SignInUser;

public class SignInRepository {

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private SignInUser user = new SignInUser();

    public MutableLiveData<SignInUser> checkAuthenticationInFirebase(){

        MutableLiveData<SignInUser> isAuthenticateLiveData = new MutableLiveData<>();

        FirebaseUser currentUsers = firebaseAuth.getCurrentUser();

        if (currentUsers == null){
            user.isAuth = false;
            isAuthenticateLiveData.setValue(user);
        }
        else {
            user.uId = currentUsers.getUid();
            user.isAuth = true;
            isAuthenticateLiveData.setValue(user);
        }

        return isAuthenticateLiveData;
    }
}
