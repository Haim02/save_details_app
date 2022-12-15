package com.example.myshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_NAME = "com.example.mysharedpref.shared_file";
    public static final String USER_NAME = "com.example.mysharedpref.shared_name";
    public static final String USER_AGE = "com.example.mysharedpref.shared_age";
    public static final String USER_EMAIL = "com.example.mysharedpref.shared_email";
    EditText name;
    EditText age;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextNmae);
        age = findViewById(R.id.editTextAge);
        email = findViewById(R.id.editTextEmail);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_NAME, 0);
        String nameStr = sharedPreferences.getString(USER_NAME, "");
        String emailStr = sharedPreferences.getString(USER_EMAIL, "");
        int ageInt = sharedPreferences.getInt(USER_AGE, 0);

        name.setText(nameStr);
        email.setText(emailStr);
        age.setText(ageInt);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String nameStr = name.getText().toString();
        int ageInt = Integer.parseInt( age.getText().toString() );
        String emailStr = email.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_NAME, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(USER_NAME, nameStr);
        editor.putString(USER_EMAIL, nameStr);
        editor.putInt(USER_AGE, ageInt);

        editor.commit();
    }

    public void send(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
}