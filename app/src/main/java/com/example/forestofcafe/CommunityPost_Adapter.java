package com.example.forestofcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommunityPost_Adapter extends RecyclerView.Adapter<CommunityPost_Adapter.ViewHoler> {
    private ArrayList<CommunityPost_Item> data = null;
    SubCommunity_Adapter.OnItemClickListener mListener;

    public CommunityPost_Adapter(ArrayList<CommunityPost_Item> list) {
        data = list;
    }

    @NonNull
    @Override
    public CommunityPost_Adapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_post_commentlist, parent, false);
        CommunityPost_Adapter.ViewHoler vh = new CommunityPost_Adapter.ViewHoler(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityPost_Adapter.ViewHoler holder, int position) {
        CommunityPost_Item item = data.get(position);
        holder.commnet_info.setText(item.getComment_writer_info());
        holder.write_time.setText(item.getWrite_time());
        holder.comment.setText(item.getCommnet());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHoler extends RecyclerView.ViewHolder {

        private TextView commnet_info;
        private TextView write_time;
        private TextView comment;


        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            commnet_info = itemView.findViewById(R.id.comment_writer);
            write_time = itemView.findViewById(R.id.write_time);
            comment = itemView.findViewById(R.id.comment);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        CommunityPost_Item item = data.get(pos);
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

    public void setOnItemClickListener(CommunityPost_Adapter.OnItemClickListener listener){
        mListener = (SubCommunity_Adapter.OnItemClickListener) listener;
    }
}
