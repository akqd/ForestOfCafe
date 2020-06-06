package com.example.forestofcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private String[] Cafe_name, Cafe_distance, Cafe_openclose;
    private Integer[] Cafe_images;

    //메인화면 커뮤니티를 위한 생성자(김준희 추가)
    private String[] writer_name, cafe_name, cafe_review, score_num, comment_num, like_num;
    private Integer[] images;

    MainHolder mainHolder;

    public MainAdapter(String[] Cafe_name, String[] Cafe_distance, String[] Cafe_openclose, Integer[] Cafe_images, String[] writer_name, String[] cafe_name, String[] cafe_review ,String[] comment_num, String[] like_num, String [] score_num, Integer[] images) {
        this.Cafe_name = Cafe_name;
        this.Cafe_distance = Cafe_distance;
        this.Cafe_openclose = Cafe_openclose;
        this.Cafe_images = Cafe_images;

        //메인화면 커뮤니티를 위한 어댑터 생성(김준희 추가)
        this.writer_name = writer_name;
        this.cafe_name = cafe_name;
        this.cafe_review = cafe_review;
        this.comment_num = comment_num;
        this.like_num = like_num;
        this.score_num = score_num;
        this.images = images;
    }

    public static class MainHolder extends RecyclerView.ViewHolder {

        public TextView Cafe_name, Cafe_distance, Cafe_openclose;
        public ImageView Cafe_images;

        //메인화면 커뮤니티를 위한 뷰홀더 생성(김준희 추가)
        public TextView writer_name, cafe_name, cafe_review, comment_num, like_num, score_num;
        public ImageView image;

        public MainHolder(View view) {
            super(view);
            this.Cafe_name = view.findViewById(R.id.tvCafeName);
            this.Cafe_distance = view.findViewById(R.id.tvCafeDistance);
            this.Cafe_openclose = view.findViewById(R.id.tvCafeOpenClose);
            this.Cafe_images = view.findViewById(R.id.imgMainCafe1);

            //메인화면 커뮤니티를 위해 추가(김준희 추가)
            this.writer_name = view.findViewById(R.id.comm_writerID);
            this.cafe_name = view.findViewById(R.id.comm_cafename);
            this.cafe_review = view.findViewById(R.id.comm_review);
            this.comment_num = view.findViewById(R.id.comm_commentnum);
            this.like_num = view.findViewById(R.id.comm_likenum);
            this.score_num = view.findViewById(R.id.comm_score);
            this.image = view.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override

    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_main_cafelist, parent, false);
        mainHolder = new MainHolder(holderView);
        return mainHolder;

    }


    @Override

    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i) {

        mainHolder.Cafe_name.setText(this.Cafe_name[i]);
        mainHolder.Cafe_distance.setText(this.Cafe_distance[i]);
        mainHolder.Cafe_openclose.setText(this.Cafe_openclose[i]);
        mainHolder.Cafe_images.setImageResource(this.Cafe_images[i]);

        //메인화면 커뮤니티를 위해 추가(김준희 추가)
        mainHolder.writer_name.setText(this.writer_name[i]);
        mainHolder.cafe_name.setText(this.cafe_name[i]);
        mainHolder.cafe_review.setText(this.cafe_review[i]);
        mainHolder.comment_num.setText(this.comment_num[i]);
        mainHolder.like_num.setText(this.like_num[i]);
        mainHolder.score_num.setText(this.score_num[i]);
        // mainHolder.image.setImageResource(this.images[i]);        이코드만 넣으면 오류생김;

    }


    @Override

    public int getItemCount() {
        return Cafe_name.length;
    }
}
