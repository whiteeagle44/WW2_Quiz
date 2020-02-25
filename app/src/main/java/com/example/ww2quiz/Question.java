package com.example.ww2quiz;

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;
    private int mPicResId;

    private int mAllAnswers;
    private int mCorrectAnswers;

    private boolean mAnswerRated;

    public Question(int allAnswers,int correctAnswers) {
        mAllAnswers = allAnswers;
        mCorrectAnswers = correctAnswers;
    }

    Question(int textResId, boolean answerTrue, int picResId) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mPicResId = picResId;

    }

    boolean isAnswerRated() {
        return mAnswerRated;
    }

    void setAnswerRated(boolean answerRated) {
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

    int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }


    int getPicResId() {
        return mPicResId;
    }

    public void setPicResId(int picResId) {
        mPicResId = picResId;
    }
}