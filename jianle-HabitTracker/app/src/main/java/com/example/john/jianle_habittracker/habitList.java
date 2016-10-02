package com.example.john.jianle_habittracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2016-09-30.
 */

public class habitList {
    private List<habitItem> tweets = new ArrayList<habitItem>();

    public void add(habitItem tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet(habitItem tweet) {
        return tweets.contains(tweet);
    }

    public habitItem getTweet(int i) {
        return tweets.get(i);
    }

    public void remove(habitItem tweet) {
        tweets.remove(tweet);
    }
}
