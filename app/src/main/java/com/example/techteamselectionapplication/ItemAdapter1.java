package com.example.techteamselectionapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ItemAdapter1 extends RecyclerView.Adapter<ItemAdapter1.MyViewHolder> {

    private Context context;
    private ArrayList<String> images;
    RequestOptions requestOptions;

    private void initGlide(){
        requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_foreground).dontTransform();
    }


    public ItemAdapter1(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.images = arrayList;
        initGlide();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(images.get(position))
                .apply(requestOptions)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}