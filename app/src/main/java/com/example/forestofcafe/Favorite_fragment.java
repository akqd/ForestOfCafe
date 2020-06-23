package com.example.forestofcafe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Favorite_fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    Context context;
    RecyclerView recyclerView;
    FavoriteCafe_Adapter adapter;
    private  ArrayList<FavoriteCafe_Item> data = new ArrayList<FavoriteCafe_Item>();
    RecyclerView.LayoutManager layoutManager;
    NestedScrollView sv_main;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        sv_main = getActivity().findViewById(R.id.sv_main);
        recyclerView = getActivity().findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FavoriteCafe_Adapter(data);
        recyclerView.setAdapter(adapter);
        data.clear();
        adapter.notifyDataSetChanged();


        addMainFavorite(getResources().getDrawable(R.drawable.cafe_ttobagi_1,null),"또바기","서울 서대문구 명지대길 108","010-7600-2602","오늘은 18시까지만 영업 합니다.","OPEN");
        addMainFavorite(getResources().getDrawable(R.drawable.cafe_thelight_1,null),"카페 빛","서울 은평구 응암로 14길 26-1","070-8784-1111","오늘은 정상 영업 합니다.","OPEN");
        addMainFavorite(getResources().getDrawable(R.drawable.cafe_timedifference_1,null),"카페 시차","서울 서대문구 증가로 10길 16-20","010-3331-9085","오늘은 오후부터 영업 시작합니다.","CLOSE");

        //카페상세정보 화면으로 이동
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new FavoriteCafe_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                ((MainActivity) context).replaceFragment(Cafe_infomation_fragment.newInstance(), null);
                sv_main.scrollTo(0,0);
            }
        });


    }
    public void addMainFavorite(Drawable cafe_image, String cafe_name, String cafe_location, String cafe_number,String cafe_notice , String cafe_open) {
        FavoriteCafe_Item item = new FavoriteCafe_Item();

        item.setCafe_image(cafe_image);
        item.setCafe_name(cafe_name);
        item.setCafe_location(cafe_location);
        item.setCafe_number(cafe_number);
        item.setCafe_notice(cafe_notice);
        item.setCafe_open_close(cafe_open);

        data.add(item);
    }





    public Favorite_fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_favorite,container,false);
    }

    public static Favorite_fragment newInstance() {
        return new Favorite_fragment();
    }
}
