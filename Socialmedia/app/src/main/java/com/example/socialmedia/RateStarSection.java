package com.example.socialmedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RateStarSection extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fbAdd;
    JSONArray jsonArray = new JSONArray();
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_star_section);

        recyclerView = findViewById(R.id.recyclerView);
        fbAdd = findViewById(R.id.fb_add);

        recyclerView.setLayoutManager(new GridLayoutManager(
                this, 3
        ));

        adapter = new MainAdapter(this, jsonArray);
        recyclerView.setAdapter(adapter);

        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(RateStarSection.this);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT
                ));

                dialog.setContentView(R.layout.dialog_main);

                dialog.show();

                RatingBar ratingBar = dialog.findViewById(R.id.rating_bar);
                TextView tvRating = dialog.findViewById(R.id.tv_rating);
                Button btSubmit = dialog.findViewById(R.id.btn_submit);

                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        tvRating.setText(String.format("(%s)", v));
                    }
                });
                btSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String sRating = String.valueOf(ratingBar.getRating());

                        try {
                            jsonArray.put(new JSONObject().put("rating", sRating));
                            recyclerView.setAdapter(adapter);
                            dialog.dismiss();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        });
    }
}