package com.example.hdehaan93.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hdehaan93 on 2/10/15.
 */
public class CheatActivity extends Activity{

    private TextView mAnswerTextView;
    private Button mShowAnswer;
    public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private boolean mCheated;
    private TextView mVersionTextView;

    private static final String mCHEATED = "cheater";


    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);


        mVersionTextView= (TextView)findViewById(R.id.APIlevel);
        //mVersionTextView.setText(R.string.API_level+ Build.VERSION.SDK_INT);//+ Build.VERSION.SDK_INT
         mVersionTextView.setText("API Level " + Build.VERSION.SDK_INT);//+


        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        mAnswerTextView = (TextView)findViewById((R.id.answerTextView));
        if(savedInstanceState!=null){
            mCheated=savedInstanceState.getBoolean(mCHEATED,false);
        }
        setAnswerShownResult(mCheated);

        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v)
            {
                if(mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }
                else{
                    mAnswerTextView.setText(R.string.false_button);
                }
                mCheated=true;
                setAnswerShownResult(mCheated);
               // mCheated=true;
            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
       // Log.i(TAG, "onSavedInstanceState");
        savedInstanceState.putBoolean(mCHEATED,mCheated);
    }
}
