package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btnclicked(View v) {
        Intent intent = new Intent(this, ChooseActivity.class);
        startActivity(intent);
    }

    public void btnclicked2(View v) {
        Intent intent = new Intent(this, GamehActivity.class);
        startActivity(intent);
    }
}
