package com.example.coderspool;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class CategoryGridAdapter extends BaseAdapter {
    private List<QModel> categoryList;
    ImageView quizImage;
    TextView quizName;

    public CategoryGridAdapter(List<QModel> categoryList) {
        this.categoryList = categoryList;
    }


    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_category_item_quizes,viewGroup,false);
            quizName = view.findViewById(R.id.categoryItemTextVieww);
            quizImage= view.findViewById(R.id.quizImage);


        quizName.setText(categoryList.get(i).getQuizName().toString());
        quizImage.setImageResource(categoryList.get(i).getQuizImage());
        return view;


        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewGroup.getContext(), LevelsActivityQuizzes.class);
                //intent.putExtra("CATEGORY",R.drawable.cbk,categoryList.get(i));
                viewGroup.getContext().startActivity(intent);
            }
        });

         */

    }
}
