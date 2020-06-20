package com.example.forestofcafe;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Setting_notice extends AppCompatActivity {

    ArrayList<String> notice_list;
    ListView listV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        setTitle("공지사항");

        listV = findViewById(R.id.listv_notice);

        notice_list = new ArrayList<>();
        notice_list.add("새로운 업데이트 사항이 있습니다.");
        notice_list.add("카페의 숲에 북가좌동 카페가 업데이트 되었습니다.");
        notice_list.add("카페의 숲을 이용해주셔서 감사합니다.");

        ArrayAdapter Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notice_list);
        listV.setAdapter(Adapter);



    }
}


