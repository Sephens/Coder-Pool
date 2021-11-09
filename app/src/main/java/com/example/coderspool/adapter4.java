package com.example.coderspool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter4 extends RecyclerView.Adapter<adapter.viewHolder> {
    public adapter4(ArrayList<SlideAdapterHelper> slideHelper){
        this.slideHelper = slideHelper;
    }
    ArrayList<SlideAdapterHelper> slideHelper;

    @NonNull
    @Override
    public adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_2,parent,false);
        adapter.viewHolder vh = new adapter.viewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull adapter.viewHolder holder, int position) {

        SlideAdapterHelper shh = slideHelper.get(position);
        holder.image.setImageResource(shh.getImage());
        holder.title.setText(shh.getTitle());
        holder.description.setText(shh.getDescription());
    }

    @Override
    public int getItemCount() {
        return slideHelper.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,description;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.card_4_img);
            title = itemView.findViewById(R.id.card_4_title);
            description = itemView.findViewById(R.id.card_4_description);
        }
    }

}
