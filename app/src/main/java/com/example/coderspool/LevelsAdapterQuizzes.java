package com.example.coderspool;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LevelsAdapterQuizzes extends BaseAdapter {


    private int numberOfLevels;
    public TextView txt;

    public LevelsAdapterQuizzes(int numberOfLevels) {
        this.numberOfLevels = numberOfLevels;
    }

    @Override
    public int getCount() {
        return numberOfLevels;
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

        View view1;
        if (view==null){

            view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.level_item_layout,viewGroup,false);


        }
        else {
            view1 = view;
        }

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewGroup.getContext(), QuizzesActivity.class);
                viewGroup.getContext().startActivity(intent);
            }
        });

        ((TextView)view1.findViewById(R.id.levelsNumberTextView)).setText(String.valueOf(i+1));

        /*Random rnd = new Random();
        int color = Color.argb(255,rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
        view1.setBackgroundColor(color);


         */
        return view1;
    }
}
