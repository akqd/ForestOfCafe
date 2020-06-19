package com.example.forestofcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity_Login extends AppCompatActivity {
    EditText edtID, edtPassword;
    Button btnFindPassword, btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_login);
        setTitle("로그인");

        edtID = findViewById(R.id.edtID);
        edtPassword = findViewById(R.id.edtPassword);

        btnFindPassword = findViewById(R.id.btnFindPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnFindPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity_Find.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
