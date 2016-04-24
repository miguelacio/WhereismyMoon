package com.example.andresbolado.whereismymoon.models;

/**
 * Created by jesusflores on 24/04/16.
 */
public class QuestionsObject {
    String cuestion;
    String answer;

    public QuestionsObject(String cuestion, String answer) {
        this.cuestion = cuestion;
        this.answer = answer;
    }

    public String getCuestion() {
        return cuestion;
    }

    public void setCuestion(String cuestion) {
        this.cuestion = cuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        answer = answer;
    }


}
