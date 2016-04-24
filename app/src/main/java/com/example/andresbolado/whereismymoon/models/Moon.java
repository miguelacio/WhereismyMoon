package com.example.andresbolado.whereismymoon.models;

/**
 * Created by jesusflores on 23/04/16.
 */
public class Moon {
    private String phase;
    private String date;
    private String time;
    private String error;


    public Moon() {
    }

    public String getPhase() {
        return phase;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
