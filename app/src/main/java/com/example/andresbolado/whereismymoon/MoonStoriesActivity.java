package com.example.andresbolado.whereismymoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.andresbolado.whereismymoon.models.MoonStories;
import com.example.andresbolado.whereismymoon.utils.StoryAdapter;

import java.util.ArrayList;

public class MoonStoriesActivity extends AppCompatActivity implements StoryAdapter.StoryCallBacks {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon_stories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvStories);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<MoonStories> arrStories = new ArrayList<MoonStories>();

        arrStories.add(new MoonStories("The Rabbit On The Moon", "\"Quetzalcoatl, an imposing and good god traveled the world as a man," +
                "tired from walking all day, he notice that his appetite increased," +
                "but remained on the road, until the stars began to shine and the moon peeked." +
                "Quetzalcoatl, decided to sit at the edge of a tree, where he saw a rabbit. \n\n" +
                "-What are you eating ?, - he asked.\n\n" +
                "-I’m eating grass. Do you want some?\n\n" +
                "-Thanks, but I do not eat grass.\n\n" +
                "-What are you going to do then?\n\n" +
                "-Maybe i would die from hunger and thirst.\n\n" +
                "Bunny came to Quetzalcoatl and told him:\n\n" +
                "-Look, I'm just a bunny, but if you're hungry, eat me, I'm here.\n\n" +
                "The benevolent god, surprised by the reaction Bunny, said:\n\n" +
                " -You will not be more than a bunny, but everyone, forever, would remember you.\n\n" +
                " Then, the bunny raised high, very high, to the moon, where the figure was stamped rabbit.\n\n" +
                " Then God came down to earth and said:\n\n" +
                "-There you have your portrait in the light, for all men and for all time.\n\n"));


        StoryAdapter storyAdapter = new StoryAdapter(MoonStoriesActivity.this, arrStories);
        mRecyclerView.setAdapter(storyAdapter);
    }

    @Override
    public void OnStorySelected(MoonStories moonStories) {

        Intent intent = new Intent(MoonStoriesActivity.this,MoonStoryScrollingActivity.class);
        intent.putExtra("Text",moonStories.getStoryText());
        intent.putExtra("Title",moonStories.getStoryName());
        startActivity(intent);

    }
}
