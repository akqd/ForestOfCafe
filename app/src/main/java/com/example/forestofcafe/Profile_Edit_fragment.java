package com.example.forestofcafe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Profile_Edit_fragment extends Fragment {
    Context context;
    View v ;
    Button btn_ok;
    EditText edt_pw;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_edit_profile, container, false); // 레이아웃 반환해서 띄웁니다!
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        btn_ok = getActivity().findViewById(R.id.btn_ok);
        edt_pw = getActivity().findViewById(R.id.edt_pw);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).replaceFragment(Profile_Edit_fragment.newInstance());
            }
        });
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
    }

    public static Profile_Edit_fragment newInstance() {
        return new Profile_Edit_fragment();
    }
}

