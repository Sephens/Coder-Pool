package com.example.coderspool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {

    public adapter(ArrayList<SlideAdapterHelper> slHelper) {
        this.slHelper = slHelper;


    }

    ArrayList<SlideAdapterHelper> slHelper;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler1,parent,false);
        viewHolder vh = new viewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        SlideAdapterHelper shh = slHelper.get(position);
        holder.image.setImageResource(shh.getImage());
        holder.title.setText(shh.getTitle());
        holder.description.setText(shh.getDescription());

    }

    @Override
    public int getItemCount() {
        return slHelper.size();
    }

    public  static class viewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,description;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.recyclerimg1);
            title = itemView.findViewById(R.id.recyclertxt1);
            description = itemView.findViewById(R.id.recyclertxt2);
        }
    }


}
