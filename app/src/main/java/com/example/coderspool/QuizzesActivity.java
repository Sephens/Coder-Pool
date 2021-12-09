package com.example.coderspool;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;

public class QuizzesActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView questionTxt, questionNumberTxt,countTimer;
    private RadioButton option1,option2,option3,option4;
    private List<Questions> questionsList;
    private int questionNum;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);

        questionTxt = findViewById(R.id.quizzesMainTextView);
        questionNumberTxt = findViewById(R.id.quizzesNumberTextView);
        countTimer = findViewById(R.id.counter);

        option1 = findViewById(R.id.optionBtn1);
        option2 = findViewById(R.id.optionBtn2);
        option3 = findViewById(R.id.optionBtn3);
        option4 = findViewById(R.id.optionBtn4);

        Typeface tp = ResourcesCompat.getFont(this,R.font.font3);
        option1.setTypeface(tp);
        option2.setTypeface(tp);
        option3.setTypeface(tp);
        option4.setTypeface(tp);
        questionNumberTxt.setTypeface(tp);
        questionTxt.setTypeface(tp);
        countTimer.setTypeface(tp);


        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        getQuestionsList();
    }

    private void getQuestionsList(){

        questionsList = new ArrayList<>();
        questionsList.add(new Questions("What is the Capital City of Kenya","Kisumu","Kitale","Kampala","Nairobi",3));
        questionsList.add(new Questions("How many counties are there in Kenya?","27","47","37","57",1));
        questionsList.add(new Questions("When did Kenya Got independence","2001","1945","1963","1962",2));
        questionsList.add(new Questions("How many presidents have kenya had since independence?","3","4","6","8",1));
        questionsList.add(new Questions("Which of the following group colonized Kenya","British","French","Portuguese","Swazi",0));
        questionsList.add(new Questions("Which of the following is not a neighbouring country to kenya","Uganda","Tanzania","Sudan","Libya",3));
        questionsList.add(new Questions("How many sets make a dozen","6","13","12","10",2));
        questionsList.add(new Questions("How many days are there in a leap year","364","365⅛","366","360",2));
        questionsList.add(new Questions("Which of the following is not a mammal","Whale","Bat","Chimpanzee","Hen",3));
        questionsList.add(new Questions("The process through which plants make their own food is called","Transpiration","Osmosis","Photosynthesis","Evolution",2));
        questionsList.add(new Questions("Plants make their own food from the following except","Sun Light","Carbon Oxide","Stomata","Oxygen",3));
        questionsList.add(new Questions("Energy is measured in ?","Kg","Tons","Joules","newtons",2));
        questionsList.add(new Questions("Force can be defined a?","Exerting of pressure","Push or Pull","None of the answers","Don't Know",1));
        questionsList.add(new Questions("How many years make a decade?","10","100","1","1000",0));
        questionsList.add(new Questions("How many years make a century?","10","1","100","none of the answers",3));

        setQuestion();

    }

    private void setQuestion(){
        countTimer.setText(String.valueOf(20));
        questionTxt.setText(questionsList.get(0).getQuestion());
        option1.setText(questionsList.get(0).getOptionA());
        option2.setText(questionsList.get(0).getOptionB());
        option3.setText(questionsList.get(0).getOptionC());
        option4.setText(questionsList.get(0).getOptionD());

        questionNumberTxt.setText(String.valueOf(1)+"/"+String.valueOf(questionsList.size()));

        startCountTimer();

        questionNum = 0;
    }

    private void startCountTimer(){
         countDownTimer  = new CountDownTimer(22000,1000) {
            @Override
            public void onTick(long l) {

                if (l<20000)
                countTimer.setText(String.valueOf(l/1000));

            }

            @Override
            public void onFinish() {

                changeQuestion();
            }
        };

        countDownTimer.start();
    }
    @Override
    public void onClick(View view) {

        int selectedOption = 0;

        switch (view.getId()){
            case R.id.optionBtn1:
                selectedOption = 1;
                break;
            case R.id.optionBtn2:
                selectedOption = 2;
                break;
            case R.id.optionBtn3:
                selectedOption =3;
                break;
            case R.id.optionBtn4:
                selectedOption = 4;
                break;
            default:
        }

        countDownTimer.cancel();
        checkAnswer(selectedOption,view);

    }

    private void checkAnswer(int selectedOption,View view){

        if(selectedOption == questionsList.get(questionNum).correctAnswer){
            // Right answer
            ((RadioButton)view).setTextColor(ColorStateList.valueOf(Color.GREEN));

        }
        else {
            //Wrong answer
            ((RadioButton)view).setTextColor(ColorStateList.valueOf(Color.RED));
            ((RadioButton)view).setChecked(false);
            switch (questionsList.get(questionNum).getCorrectAnswer()){
                case 1:
                    option1.setTextColor(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setTextColor(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setTextColor(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setTextColor(ColorStateList.valueOf(Color.GREEN));
                    break;


            }
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                changeQuestion();
            }
        },2000);



    }

    private void changeQuestion(){
        if (questionNum < questionsList.size()-1){

            questionNum ++;
            playAnimation(questionTxt,0,0);
            playAnimation(option1,0,1);
            playAnimation(option2,0,2);
            playAnimation(option3,0,3);
            playAnimation(option4,0,4);

            questionNumberTxt.setText(String.valueOf(questionNum+1)+"/"+String.valueOf(questionsList.size()));
            countTimer.setText(String.valueOf(20));
            startCountTimer();
        }

        else {
            //Display the Score (Go to the score Activity)
            Intent intent = new Intent(QuizzesActivity.this, Scores.class);
            startActivity(intent);
            QuizzesActivity.this.finish();
        }
    }

    private void playAnimation(View view, final  int value,int viewNum){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).
        setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                if (value == 0){

                    switch (viewNum){
                        case 0:
                            ((TextView)view).setText(questionsList.get(questionNum).getQuestion());
                            break;
                        case 1:
                            ((Button)view).setText(questionsList.get(questionNum).getOptionA());
                            break;
                        case 2:
                            ((Button)view).setText(questionsList.get(questionNum).getOptionB());
                            break;
                        case 3:
                            ((Button)view).setText(questionsList.get(questionNum).getOptionC());
                            break;
                        case 4:
                            ((Button)view).setText(questionsList.get(questionNum).getOptionD());
                            break;
                    }

                    if (viewNum!=0){
                        ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF3700B3")));
                    }

                    playAnimation(view,1,viewNum);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}