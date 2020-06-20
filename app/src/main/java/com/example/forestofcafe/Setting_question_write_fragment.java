package com.example.forestofcafe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class Setting_question_write_fragment  extends Fragment {

    Context context;
    Button addBtn;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    View v;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_setting_question_write, container, false);
        return v;

    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        addBtn = getActivity().findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                dlg.setTitle("알림");
                dlg.setMessage("문의사항을 등록하시겠습니까?");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "문의사항이 등록되었습니다.",Toast.LENGTH_SHORT).show();
                        ((MainActivity)context).fragmentManager.popBackStackImmediate(null,((MainActivity) context).fragmentManager.POP_BACK_STACK_INCLUSIVE);


                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"등록하기 취소",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
    }

    public void onDestroyView() { // 화면에서 사라질때 프래그먼트의 뷰 삭제
        super.onDestroyView();
        if (v != null) {
            ViewGroup parent = (ViewGroup) v.getParent();
            if (parent != null) {
                parent.removeView(v);
            }
        }
    }


    public static Setting_question_write_fragment newInstance() {
        return new Setting_question_write_fragment();
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

