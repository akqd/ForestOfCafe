package com.example.forestofcafe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class Search_Activity extends AppCompatActivity {

    SearchView search_view ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        search_view = findViewById(R.id.search_view);
    }
}
