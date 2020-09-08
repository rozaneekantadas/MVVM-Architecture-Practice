package com.suptodas.diu.mvvmarchitecturepractice.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.auth.AuthCredential;
import com.suptodas.diu.mvvmarchitecturepractice.model.SignInUser;
import com.suptodas.diu.mvvmarchitecturepractice.repository.SignInRepository;

public class SignInViewModel extends AndroidViewModel {

    private SignInRepository repository;
    public LiveData<SignInUser> checkAuthenticateLiveData;
    public LiveData<String> authenticationLiveData;

    public SignInViewModel(@NonNull Application application) {
        super(application);
        repository = new SignInRepository();
    }

    public void signInWithGoogle(AuthCredential authCredential){

        authenticationLiveData = repository.firebaseSignInWithGoogle(authCredential);
    }

    public void checkAuthenticate(){

        checkAuthenticateLiveData = repository.checkAuthenticationInFirebase();
    }
}
