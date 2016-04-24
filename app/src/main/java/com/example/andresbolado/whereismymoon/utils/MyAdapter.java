package com.example.andresbolado.whereismymoon.utils;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.andresbolado.whereismymoon.R;
import com.example.andresbolado.whereismymoon.models.QuestionsObject;

import java.util.ArrayList;

/**
 * Created by andresbolado on 4/23/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<QuestionsObject> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        public ViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<QuestionsObject> myQuestion)
    {
        mDataset = myQuestion;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final FrameLayout frm1 = (FrameLayout) holder.view.findViewById(R.id.frameCard1);
        final TextView question  = (TextView) holder.view.findViewById(R.id.info_text);

        frm1.setBackgroundColor(Color.parseColor("#000000"));
        question.setTextColor(Color.WHITE);

        question.setText(mDataset.get(position).getCuestion());


        question.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {


                if(question.getText()== mDataset.get(position).getCuestion() )
                {
                    int coordenadaX1 = (frm1.getLeft() +frm1.getRight()) / 2;
                    int coordenadaY1 = (frm1.getBottom() + frm1.getTop()) / 2;
                    int coordenadaX2 = (question.getLeft() +question.getRight()) / 2;
                    int coordenadaY2 = (question.getBottom() + question.getTop()) / 2;


                        int radiofinal1 = Math.max(frm1.getWidth(), frm1.getHeight());
                        int radiofinal2 = Math.max(question.getWidth(), question.getHeight());




                        Animator animacion3 = ViewAnimationUtils.createCircularReveal(frm1, coordenadaX1, coordenadaY1, 0,radiofinal1);
                        Animator animacion4 = ViewAnimationUtils.createCircularReveal(question, coordenadaX2, coordenadaY2,0, radiofinal2);


                        frm1.setVisibility(View.VISIBLE);
                        question.setVisibility(View.VISIBLE);

                        animacion3.setDuration(2000);
                        animacion4.setDuration(2000);
                        animacion3.start();
                        animacion4.start();
                        frm1.setBackgroundColor(Color.WHITE);
                        question.setTextColor(Color.BLACK);
                        question.setText(mDataset.get(position).getAnswer());




                }else{
                    int coordenadaX1 = (frm1.getLeft() +frm1.getRight()) / 2;
                    int coordenadaY1 = (frm1.getBottom() + frm1.getTop()) / 2;
                    int coordenadaX2 = (question.getLeft() +question.getRight()) / 2;
                    int coordenadaY2 = (question.getBottom() + question.getTop()) / 2;



                    int radiofinal1 = Math.max(frm1.getWidth(), frm1.getHeight());
                    int radiofinal2 = Math.max(question.getWidth(), question.getHeight());




                    Animator animacion3 = ViewAnimationUtils.createCircularReveal(frm1, coordenadaX1, coordenadaY1, 0,radiofinal1);
                    Animator animacion4 = ViewAnimationUtils.createCircularReveal(question, coordenadaX2, coordenadaY2,0, radiofinal2);

                    animacion3.setDuration(2000);
                    animacion4.setDuration(2000);

                    frm1.setVisibility(View.VISIBLE);
                    question.setVisibility(View.VISIBLE);


                    animacion3.start();
                    animacion4.start();
                    frm1.setBackgroundColor(Color.parseColor("#000000"));
                    question.setTextColor(Color.WHITE);
                    question.setText(mDataset.get(position).getCuestion());

                }

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
