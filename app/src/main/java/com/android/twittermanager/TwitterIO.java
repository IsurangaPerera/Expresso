package com.android.twittermanager;

import java.util.ArrayList;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by isurangaperera on 2/21/17.
 */
public abstract class TwitterIO {

    public static final String TWITTER_CONSUMER_KEY = "Map2qDKcHGIfYmCOIzWgC1A7W";
    public static final String TWITTER_CONSUMER_SECRET = "5oeYORsYkcu9vkR5gO5BAr1kqz1djqowwJJXt82I7YMZzMrrcd";
    public static final String ACCESS_TOKEN = "833858636900421637-vJIZr55gkepGJTp4EKMM1YIm3EZGwen";
    public static final String ACCESS_TOKEN_SECRET = "h7P8Apl9ixiMvFXKsajPiCSddy3yZ4sj6NBkzI27u8MzX";

    protected Twitter twitter;

    public Twitter configureTwitter() {

        ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        configBuilder.setOAuthConsumerKey(TWITTER_CONSUMER_KEY);
        configBuilder.setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET);
        configBuilder.setOAuthAccessToken(ACCESS_TOKEN);
        configBuilder.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

        this.twitter = new TwitterFactory(configBuilder.build()).getInstance();

        return twitter;
    }
    public abstract ArrayList<Status> getTweets(String userName);
}
