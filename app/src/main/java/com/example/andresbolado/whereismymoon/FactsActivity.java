package com.example.andresbolado.whereismymoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andresbolado.whereismymoon.models.QuestionsObject;
import com.example.andresbolado.whereismymoon.utils.MyAdapter;

import java.util.ArrayList;

public class FactsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        ArrayList<QuestionsObject> quest = new ArrayList<QuestionsObject>();

        quest.add(new QuestionsObject("how far is the moon?","Min. 363,000, max 405,000 km"));
        quest.add(new QuestionsObject("How long is a day on the moon","A lunar day is 27.3 Earth days long"));
        quest.add(new QuestionsObject("What is the temperature on the moon surface?","Between -233°C and +123 °C"));
        quest.add(new QuestionsObject("How much would you weigh on the moon?","1/6th of what you weigh on Earth"));
        quest.add(new QuestionsObject("Hoy many people malked on the moon?","12 astronauts during the Apollo programme (1969 – 1972)"));
        quest.add(new QuestionsObject("HOW LONG DOES IT TAKE TO GO THE MOON?","About 3 days"));
        quest.add(new QuestionsObject("Why does the moon look bigger at times?","Due to its elliptical orbit"));
        quest.add(new QuestionsObject("Is there water on the moon","Yes, water ice at the poles"));
        quest.add(new QuestionsObject("Why do you see many crater on the moon?","Craters keep their shape since there is no weather and no tectonic activity"));
        quest.add(new QuestionsObject("Earth-Moon: how long does he light take?","About 1.28 seconds"));
        quest.add(new QuestionsObject("How big does earth look like from the moon?","Bigger than what the Moon looks to us from Earth"));
        quest.add(new QuestionsObject("What are the dark and light areas on the moon?","Lava flows are dark, highlands are bright"));
        quest.add(new QuestionsObject("Is there a dark side of the moon?","No. We talk about Near and Far side"));




        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(quest);
        mRecyclerView.setAdapter(mAdapter);
    }
}
