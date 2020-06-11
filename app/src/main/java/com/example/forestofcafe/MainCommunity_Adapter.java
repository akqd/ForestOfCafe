package com.example.forestofcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainCommunity_Adapter extends RecyclerView.Adapter<MainCommunity_Adapter.ViewHolder> {

    private List<MainCommunity_Item> community_itemList;

    public MainCommunity_Adapter(List<MainCommunity_Item> community_itemList) {
        this.community_itemList = community_itemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_main_community, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int profile = community_itemList.get(position).getProfile();
        int cafeimage = community_itemList.get(position).getCafe_image();
        String id = community_itemList.get(position).getWriter_name();
        String cafe_name = community_itemList.get(position).cafe_name;
        String like_num = community_itemList.get(position).getLike_num();
        String commnet_num = community_itemList.get(position).getComment_num();
        String score = community_itemList.get(position).getScore_num();
        String review = community_itemList.get(position).getCafe_review();
        viewHolder.setData(profile, cafeimage, id,cafe_name, like_num, commnet_num, score, review);
    }

    @Override
    public int getItemCount() {
        return community_itemList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView profile;
        private ImageView cafe_img;
        private TextView id;
        private TextView cafe_name;
        private TextView like_num;
        private TextView comment_num;
        private TextView score;
        private TextView review;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.comm_writerProfile);
            cafe_img = itemView.findViewById(R.id.comm_imageview);
            id = itemView.findViewById(R.id.comm_writerID);
            cafe_name = itemView.findViewById(R.id.comm_cafename);
            like_num = itemView.findViewById(R.id.comm_likenum);
            comment_num = itemView.findViewById(R.id.comm_commentnum);
            score = itemView.findViewById(R.id.comm_score);
            review = itemView.findViewById(R.id.comm_review);
        }

        private void setData(int userprofile, int cafeimg, String userid, String cname, String likenum, String commnetnum, String scorenum, String cafereview){
            profile.setImageResource(userprofile);
            cafe_img.setImageResource(cafeimg);
            id.setText(userid);
            cafe_name.setText(cname);
            like_num.setText(likenum);
            comment_num.setText(commnetnum);
            score.setText(scorenum);
            review.setText(cafereview);
        }
    }
}
