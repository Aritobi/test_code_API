package com.example.test_code_api;

import static com.example.test_code_api.MainActivity.EXTRA_CREATOR;

import static com.example.test_code_api.MainActivity.EXTRA_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);


        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText("Resumé: "+ creatorName);


    }
}