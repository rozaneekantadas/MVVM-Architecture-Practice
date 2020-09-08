package com.suptodas.diu.mvvmarchitecturepractice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.suptodas.diu.mvvmarchitecturepractice.R;
import com.suptodas.diu.mvvmarchitecturepractice.viewmodel.SignInViewModel;

public class SignInActivity extends AppCompatActivity {

    private Button signInButton;
    private SignInViewModel signInViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        intiSignInVIewModel();

        signInButton  = findViewById(R.id.signInButtonId);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    private void intiSignInVIewModel() {

        signInViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(SignInViewModel.class);
    }

    private void signIn() {



    }
}
