package com.example.forestofcafe;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;


public class Home_fragment extends Fragment {
    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View v;
    TextView tvCafeListMore;
    RecyclerView rv_MainCafeList, comm_recyclerView, fv_recyclerView;
    RecyclerView.LayoutManager layoutManager , fv_layoutManeger;
    MainCafeList_Adapter mAdapter;
    private ArrayList<MainCafeList_Item> mData = new ArrayList<MainCafeList_Item>();
    MainFavorite_Adapter fAdapter;
    private  ArrayList<MainFavorite_Item> fData = new ArrayList<MainFavorite_Item>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        tvCafeListMore = getActivity().findViewById(R.id.tvMore);
        rv_MainCafeList = getActivity().findViewById(R.id.rv_MainCafeList);
        layoutManager = new LinearLayoutManager(context);
        rv_MainCafeList.setLayoutManager(layoutManager);
        mAdapter = new MainCafeList_Adapter(mData);
        rv_MainCafeList.setAdapter(mAdapter);
        tvCafeListMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(MainCafeList_fragment.newInstance(),null);
            }
        });
        addCafeListItem("카페이름1", "050m", "OPEN", getResources().getDrawable(R.drawable.cafe1, null));
        addCafeListItem("카페이름2", "100m", "CLOSE", getResources().getDrawable(R.drawable.cafe2, null));
        addCafeListItem("카페이름3", "200m", "OPEN", getResources().getDrawable(R.drawable.cafe3, null));
        mAdapter.notifyDataSetChanged();
        //메인 화면 - 즐겨찾는 카페 리스트
        fv_recyclerView = getActivity().findViewById(R.id.fv_recyclerView);
        fv_layoutManeger = new LinearLayoutManager(context);
        fv_recyclerView.setLayoutManager(fv_layoutManeger);
        fAdapter = new MainFavorite_Adapter(fData);
        fv_recyclerView.setAdapter(fAdapter);
        addMainFavorite(getResources().getDrawable(R.drawable.cafe_thelight_1,null),"카페 빛","오늘은 정상 영업 합니다.","OPEN");
        addMainFavorite(getResources().getDrawable(R.drawable.cafe_timedifference_1,null),"카페 시차","오늘은 오후부터 영업 시작합니다.","CLOSE");
        addMainFavorite(getResources().getDrawable(R.drawable.cafe_ttobagi_1,null),"또바기","오늘은 영업 쉽니다.","CLOSE");
        //메인커뮤니티화면에 대한 코드 추가(김준희)
        comm_recyclerView = getActivity().findViewById(R.id.comm_recyclerView);
        LinearLayoutManager comm_layoutManager = new LinearLayoutManager(context);

        comm_layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        comm_recyclerView.setLayoutManager(comm_layoutManager);

        List<MainCommunity_Item> community_itemList = new ArrayList<>();
        community_itemList.add(new MainCommunity_Item(R.drawable.ic_profile, R.drawable.cafe1,"커피돌이", "Be, Bridge", "넓어서 좋고 분위기가 시원시원해요~", "4.7", "10", "5"));
        community_itemList.add(new MainCommunity_Item(R.drawable.ic_profile, R.drawable.cafe2, "커피순이", "Cafe청담", "정동극장 입장전에 한잔하기 좋아요~ 따뜻한 분위기라 힐링되네요~", "5.0", "18", "9"));
        community_itemList.add(new MainCommunity_Item(R.drawable.ic_profile, R.drawable.cafe3, "조범석", "PS카페", "참치를 안파네", "1", "99", "99"));

        MainCommunity_Adapter comm_adapter = new MainCommunity_Adapter(community_itemList);
        comm_adapter.notifyDataSetChanged();
        comm_recyclerView.setAdapter(comm_adapter);
    }

    public void addCafeListItem(String cafe_name, String cafe_distance, String cafe_openclose, Drawable cafe_image) {
        MainCafeList_Item item = new MainCafeList_Item();
        item.setCafe_Name(cafe_name);
        item.setCafe_distance(cafe_distance);
        item.setCafe_openclose(cafe_openclose);
        item.setCafe_Image(cafe_image);
        mData.add(item);
    }

    public void addMainFavorite(Drawable cafe_image, String cafe_name, String cafe_notice , String cafe_open) {
        MainFavorite_Item item = new MainFavorite_Item();

        item.setCafe_image(cafe_image);
        item.setCafe_name(cafe_name);
        item.setCafe_notice(cafe_notice);
        item.setCafe_open_close(cafe_open);

        fData.add(item);
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

    public static Home_fragment newInstance() {
        return new Home_fragment();
    }
}
