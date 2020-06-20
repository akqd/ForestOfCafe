package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class Setting_notice_fragment extends Fragment {

    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View v;

    ArrayList<String> notice_list;
    ListView listV;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_setting_notice, container, false);
        return v;

    }

        @Override
        public void onActivityCreated (@Nullable Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);
            context = getActivity();
            listV = getActivity().findViewById(R.id.listv_notice);

            notice_list = new ArrayList<>();
            notice_list.add("새로운 업데이트 사항이 있습니다.");
            notice_list.add("카페의 숲에 북가좌동 카페가 업데이트 되었습니다.");
            notice_list.add("카페의 숲을 이용해주셔서 감사합니다.");

            ArrayAdapter Adapter = new ArrayAdapter<String>(getActivity(), simple_list_item_1,notice_list);
            listV.setAdapter(Adapter);


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

