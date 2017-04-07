package com.example.android.healthquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Makes sure that the keyboard is not automatically showing when the app is opened
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_main);
    }

    /*
    This method changes the activity to the quiz when the start button is pressed, and passes the
    name from the EditText field to the new activity.
     */
    public void startQuiz(View view) {
        EditText nameField = (EditText) findViewById(R.id.nameField);
        String userName = nameField.getText().toString();
        Intent intent = new Intent("com.example.android.healthquizapp.quiz");
        intent.putExtra("userName", userName);
        startActivity(intent);
    }
}
