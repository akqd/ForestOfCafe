package com.example.forestofcafe;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Community_post_fragment extends Fragment {
    Context context;
    RatingBar rb;
    View v;
    ImageView profile_img, cafe_img;
    TextView writer_name, cafe_name, cafe_address, comment_num, like_num, cafe_review;
    RatingBar ratingBar;
    EditText input_comment;
    Button btn_comment;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CommunityPost_Adapter Adapter;
    private ArrayList<CommunityPost_Item> data = new ArrayList<CommunityPost_Item>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        recyclerView = getActivity().findViewById(R.id.post_recyclerview);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new CommunityPost_Adapter(data);
        recyclerView.setAdapter(Adapter);

        profile_img = getActivity().findViewById(R.id.writer_profile);
        cafe_img = getActivity().findViewById(R.id.post_image);
        writer_name = getActivity().findViewById(R.id.writer_id);
        cafe_name = getActivity().findViewById(R.id.cafe_name);
        cafe_address = getActivity().findViewById(R.id.cafe_address);
        comment_num = getActivity().findViewById(R.id.comment_num);
        like_num = getActivity().findViewById(R.id.like_num);
        cafe_review = getActivity().findViewById(R.id.post_review);
        ratingBar = getActivity().findViewById(R.id.star_num);
        input_comment = getActivity().findViewById(R.id.et_enroll_comment);
        btn_comment = getActivity().findViewById(R.id.btn_enroll_comment);

        //profile_img.setImageResource(R.drawable.프로필 이미지);
        cafe_img.setImageResource(R.drawable.cafe_thelight_1);
        writer_name.setText("카페돌이");
        cafe_name.setText("카페 빛");
        cafe_address.setText("서울 은평구 응암로 14길 26-1");
        comment_num.setText("11");
        like_num.setText("7");
        cafe_review.setText("고급스럽고 분위기있는 카페였어요. 메뉴도 많고 사장님이 친절해서 좋았어요! 커피도 맛있었고 빵도 맛있었어요~");
        ratingBar.setRating((float)4.7);

        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_comment == null || input_comment.length() == 0){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                    dlg.setTitle("잠깐!");
                    dlg.setMessage("등록할 내용을 작성해주세요!");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }else{
                    AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                    dlg.setTitle("알림");
                    dlg.setMessage("댓글을 등록할까요?");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
            }
        });


        addsubcommitem("코멘트남", " (2020-05-11 12:50:30)", "항상 좋은 게시물 감사합니다.");
        addsubcommitem("코멘트걸", " (2020-05-16 14:29:54)","엄청 이쁘네요~~ 한번 가볼게요~");
        addsubcommitem("댓글로봇", " (2020-06-09 20:03:12)", "이걸 이제봤네요~ 한번 가봐야겠네요~");
    }

    private void addsubcommitem(String writer_info,String write_time, String comment) {
        CommunityPost_Item item = new CommunityPost_Item();

        item.setComment_writer_info(writer_info);
        item.setWrite_time(write_time);
        item.setCommnet(comment);

        data.add(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post,container,false);
    }

    @Override
    public void onStop() {
        super.onStop();
        data.clear();
        Adapter.notifyDataSetChanged();
    }

    public static Community_post_fragment newInstance(){
        return new Community_post_fragment();
    }
}
