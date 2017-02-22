package com.example.test.expresso;

import com.android.twittermanager.TweetManager;
import com.android.twittermanager.TwitterIO;

import java.util.ArrayList;
import java.util.Arrays;

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

    private ArrayList<Token> process()throws NoTweetsException {
        if(tweetList == null)
            throw new NoTweetsException("No Tweets Available");
        ArrayList<Token> tokenList = new ArrayList<Token>();
        for(Status tweet : tweetList) {
            String str = tweet.getText().toLowerCase();
            str = str.replaceAll("((www\\.[^\\s]+)|(https?://[^\\s]+))", "URL")
                    .replaceAll("@[^\\s]+", "AT_USER")
                    .replaceAll("#(\\S+)", "$1").trim();
            Token newToken = new Token();
            newToken.setFeatureVector(str);
            tokenList.add(newToken);
        }
        return tokenList;
    }
}
