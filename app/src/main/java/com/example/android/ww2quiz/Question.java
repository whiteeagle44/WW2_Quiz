package com.example.android.ww2quiz;

/**
 * Created by User on 27.05.2017.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;
    private int mPicResId;

    private int mAllAnswers;
    private int mCorrectAnswers;

    private boolean mAnswerRated;


    public Question() { }

    public Question(int allAnswers,int correctAnswers) {
        mAllAnswers = allAnswers;
        mCorrectAnswers = correctAnswers;

    }

    public Question(int textResId, boolean answerTrue, int picResId) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mPicResId = picResId;

    }

    public boolean isAnswerRated() {
        return mAnswerRated;
    }

    public void setAnswerRated(boolean answerRated) {
        mAnswerRated = answerRated;
    }

    public int getAllAnswers() {
        return mAllAnswers;
    }

    public void setAllAnswers(int allAnswers) {
        mAllAnswers = allAnswers;
    }

    public int getCorrectAnswers() {
        return mCorrectAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        mCorrectAnswers = correctAnswers;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }


    public int getPicResId() {
        return mPicResId;
    }

    public void setPicResId(int picResId) {
        mPicResId = picResId;
    }
}