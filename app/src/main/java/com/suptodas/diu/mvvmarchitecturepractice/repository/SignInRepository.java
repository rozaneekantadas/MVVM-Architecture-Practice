package com.suptodas.diu.mvvmarchitecturepractice.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
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

    public MutableLiveData<String> firebaseSignInWithGoogle(final AuthCredential authCredential){
        final MutableLiveData<String> authMutabeleLiveData = new MutableLiveData<>();

        firebaseAuth.signInWithCredential(authCredential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                String uId = currentUser.getUid();

                authMutabeleLiveData.setValue(uId);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                authMutabeleLiveData.setValue(e.toString());
            }
        });

        return authMutabeleLiveData;
    }
}
