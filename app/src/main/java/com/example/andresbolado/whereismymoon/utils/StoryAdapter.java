package com.example.andresbolado.whereismymoon.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andresbolado.whereismymoon.R;
import com.example.andresbolado.whereismymoon.models.MoonStories;

import java.util.ArrayList;

/**
 * Created by jesusflores on 24/04/16.
 */
public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    public static interface StoryCallBacks{
        public void OnStorySelected(MoonStories moonStories);
    }
    private  StoryCallBacks storyCallBacks;

    private ArrayList<MoonStories> moonStoriesList;
    private Context context;

    public StoryAdapter(Context context, ArrayList<MoonStories> moonStoriesList){
        this.context = context;
        this.moonStoriesList = moonStoriesList;
        this.storyCallBacks = (StoryCallBacks) context;
    }



    @Override
    public StoryAdapter.StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardview = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item_cardview,parent,false);
        return new StoryViewHolder(cardview);

    }

    @Override
    public void onBindViewHolder(StoryAdapter.StoryViewHolder holder, int position) {
        final MoonStories moonStories = moonStoriesList.get(position);
        holder.storyName.setText(moonStories.getStoryName());
        holder.clickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storyCallBacks.OnStorySelected(moonStories);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moonStoriesList.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        TextView storyName;
        View clickView;
        public StoryViewHolder(View itemView) {
            super(itemView);
            this.clickView = itemView.findViewById(R.id.click_view);
            this.storyName = (TextView) itemView.findViewById(R.id.cvStoryTitle);
        }
    }
}
