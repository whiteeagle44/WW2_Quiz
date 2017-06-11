package com.example.android.ww2quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.ww2quiz.R.id.chart;

/**
 * Created by User on 02.06.2017.
 */

public class ResultsActivity extends AppCompatActivity {

    private int mAllAnswers;
    private int mCorrectAnswers;
    private int mIncorrectAnswers;

    private static final String TAG = "ResultsActivity";

    private TextView scoreRating;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        final PieChart pieChart = (PieChart) findViewById(chart);

        Intent mIntent = getIntent();
        mAllAnswers = mIntent.getIntExtra("allAnswers", 10);
        mCorrectAnswers = mIntent.getIntExtra("correctAnswers", 4);
        mIncorrectAnswers = mAllAnswers - mCorrectAnswers;

        scoreRating = (TextView) findViewById(R.id.score_rating);

        switch (mCorrectAnswers) {
            case 1:
                setScoreRating("One point?! Seriously?");
                break;

            case 2:
                setScoreRating("Two points! Shame on you, young padawan!");
                break;

            case 3:
                setScoreRating("Triple kill! But seven wrong!");
                break;

            case 4:
                setScoreRating("Four points. That's more than half wrong!");
                break;

            case 5:
                setScoreRating("Five points is a rather average result");
                break;

            case 6:
                setScoreRating("Call yourself a winner! More than half correct!");
                break;

            case 7:
                setScoreRating("Seven points is a good score!");
                break;

            case 8:
                setScoreRating("Eight correct! Great score!");
                break;

            case 9:
                setScoreRating("Excellent score! 9 answers correct.");
                break;

            case 10:
                setScoreRating("Wow! You know everything!");
                break;

            default:
                setScoreRating("What's wrong?");
        }

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(mCorrectAnswers));
        entries.add(new PieEntry(mIncorrectAnswers));
        PieDataSet setComp1 = new PieDataSet(entries, "Correct answers");
        // sets colors for the dataset, resolution of the resource name to a "real" color is done internally
        setComp1.setColors(new int[] { R.color.white, R.color.transparent, }, ResultsActivity.this);
        setComp1.setDrawValues(false);
        Legend l= pieChart.getLegend();
        l.setEnabled(false);
        PieData data = new PieData(setComp1);
        pieChart.setCenterText(mCorrectAnswers + " / " + mAllAnswers);
        pieChart.setCenterTextSize(60f);
        pieChart.setCenterTextTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL));
        pieChart.setCenterTextColor(getResources().getColor(R.color.white));
        pieChart.setHoleColor(getResources().getColor(R.color.transparent));
        pieChart.setHoleRadius(80f);
        pieChart.setData(data);
        pieChart.setDescription(null);
        pieChart.setDrawSliceText(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.invalidate(); // refresh

    }

    public void setScoreRating(String scoreRatingText) {
        scoreRating.setText(scoreRatingText);
    }


}
