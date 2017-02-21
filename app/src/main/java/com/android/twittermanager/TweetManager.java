package com.android.twittermanager;

import java.util.ArrayList;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * Created by isurangaperera on 2/21/17.
 */
public class TweetManager  extends TwitterIO{
    private static TweetManager singleton;

    private TweetManager() {
        super();
    }

    public static TweetManager getInstance() {
        return (singleton == null)? new TweetManager() : singleton;
    }

    @Override
    public ArrayList<Status> getTweets(String userName) {
        ArrayList<Status> tweetList = new ArrayList<>();
        int pageno = 1;
        while(true) {
            try {
                int size = tweetList.size();
                Paging page = new Paging(pageno++, 100);
                tweetList.addAll(twitter.getUserTimeline(userName, page));
                if (tweetList.size() == size)
                    break;
            }
            catch(TwitterException e) {

                e.printStackTrace();
            }
        }
        return tweetList;
    }
}
