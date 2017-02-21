package com.example.test.expresso;

import com.android.twittermanager.TweetManager;
import com.android.twittermanager.TwitterIO;

import java.util.ArrayList;
import twitter4j.Status;

/**
 * Created by isurangaperera on 2/21/17.
 */
public class StatusProcessor {
    private ArrayList<Status> tweetList;

    public StatusProcessor(String userName) {
        this.getUserStatus(userName);
    }

    public StatusProcessor() {

    }

    public void getUserStatus(String userName ) {
        TwitterIO tManager = TweetManager.getInstance();
        this.tweetList = tManager.getTweets(userName);
    }
}
