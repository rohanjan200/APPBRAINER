package com.example.myapplication2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {
Button button;
TextView sumView ;
TextView resultView;
TextView pointsView;
Button button0 ;
Button button1 ;
Button button2 ;
Button button3 ;
Button playagain;
ImageView imageView;
TextView timer ;
RelativeLayout relativeLayout;
EditText playerName;
TextView instruction;
TextView gamename;

// array for answers declare
ArrayList<Integer> answers = new ArrayList<Integer>();
int locationOfCorrectAnswer;
int score= 0;
int numberOfQuestions = 0;
    int opt =0;
    int incorrectAnswer;

    public void playAgain(View view) {

        score = 0;
        numberOfQuestions =0;
        relativeLayout.setVisibility(View.VISIBLE);
        timer.setText("30s");
        pointsView.setText("0/0");
        resultView.setText("");
        playagain.setVisibility(View.INVISIBLE);
        generateQuestion();
              //the countdown from 30s with interval of 1 s
        new CountDownTimer(9100, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+ "s");
                resultView.setText("WELCOME "+playerName.getText());
            }

            @Override
            public void onFinish() {
                playagain.setVisibility(View.VISIBLE);
                timer.setText("0s");
                resultView.setText(playerName.getText()+""+" YOU GOT "+Integer.toString(score)+" POINTS"+" \n"  + " YOU HAVE ANSWERED " + Integer.toString(opt)+" out of "+ Integer.toString(numberOfQuestions)+" CORRECT ANSWERS");
              //  pointsView.setText();
                relativeLayout.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    public void chooseAnswer(View view) {
        if (view.getTag().toString().equals(Integer.toString((locationOfCorrectAnswer)))) {

            score++;
            opt= score;
            resultView.setText("Correct");

        }
        else {
            resultView.setText("WRONG");
            score--;
        }
        numberOfQuestions++;

        pointsView.setText( Integer.toString(score)+" POINTS");

      //  pointsView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generateQuestion();

    }
 public void generateQuestion(){
     Random rand = new Random();

     int a =rand.nextInt(39);
     int b =rand.nextInt(29);


     sumView.setText(Integer.toString(a) + "+"+ Integer.toString(b));
     // option generator
     locationOfCorrectAnswer = rand.nextInt(4);
     answers.clear();

     for(int i=0; i<4; i++)
     {
         if(i == locationOfCorrectAnswer){
             answers.add(a+b);
         }else{
             incorrectAnswer = rand.nextInt(68);
             while (incorrectAnswer == a+b){
                 incorrectAnswer = rand.nextInt(68);
             }
             answers.add(incorrectAnswer);
         }

     }
     button0.setText(Integer.toString(answers.get(0)));
     button1.setText(Integer.toString(answers.get(1)));
     button2.setText(Integer.toString(answers.get(2)));
     button3.setText(Integer.toString(answers.get(3)));
 }

    public void Start(View view) {
        button.setVisibility(View.INVISIBLE);
        relativeLayout.setVisibility(View.VISIBLE);
        playerName.setVisibility(View.INVISIBLE);
        resultView.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playagain));
        instruction.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerName = (EditText)findViewById(R.id.playerName);
        button = (Button) findViewById(R.id.button);
        sumView = (TextView) findViewById(R.id.sumView);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        resultView = (TextView) findViewById(R.id.resultView);
        pointsView = (TextView) findViewById(R.id.pointsView);
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        timer = (TextView) findViewById(R.id.timer);
        playagain = (Button)findViewById(R.id.playagain);
        imageView =(ImageView)findViewById(R.id.imageView);
        instruction = (TextView)findViewById(R.id.instruction);
        gamename = (TextView)findViewById(R.id.gamename);


        imageView.animate().rotation(3600f).scaleYBy(1.5f).scaleXBy(1.5f).setDuration(5000);
        relativeLayout.setVisibility(View.INVISIBLE);
        resultView.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.VISIBLE);
        generateQuestion();

    }

    public void imageBtn(View view) {
      //  imageView.animate().rotation(3600f).setDuration(5000);
        imageView.setVisibility(View.INVISIBLE);
        button.setVisibility(View.VISIBLE);
        gamename.setVisibility(View.INVISIBLE);
        playerName.setVisibility(View.VISIBLE);
    }
}