package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

//import static com.example.appgrado.MainActivity.listOfflineQuestion;
//import static com.example.appgrado.QuestionRazonamientoLevel1.QuestionRazonamientoLevel1;

public class DashboardActivity extends AppCompatActivity {

//    CountDownTimer countDownTimer;
//    int timerValue = 20;
//    RoundedHorizontalProgressBar progressBar;
//    private Object CountDownTimer;
//    List<ModelClass> allQuestionsList; //importamos la lista de preguntas
//    ModelClass modelClass;
//    int index = 0;
//    TextView preguntas, optionA, optionB, optionC, optionD;
//    CardView ResponseA, ResponseB, ResponseC, ResponseD;
//    int correctCount = 0;
//    int incorrectCount = 0;
//    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //progressBar = findViewById(R.id.quiz_timer);

//        Hooks();

//        allQuestionsList = listOfflineQuestion2;
//        Collections.shuffle(allQuestionsList);
//        modelClass = listOfflineQuestion2.get(index);
//
//        nextBtn.setClickable(false);
//        setAllData();


//        CountDownTimer = new CountDownTimer(20000, 1000){
//            @Override
//            public void onTick( long millisUntilFinished) {
                //Metodo para reducir el contador y mostrar barra
//                timerValue = timerValue-1;
//                progressBar.setProgress(timerValue);
            }

//            @Override
//            public void onFinish() {
//                mostrar dialogo
//                Dialog dialog = new Dialog(DashboardActivity.this,R.style.Dialogo);
//                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
//                dialog.setContentView(R.layout.time_out_dialogo);
//
//                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
//                        startActivity(intent);
//                    }
//                });
//
//                dialog.show();
//
//            }
//        }.start();
//    }
//
//    private void setAllData() {
//        preguntas.setText(modelClass.getInitialQuestion());
//        optionA.setText(modelClass.getResponseA());
//        optionB.setText(modelClass.getResponseB());
//        optionC.setText(modelClass.getResponseC());
//        optionD.setText(modelClass.getResponseD());
//
//    }
//
//    private void Hooks() {
//        progressBar = findViewById(R.id.quiz_timer);
//        preguntas = findViewById(R.id.card_preguntas);
//        optionA = findViewById(R.id.card_optionA);
//        optionB = findViewById(R.id.card_optionB);
//        optionC = findViewById(R.id.card_optionC);
//        optionD = findViewById(R.id.card_optionD);
//
//        ResponseA = findViewById(R.id.cardA);
//        ResponseB = findViewById(R.id.cardB);
//        ResponseC = findViewById(R.id.cardC);
//        ResponseD = findViewById(R.id.cardD);
//
//        nextBtn = findViewById(R.id.nextBtn);
//    }
//
//    public void correct_Questions(CardView cardView){
//
//        cardView.setBackgroundColor(getResources().getColor(R.color.green));
//
//        nextBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                correctCount++;
//                index++;
//                modelClass = listOfflineQuestion2.get(index);
//                setAllData();
//            }
//        });
//    }
//
//    public void incorrect_Questions(CardView ResponseA) {
//
//        ResponseA.setCardBackgroundColor(getResources().getColor(R.color.red));
//
//        nextBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                incorrectCount++;
//                if(index<allQuestionsList.size()-1){
//                    index++;
//                    modelClass = listOfflineQuestion2.get(index);
//                    setAllData();
//                    resetColor();
//                }else{
//                    GameWon();
//                }
//            }
//        });
//    }
//
//    private void GameWon() {
//        Intent intent = new Intent(DashboardActivity.this, WonActivity.class);
//        intent.putExtra("correcta",correctCount);
//        intent.putExtra("incorrecta",incorrectCount);
//        startActivity(intent);
//    }
//
//    public void enableButton(){
//        ResponseA.setClickable(true);
//        ResponseB.setClickable(true);
//        ResponseC.setClickable(true);
//        ResponseD.setClickable(true);
//    }
//
//    public void disableButton(){
//        ResponseA.setClickable(false);
//        ResponseB.setClickable(false);
//        ResponseC.setClickable(false);
//        ResponseD.setClickable(false);
//    }
//
//    public void resetColor(){
//        ResponseA.setBackgroundColor(getResources().getColor(R.color.white));
//        ResponseB.setBackgroundColor(getResources().getColor(R.color.white));
//        ResponseC.setBackgroundColor(getResources().getColor(R.color.white));
//        ResponseD.setBackgroundColor(getResources().getColor(R.color.white));
//    }
//
//    public void OptionAClick(View view) {
//        disableButton();
//        nextBtn.setClickable(true);
//        if(modelClass.getResponseA().equals(modelClass.getResponseANS())){
//            ResponseA.setCardBackgroundColor(getResources().getColor(R.color.green));
//
//            if(index<listOfflineQuestion2.size()-1){
//                correct_Questions(ResponseA);
////               index++;
////               modelClass = listOfflineQuestion.get(index);
////                setAllData();
////                resetColor();
//            } else{
//                GameWon();
//            }
//        }else{
//            incorrect_Questions(ResponseA);
//        }
//    }
//
//    public void OptionAClickB(View view) {
//        disableButton();
//        nextBtn.setClickable(true);
//        if(modelClass.getResponseB().equals(modelClass.getResponseANS())){
//            ResponseB.setCardBackgroundColor(getResources().getColor(R.color.green));
//
//            if(index<listOfflineQuestion2.size()-1){
//                correct_Questions(ResponseB);
////                index++;
////                modelClass = listOfflineQuestion.get(index);
////                setAllData();
////                resetColor();
//            } else{
//                GameWon();
//            }
//        }else{
//            incorrect_Questions(ResponseB);
//        }
//    }
//
//    public void OptionAClickC(View view) {
//        disableButton();
//        nextBtn.setClickable(true);
//        if(modelClass.getResponseC().equals(modelClass.getResponseANS())){
//            ResponseC.setCardBackgroundColor(getResources().getColor(R.color.green));
//
//            if(index<listOfflineQuestion2.size()-1){
//                correct_Questions(ResponseC);
////                index++;
////                modelClass = listOfflineQuestion.get(index);
////                setAllData();
////                resetColor();
//            } else{
//                GameWon();
//            }
//        }else{
//            incorrect_Questions(ResponseC);
//        }
//    }
//
//    public void OptionAClickD(View view) {
//        disableButton();
//        nextBtn.setClickable(true);
//        if(modelClass.getResponseD().equals(modelClass.getResponseANS())){
//            ResponseD.setCardBackgroundColor(getResources().getColor(R.color.green));
//
//            if(index<listOfflineQuestion2.size()-1){
//                correct_Questions(ResponseD);
////                index++;
////                modelClass = listOfflineQuestion.get(index);
////                setAllData();
////                resetColor();
////                correct_Questions();
//            } else{
//                GameWon();
//            }
//        }else{
//            incorrect_Questions(ResponseD);
//        }
//    }

}

