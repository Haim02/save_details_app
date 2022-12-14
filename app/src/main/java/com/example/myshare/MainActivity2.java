package com.example.myshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);

        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.SHARED_NAME, 0);
        textView.setText( sharedPreferences.getString(MainActivity.USER_EMAIL, ""));
        textView.setText( sharedPreferences.getString(MainActivity.USER_EMAIL, ""));
    }
}