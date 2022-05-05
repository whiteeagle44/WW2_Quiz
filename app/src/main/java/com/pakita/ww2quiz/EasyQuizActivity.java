package com.pakita.ww2quiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Vibrator;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class EasyQuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private ImageView mHeaderImage;
    private ProgressBar mProgressBar;

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final String KEY_INDEX2 = "index2";
    private static final String KEY_INDEX3 = "index3";
    private static final String KEY_INDEX4 = "index4";
    private static final String KEY_INDEX5 = "index5";

    private boolean mIsTrueButtonGreen;
    private boolean mIsTrueButtonRed;
    private boolean mIsFalseButtonGreen;
    private boolean mIsFalseButtonRed;
    private int mCorrectAnswerColor;
    private int mIncorrectAnswerColor;

    private int mAllAnswers;
    private int mCorrectAnswers;

    private Question[] mQuestionBankEasy = new Question[]
            {
                    new Question(R.string.question_one_easy, false, R.drawable.ww2_easy1),
                    new Question(R.string.question_two_easy, false, R.drawable.ww2_easy2),
                    new Question(R.string.question_three_easy, true, R.drawable.ww2_easy3),
                    new Question(R.string.question_four_easy, false, R.drawable.ww2_easy4),
                    new Question(R.string.question_five_easy, true, R.drawable.ww2_easy5),
                    new Question(R.string.question_one_easy, true, R.drawable.ww2_easy6),
                    new Question(R.string.question_two_easy, false, R.drawable.ww2_easy7),
                    new Question(R.string.question_three_easy, false, R.drawable.ww2_easy8),
                    new Question(R.string.question_four_easy, true, R.drawable.ww2_easy9),
                    new Question(R.string.question_five_easy, true, R.drawable.ww2_easy10),
            };


    private int mCurrentIndex = 0;
    private String PREFS_NAME = "WW2";
    private boolean isSaved;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mCorrectAnswerColor = getResources().getColor(R.color.correctAnswerButton);
        mIncorrectAnswerColor = getResources().getColor(R.color.incorrectAnswerButton);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);

            if (savedInstanceState.getBoolean(KEY_INDEX2, false)) {
                mTrueButton.getBackground().setColorFilter(mCorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
            }

            if (savedInstanceState.getBoolean(KEY_INDEX3, false)) {
                mTrueButton.getBackground().setColorFilter(mIncorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
            }

            if (savedInstanceState.getBoolean(KEY_INDEX4, false)) {
                mFalseButton.getBackground().setColorFilter(mCorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
            }

            if (savedInstanceState.getBoolean(KEY_INDEX5, false)) {
                mFalseButton.getBackground().setColorFilter(mIncorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
            }
        }

        mQuestionTextView = findViewById(R.id.question_text_view);
        updateQuestion();

        mAllAnswers = mQuestionBankEasy.length;

        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setProgress(mCurrentIndex);
        mProgressBar.setMax(10);

        mHeaderImage = findViewById(R.id.header_image);

        ImageButton mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(v -> {
            isSaved = false;
            if (mCurrentIndex >= mQuestionBankEasy.length - 1) {
                Intent mIntent = new Intent(EasyQuizActivity.this, ResultsActivity.class);
                mIntent.putExtra("allAnswers", mAllAnswers);
                mIntent.putExtra("correctAnswers", mCorrectAnswers);
                startActivity(mIntent);
            } else {
                mCurrentIndex += 1;
                updateQuestion();
                mProgressBar.setProgress(mCurrentIndex);
                mTrueButton.getBackground().clearColorFilter();
                mFalseButton.getBackground().clearColorFilter();
            }
            Log.i(TAG, "Current index" + mCurrentIndex);
        });

        ImageButton mPrevButton = findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(v -> {
            if (mCurrentIndex != 0) {
                mCurrentIndex -= 1;
                updateQuestion();
                mProgressBar.setProgress(mCurrentIndex);
                mTrueButton.getBackground().clearColorFilter();
                mFalseButton.getBackground().clearColorFilter();
            } else {
                Intent mIntent = new Intent(EasyQuizActivity.this, MainActivity.class);
                startActivity(mIntent);
            }
        });


        mTrueButton.setOnClickListener(v -> checkAnswer(true));

        mFalseButton.setOnClickListener(v -> checkAnswer(false));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "OnSaveInstanceState");
        outState.putInt(KEY_INDEX, mCurrentIndex);
        outState.putBoolean(KEY_INDEX2, mIsTrueButtonGreen);
        outState.putBoolean(KEY_INDEX3, mIsTrueButtonRed);
        outState.putBoolean(KEY_INDEX4, mIsFalseButtonGreen);
        outState.putBoolean(KEY_INDEX5, mIsFalseButtonRed);

    }

    private void updateQuestion() {
        int question = mQuestionBankEasy[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        mHeaderImage = findViewById(R.id.header_image);
        int picResId = mQuestionBankEasy[mCurrentIndex].getPicResId();
        mHeaderImage.setImageResource(picResId);
    }


    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBankEasy[mCurrentIndex].isAnswerTrue();
        boolean answerRated = mQuestionBankEasy[mCurrentIndex].isAnswerRated();

        if (!answerRated) {

            if (userPressedTrue == answerIsTrue) {
                if (userPressedTrue) {
                    mTrueButton.getBackground().setColorFilter(mCorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
                    mIsTrueButtonGreen = true;
                    mCorrectAnswers += 1;
                    mQuestionBankEasy[mCurrentIndex].setAnswerRated(true);
                } else {
                    mFalseButton.getBackground().setColorFilter(mCorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
                    mIsFalseButtonGreen = true;
                    mCorrectAnswers += 1;
                    mQuestionBankEasy[mCurrentIndex].setAnswerRated(true);

                }
            } else {
                if (userPressedTrue) {
                    mTrueButton.getBackground().setColorFilter(mIncorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
                    mFalseButton.getBackground().setColorFilter(mCorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
                    mIsTrueButtonRed = true;
                    mIsFalseButtonGreen = true;
                    mQuestionBankEasy[mCurrentIndex].setAnswerRated(true);


                    Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
                    // Vibrate for 150 milliseconds
                    if (v != null)
                        v.vibrate(150);
                } else {
                    mFalseButton.getBackground().setColorFilter(mIncorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
                    mTrueButton.getBackground().setColorFilter(mCorrectAnswerColor, PorterDuff.Mode.MULTIPLY);
                    mIsFalseButtonRed = true;
                    mIsTrueButtonGreen = true;
                    mQuestionBankEasy[mCurrentIndex].setAnswerRated(true);


                    Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
                    // Vibrate for 150 milliseconds
                    if (v != null)
                        v.vibrate(100);
                }
            }
        } else {
            Toast.makeText(this, "You've already submitted an answer.", Toast.LENGTH_SHORT).show();
        }
    }


}
