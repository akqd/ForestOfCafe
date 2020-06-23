package com.example.forestofcafe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainCafeList_fragment extends Fragment implements OnMapReadyCallback {

    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View v;

    RecyclerView rv_MainCafeListMore;
    RecyclerView.LayoutManager layoutManager;
    SearchResult_Adapter mAdapter;
    private ArrayList<SearchResult_Item> mData = new ArrayList<SearchResult_Item>();
    NestedScrollView sv_main;

    MapView mapViewMore;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();

        mapViewMore = v.findViewById(R.id.mapMore);
        mapViewMore.onCreate(savedInstanceState);

        mapViewMore.getMapAsync((OnMapReadyCallback) this);

        sv_main = getActivity().findViewById(R.id.sv_main);

        rv_MainCafeListMore = getActivity().findViewById(R.id.rv_MainCafeListMore);
        layoutManager = new LinearLayoutManager(context);
        rv_MainCafeListMore.setLayoutManager(layoutManager);
        mAdapter = new SearchResult_Adapter(mData);
        rv_MainCafeListMore.setAdapter(mAdapter);
        mData.clear();
        mAdapter.notifyDataSetChanged();

        addItem(getResources().getDrawable(R.drawable.cafe_ttobagi_1, null), "OPEN", "또바기", "서울 서대문구 명지대길 108", "#디저트 #와플, #분위기 좋은", "180m");
        addItem(getResources().getDrawable(R.drawable.cafe_sweatfilling_1, null), "CLOSE", "달콤충전소", "서울 서대문구 거북골로 6", "#디저트 #마카롱", "390m");
        addItem(getResources().getDrawable(R.drawable.cafe_howdy_1, null), "OPEN", "하우디", "서울 서대문구 명지대길 10 2층", "#분위기 좋은 #명지대 앞", "430m");
        addItem(getResources().getDrawable(R.drawable.cafe_pongshin_1, null), "CLOSE", "퐁신수플레", "서울 서대문구 거북골로 31-1", "#디저트 #수플레, #테라스", "580m");
        addItem(getResources().getDrawable(R.drawable.cafe_timedifference_1, null), "OPEN", "시차", "서울 서대문구 증가로 10길 16-20", "#디저트 #수제펑리수", "780m");
        mAdapter.notifyDataSetChanged();

        //카페상세정보화면으로 이동
        mAdapter.setOnItemClickListener(new SearchResult_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ((MainActivity) context).replaceFragment(Cafe_infomation_fragment.newInstance(), null);
                sv_main.scrollTo(0,0);
            }
        });
    }

    public void addItem(Drawable cafe_image, String op_cl, String title, String location, String keyword, String distance) {
        SearchResult_Item item = new SearchResult_Item();
        item.setCafe_image(cafe_image);
        item.setCafe_OP_CL(op_cl);
        item.setCafe_title(title);
        item.setCafe_location(location);
        item.setCafe_keyword(keyword);
        item.setCafe_distance(distance);
        mData.add(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            v = inflater.inflate(R.layout.fragment_menu_home_cafelistmore, container, false);
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

    public static MainCafeList_fragment newInstance() {
        return new MainCafeList_fragment();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(this.getActivity());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(37.584783, 126.925187), 15);
        googleMap.animateCamera(cameraUpdate);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.585232, 126.923075)).title("또바기").snippet("서울 서대문구 명지대길 108"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.581415, 126.926203)).title("달콤충전소").snippet("서울 서대문구 거북골로 6"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.580897, 126.925141)).title("하우디").snippet("서울 서대문구 명지대길 10 2층"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.579601, 126.924134)).title("퐁신 수플레").snippet("서울 서대문구 거북골로 31-1"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.577736, 126.924150)).title("시차").snippet("서울 서대문구 증가로 10길 16-20"));
    }

    @Override
    public void onResume() {
        mapViewMore.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapViewMore.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapViewMore.onLowMemory();
    }
}
