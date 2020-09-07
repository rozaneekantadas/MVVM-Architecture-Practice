package com.suptodas.diu.mvvmarchitecturepractice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.suptodas.diu.mvvmarchitecturepractice.R;
import com.suptodas.diu.mvvmarchitecturepractice.model.SignInUser;
import com.suptodas.diu.mvvmarchitecturepractice.viewmodel.SignInViewModel;

public class SlashScreenActivity extends AppCompatActivity {

    private SignInViewModel signInViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash_screen);

        initSplashViewMode();
        checkIfUserAuthenticate();
    }

    private void checkIfUserAuthenticate() {
        signInViewModel.checkAuthenticate();
        signInViewModel.checkAuthenticateLiveData.observe(this, new Observer<SignInUser>() {
            @Override
            public void onChanged(SignInUser signInUser) {
                if(!signInUser.isAuth){
                    goToSignInActivity();
                }
                else {
                    goToMainActivity();
                }
            }
        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(SlashScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToSignInActivity() {
        Intent intent = new Intent(SlashScreenActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    private void initSplashViewMode() {

        signInViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(SignInViewModel.class);
    }
}
