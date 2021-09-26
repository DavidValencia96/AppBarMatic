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

public class QuestionPensMetricoyGeomeLevel1 extends AppCompatActivity {

    public static ArrayList<ModelClass> QuestionPensMetricoyGeomeLevel1;

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
    String nombreNivel = "nivel 1 de Pensamiento Métrico y Geométrico. ";
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pens_metricoy_geome_level1);

        QuestionPensMetricoyGeomeLevel1 = new ArrayList<>();

//        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("test8", "a","b","c","d", "ANS")); ejemplo de orden de preguntas y respuestas

//        QuestionPensNumyVariLevel1.add(new ModelClass("¿Por cuántos triángulos equiláteros está compuesta la siguiente figura?",
//                "9","10","12","13", "13"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Al trazar la bisectriz de un ángulo se obtienen:",
                "Un ángulo doble que el otro","Dos ángulos suplementarios","Dos ángulos complementarios","Dos ángulos iguales", "Dos ángulos iguales"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Cuando las agujas del reloj marcan las 3:00 pm, forman un ángulo:",
                "Agudo","Recto","Obtuso","Llano", "Recto"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Si en un triángulo rectángulo, la medida de uno de los ángulos agudos es 38 grados, ¿Cuál es la medida del tercer ángulo?",
                "52 grados","38 grados","90 grados","60 grados", "52 grados"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Al triángulo que tiene los tres lados desiguales se le llama:",
                "Rectángulo","Isósceles","Escaleno","Equilátero", "Escaleno"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Al segmento trazado desde el vértice de un triángulo al punto medio del lado opuesto se denomina:",
                "Mediana","Bisectriz","Mediatriz","Altura", "Mediana"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Al segmento perpendicular trazado desde el vértice de un triángulo al lado opuesto o a su prolongación se le denomina:",
                "Mediana","Bisectriz","Mediatriz","Altura", "Altura"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Al cuadrilátero que tiene sus lados opuestos iguales y paralelos se le denomina:",
                "Trapecio","Paralelogramo","Trapezoide","Cubo", "Paralelogramo"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Dados dos polígonos con la misma área y perímetro, se puede afirmar que:",
                "Tienen siempre la misma forma","Tienen siempre el mismo número de lados","Pueden no ser iguales","Tienen siempre la misma medida", "Pueden no ser iguales"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("Cuántos lados tiene un pentadecágono",
                "15","10","5","20", "15"));

        QuestionPensMetricoyGeomeLevel1.add(new ModelClass("A la recta perpendicular al segmento que pasa por su punto medio se le denomina:",
                "Bisectriz","Incentro","Directriz","Mediatriz", "Mediatriz"));

//        QuestionPensNumyVariLevel1.add(new ModelClass("Si 2 pintores tardan 6 días en pintar un muro. ¿Cuánto tardarán 3 pintores en realizar el mismo trabajo?", R.drawable.acercade,
//                "3","4","5","1", "4"));



        Hooks();

        allQuestionsList = QuestionPensMetricoyGeomeLevel1;
        Collections.shuffle(allQuestionsList);
        modelClass = QuestionPensMetricoyGeomeLevel1.get(index);

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
//                Dialog dialog = new Dialog(QuestionPensMetricoyGeomeLevel1.this, R.style.Dialogo);
                Dialog dialog = new Dialog(QuestionPensMetricoyGeomeLevel1.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogo);

                // al presionar intetar de nuevo redirige hacia .
                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionPensMetricoyGeomeLevel1.this, SubmenuRazonamiento.class);
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
                modelClass = QuestionPensMetricoyGeomeLevel1.get(index);
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
                    modelClass = QuestionPensMetricoyGeomeLevel1.get(index);
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
        Intent intent = new Intent(QuestionPensMetricoyGeomeLevel1.this, WonActivity.class);
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
            if(index < QuestionPensMetricoyGeomeLevel1.size() - 1){
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

            if(index < QuestionPensMetricoyGeomeLevel1.size() - 1){
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

            if(index < QuestionPensMetricoyGeomeLevel1.size() - 1){
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

            if(index < QuestionPensMetricoyGeomeLevel1.size() - 1){
                correct_Questions(ResponseD);
            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseD);
        }
    }

    public void irMetricoyGeometrica(View view){
        Intent i = new Intent(QuestionPensMetricoyGeomeLevel1.this, SubmenuPensMetricoyGeome.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}