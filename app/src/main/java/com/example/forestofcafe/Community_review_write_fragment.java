package com.example.forestofcafe;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Community_review_write_fragment extends Fragment {
    Context context;
    TextView cafe_info, attach_list;
    EditText review, hashtag;
    RatingBar star_num;
    Button btn_write;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        cafe_info = getActivity().findViewById(R.id.cafe_info);
        attach_list = getActivity().findViewById(R.id.attach_list);
        review = getActivity().findViewById(R.id.et_review);
        hashtag = getActivity().findViewById(R.id.et_hashtag);
        star_num = getActivity().findViewById(R.id.star_score);
        btn_write = getActivity().findViewById(R.id.btn_review_write);

        cafe_info.setText("커피나무" +"\n" + "서울특별시 서대문구 북가좌동");
        attach_list.setText("사진1, 사진2");
        review.setText("집주변에 카페가 있길래 가봤는데 조용하고 분위기좋아서 만족스러웠어요. 커피도 맛있고 빵도 맛있어요");
        hashtag.setText("#디저트 #커피 #카페");
        star_num.setRating((float)5);

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(review == null || review.length() == 0){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                    dlg.setTitle("잠깐!");
                    dlg.setMessage("작성할 내용을 입력해주세요!");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }else{
                    AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                    dlg.setTitle("알림");
                    dlg.setMessage("작성된 글을 등록할까요?");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_write_review,container,false);
    }
}
