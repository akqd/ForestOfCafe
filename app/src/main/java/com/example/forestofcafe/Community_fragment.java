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

        addsubcommitem(getResources().getDrawable(R.drawable.cafe_ttobagi_1), getResources().getDrawable(R.drawable.ic_profile), "커피돌이", "또바기", "서울 서대문구 명지대길 108", "고급스럽고 분위기있는 카페였어요. 메뉴도 많고 사장님이 친절해서 좋았어요! 커피도 맛있었고 디저트도 맛있었어요~", "7", "11", (float) 4.7);
        addsubcommitem(getResources().getDrawable(R.drawable.cafe_thelight_1), getResources().getDrawable(R.drawable.ic_profile), "김준희", "카페 빛", "서울 은평구 응암로 14길 26-1", "지나가다 쉴겸 잠깐 들어왔는데 분위기 완전 좋아요~", "6", "14", (float) 4.5);
        addsubcommitem(getResources().getDrawable(R.drawable.cafe_timedifference_1), getResources().getDrawable(R.drawable.ic_profile), "커피중독자", "카페 시차", "서울 서대문구 증가로 10길 16-20", "사장님이 친절했고 커피향이 좋네요. 디저트는 안먹어봤는데 종류도 많아요.", "11", "17", (float) 4.0);

        scAdapter.notifyDataSetChanged();
        scAdapter.setOnItemClickListener(new SubCommunity_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ((MainActivity) context).replaceFragment(Community_post_fragment.newInstance(), null);
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

        scdata.add(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_community, container, false);
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

    public static Community_fragment newInstance() {
        return new Community_fragment();
    }
}
