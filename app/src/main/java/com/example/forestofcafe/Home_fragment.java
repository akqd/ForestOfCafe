package com.example.forestofcafe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class Home_fragment extends Fragment implements OnMapReadyCallback {
    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View v;
    TextView tvCafeListMore, tvFavoriteCafeMore, comm_more;
    RecyclerView rv_MainCafeList, comm_recyclerView, fv_recyclerView;
    RecyclerView.LayoutManager layoutManager , fv_layoutManeger, comm_layoutManager;
    MainCafeList_Adapter mAdapter;
    private ArrayList<MainCafeList_Item> mData = new ArrayList<MainCafeList_Item>();
    MainFavorite_Adapter fAdapter;
    private  ArrayList<MainFavorite_Item> fData = new ArrayList<MainFavorite_Item>();
    MainCommunity_Adapter cAdapter;
    private ArrayList<MainCommunity_Item> cData = new ArrayList<MainCommunity_Item>();
    BottomNavigationView bottomNavigationView;
    MapView mapView;
    NestedScrollView sv_main;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        sv_main = getActivity().findViewById(R.id.sv_main);
        mapView = v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync((OnMapReadyCallback) this);
        bottomNavigationView = getActivity().findViewById(R.id.navigation_bottom);
        tvCafeListMore = getActivity().findViewById(R.id.tvMore);
        rv_MainCafeList = getActivity().findViewById(R.id.rv_MainCafeList);
        layoutManager = new LinearLayoutManager(context);
        rv_MainCafeList.setLayoutManager(layoutManager);
        mAdapter = new MainCafeList_Adapter(mData);
        rv_MainCafeList.setAdapter(mAdapter);
        mData.clear();
        mAdapter.notifyDataSetChanged();
        tvCafeListMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).sv_main.scrollTo(0,0);
                ((MainActivity) context).replaceFragment(MainCafeList_fragment.newInstance(), null);
            }
        });
        addCafeListItem("또바기", "180m", "OPEN", getResources().getDrawable(R.drawable.cafe_ttobagi_1, null));
        addCafeListItem("달콤충전소", "390m", "CLOSE", getResources().getDrawable(R.drawable.cafe_sweatfilling_1, null));
        addCafeListItem("하우디", "430m", "OPEN", getResources().getDrawable(R.drawable.cafe_howdy_1, null));
        mAdapter.notifyDataSetChanged();

        mAdapter.setOnItemClickListener(new MainCafeList_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ((MainActivity) context).replaceFragment(Cafe_infomation_fragment.newInstance(), null);
                sv_main.scrollTo(0,0);
                Toast.makeText(context, "카페 상세화면으로 이동", Toast.LENGTH_SHORT).show();
            }
        });

        //메인 화면 - 즐겨찾는 카페 리스트
        fv_recyclerView = getActivity().findViewById(R.id.fv_recyclerView);
        fv_layoutManeger = new LinearLayoutManager(context);
        fv_recyclerView.setLayoutManager(fv_layoutManeger);
        fAdapter = new MainFavorite_Adapter(fData);
        fv_recyclerView.setAdapter(fAdapter);
        fData.clear();
        fAdapter.notifyDataSetChanged();
        tvFavoriteCafeMore = getActivity().findViewById(R.id.fv_more);

        addMainFavorite(getResources().getDrawable(R.drawable.cafe_thelight_1,null),"카페 빛","오늘은 정상 영업 합니다.","OPEN");
        addMainFavorite(getResources().getDrawable(R.drawable.cafe_timedifference_1,null),"카페 시차","오늘은 오후부터 영업 시작합니다.","CLOSE");
        addMainFavorite(getResources().getDrawable(R.drawable.cafe_ttobagi_1,null),"또바기","오늘은 영업 쉽니다.","CLOSE");

        fAdapter.notifyDataSetChanged();

        fAdapter.setOnItemClickListener(new MainFavorite_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                ((MainActivity) context).replaceFragment(Cafe_infomation_fragment.newInstance(), null);
                sv_main.scrollTo(0,0);
                Toast.makeText(context, "카페 상세화면으로 이동", Toast.LENGTH_SHORT).show();
            }
        });

        tvFavoriteCafeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.setSelectedItemId(R.id.bottom_favorite);
            }
        });

        //메인커뮤니티화면에 대한 코드 추가(김준희)
        comm_recyclerView = getActivity().findViewById(R.id.comm_recyclerView);
        comm_layoutManager = new LinearLayoutManager(context);
        comm_recyclerView.setLayoutManager(comm_layoutManager);
        cAdapter = new MainCommunity_Adapter(cData);
        comm_recyclerView.setAdapter(cAdapter);
        cData.clear();
        cAdapter.notifyDataSetChanged();
        comm_more = getActivity().findViewById(R.id.comm_more);

        addMainCommunity(getResources().getDrawable(R.drawable.ic_profile,null), getResources().getDrawable(R.drawable.cafe_ttobagi_1,null), "카페돌이", "또바기", "7", "13", "5", "고급스럽고 분위기있는 카페였어요. 메뉴도 많고 사장님이 친절해서 좋았어요! 커피도 맛있었고 디저트도 맛있었어요~");
        addMainCommunity(getResources().getDrawable(R.drawable.ic_profile,null), getResources().getDrawable(R.drawable.cafe_thelight_1,null), "김준희", "카페 빛", "6", "13", "4.5", "지나가다 쉴겸 잠깐 들어왔는데 분위기 완전 좋네요.");
        addMainCommunity(getResources().getDrawable(R.drawable.ic_profile,null), getResources().getDrawable(R.drawable.cafe_timedifference_1,null), "커피중독자", "카페 시차", "11", "13", "4", "사장님이 친절했고 커피향이 좋네요. 디저트는 안먹어봤는데 종류도 많아요.");

        comm_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.setSelectedItemId(R.id.bottom_community);
            }
        });

        cAdapter.notifyDataSetChanged();
        cAdapter.setOnItemClickListener(new MainCommunity_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ((MainActivity) context).replaceFragment(Community_post_fragment.newInstance(), null);
                sv_main.scrollTo(0,0);
                Toast.makeText(context, "작성글 자세히보기로 이동", Toast.LENGTH_SHORT).show();
            }
        });
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

    public void addMainCommunity(Drawable profile, Drawable cafe_image, String id, String cafe_name , String comment_num, String like_num, String score, String review) {
        MainCommunity_Item item = new MainCommunity_Item();

        item.setProfile(profile);
        item.setCafe_Img(cafe_image);
        item.setId(id);
        item.setCafe_Name(cafe_name);
        item.setComment_Num(comment_num);
        item.setLike_Num(like_num);
        item.setScore(score);
        item.setReview(review);

        cData.add(item);
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
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
