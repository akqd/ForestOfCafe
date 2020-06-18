package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Profile_fragment extends Fragment {
    Context context;
    ListView listv_profile_menu;
    ArrayList<ProfileListView_Item> pList = new ArrayList<ProfileListView_Item>();
    View v ;
    ProfileListView_Adapter pAdapter = null;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_menu_profile, container, false); // 레이아웃 반환해서 띄웁니다!
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        addItem(R.drawable.ic_heart,"즐겨찾기 한 카페");
        addItem(R.drawable.ic_pencil,"내가 쓴 글");
        addItem(R.drawable.ic_comment,"댓글 단 글");
        addItem(R.drawable.ic_bottom_profile,"회원 정보 수정");
        addItem(R.drawable.ic_exit,"로그아웃");
        listv_profile_menu = getActivity().findViewById(R.id.listv_profile_menu);
        pAdapter = new ProfileListView_Adapter(pList,context);
        listv_profile_menu.setAdapter(pAdapter);
        pAdapter.notifyDataSetChanged();
        listv_profile_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 : {
                        ((MainActivity)context).replaceFragment(Favorite_fragment.newInstance());
                        BottomNavigationView btm = ((MainActivity)context).findViewById(R.id.navigation_bottom);
                        btm.setSelectedItemId(R.id.bottom_favorite);
                        break;
                    }
                    case 1 :  {
                        break;
                    }
                    case 2 :  {
                        break;
                    }
                    case 3 :  {
                        break;
                    }
                    case 4 :  {
                        break;
                    }
                }
            }
        });
    }

    
    public void addItem(int menu_icon, String menu_str) {
        ProfileListView_Item item = new ProfileListView_Item();
        item.setMenu_icon(menu_icon);
        item.setMenu_str(menu_str);
        pList.add(item);
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
    @Override
    public void onStop() {
        super.onStop();
        pList.clear();
        pAdapter.notifyDataSetChanged();
    }

}
