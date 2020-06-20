package com.example.forestofcafe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
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

public class Cafe_infomation_fragment extends Fragment implements OnMapReadyCallback {
    Context context;

    MapView info_mapview;
    Integer key = 1;
    TextView more;
    ConstraintLayout more_layout;
    View v;
    ImageView main_img, sub_img1, sub_img2, sub_img3;
    TextView info_name, info_score, info_review_num, info_distance, info_address, info_hashtag, info_standard_infomation, info_openclose, info_notice, info_more_infomation, info_menu, info_write_review;

    RecyclerView info_comm_recyclerview;
    RecyclerView.LayoutManager layoutManager;
    SubCommunity_Adapter Adapter;
    private ArrayList<SubCommunity_Item> data = new ArrayList<SubCommunity_Item>();
    NestedScrollView sv_main;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        info_mapview = getActivity().findViewById(R.id.info_map);
        info_mapview.onCreate(savedInstanceState);
        info_mapview.getMapAsync(this);

        sv_main = getActivity().findViewById(R.id.sv_main);

        info_comm_recyclerview = getActivity().findViewById(R.id.info_comm_recyclerView);
        layoutManager = new LinearLayoutManager(context);
        info_comm_recyclerview.setLayoutManager(layoutManager);
        Adapter = new SubCommunity_Adapter(data);
        info_comm_recyclerview.setAdapter(Adapter);
        data.clear();
        Adapter.notifyDataSetChanged();

        main_img = getActivity().findViewById(R.id.imgMain);
        sub_img1 = getActivity().findViewById(R.id.img1);
        sub_img2 = getActivity().findViewById(R.id.img2);
        sub_img3 = getActivity().findViewById(R.id.img3);
        info_name = getActivity().findViewById(R.id.info_cafe_name);
        info_score = getActivity().findViewById(R.id.info_score);
        info_review_num = getActivity().findViewById(R.id.into_review_num);
        info_distance = getActivity().findViewById(R.id.info_distance);
        info_address = getActivity().findViewById(R.id.info_cafe_address);
        info_hashtag = getActivity().findViewById(R.id.info_hashtag);
        info_standard_infomation = getActivity().findViewById(R.id.info_tv_standard_info);
        info_openclose = getActivity().findViewById(R.id.info_open_close);
        info_notice = getActivity().findViewById(R.id.info_tv_notice);
        info_more_infomation = getActivity().findViewById(R.id.info_tv_moreinfo);
        info_menu = getActivity().findViewById(R.id.info_menuinfomation);
        info_write_review = getActivity().findViewById(R.id.info_write_review);

        main_img.setImageResource(R.drawable.cafe_ttobagi_1);
        sub_img1.setImageResource(R.drawable.cafe_ttobagi_2);
        sub_img2.setImageResource(R.drawable.cafe_ttobagi_3);
        sub_img3.setImageResource(R.drawable.cafe_ttobagi_4);
        info_name.setText("또바기");
        info_score.setText("4.7");
        info_review_num.setText("45개의 평가");
        info_distance.setText("180m");
        info_address.setText("서울 서대문구 명지대길 108");
        info_hashtag.setText("#디저트 #와플 #분위기 좋은");
        info_standard_infomation.setText("운영시간: 월 ~ 금(오전 10:00분 ~ 오후 22:00분 까지)\n전화번호: 010-7600-2602");
        info_openclose.setText("운영중");
        info_notice.setText("7월12일부터 14일까지 휴가로 인해 휴점합니다!");
        info_more_infomation.setText("좌석수: 보통\n콘센트 수: 보통\n노키즈존: X\n주차공간: X\n반려동물 출입: X\n야외 테라스: X\nWi-Fi: O");


        more = getActivity().findViewById(R.id.info_more);
        more_layout = getActivity().findViewById(R.id.info_layout2);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(key == 1){
                    more_layout.setVisibility(View.VISIBLE);
                    more.setText("더보기▲");
                    key = 2;
                }
                else{
                    more_layout.setVisibility(View.GONE);
                    more.setText("더보기▼");
                    key = 1;
                }
            }
        });

        info_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).replaceFragment(Cafe_menu_fragment.newInstance(), null);
                Toast.makeText(context, "메뉴판으로 이동", Toast.LENGTH_SHORT).show();
            }
        });

        info_write_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).replaceFragment(Community_review_write_fragment.newInstance(), null);
                Toast.makeText(context, "글작성화면으로 이동", Toast.LENGTH_SHORT).show();
            }
        });

        addsubcommitem(getResources().getDrawable(R.drawable.review1), getResources().getDrawable(R.drawable.ic_profile), "김준희", "또바기", "서울 서대문구 명지대길 108", "분위기 진짜 대박이에요ㅋㅋㅋ 한번 와보세요", "7", "11", (float) 4.7);
        addsubcommitem(getResources().getDrawable(R.drawable.review2), getResources().getDrawable(R.drawable.ic_profile), "블거지", "또바기", "서울 서대문구 명지대길 108", "제가찾던 카페가 여기있었네요~", "6", "14", (float) 4.5);
        addsubcommitem(getResources().getDrawable(R.drawable.review3), getResources().getDrawable(R.drawable.ic_profile), "커피중독자", "또바기", "서울 서대문구 명지대길 108", "분위기때문이라도 와볼만하네요. 신기한 커피도 많고 맛도 나쁘지 않아요", "11", "17", (float) 4.0);

        Adapter.notifyDataSetChanged();
        Adapter.setOnItemClickListener(new SubCommunity_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ((MainActivity) context).replaceFragment(Community_post_fragment.newInstance(), null);
                sv_main.scrollTo(0,0);
                Toast.makeText(context, position + "번", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addsubcommitem(Drawable cafe_img, Drawable writer_profile, String writer_name, String cafe_name, String cafe_address, String review, String comment_num, String like_num, Float star_num) {
        SubCommunity_Item item = new SubCommunity_Item();

        item.setCafe_Img(cafe_img);
        item.setWriter_Profile(writer_profile);
        item.setWriter_Id(writer_name);
        item.setCafe_Name(cafe_name);
        item.setCafe_Address(cafe_address);
        item.setReview(review);
        item.setComment_Num(comment_num);
        item.setLike_Num(like_num);
        item.setStar_num(star_num);

        data.add(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cafe_infomation, container, false);
    }

    public void onDestroyView() { // 화면에서 사라질때 프래그먼트의 뷰 삭제
        super.onDestroyView();
        if (v != null) {
            ViewGroup parent = (ViewGroup) v.getParent();
            if (parent != null) {
                parent.removeView(v);
            }
        }
    }

    public static Cafe_infomation_fragment newInstance() {
        return new Cafe_infomation_fragment();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(this.getActivity());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(37.590624, 126.920749), 15);
        googleMap.animateCamera(cameraUpdate);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(37.590624, 126.920749)).title("카페 빛").snippet("서울 은평구 응암로 14길 26-1"));
    }

    @Override
    public void onResume() {
        info_mapview.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        info_mapview.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        info_mapview.onLowMemory();
    }

}
