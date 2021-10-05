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

public class QuestionPensMetricoyGeomeLevel2 extends AppCompatActivity {

    public static ArrayList<ModelClass> QuestionPensMetricoyGeomeLevel2;

    CountDownTimer countDownTimer;
    int timerValue = 600; //contador de tiempo 10 min ==  600000 mils
    RoundedHorizontalProgressBar progressBar;
    List<ModelClass> allQuestionsList; //importamos la lista de preguntas en caso de que este en otra vista
    ModelClass modelClass;
    int index = 0;
    //    ImageView imagen;
    TextView preguntas, optionA, optionB, optionC, optionD;
    CardView ResponseA, ResponseB, ResponseC, ResponseD;
    int correctCount = 0;
    int incorrectCount = 0;
    String nombreNivel = "nivel 2 de Pensamiento Métrico y Geométrico. ";
    LinearLayout nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pens_metricoy_geome_level2);

        QuestionPensMetricoyGeomeLevel2 = new ArrayList<>();

//        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("test8", "a","b","c","d", "ANS")); ejemplo de orden de preguntas y respuestas

//        QuestionPensNumyVariLevel1.add(new ModelClass("¿Por cuántos triángulos equiláteros está compuesta la siguiente figura?",
//                "9","10","12","13", "13"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("Si en un rectángulo se aumenta la longitud de uno de sus lados en 100 %, su área",
                "Aumenta en un 50 %","Se duplica","No cambia","Aumenta en 100 unidades", "Se duplica"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("A cuántos cm equivalen 2,5 metros",
                "25 cm","2500 cm","250 cm","0,25 cm", "250 cm"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("En un triángulo rectángulo la medida de la hipotenusa es de 5 cm, mientras que uno de sus catetos mide 3 cm, ¿cuál es la medida del otro cateto?",
                "2 cm","3 cm","4 cm","5 cm", "4 cm"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("El largo de un rectángulo es el doble del ancho.  El perímetro es de 60cm. ¿Cuáles son las medidas del largo y del ancho del rectángulo?",
                "7 y 14 cm","12 y 24 cm","8 y 16 cm","10 y 20 cm", "10 y 20 cm"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("Un albañil tiene que embaldosar un salón de forma cuadrada que tiene de lado 8 metros; si en cada metro cuadrado se utilizan 16 baldosas, ¿Cuántas baldosas son necesarias para cubrir todo el salón?",
                "1024 baldosas","924 baldosas","1124 baldosas","1000 baldosas", "1024 baldosas"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("Si un cuadrado, un triángulo y un rectángulo tiene cada uno 24 cm de perímetro.  Se puede afirmar que:",
                "Todas las figuras tienen igual área","El cuadrado es la figura que tiene mayor área","El triángulo es la figura que tiene mayor área","El rectángulo es la figura que tiene mayor área", "El cuadrado es la figura que tiene mayor área"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("La suma de los ángulos internos de un cuadrilátero es igual a:",
                "360º","180º","270º","100º", "360º"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("Un trapezoide es un cuadrilátero que tiene:",
                "Dos pares de lados paralelos","Un par de lados paralelos","Ningún par de lados paralelos","Un ángulo recto", "Ningún par de lados paralelos"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("El punto donde se cortan las tres bisectrices de los ángulos internos de un triángulo se denomina: ",
                "Cincuncentro","Incentro","Baricentro","Ortocentro", "Incentro"));

        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("La suma de los ángulos exteriores de un triángulo cualquiera es igual a:",
                "90º","180º","270º","360º", "360º"));

//        QuestionPensMetricoyGeomeLevel2.add(new ModelClass("Si 2 pintores tardan 6 días en pintar un muro. ¿Cuánto tardarán 3 pintores en realizar el mismo trabajo?", R.drawable.acercade,
//                "3","4","5","1", "4"));



        Hooks();

        allQuestionsList = QuestionPensMetricoyGeomeLevel2;
        Collections.shuffle(allQuestionsList);
        modelClass = QuestionPensMetricoyGeomeLevel2.get(index);

        ResponseA.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseB.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseC.setBackgroundColor(getResources().getColor(R.color.white));
        ResponseD.setBackgroundColor(getResources().getColor(R.color.white));

        nextBtn.setClickable(false);

        countDownTimer = new CountDownTimer(600000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                //Metodo para reducir el contador y mostrar barra
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                //mostrar dialogo
//                Dialog dialog = new Dialog(QuestionPensMetricoyGeomeLevel1.this, R.style.Dialogo);
                Dialog dialog = new Dialog(QuestionPensMetricoyGeomeLevel2.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogo);

                // al presionar intetar de nuevo redirige hacia .
                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionPensMetricoyGeomeLevel2.this, SubmenuRazonamiento.class);
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
        timerValue = 600;
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
                modelClass = QuestionPensMetricoyGeomeLevel2.get(index);
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
                    modelClass = QuestionPensMetricoyGeomeLevel2.get(index);
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
        Intent intent = new Intent(QuestionPensMetricoyGeomeLevel2.this, WonActivity.class);
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
        ResponseA.setBackgroundColor(getResources().getColor(R.color.LightGrey));
        ResponseB.setBackgroundColor(getResources().getColor(R.color.LightGrey));
        ResponseC.setBackgroundColor(getResources().getColor(R.color.LightGrey));
        ResponseD.setBackgroundColor(getResources().getColor(R.color.LightGrey));
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
            if(index < QuestionPensMetricoyGeomeLevel2.size() - 1){
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

            if(index < QuestionPensMetricoyGeomeLevel2.size() - 1){
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

            if(index < QuestionPensMetricoyGeomeLevel2.size() - 1){
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

            if(index < QuestionPensMetricoyGeomeLevel2.size() - 1){
                correct_Questions(ResponseD);
            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseD);
        }
    }

    public void irMetricoyGeometrica(View view){
        Intent i = new Intent(QuestionPensMetricoyGeomeLevel2.this, SubmenuPensMetricoyGeome.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}