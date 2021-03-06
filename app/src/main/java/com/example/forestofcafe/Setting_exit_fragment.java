package com.example.forestofcafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Setting_exit_fragment extends Fragment {

    TextView tv;
    boolean btn_point;
    Button btn;
    Context context;
    View v;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            v = inflater.inflate(R.layout.fragment_setting_exit, container, false);
            return v;
        }
        @Override
        public void onActivityCreated (@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            context = getActivity();

            btn_point = true;
            tv = getActivity().findViewById(R.id.tv_exit);
            btn = getActivity().findViewById(R.id.btn_exit);

            tv.setText("탈퇴를 하면 기존 정보가\n사라집니다.\n\n탈퇴하시겠습니까?");
            btn.setText("탈퇴");


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (btn_point) {
                        tv.setText("탈퇴되었습니다.\n\n이용해주셔서\n감사합니다");
                        btn.setText("시작화면으로");
                        btn_point = false;
                    } else {
                        Intent intent = new Intent(context, StartActivity.class);
                        startActivity(intent);
                    }
                }

            });
        }

        public static Setting_exit_fragment newInstance() {
            return new Setting_exit_fragment();
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
