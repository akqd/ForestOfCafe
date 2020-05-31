package com.example.forestofcafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Profile_fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    /* 나중에 사용할 것들
      public Profile_fragment() {
           // Required empty public constructor
       }
       public static Profile_fragment newInstance(String param1, String param2) {
           Profile_fragment fragment = new Profile_fragment();
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
        return inflater.inflate(R.layout.fragment_menu_profile,container,false); // 레이아웃 반환해서 띄웁니다!
    }
}
