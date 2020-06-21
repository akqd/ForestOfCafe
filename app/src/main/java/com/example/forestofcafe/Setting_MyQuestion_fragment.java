package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Setting_MyQuestion_fragment extends Fragment {


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
        v = inflater.inflate(R.layout.fragment_setting_myquestion, container, false);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
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
            listGroup.add("업데이트가 너무 느려요");
            listGroup.add("오류가 너무 많아요");

            List<String> list = new ArrayList<>();

            list.add("앱 업데이트가 너무 느립니다. 업데이트를 하는 주기가 있는건가요?");
            list.add("카페의 숲을 이용해주셔서 감사합니다. 카페의 숲은 카페 정보가 일정량 이상 추가되면 일괄적으로 업데이트를 하고 있습니다.");
            listItem.put(listGroup.get(0),list);


            List<String> list2 = new ArrayList<>();

            list2.add("어플에 오류가 너무 많아서 짜증이 나요");
            list2.add("안녕하세요 00님. 정확한 오류 판단을 위해 00님께서 발견하신 오류를 1:1 문의 게시판에 상세하게 적어주시면 감사하겠습니다.");
            listItem.put(listGroup.get(1),list2);

            adapter.notifyDataSetChanged();
        }


    public static Setting_MyQuestion_fragment newInstance() {
        return new Setting_MyQuestion_fragment();
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

