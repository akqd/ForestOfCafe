package com.example.forestofcafe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class Search_Activity extends AppCompatActivity {

    Chip chip1 ;
    AutoCompleteTextView act_search;
    RecyclerView rv_searchResult;
    SearchResult_Adapter sAdapter ;
    private ArrayList<SearchResult_Item> sData = new ArrayList<SearchResult_Item>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        act_search = findViewById(R.id.act_search);
        act_search.setText("디저트");
        rv_searchResult = findViewById(R.id.rv_searchResult);
        chip1 = findViewById(R.id.chip1);
        sAdapter = new SearchResult_Adapter(sData);
        sAdapter.setOnItemClickListener(new SearchResult_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int postion) {
                finish();
                ((MainActivity)MainActivity.sContext).replaceFragment(Cafe_infomation_fragment.newInstance(),null);
            }
        });
        rv_searchResult.setAdapter(sAdapter);
        rv_searchResult.setLayoutManager(new LinearLayoutManager(this));
        addItem(getDrawable(R.drawable.cafe_ttobagi_1), "OPEN", "또바기", "서울 서대문구 명지대길 108", "#디저트 #와플, #분위기 좋은", "180m");
        addItem(getDrawable(R.drawable.cafe_sweatfilling_1), "CLOSE", "달콤충전소", "서울 서대문구 거북골로 6", "#디저트 #마카롱", "390m");
        addItem(getDrawable(R.drawable.cafe_pongshin_1), "CLOSE", "퐁신수플레", "서울 서대문구 거북골로 31-1", "#디저트 #수플레, #테라스", "580m");
        addItem(getDrawable(R.drawable.cafe_timedifference_1), "OPEN", "시차", "서울 서대문구 증가로 10길 16-20", "#디저트 #수제펑리수", "780m");
        addItem(getDrawable(R.drawable.cafe_onthepalette_1),"OPEN","온더팔레트", "서울 은평구 응암로 14실 17", "#디저트, #와플, #느낌있는","780m");
        sAdapter.notifyDataSetChanged();

    }

    public void addItem(Drawable cafe_image, String op_cl, String title, String location, String keyword, String distance){
        SearchResult_Item item = new SearchResult_Item();
        item.setCafe_image(cafe_image);
        item.setCafe_OP_CL(op_cl);
        item.setCafe_title(title);
        item.setCafe_location(location);
        item.setCafe_keyword(keyword);
        item.setCafe_distance(distance);
        sData.add(item);
    }

}
