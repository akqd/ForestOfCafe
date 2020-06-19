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

public class Profile_Edit_Region_fragment extends Fragment {
    Context context;
    View v ;
    Button btn_region_ok;
    EditText edt_region,edt_region_detail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_edit_profile_region, container, false); // 레이아웃 반환해서 띄웁니다!
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        btn_region_ok = getActivity().findViewById(R.id.btn_edit_region_ok);
        edt_region = getActivity().findViewById(R.id.etd_edit_region);
        edt_region_detail = getActivity().findViewById(R.id.etd_edit_region);
        btn_region_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).replaceFragment(Profile_Edit_Complete_fragment.newInstance(),null);
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

    public static Profile_Edit_Region_fragment newInstance() {
        return new Profile_Edit_Region_fragment();
    }
}


