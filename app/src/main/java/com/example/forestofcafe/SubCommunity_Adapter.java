package com.example.forestofcafe;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubCommunity_Adapter extends RecyclerView.Adapter<SubCommunity_Adapter.ViewHoler> {

    private ArrayList<SubCommunity_Item> data = null;
    SubCommunity_Adapter.OnItemClickListener mListener;

    public SubCommunity_Adapter(ArrayList<SubCommunity_Item> list) {
        data = list;
    }

    @NonNull
    @Override
    public SubCommunity_Adapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_community, parent, false);
        SubCommunity_Adapter.ViewHoler vh = new SubCommunity_Adapter.ViewHoler(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SubCommunity_Adapter.ViewHoler holder, int position) {
        SubCommunity_Item item = data.get(position);
        holder.cafe_img.setImageDrawable(item.getCafe_Img());
        holder.writer_profile.setImageDrawable(item.getWriter_Profile());
        holder.writer_id.setText(item.getWriter_Id());
        holder.cafe_name.setText(item.getCafe_Name());
        holder.cafe_address.setText(item.getCafe_Address());
        holder.review.setText(item.getReview());
        holder.comment_num.setText(item.getComment_Num());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHoler extends RecyclerView.ViewHolder {

        private ImageView cafe_img;
        private ImageView writer_profile;
        private TextView writer_id;
        private TextView cafe_name;
        private TextView cafe_address;
        private TextView review;
        private TextView comment_num;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            cafe_img = itemView.findViewById(R.id.cafe_img);
            writer_profile = itemView.findViewById(R.id.writer_profile);
            writer_id = itemView.findViewById(R.id.writer_id);
            cafe_name = itemView.findViewById(R.id.cafe_name);
            cafe_address = itemView.findViewById(R.id.cafe_address);
            review = itemView.findViewById(R.id.review);
            comment_num = itemView.findViewById(R.id.comment_num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        SubCommunity_Item item = data.get(pos);
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

    public void setOnItemClickListener(SubCommunity_Adapter.OnItemClickListener listener){
        mListener = listener;
    }
}
