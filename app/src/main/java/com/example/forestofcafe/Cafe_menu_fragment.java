package com.example.forestofcafe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cafe_menu_fragment extends Fragment {
    Context context;
    View v;

    RecyclerView menu_recyclerview;
    RecyclerView.LayoutManager layoutManager;
    Cafe_menu_Adapter adapter;
    private ArrayList<Cafe_menu_Item> data = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        menu_recyclerview = getActivity().findViewById(R.id.menu_listview);
        layoutManager = new LinearLayoutManager(context);
        menu_recyclerview.setLayoutManager(layoutManager);
        adapter = new Cafe_menu_Adapter(data);
        menu_recyclerview.setAdapter(adapter);
        data.clear();
        adapter.notifyDataSetChanged();

        addsubcommitem(getResources().getDrawable(R.drawable.coffee1),"아메리카노", "ICE: 3000\nHOT:2500");
        addsubcommitem(getResources().getDrawable(R.drawable.coffee2),"비엔나 커피", "ICE:5000\nHOT:4500");
        addsubcommitem(getResources().getDrawable(R.drawable.coffee3),"카페라떼", "4000");


        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new SubCommunity_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //((MainActivity) context).replaceFragment(Community_post_fragment.newInstance(), null);
                Toast.makeText(context, position + "번 메뉴", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addsubcommitem(Drawable img, String name, String price) {
        Cafe_menu_Item item = new Cafe_menu_Item();

        item.setMenu_img(img);
        item.setMenu_name(name);
        item.setMenu_price(price);

        data.add(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cafe_menu, container, false);
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

    public static Cafe_menu_fragment newInstance() {
        return new Cafe_menu_fragment();
    }
}
