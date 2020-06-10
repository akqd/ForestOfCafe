package com.example.forestofcafe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.concurrent.TimeoutException;


public class Home_fragment extends Fragment {
    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View v;

    RecyclerView rv_MainCafeList;
    RecyclerView.LayoutManager layoutManager;
    MainCafeList_Adapter mAdapter;
    private ArrayList<MainCafeList_Item> mData = new ArrayList<MainCafeList_Item>();


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        rv_MainCafeList = getActivity().findViewById(R.id.rv_MainCafeList);
        layoutManager = new LinearLayoutManager(context);
        rv_MainCafeList.setLayoutManager(layoutManager);
        mAdapter = new MainCafeList_Adapter(mData);
        rv_MainCafeList.setAdapter(mAdapter);

        addCafeListItem("카페이름1", "050m", "OPEN", getResources().getDrawable(R.drawable.cafe1, null));
        addCafeListItem("카페이름2", "100m", "CLOSE", getResources().getDrawable(R.drawable.cafe2, null));
        addCafeListItem("카페이름3", "200m", "OPEN", getResources().getDrawable(R.drawable.cafe3, null));
        mAdapter.notifyDataSetChanged();
    }

    public void addCafeListItem(String cafe_name, String cafe_distance, String cafe_openclose, Drawable cafe_image) {
        MainCafeList_Item item = new MainCafeList_Item();

        item.setCafe_Name(cafe_name);
        item.setCafe_distance(cafe_distance);
        item.setCafe_openclose(cafe_openclose);
        item.setCafe_Image(cafe_image);

        mData.add(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            v = inflater.inflate(R.layout.fragment_menu_home, container, false);
        } catch (InflateException e) { // 구글 Map fragment inflate 에러 무시
        }
        return v;
    }

    @Override
    public void onDestroyView() { // 화면에서 라라질때 프래그먼트의 뷰 삭제
        super.onDestroyView();
        if (v != null) {
            ViewGroup parent = (ViewGroup) v.getParent();
            if (parent != null) {
                parent.removeView(v);
            }
        }
    }
}
