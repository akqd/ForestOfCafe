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
    View v;
    Profile_CustomDialog dialog = null;



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

                View.OnClickListener postiveListner = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"문의가 접수되었습니다.",Toast.LENGTH_SHORT).show();
                        ((MainActivity)context).fragmentManager.popBackStackImmediate(null,((MainActivity) context).fragmentManager.POP_BACK_STACK_INCLUSIVE);
                        dialog.dismiss();
                    }
                };
                View.OnClickListener negativeListner = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"취소 버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                };
                dialog = new Profile_CustomDialog(context,"등록하시겠습니까?",postiveListner,negativeListner);
                dialog.show();
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

