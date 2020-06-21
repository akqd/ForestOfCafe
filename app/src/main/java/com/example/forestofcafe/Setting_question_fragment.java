package com.example.forestofcafe;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class Setting_question_fragment extends Fragment {
    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
        View v;

        ArrayList<String> arrayList;
        ListView listV;


public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_setting_question, container, false);
        return v;

        }

@Override
public void onActivityCreated (@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        listV = getActivity().findViewById(R.id.listv_question);

        arrayList = new ArrayList<>();
        arrayList.add("문의하기");
        arrayList.add("내 문의사항 보기");
        ArrayAdapter Adapter = new ArrayAdapter<String>(getActivity(),simple_list_item_1,arrayList){


            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);
                TextView tv = view.findViewById(android.R.id.text1);
                tv.setTextColor(getResources().getColor(R.color.colorBrown));
                return view;
            }
        };
        listV.setAdapter(Adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        ((MainActivity) context).replaceFragment(Setting_question_write_fragment.newInstance(), null);
                        break;
                    }
                    case 1: {
                        ((MainActivity) context).replaceFragment(Setting_MyQuestion_fragment.newInstance(), null);

                        break;
                    }
                }
            }
        });
     }

public static Setting_question_fragment newInstance() {
        return new Setting_question_fragment();
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
