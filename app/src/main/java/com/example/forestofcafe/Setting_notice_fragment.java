package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static android.R.layout.simple_list_item_1;

public class Setting_notice_fragment extends Fragment {

    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    Expendable_List_Adapter adapter;

    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View v;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_setting_notice, container, false);
        return v;

    }

        @Override
        public void onActivityCreated (@Nullable Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);

            context = getActivity();
            expandableListView = getActivity().findViewById(R.id.expandableListView);
            listGroup = new ArrayList<>();
            listItem = new HashMap<>();
            adapter = new Expendable_List_Adapter(context, listGroup, listItem);
            expandableListView.setAdapter(adapter);
            initListData();

        }
    private void initListData(){
        listGroup.add("카페의 숲에 북가좌동 정보가 추가되었습니다.");
        listGroup.add("카페의 숲을 이용해주셔서 감사합니다.");


        listItem.put(listGroup.get(0), Collections.singletonList("많은분들의 기다림 끝에 드디어 북가좌동에 위치한 카페들의 정보가 업데이트 되었습니다."));
        listItem.put(listGroup.get(1), Collections.singletonList("당신 주변의 카페를 찾아드립니다! 안녕하세요. 카페의 숲이 드디어 정식으로 출시되었습니다! 앞으로 카페의 숲에서 많은 카페들을 만나보세요!"));

        adapter.notifyDataSetChanged();
        }

    public static Setting_notice_fragment newInstance() {
        return new Setting_notice_fragment();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    }

