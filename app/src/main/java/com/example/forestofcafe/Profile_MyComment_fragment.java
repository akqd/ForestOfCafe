package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Profile_MyComment_fragment extends Fragment {
    Context context;
    View v ;
    RecyclerView rv_MyComment;
    ArrayList<Profile_MyComment_Item> pData = new ArrayList<Profile_MyComment_Item>();
    Profile_MyComment_Adapter pAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_profile_mycomment, container, false); // 레이아웃 반환해서 띄웁니다!
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        rv_MyComment = getActivity().findViewById(R.id.rv_MyComment);
        pAdapter = new Profile_MyComment_Adapter(pData);
        rv_MyComment.setAdapter(pAdapter);
        rv_MyComment.setLayoutManager(new LinearLayoutManager(context));
        pData.clear();
        addItem("카페돌이","또바기","서울시 서대문구 홍은동","고급스럽고 분위기있는 카페였어요","항상 좋은 게시물 감사합니다","2020-05-11 (12:50:30)",R.drawable.cafe_ttobagi_1);
        pAdapter.notifyDataSetChanged();
        pAdapter.setOnItemClickListener(new Profile_MyComment_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int postion) {
                ((MainActivity)context).replaceFragment(Community_post_fragment.newInstance(),null);
            }
        });
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
    @Override
    public void onStop() {
        super.onStop();
    }
    public static Profile_MyComment_fragment newInstance() {
        return new Profile_MyComment_fragment();
    }
    public void addItem(String postWriter,String cafeName,String cafeLocation,String communityContent,String comentCotent,String comentWriteTime,int img_post){
        Profile_MyComment_Item item = new Profile_MyComment_Item();
        item.setPostWriter(postWriter);
        item.setCafeName(cafeName);
        item.setCafeLocation(cafeLocation);
        item.setCommunityContent(communityContent);
        item.setComentCotent(comentCotent);
        item.setComentWriteTime(comentWriteTime);
        item.setImg_post(img_post);
        pData.add(item);
    }
}

