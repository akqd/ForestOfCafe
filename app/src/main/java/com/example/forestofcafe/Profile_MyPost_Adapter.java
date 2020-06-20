package com.example.forestofcafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Profile_MyPost_Adapter extends RecyclerView.Adapter<Profile_MyPost_Adapter.ViewHolder> {
    ArrayList<Profile_MyPost_Item> data = null;
    Context context;
    OnItemClickListener mListner;

    public Profile_MyPost_Adapter(ArrayList<Profile_MyPost_Item> list) {
        data = list;
    }

    @NonNull
    @Override
    public Profile_MyPost_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_holder_profile_mypost, parent, false);
        Profile_MyPost_Adapter.ViewHolder vh = new Profile_MyPost_Adapter.ViewHolder(view);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull Profile_MyPost_Adapter.ViewHolder holder, int position) {
        Profile_MyPost_Item item = data.get(position);
        holder.imgv_CafePost.setImageResource(item.getCafePost());
        holder.tv_mypost_cafeContent.setText(item.getCafeContent());
        holder.tv_mypost_cafeLocation.setText(item.getCafeLocation());
        holder.tv_mypost_cafeName.setText(item.getCafeName());
        holder.tv_FavoriteCount.setText(item.getFavoriteCount());
        holder.tv_CommentCount.setText(item.getCommentCount());
        holder.tv_mypost_writeTime.setText(item.getWriteTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        Button btn_mypost_Modify, btn_mypost_Delete;
        ImageView imgv_CafePost,imgv_mypost_comment,imgv_mypost_favorite;
        TextView tv_mypost_cafeName, tv_mypost_cafeLocation, tv_mypost_cafeContent,tv_CommentCount, tv_FavoriteCount,tv_mypost_writeTime;
        Profile_CustomDialog dialog;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dialog = null;
            btn_mypost_Modify = itemView.findViewById(R.id.btn_mypost_Modify);
            btn_mypost_Delete = itemView.findViewById(R.id.btn_mypost_Delete);
            imgv_CafePost = itemView.findViewById(R.id.imgv_CafePost);
            imgv_mypost_comment = itemView.findViewById(R.id.imgv_mypost_comment);
            imgv_mypost_favorite = itemView.findViewById(R.id.imgv_mypost_favorite);
            tv_mypost_cafeName = itemView.findViewById(R.id.tv_mypost_cafeName);
            tv_mypost_cafeLocation = itemView.findViewById(R.id.tv_mypost_cafeLocation);
            tv_mypost_cafeContent = itemView.findViewById(R.id.tv_mypost_cafeContent);
            tv_mypost_writeTime = itemView.findViewById(R.id.tv_mypost_writeTime);
            tv_CommentCount = itemView.findViewById(R.id.tv_CommentCount);
            tv_FavoriteCount = itemView.findViewById(R.id.tv_FavoriteCount);
            btn_mypost_Modify.setText("수정");
            btn_mypost_Delete.setText("삭제");
            imgv_mypost_favorite.setImageResource(R.drawable.ic_heart);
            imgv_mypost_comment.setImageResource(R.drawable.ic_comment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Profile_MyPost_Item item = data.get(pos);
                        if (mListner != null) {
                            mListner.onItemClick(v, pos);
                        }
                    }
                }
            });
            btn_mypost_Modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View.OnClickListener postiveListner = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"수정 버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show();
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
                    dialog = new Profile_CustomDialog(context,"게시글을 수정하시겠습니까?",postiveListner,negativeListner);
                    dialog.show();
                }
            });
            btn_mypost_Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View.OnClickListener postiveListner = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,"삭제 버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show();
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
                    dialog = new Profile_CustomDialog(context,"게시글을 삭제하시겠습니까?",postiveListner,negativeListner);
                    dialog.show();
                }
            });

        }
    }
    public interface OnItemClickListener {
        void onItemClick(View v, int postion);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListner = listener;
    }
}
