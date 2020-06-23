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

        addsubcommitem(getResources().getDrawable(R.drawable.ttobagi_menu_chococream),"★초코크림", "₩5,500");
        addsubcommitem(getResources().getDrawable(R.drawable.ttobagi_menu_creamamericano),"크림아메리카노", "₩4,500");
        addsubcommitem(getResources().getDrawable(R.drawable.ttobagi_menu_darkchococake),"꾸덕 다크초코", "₩4,000");
        addsubcommitem(getResources().getDrawable(R.drawable.ttobagi_menu_earlgrey),"얼그레이", "₩5,500");
        addsubcommitem(getResources().getDrawable(R.drawable.ttobagi_menu_lemonade),"레모네이드", "₩4,000");
        addsubcommitem(getResources().getDrawable(R.drawable.coffee1),"아메리카노", "ICE: ₩4,000 \n\nHOT: ₩3,500");


        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new SubCommunity_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //((MainActivity) context).replaceFragment(Community_post_fragment.newInstance(), null);
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
