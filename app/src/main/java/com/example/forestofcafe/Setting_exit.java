package com.example.forestofcafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Setting_exit extends AppCompatActivity {

    TextView tv;
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        tv = findViewById(R.id.tv_exit);
        btn = findViewById(R.id.btn_exit);

        tv.setText("탈퇴를 하면 기존 정보가\n사라집니다.\n\n탈퇴하시겠습니까?");
        btn.setText("탈퇴");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("탈퇴되었습니다.\n\n이용해주셔서\n감사합니다");
                btn.setText("시작화면으로");

            }
        });


    }



}
