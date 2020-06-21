package com.example.forestofcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainCommunity_Adapter extends RecyclerView.Adapter<MainCommunity_Adapter.ViewHoler> {

    private ArrayList<MainCommunity_Item> data = null;
    MainCommunity_Adapter.OnItemClickListener mListener;

    public MainCommunity_Adapter(ArrayList<MainCommunity_Item> list){data = list;}



    @NonNull
    @Override
    public MainCommunity_Adapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_main_community, parent, false);
        MainCommunity_Adapter.ViewHoler vh = new MainCommunity_Adapter.ViewHoler(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainCommunity_Adapter.ViewHoler holder, int position) {
        MainCommunity_Item item = data.get(position);
        holder.profile.setImageDrawable(item.getProfile());
        holder.cafe_img.setImageDrawable(item.getCafe_Img());
        holder.id.setText(item.getId());
        holder.cafe_name.setText(item.getCafe_Name());
        holder.like_num.setText(item.getLike_Num());
        holder.comment_num.setText(item.getComment_Num());
        holder.score.setText(item.getScore());
        holder.review.setText(item.getReview());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHoler extends RecyclerView.ViewHolder {

        private ImageView profile;
        private ImageView cafe_img;
        private TextView id;
        private TextView cafe_name;
        private TextView like_num;
        private TextView comment_num;
        private TextView score;
        private TextView review;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.comm_writerProfile);
            cafe_img = itemView.findViewById(R.id.comm_imageview);
            id = itemView.findViewById(R.id.comm_writerID);
            cafe_name = itemView.findViewById(R.id.comm_cafename);
            like_num = itemView.findViewById(R.id.comm_likenum);
            comment_num = itemView.findViewById(R.id.comm_commentnum);
            score = itemView.findViewById(R.id.comm_score);
            review = itemView.findViewById(R.id.comm_review);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        MainCommunity_Item item = data.get(pos);
                        if(mListener != null) {
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(MainCommunity_Adapter.OnItemClickListener listener){
        mListener = listener;
    }
}
