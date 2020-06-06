package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.concurrent.TimeoutException;


public class Home_fragment extends Fragment {
    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    View v;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        recyclerView = getActivity().findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        String[] Cafe_name = {"카페이름1", "카페이름2","카페이름3","카페이름1", "카페이름2", "카페이름3"};
        String[] Cafe_distance = {"500m", "1km", "1.5km","500m", "1km", "1.5km"};
        String[] Cafe_openclose = {"CLOSE", "OPEN", "OPEN","CLOSE", "OPEN", "OPEN"};
        Integer[] Cafe_images = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
        adapter = new com.example.forestofcafe.MainAdapter(Cafe_name, Cafe_distance, Cafe_openclose, Cafe_images);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            v = inflater.inflate(R.layout.fragment_menu_home, container, false);
        }catch(InflateException e){ // 구글 Map fragment inflate 에러 무시
        }
        return v;
    }

    @Override
    public void onDestroyView() { // 화면에서 라라질때 프래그먼트의 뷰 삭제
        super.onDestroyView();
        if(v != null){
            ViewGroup parent = (ViewGroup) v.getParent();
            if(parent!= null){
                parent.removeView(v);
            }
        }
    }
}
