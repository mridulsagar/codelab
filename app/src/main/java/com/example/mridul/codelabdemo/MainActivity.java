package com.example.mridul.codelabdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvQuestion;
    EditText etAnswer;
    Random randomNumber;

    private int number_1;
    private int number_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuestion = findViewById(R.id.tvQuestion);
        etAnswer = findViewById(R.id.etAnswer);

        // construct the randomNumber object
        randomNumber = new Random();

        createQuestion();
    }

    private void createQuestion() {
        number_1 = randomNumber.nextInt(100);
        number_2 = randomNumber.nextInt(100);

        tvQuestion.setText(number_1 + " + " + number_2 + " = ?");
    }

    public void checkAnswer(View view) {
        String answerStr = etAnswer.getText().toString();

        if(!answerStr.equals("")){
            int answer = Integer.parseInt(answerStr);

            if(number_1+number_2 == answer){
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Wrong Answer\n correct answer: "+ (number_1+number_2), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Please enter your answer first.", Toast.LENGTH_SHORT).show();
        }
    }

    public void generateNewQuestion(View view) {
        createQuestion();
    }
}
