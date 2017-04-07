package com.example.android.healthquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.healthquizapp.R.id.q6a1;
import static com.example.android.healthquizapp.R.id.q6a2;
import static com.example.android.healthquizapp.R.id.q6a3;
import static com.example.android.healthquizapp.R.id.q6a4;
import static com.example.android.healthquizapp.R.id.resultNum;
import static com.example.android.healthquizapp.R.id.results;

public class quiz extends AppCompatActivity {
    boolean q1, q2, q3, q4, q5, q6, q7;
    String questionSevenAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void onRadioButtonClicked1(View View) {
        RadioButton cb1_1 = (RadioButton) findViewById(R.id.q1_1);
        if (cb1_1.isChecked()) {
            q1 = true;
        } else
            q1 = false;
    }

    public void onRadioButtonClicked2(View View) {
        RadioButton cb2_2 = (RadioButton) findViewById(R.id.q2_2);
        if (cb2_2.isChecked()) {
            q2 = true;
        } else
            q2 = false;
    }

    public void onRadioButtonClicked3(View View) {
        RadioButton cb3_2 = (RadioButton) findViewById(R.id.q3_2);
        if (cb3_2.isChecked()) {
            q3 = true;
        } else
            q3 = false;
    }

    public void onRadioButtonClicked4(View View) {
        RadioButton cb4_2 = (RadioButton) findViewById(R.id.q4_1);
        if (cb4_2.isChecked()) {
            q4 = true;
        } else
            q4 = false;
    }

    public void onRadioButtonClicked5(View View) {
        RadioButton cb5_2 = (RadioButton) findViewById(R.id.q5_2);
        if (cb5_2.isChecked()) {
            q5 = true;
        } else
            q5 = false;
    }

    public void done(View view) {
        TextView results = (TextView) findViewById(R.id.results);
        CheckBox q6a1 = (CheckBox) findViewById(R.id.q6a1);
        CheckBox q6a2 = (CheckBox) findViewById(R.id.q6a2);
        CheckBox q6a3 = (CheckBox) findViewById(R.id.q6a3);
        CheckBox q6a4 = (CheckBox) findViewById(R.id.q6a4);
        EditText questionSevenEditText = (EditText) findViewById(R.id.questionSevenAnswer);
        TextView messagenum = (TextView) findViewById(R.id.resultNum);
        questionSevenAnswer = questionSevenEditText.getText().toString();

//      Checks if the right answers are selected in question 6
        if (q6a1.isChecked() && q6a2.isChecked() && q6a4.isChecked())
            q6 = true;

//      Checks if the wrong answer is also selected for question 6
        if (q6a3.isChecked())
            q6 = false;

        if (questionSevenAnswer.equalsIgnoreCase("dehydrated"))
            q7 = true;

        int resultNum = 0;
        if (q1 == true)
            resultNum++;
        if (q2 == true)
            resultNum++;
        if (q3 == true)
            resultNum++;
        if (q4 == true)
            resultNum++;
        if (q5 == true)
            resultNum++;
        if (q6 == true)
            resultNum++;
        if (q7 == true)
            resultNum++;
        String messagenumtext = resultNum + "/7";

        messagenum.setText(messagenumtext);
        String message = getString(R.string.q1r)+ " " + q1 + "\n"
                + getString(R.string.q2r) + " " + q2 + "\n"
                + getString(R.string.q3r) + " " + q3 + "\n"
                + getString(R.string.q4r) + " " + q4 + "\n"
                + getString(R.string.q5r) + " " + q5 + "\n"
                + getString(R.string.q6r) + " " + q6 + "\n"
                + getString(R.string.q7r) + " " + q7;
        results.setText(message);
        results.setVisibility(View.VISIBLE);
        String messageToast;
        if (resultNum == 7)
            messageToast = getString(R.string.congratulations);
        else if (resultNum < 7 && resultNum > 3)
            messageToast = getString(R.string.prettyGood);
        else if (resultNum == 3)
            messageToast = getString(R.string.notTerrible);
        else
            messageToast = getString(R.string.terribleScore);
        String userName = getIntent().getStringExtra("userName");
        messageToast = messageToast + " " + userName + "!\nYour score is : " + messagenumtext + "!";
        Toast.makeText(getApplicationContext(), messageToast,
                Toast.LENGTH_LONG).show();
    }

    public void reset(View View) {
        TextView results = (TextView) findViewById(R.id.results);
        recreate();
        RadioGroup rd1 = (RadioGroup) findViewById(R.id.radiogroup1);
        rd1.clearCheck();
        RadioGroup rd2 = (RadioGroup) findViewById(R.id.radiogroup2);
        rd2.clearCheck();
        RadioGroup rd3 = (RadioGroup) findViewById(R.id.radiogroup3);
        rd3.clearCheck();
        RadioGroup rd4 = (RadioGroup) findViewById(R.id.radiogroup4);
        rd4.clearCheck();
        RadioGroup rd5 = (RadioGroup) findViewById(R.id.radiogroup5);
        rd5.clearCheck();
        CheckBox q6a1 = (CheckBox) findViewById(R.id.q6a1);
        q6a1.setChecked(false);
        CheckBox q6a2 = (CheckBox) findViewById(R.id.q6a2);
        q6a2.setChecked(false);
        CheckBox q6a3 = (CheckBox) findViewById(R.id.q6a3);
        q6a3.setChecked(false);
        CheckBox q6a4 = (CheckBox) findViewById(R.id.q6a4);
        q6a4.setChecked(false);
        EditText questionSevenEditText = (EditText) findViewById(R.id.questionSevenAnswer);
        questionSevenEditText.setText("");
        results.setVisibility(View.INVISIBLE);
    }
}
