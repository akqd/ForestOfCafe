package com.example.forestofcafe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Community_fragment extends Fragment {

    Context context;
    RatingBar rb;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View v;

    RecyclerView subcomm_recyclerview;
    RecyclerView.LayoutManager layoutManager;
    SubCommunity_Adapter scAdapter;
    private ArrayList<SubCommunity_Item> scdata = new ArrayList<SubCommunity_Item>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        subcomm_recyclerview = getActivity().findViewById(R.id.sub_comm_recyclerView);
        layoutManager = new LinearLayoutManager(context);
        subcomm_recyclerview.setLayoutManager(layoutManager);
        scAdapter = new SubCommunity_Adapter(scdata);
        subcomm_recyclerview.setAdapter(scAdapter);
        scdata.clear();
        scAdapter.notifyDataSetChanged();

        addsubcommitem(getResources().getDrawable(R.drawable.cafe1), getResources().getDrawable(R.drawable.ic_profile),"김준희", "Be, Bridge", "강원도 영월군 김삿갓면 주문리 6-1", "카페가 넓고 엄청 고급지게 생겼어요. 거리가 멀다는게 좀 흠", "7", "11", (float) 4.7);
        addsubcommitem(getResources().getDrawable(R.drawable.cafe2), getResources().getDrawable(R.drawable.ic_profile),"커피돌이", "Cafe청담", "서울특별시 청담동 선릉로 162길 51", "정동극장 기다리다 잠깐 들어왔는데 분위기 완전 좋아요~", "6", "14", (float) 4.5);
        addsubcommitem(getResources().getDrawable(R.drawable.cafe3), getResources().getDrawable(R.drawable.ic_profile),"커피중독자", "PS카페", "서울특별시 신사동 도산대로 49길", "싱가포르 분위기 카페라고해서 와봤어요~ 이국적인 분위기가 엄청 좋네요", "11", "17", (float) 4.0);

        scAdapter.notifyDataSetChanged();
        scAdapter.setOnItemClickListener(new SubCommunity_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ((MainActivity)context).replaceFragment(Community_post_fragment.newInstance(),null);
                Toast.makeText(context, position+"번", Toast.LENGTH_SHORT).show();
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

        scdata.add(item);
    }

    /*    public Community_fragment() {
        // Required empty public constructor
    }

    public static Community_fragment newInstance(String param1, String param2) {
        Community_fragment fragment = new Community_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_community,container,false);
    }


    public void onDestroyView() { // 화면에서 라라질때 프래그먼트의 뷰 삭제
        super.onDestroyView();
        if (v != null) {
            ViewGroup parent = (ViewGroup) v.getParent();
            if (parent != null) {
                parent.removeView(v);
            }
        }
    }

    public static Community_fragment newInstance(){
        return new Community_fragment();
    }
}
