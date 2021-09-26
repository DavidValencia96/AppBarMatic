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

public class QuestionPensEducaFinancieraLevel2 extends AppCompatActivity {

    public static ArrayList<ModelClass> QuestionPensEducaFinancieraLevel2;

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
    String nombreNivel = "nivel 2 de Educación Financiera. ";
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pens_educa_financiera_level2);

        QuestionPensEducaFinancieraLevel2 = new ArrayList<>();

//        QuestionPensEducaFinancieraLevel2.add(new ModelClass("test8", "a","b","c","d", "ANS")); ejemplo de orden de preguntas y respuestas

//        QuestionPensEducaFinancieraLevel2.add(new ModelClass("¿Por cuántos triángulos equiláteros está compuesta la siguiente figura?",
//                "9","10","12","13", "13"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test1",
                "$110.000","$106.000","$101.000","$112.000", "$106.000"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test2",
                "$1’650.000","$1’700.000","$1’800.000","$1’950.000", "$1’650.000"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test3",
                "$230.000","$300.000","$250.000","$200.000", "$250.000"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test4",
                "$800.000","$850.000","$980.000","$900.000", "$900.000"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test5",
                "$2’760.000","$2’500.000","$2’450.000","$2’100.000", "$2’760.000"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test6",
                "$2’240.000","$2’380.000","$2’400.000","$2’530.000", "$2’240.000"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test7",
                "$100.000","$200.000","$300.000","$400.000", "$200.000"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test8",
                "La relación entre la rentabilidad y el capital en una economía","La posibilidad de invertir y generar más ingresos ","El crecimiento generalizado y continuo de los precios de los bienes y servicios de una economía.","La variación de los costos de los productos en una economía", "El crecimiento generalizado y continuo de los precios de los bienes y servicios de una economía."));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test9",
                "$59.000","$114.000","$52.000","$54.000", "$59.000"));

        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Test10",
                "10%","5%","15%","20%", "5%"));

//        QuestionPensEducaFinancieraLevel2.add(new ModelClass("Si 2 pintores tardan 6 días en pintar un muro. ¿Cuánto tardarán 3 pintores en realizar el mismo trabajo?", R.drawable.acercade,
//                "3","4","5","1", "4"));



        Hooks();

        allQuestionsList = QuestionPensEducaFinancieraLevel2;
        Collections.shuffle(allQuestionsList);
        modelClass = QuestionPensEducaFinancieraLevel2.get(index);

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
                Dialog dialog = new Dialog(QuestionPensEducaFinancieraLevel2.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogo);

                // al presionar intetar de nuevo redirige hacia .
                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionPensEducaFinancieraLevel2.this, SubmenuRazonamiento.class);
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
                modelClass = QuestionPensEducaFinancieraLevel2.get(index);
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
                    modelClass = QuestionPensEducaFinancieraLevel2.get(index);
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
        Intent intent = new Intent(QuestionPensEducaFinancieraLevel2.this, WonActivity.class);
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
            if(index < QuestionPensEducaFinancieraLevel2.size() - 1){
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

            if(index < QuestionPensEducaFinancieraLevel2.size() - 1){
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

            if(index < QuestionPensEducaFinancieraLevel2.size() - 1){
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

            if(index < QuestionPensEducaFinancieraLevel2.size() - 1){
                correct_Questions(ResponseD);
            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseD);
        }
    }

    public void irEdufinanciera(View view){
        Intent i = new Intent(QuestionPensEducaFinancieraLevel2.this, SubmenuPensEducaFinanciera.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}