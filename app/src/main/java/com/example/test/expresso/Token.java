package com.example.test.expresso;

/**
 * Created by isurangaperera on 2/21/17.
 */
public class Token {
    private boolean classification;
    private String[] featureVector;

    public void setFeatureVector(String tweet) {
        featureVector = tweet.split(" ");
    }

    public void setClassification(boolean classification) {
        this.classification = classification;
    }
}
