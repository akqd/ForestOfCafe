package com.example.forestofcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity_FindEmail extends AppCompatActivity {
    EditText edtEmail;
    Button btnFindPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_findbyemail);
        setTitle("E-mail로 찾기");

        edtEmail = findViewById(R.id.edtEmail);
        btnFindPassword = findViewById(R.id.btnFindPassword);

        btnFindPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity_Login.class);
                startActivity(intent);
            }
        });

    }
}
