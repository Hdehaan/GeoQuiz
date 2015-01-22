package com.example.hdehaan93.geoquiz;

/**
 * Created by hdehaan93 on 1/20/15.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question, boolean trueQuestion){
        mQuestion=question;
        mTrueQuestion=trueQuestion;
    }

    public int getmQuestion() {
        return mQuestion;
    }
    public boolean getmTrueQuestion() {
        return mTrueQuestion;
    }
    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setmTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }
}
