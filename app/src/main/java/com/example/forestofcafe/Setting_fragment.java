package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Setting_fragment extends Fragment {

    Button btn_modify;
    View v;
    Context context;
    ListView listv_setting_menu;
    ArrayList<SettingListView_Item> sList = new ArrayList<SettingListView_Item>();
    SettingListView_Adapter sAdapter = null;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        context = getActivity();
        sAdapter = new SettingListView_Adapter(sList,context);
        listv_setting_menu = getActivity().findViewById(R.id.listv_setting);
        listv_setting_menu.setAdapter(sAdapter);
        sList.clear();
        sAdapter.notifyDataSetChanged();
        addItem(R.drawable.ic_notice,"공지사항");
        addItem(R.drawable.ic_question,"1:1문의");
        addItem(R.drawable.ic_version,"앱 버전");
        addItem(R.drawable.ic_exit,"회원탈퇴");
        sAdapter.notifyDataSetChanged();


        btn_modify = getActivity().findViewById(R.id.btnModify);

        btn_modify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(Profile_Edit_fragment.newInstance(),null);

            }
        } );
            listv_setting_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0 : {
                            ((MainActivity)getActivity()).replaceFragment(Setting_notice_fragment.newInstance(),null);

                            break;
                        }
                        case 1 :  {
                            ((MainActivity)getActivity()).replaceFragment(Setting_question_fragment.newInstance(),null);

                            break;
                        }
                        case 2 :  {
                            ((MainActivity)getActivity()).replaceFragment(Setting_version_fragment.newInstance(),null);

                            break;
                        }
                        case 3 :  {
                            ((MainActivity)getActivity()).replaceFragment(Setting_exit_fragment.newInstance(),null);
                            break;
                        }
                    }
                }
            });
        }
        public void addItem(int menu_icon, String menu_str) {
            SettingListView_Item item = new SettingListView_Item();
            item.setMenu_icon(menu_icon);
            item.setMenu_str(menu_str);
            sList.add(item);
        }

        @Override
        public void onStop() {
            super.onStop();
        }
        @Override
        public void onResume() {
            super.onResume();
        }

    public void onDestroyView() {
        super.onDestroyView();
        if (v != null) {
            ViewGroup parent = (ViewGroup) v.getParent();
            if (parent != null) {
                parent.removeView(v);
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_setting, container, false);

    }
}
