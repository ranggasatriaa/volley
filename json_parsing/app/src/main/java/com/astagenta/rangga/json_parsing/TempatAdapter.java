package com.astagenta.rangga.json_parsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class TempatAdapter extends RecyclerView.Adapter<TempatAdapter.TempatViewHolder> {

    private Context mContext;
    private ArrayList<TempatItem> mTempatList;

    public TempatAdapter(Context context, ArrayList<TempatItem> tempatList){
        mContext = context;
        mTempatList = tempatList;
    }

    @NonNull
    @Override
    public TempatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.tempat_item, parent, false);
        return new TempatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TempatViewHolder holder, int position) {
        TempatItem currentItem = mTempatList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String name = currentItem.getName();
        String latitude = currentItem.getLatitude();
        String longitude = currentItem.getLongitude();
        String category = currentItem.getCategory();

        holder.mTextViewName.setText(name);
        holder.mTextViewLatitude.setText(latitude);
        holder.mTextViewLongitude.setText(longitude);
        holder.mTextViewCategory.setText(category);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mTempatList.size();
    }

    public class TempatViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextViewName;
        public TextView mTextViewLatitude;
        public TextView mTextViewLongitude;
        public TextView mTextViewCategory;

        public TempatViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewName = itemView.findViewById(R.id.text_view_name);
            mTextViewLatitude = itemView.findViewById(R.id.text_view_latitude);
            mTextViewLongitude = itemView.findViewById(R.id.text_view_longitude);
            mTextViewCategory = itemView.findViewById(R.id.text_view_category);
        }
    }

}
