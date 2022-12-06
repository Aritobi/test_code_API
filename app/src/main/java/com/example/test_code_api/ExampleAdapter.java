package com.example.test_code_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private Context mContext ;
    private ArrayList<ExampleItem> mExamplelist;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener ;
    }
    public ExampleAdapter(Context context, ArrayList<ExampleItem> examplelist){
        mContext =context;
        mExamplelist = examplelist;
    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExamplelist.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        double likecount = currentItem.getLikeCount();
        String date = currentItem.getDate();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("notes:"+ likecount);
        holder.mTextViewDate.setText("date:"+date);

        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);




    }

    @Override
    public int getItemCount() {
        return mExamplelist.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView ;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes ;
        public TextView mTextViewDate ;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);
            mTextViewDate = itemView.findViewById(R.id.text_view_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);

                        }
                    }
                }
            });


        }
    }

}
