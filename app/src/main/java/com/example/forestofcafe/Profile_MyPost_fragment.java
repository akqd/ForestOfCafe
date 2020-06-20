package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Profile_MyPost_fragment extends Fragment {
    Context context;
    View v ;
    RecyclerView rv_MyPost;
    ArrayList<Profile_MyPost_Item> pData = new ArrayList<Profile_MyPost_Item>();
    Profile_MyPost_Adapter pAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_profile_mypost, container, false); // 레이아웃 반환해서 띄웁니다!
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        rv_MyPost = getActivity().findViewById(R.id.rv_MyPost);
        pAdapter = new Profile_MyPost_Adapter(pData);
        rv_MyPost.setAdapter(pAdapter);
        rv_MyPost.setLayoutManager(new LinearLayoutManager(context));
        addItem("카페의 숲","서울시 마포구 성산동","빵이 참 맛있네요","21","14","2020-06-19 (11:28)",R.drawable.cafe_image);
        pAdapter.notifyDataSetChanged();
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
    public static Profile_MyPost_fragment newInstance() {
        return new Profile_MyPost_fragment();
    }
    public void addItem(String cafeName,String cafeLocation,String cafeContent,String commentCount,String favoriteCount,String writeTime,int cafePost){
        Profile_MyPost_Item item = new Profile_MyPost_Item();
        item.setCafeName(cafeName);
        item.setCafeLocation(cafeLocation);
        item.setCafeContent(cafeContent);
        item.setCommentCount(commentCount);
        item.setFavoriteCount(favoriteCount);
        item.setWriteTime(writeTime);
        item.setCafePost(cafePost);
        pData.add(item);
    }
}