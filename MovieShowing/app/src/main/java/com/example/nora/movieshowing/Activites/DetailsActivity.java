package com.example.nora.movieshowing.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nora.movieshowing.Model.Movie;
import com.example.nora.movieshowing.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Movie detail =getIntent().getParcelableExtra("Details");



    }




}
