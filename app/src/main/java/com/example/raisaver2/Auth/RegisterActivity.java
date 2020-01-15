package com.example.raisaver2.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.raisaver2.FragmentHome.Fragment;
import com.example.raisaver2.MainActivity;
import com.example.raisaver2.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Login(View view) {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void BtnRegister(View view) {
        Intent i = new Intent(RegisterActivity.this, Fragment.class);
        startActivity(i);
    }
}
