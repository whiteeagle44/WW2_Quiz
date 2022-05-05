package com.pakita.ww2quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import static com.pakita.ww2quiz.R.id.chart;

public class ResultsActivity extends AppCompatActivity {

    private TextView scoreRating;
    private ImageButton mNextButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        final PieChart pieChart = findViewById(chart);

        Intent mIntent = getIntent();
        int mAllAnswers = mIntent.getIntExtra("allAnswers", 10);
        int mCorrectAnswers = mIntent.getIntExtra("correctAnswers", 4);
        int mIncorrectAnswers = mAllAnswers - mCorrectAnswers;

        scoreRating = findViewById(R.id.score_rating);

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(mIntent);
            }
        });

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
        pieChart.setDrawEntryLabels(false);
        pieChart.invalidate(); // refresh

    }

    public void setScoreRating(String scoreRatingText) {
        scoreRating.setText(scoreRatingText);
    }
}