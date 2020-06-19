package com.example.forestofcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity_Find extends AppCompatActivity {
    Button btnFindPhone, btnFindEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_findpassword);
        setTitle("비밀번호 찾기");

        btnFindPhone = findViewById(R.id.btnFindPhone);
        btnFindEmail = findViewById(R.id.btnFindEmail);

        btnFindPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity_FindPhone.class);
                startActivity(intent);
            }
        });

        btnFindEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity_FindEmail.class);
                startActivity(intent);
            }
        });
    }
}
