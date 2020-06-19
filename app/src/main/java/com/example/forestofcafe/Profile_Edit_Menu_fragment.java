package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Profile_Edit_Menu_fragment extends Fragment {
    Context context;
    View v ;
    Button btn_edit_pw,btn_edit_call,btn_edit_region,btn_edit_email;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_edit_profile_menu, container, false); // 레이아웃 반환해서 띄웁니다!
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        btn_edit_pw = getActivity().findViewById(R.id.btn_edit_pw);
        btn_edit_email = getActivity().findViewById(R.id.btn_edit_email);
        btn_edit_call = getActivity().findViewById(R.id.btn_edit_call);
        btn_edit_region = getActivity().findViewById(R.id.btn_edit_region);
        btn_edit_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).replaceFragment(Profile_Edit_Password_fragment.newInstance(),null);
            }
        });
        btn_edit_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).replaceFragment(Profile_Edit_Email_fragment.newInstance(),null);
            }
        });
        btn_edit_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).replaceFragment(Profile_Edit_Call_fragment.newInstance(),null);
            }
        });
        btn_edit_region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).replaceFragment(Profile_Edit_Region_fragment.newInstance(),null);
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

    public static Profile_Edit_Menu_fragment newInstance() {
        return new Profile_Edit_Menu_fragment();
    }
}
