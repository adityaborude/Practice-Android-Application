package com.example.techteamselectionapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ItemAdapter2 extends RecyclerView.Adapter<ItemAdapter2.MyViewHolder> {

    private void initGlide(){
        requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_foreground).centerCrop();
    }

    ArrayList<ListItem> items;
    private Context context;
    RequestOptions requestOptions;

    public ItemAdapter2(ArrayList<ListItem> items, Context context) {
        this.items = items;
        this.context = context;
        initGlide();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView date;
        TextView name;
        TextView venue;
        TextView price;
        Button book;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.list_image);
            this.date = itemView.findViewById(R.id.list_item_date);
            this.name = itemView.findViewById(R.id.list_item_title);
            this.venue = itemView.findViewById(R.id.list_item_venue);
            this.price = itemView.findViewById(R.id.list_item_price);
            this.book = itemView.findViewById(R.id.list_item_buy);
        }
    }
    @NonNull
    @Override
    public ItemAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter2.MyViewHolder holder, int position) {
        Glide.with(context)
                .load(items.get(position).getImage())
                .apply(requestOptions)
                .into(holder.image);
        holder.image.setClipToOutline(true);
        holder.date.setText(items.get(position).getDate());
        holder.name.setText(items.get(position).getName());
        holder.venue.setText(items.get(position).getVenue());
        holder.price.setText(items.get(position).getPrice());
        holder.price.setTypeface(null, Typeface.BOLD);
        holder.book.setTypeface(Typeface.createFromAsset(context.getAssets(), "myfont.ttf"));
        holder.book.setText("Book Now");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
