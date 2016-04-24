package com.example.andresbolado.whereismymoon;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.andresbolado.whereismymoon.models.Moon;
import com.example.andresbolado.whereismymoon.utils.DialogUtil;
import com.example.andresbolado.whereismymoon.utils.JSONParser;
import com.example.andresbolado.whereismymoon.utils.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MoonScrollingActivity extends AppCompatActivity {

    public TextView currentPhase, currentUntil;
    ImageView currentImage, currentImagePlace;

    private RequestQueue requestQueue;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        requestQueue = Volley.newRequestQueue(this);
        currentPhase = (TextView) findViewById(R.id.text_view_current_phase);
        currentUntil = (TextView) findViewById(R.id.text_view_current_until);
        currentImage = (ImageView) findViewById(R.id.image_view_current_image);
        currentImagePlace = (ImageView) findViewById(R.id.image_view_current_place);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Calendar c = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = df.format(c.getTime());
        String basePhaseURL = "http://api.usno.navy.mil/moon/phase?date=";
        String contextPhaseURL = "&nump=1";
        String ultimatePhaseURL = basePhaseURL + currentDate + contextPhaseURL;

        String baseImageURL = "http://api.usno.navy.mil/imagery/moon.png?&date=";
        String ultimateImageURL = baseImageURL + currentDate;
        Log.i("imageURL", ultimateImageURL);

        String ultimateCurrentMoonImageURL = "http://api.usno.navy.mil/imagery/earth.png";


        ImageRequest request = new ImageRequest(ultimateImageURL,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        progressBar.setVisibility(View.INVISIBLE);
                        currentImage.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.INVISIBLE);
                        currentImage.setImageResource(R.drawable.ic_broken_image);
                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(request);


        ImageRequest placerequest = new ImageRequest(ultimateCurrentMoonImageURL,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        currentImagePlace.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        currentImagePlace.setImageResource(R.drawable.ic_broken_image);
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(placerequest);

        try {
            getCurrentMoon(ultimatePhaseURL);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void getCurrentMoon(String url) throws JSONException {


        final ProgressDialog progressDialog = ProgressDialog.show(this, getString(R.string.getting_moon_dta), getString(R.string.please_wait), true, false);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                System.out.println(response);
                try {
                    Moon currentMoon = JSONParser.parseMoonPhaseJSON(response);

                    currentPhase.setText(currentMoon.getPhase());
                    currentUntil.setText(currentMoon.getDate());

                } catch (JSONException e) {
                    DialogUtil.createSimpleDialog(MoonScrollingActivity.this, getString(R.string.error_parsing_data), e.getMessage()).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        DialogUtil.createSimpleDialog(MoonScrollingActivity.this, getString(R.string.error_parsing_data), error.getMessage()).show();

                    }
                });

        requestQueue.add(jsonObjectRequest);


    }


}
