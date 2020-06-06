package com.example.forestofcafe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.google.android.material.chip.Chip;

public class Search_Activity extends AppCompatActivity {

    SearchView search_view ;
    Chip chip1 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search_view = findViewById(R.id.search_view);
        chip1 = findViewById(R.id.chip1);
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
    }
}
