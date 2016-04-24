package com.example.andresbolado.whereismymoon.utils;

import com.example.andresbolado.whereismymoon.models.Moon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jesusflores on 23/04/16.
 */
public class JSONParser {

    public static Moon parseMoonPhaseJSON(JSONObject response) throws JSONException{
        Moon moon = new Moon();

        response.getString(JSONKeys.KEY_ERROR);

        JSONArray jsonObjectMoonPhase = response.getJSONArray(JSONKeys.KEY_PHASEDATA);


        JSONObject jsonArray = jsonObjectMoonPhase.getJSONObject(0);


        moon.setDate(jsonArray.getString(JSONKeys.KEY_DATE));
        moon.setTime(jsonArray.getString(JSONKeys.KEY_TIME));
        moon.setPhase(jsonArray.getString(JSONKeys.KEY_PHASE));

        return moon;
    }
}
