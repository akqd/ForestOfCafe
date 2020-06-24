package com.example.forestofcafe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Setting_version_fragment extends Fragment {
    Context context;
    View v;

    TextView tv_version;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_app_version, container, false);
        return v;

    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        context = getActivity();

        tv_version = getActivity().findViewById(R.id.tv_version);

        tv_version.setText("현재버전 : 1.0.1\n\n최신버전입니다.");

    }

    public static Setting_version_fragment newInstance() {
        return new Setting_version_fragment();
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
