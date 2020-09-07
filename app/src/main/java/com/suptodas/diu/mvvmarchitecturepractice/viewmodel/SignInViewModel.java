package com.suptodas.diu.mvvmarchitecturepractice.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.suptodas.diu.mvvmarchitecturepractice.model.SignInUser;
import com.suptodas.diu.mvvmarchitecturepractice.repository.SignInRepository;

public class SignInViewModel extends AndroidViewModel {

    private SignInRepository repository;
    public LiveData<SignInUser> checkAuthenticateLiveData;

    public SignInViewModel(@NonNull Application application) {
        super(application);
        repository = new SignInRepository();
    }

    public void checkAuthenticate(){

        checkAuthenticateLiveData = repository.checkAuthenticationInFirebase();
    }
}
