package com.example.raisaver2.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.raisaver2.FragmentHome.Fragment;
import com.example.raisaver2.MainActivity;
import com.example.raisaver2.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Register(View view) {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    public void BtnLogin(View view) {
        Intent i = new Intent(LoginActivity.this, Fragment.class);
        startActivity(i);
    }
}
