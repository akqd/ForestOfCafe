package com.example.forestofcafe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class Search_Activity extends AppCompatActivity {

    SearchView search_view ;
    Chip chip1 ;
    RecyclerView rv_searchResult;
    SearchResult_Adapter sAdapter ;
    private ArrayList<SearchResult_Item> sData = new ArrayList<SearchResult_Item>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        rv_searchResult = findViewById(R.id.rv_searchResult);
        search_view = findViewById(R.id.search_view);
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

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { // 작성한 다음 검색 버튼을 눌렀을때 검색
                return true; // 사용하는 곳의 반환값은 true
            }
            @Override
            public boolean onQueryTextChange(String newText) { // 작성하는 순간마다 검색 됨
                return false;

            }
        });
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
