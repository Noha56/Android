package com.example.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateViewSection extends AppCompatActivity {

    TextView rateCount,showRating;
    EditText review;
    Button submit;
    RatingBar ratingBar;
    float rateValue;String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_view_section);

        rateCount=findViewById(R.id.ratingCount);
        ratingBar=findViewById(R.id.ratingBar);
        review=findViewById(R.id.review);
        submit=findViewById(R.id.submitBtn);
        showRating=findViewById(R.id.showRating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rateValue=ratingBar.getRating();
                if(rateValue<=1 && rateValue>0){
                    rateCount.setText("Bad"+rateValue+"/5");
                }else if(rateValue<=2 && rateValue>1){
                    rateCount.setText("Ok"+rateValue+"/5");
                }else if(rateValue<=3 && rateValue>2){
                    rateCount.setText("Good"+rateValue+"/5");
                }else if(rateValue<=4 && rateValue>3){
                    rateCount.setText("Very Good"+rateValue+"/5");
                }else if(rateValue<=5 && rateValue>4){
                    rateCount.setText("Best"+rateValue+"/5");
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp=rateCount.getText().toString();
                showRating.setText("Your Rating: \n"+temp+"\n"+review.getText());
                review.setText("");
                ratingBar.setRating(0);
                rateCount.setText("");

            }
        });
    }
}