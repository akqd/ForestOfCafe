package com.example.main_commnity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<Main_Community_Model> community_modelList = new ArrayList<>();
        community_modelList.add(new Main_Community_Model(R.drawable.ic_profile, R.drawable.cafe1,"커피돌이", "Be, Bridge", "넓어서 좋고 분위기가 시원시원해요~", "4.7", "10", "5"));
        community_modelList.add(new Main_Community_Model(R.drawable.ic_profile, R.drawable.cafe2, "커피순이", "Cafe청담", "정동극장 입장전에 한잔하기 좋아요~ 따뜻한 분위기라 힐링되네요~", "5.0", "18", "9"));
        community_modelList.add(new Main_Community_Model(R.drawable.ic_profile, R.drawable.cafe3, "조범석", "PS카페", "참치를 안파네", "1", "99", "99"));

        MainCommunity_Adapter adapter = new MainCommunity_Adapter(community_modelList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }
}