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
        rv_searchResult = findViewById(R.id.rv_searchResult);
        chip1 = findViewById(R.id.chip1);
        sAdapter = new SearchResult_Adapter(sData);
        sAdapter.setOnItemClickListener(new SearchResult_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int postion) {
                Toast.makeText(getApplicationContext(),postion + "아이템 선택됨",Toast.LENGTH_SHORT).show();
            }
        });
        rv_searchResult.setAdapter(sAdapter);
        rv_searchResult.setLayoutManager(new LinearLayoutManager(this));
        addItem(getDrawable(R.drawable.cafe_image),"OPEN","카페1","카페1주소","#대충 #만듬","350km");
        addItem(getDrawable(R.drawable.cafe1),"CLOSE","카페2","카페2주소","#대충 #만듬","450km");
        addItem(getDrawable(R.drawable.cafe2),"OPEN","카페3","카페3주소","#대충 #만듬","550km");
        addItem(getDrawable(R.drawable.cafe3),"CLOSE","카페4","카페4주소","#대충 #만듬","650km");
        addItem(getDrawable(R.drawable.cafe4),"OPEN","카페5","카페5주소","#대충 #만듬","750km");
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
