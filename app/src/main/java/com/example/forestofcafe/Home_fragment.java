package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

/*    public Home_fragment() {
        // Required empty public constructor
    }

    public static Home_fragment newInstance(String param1, String param2) {
        Home_fragment fragment = new Home_fragment();
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
        View v = inflater.inflate(R.layout.fragment_menu_home, container, false);
        context = getActivity();
        recyclerView = v.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        String[] Cafe_name = {"카페이름1", "카페이름2","카페이름3","카페이름1", "카페이름2", "카페이름3"};
        String[] Cafe_distance = {"500m", "1km", "1.5km","500m", "1km", "1.5km"};
        String[] Cafe_openclose = {"CLOSE", "OPEN", "OPEN","CLOSE", "OPEN", "OPEN"};
        Integer[] Cafe_images = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
        adapter = new  com.example.forestofcafe.MainAdapter(Cafe_name, Cafe_distance, Cafe_openclose, Cafe_images);
        recyclerView.setAdapter(adapter);


        return v;
    }
}
