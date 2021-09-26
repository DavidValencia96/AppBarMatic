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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionPensAleatorioLevel1 extends AppCompatActivity {

    public static ArrayList<ModelClass> QuestionPensAleatorioLevel1;

    CountDownTimer countDownTimer;
    int timerValue = 20; //contador de tiempo 5 min == 50000milsg
    RoundedHorizontalProgressBar progressBar;
    List<ModelClass> allQuestionsList; //importamos la lista de preguntas en caso de que este en otra vista
    ModelClass modelClass;
    int index = 0;
    //    ImageView imagen;
    TextView preguntas, optionA, optionB, optionC, optionD;
    CardView ResponseA, ResponseB, ResponseC, ResponseD;
    int correctCount = 0;
    int incorrectCount = 0;
    String nombreNivel = "nivel 1 de Pensamiento Aleatorio. ";
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pens_aleatorio_level1);

        QuestionPensAleatorioLevel1 = new ArrayList<>();

//        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("test8", "a","b","c","d", "ANS")); ejemplo de orden de preguntas y respuestas

//        QuestionPensNumyVariLevel1.add(new ModelClass("¿Por cuántos triángulos equiláteros está compuesta la siguiente figura?",
//                "9","10","12","13", "13"));

        QuestionPensAleatorioLevel1.add(new ModelClass("Los siguientes datos corresponden a las edades de un grupo de estudiantes del grado cuarto: 9, 9,8,9,8,7,9,10,8,9,10,10,8. En el conjunto de datos la moda está dada por:",
                "9","8","10","7", "9"));

        QuestionPensAleatorioLevel1.add(new ModelClass("Con los dígitos 1,2,3,4,5,6 y 7 ¿cuántos números de tres cifras se pueden formar si no se repiten los dígitos?",
                "210","90","196","150", "210"));

        QuestionPensAleatorioLevel1.add(new ModelClass("Alejandra tiene cuatro faldas y seis blusas. ¿De cuántas maneras diferentes se puede vestir?",
                "12","36","24","48", "24"));

        QuestionPensAleatorioLevel1.add(new ModelClass("En una caja hay siete pelotas azules y cuatro blancas. Se va a tomar una de ellas al azar, ¿Qué probabilidad hay de que sea azul?",
                "4/11","11","7","7/11", "7/11"));

        QuestionPensAleatorioLevel1.add(new ModelClass("Se tiene en una urna 10 bolas enumeradas del 0 al 9. ¿Cuál es la probabilidad de sacar un 3?",
                "3/10","1/9","1/10","10", "1/10"));

        QuestionPensAleatorioLevel1.add(new ModelClass("Cuántas ensaladas diferentes se pueden preparar con tomate, cebolla, aguacate, pepino, lechuga. Si cada plato debe tener 3 ingredientes.",
                "10","15","20","25", "10"));

        QuestionPensAleatorioLevel1.add(new ModelClass("En una caja hay 30 bolas blancas y 40 bolas negras. La probabilidad de sacar una bola negra es:",
                "4/3","3/4","4/7","5/7", "4/7"));

        QuestionPensAleatorioLevel1.add(new ModelClass("Si 4 fichas blancas se cambian por una azul, 3 azules se cambian por una Verde y 4 verdes por una roja. ¿Con 144 fichas blancas para cuántas verdes alcanzan?",
                "6","12","4","3", "12"));

        QuestionPensAleatorioLevel1.add(new ModelClass("Si una ficha roja equivale a 3 azules y cada azul equivale a 2 blancas, ¿a cuánto equivaldrán 120 blancas?",
                "20 rojas","20 azules","15 azules","10 rojas", "20 rojas"));

        QuestionPensAleatorioLevel1.add(new ModelClass("Los balones de fútbol y de baloncesto de una escuela deportiva suman 40 en total. Se sabe que hay 2 balones de baloncesto por cada 3 balones de fútbol. ¿Cuántos hay de cada uno?",
                "5 de baloncesto y 35 de fútbol","16 de baloncesto y 24 de fútbol","24 de baloncesto y 16 de fútbol","80 de baloncesto y 120 de fútbol", "16 de baloncesto y 24 de fútbol"));

//        add line blank

//        QuestionPensAleatorioLevel1.add(new ModelClass("Si 2 pintores tardan 6 días en pintar un muro. ¿Cuánto tardarán 3 pintores en realizar el mismo trabajo?", R.drawable.acercade,
//                "3","4","5","1", "4"));



        Hooks();

        allQuestionsList = QuestionPensAleatorioLevel1;
        Collections.shuffle(allQuestionsList);
        modelClass = QuestionPensAleatorioLevel1.get(index);

        ResponseA.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseB.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseC.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseD.setBackgroundColor(getResources().getColor(R.color.white));

        nextBtn.setClickable(false);

        countDownTimer = new CountDownTimer(20000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                //Metodo para reducir el contador y mostrar barra
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                //mostrar dialogo
//                Dialog dialog = new Dialog(QuestionPensAleatorioLevel1.this, R.style.Dialogo);
                Dialog dialog = new Dialog(QuestionPensAleatorioLevel1.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogo);

                // al presionar intetar de nuevo redirige hacia .
                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionPensAleatorioLevel1.this, SubmenuRazonamiento.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();
        setAllData();
    }

    private void setAllData() {
        preguntas.setText(modelClass.getInitialQuestion());
//        imagen.setImageResource(modelClass.getImagen());
        optionA.setText(modelClass.getResponseA());
        optionB.setText(modelClass.getResponseB());
        optionC.setText(modelClass.getResponseC());
        optionD.setText(modelClass.getResponseD());
        timerValue = 20;
        countDownTimer.cancel();
        countDownTimer.start();
    }

    private void Hooks() {
        progressBar = findViewById(R.id.quiz_timer);
        preguntas = findViewById(R.id.card_preguntas);
//        imagen = findViewById(R.id.imagen1);
        optionA = findViewById(R.id.card_optionA);
        optionB = findViewById(R.id.card_optionB);
        optionC = findViewById(R.id.card_optionC);
        optionD = findViewById(R.id.card_optionD);

        ResponseA = findViewById(R.id.cardA);
        ResponseB = findViewById(R.id.cardB);
        ResponseC = findViewById(R.id.cardC);
        ResponseD = findViewById(R.id.cardD);

        nextBtn = findViewById(R.id.nextBtn);
    }

    public void correct_Questions(CardView cardView){

        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                modelClass = QuestionPensAleatorioLevel1.get(index);
                resetColor();
                setAllData();
                enableButton();
            }
        });
    }

    public void incorrect_Questions(CardView ResponseA) {

        ResponseA.setBackgroundColor(getResources().getColor(R.color.red));
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrectCount++;
                if(index < allQuestionsList.size() - 1){
                    index++;
                    modelClass = QuestionPensAleatorioLevel1.get(index);
                    resetColor();
                    setAllData();
                    enableButton();
                }else{
                    GameWon();
                }
            }
        });
    }

    private void GameWon() {
        Intent intent = new Intent(QuestionPensAleatorioLevel1.this, WonActivity.class);
        intent.putExtra("correcta", correctCount);
        intent.putExtra("incorrecta", incorrectCount);
        intent.putExtra("nombre_nivel", nombreNivel);
        startActivity(intent);
    }

    public void enableButton(){
        ResponseA.setClickable(true);
        ResponseB.setClickable(true);
        ResponseC.setClickable(true);
        ResponseD.setClickable(true);
    }

    public void disableButton(){
        ResponseA.setClickable(false);
        ResponseB.setClickable(false);
        ResponseC.setClickable(false);
        ResponseD.setClickable(false);
    }

    public void resetColor(){
        ResponseA.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseB.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseC.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptionClickA(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelClass.getResponseA().equals(modelClass.getResponseANS())){
            ResponseA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index < QuestionPensAleatorioLevel1.size() - 1){
                correct_Questions(ResponseA);

            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseA);
        }
    }

    public void OptionClickB(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelClass.getResponseB().equals(modelClass.getResponseANS())){
            ResponseB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index < QuestionPensAleatorioLevel1.size() - 1){
                correct_Questions(ResponseB);

            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseB);
        }
    }

    public void OptionClickC(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelClass.getResponseC().equals(modelClass.getResponseANS())){
            ResponseC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index < QuestionPensAleatorioLevel1.size() - 1){
                correct_Questions(ResponseC);

            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseC);
        }
    }

    public void OptionClickD(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(modelClass.getResponseD().equals(modelClass.getResponseANS())){
            ResponseD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index < QuestionPensAleatorioLevel1.size() - 1){
                correct_Questions(ResponseD);
            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseD);
        }
    }

    public void irPensamiento(View view){
        Intent i = new Intent(QuestionPensAleatorioLevel1.this, SubmenuPensAleatorio.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}