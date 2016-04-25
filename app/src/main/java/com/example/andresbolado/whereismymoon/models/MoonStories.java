package com.example.andresbolado.whereismymoon.models;

/**
 * Created by caffeinelabs05 on 4/24/16.
 */
public class MoonStories {
    String storyName;
    String storyText;
    String storyImage;

    public String getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(String storyImage) {
        this.storyImage = storyImage;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public MoonStories(String storyName, String storyText) {
        this.storyName = storyName;
        this.storyText = storyText;
    }


}
