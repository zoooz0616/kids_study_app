package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

    }
    public void korean_btn(View v) {
        Intent intent = new Intent(ChooseActivity.this, GameActivity.class);
        startActivity(intent);
    }

    public void math_btn(View v) {
        Intent intent = new Intent(ChooseActivity.this, MGameActivity.class);
        startActivity(intent);
    }

}
