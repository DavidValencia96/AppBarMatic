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

public class QuestionPensNumyVariLevel1 extends AppCompatActivity {

    public static ArrayList<ModelClass> QuestionPensNumyVariLevel1;

    CountDownTimer countDownTimer;
    int timerValue = 600; //contador de tiempo 5 min == 50000milsg
    RoundedHorizontalProgressBar progressBar;
    List<ModelClass> allQuestionsList; //importamos la lista de preguntas en caso de que este en otra vista
    ModelClass modelClass;
    int index = 0;
    //    ImageView imagen;
    TextView preguntas, optionA, optionB, optionC, optionD;
    CardView ResponseA, ResponseB, ResponseC, ResponseD;
    int correctCount = 0;
    int incorrectCount = 0;
    String nombreNivel = "nivel 1 de Pensamiento Numérico y Variacional. ";
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pens_numy_vari_level1);

        QuestionPensNumyVariLevel1 = new ArrayList<>();

//        listOfflineQuestion2.add(new ModelClass("test8", "a","b","c","d", "ANS")); ejemplo de orden de preguntas y respuestas

//        QuestionPensNumyVariLevel1.add(new ModelClass("¿Por cuántos triángulos equiláteros está compuesta la siguiente figura?",
//                "9","10","12","13", "13"));

        QuestionPensNumyVariLevel1.add(new ModelClass("En el número 43.678, el número 3 representa:",
                "La cifra de las unidades","La cifra de las decenas de mil","La cifra de las unidades de mil","La cifra de las decenas", "La cifra de las unidades de mil"));

        QuestionPensNumyVariLevel1.add(new ModelClass("Al sumar los números: 65,4 + 22 + 0,24 + 157,06 se obtiene:",
                "244,7","24,47","2447","2,447", "244,7"));

        QuestionPensNumyVariLevel1.add(new ModelClass("La profe Suyis va a realizar una rifa entre los estudiantes del grado sexto, ella ha determinado que el estudiante ganador será quien tenga el número que se obtiene al calcular el mínimo común múltiplo entre 18, 24 y 48. Según esas condiciones el ganador será el número:",
                "120","144","210","150", "144"));

        QuestionPensNumyVariLevel1.add(new ModelClass("Juana compró una pizza que estaba dividida en 12 porciones, si Miguel se comió las tres cuartas partes de la pizza, ¿Cuántas porciones le quedaron a Juana?",
                "3 porciones","4 porciones","2 porciones","5 porciones", "3 porciones"));

        QuestionPensNumyVariLevel1.add(new ModelClass("Si se sabe que 162 litros de vino cuestan $324.000, ¿Cuál es el valor de 285 litros de la misma calidad?",
                "$650.000","$410.000","$740.000","$570.000", "$570.000"));

        QuestionPensNumyVariLevel1.add(new ModelClass("El profe Rosemberg quiere comprarse una camisa nueva y va a un almacén donde se encuentran en ofertas, si la camisa que quiere cuesta $70.000 y tiene un descuento del 25%, ¿cuánto le están descontando?",
                "$17.500","$18.000","$16.450","$19.000", "$17.500"));

        QuestionPensNumyVariLevel1.add(new ModelClass("El profe Rosemberg quiere comprarse una camisa nueva y va a un almacén donde se encuentran en ofertas, si la camisa que quiere cuesta $70.000 y tiene un descuento del 25%, ¿cuánto debe pagar por la camisa?",
                "$52.500","$52.000","$53.550","$51.000", "$52.500"));

        QuestionPensNumyVariLevel1.add(new ModelClass("Un estudiante del grado noveno tiene en su finca vacas y caballos que sumados son 40. Si tiene 22 caballos, ¿qué porcentaje representa el número de vacas?",
                "Las vacas representan el 20%","Las vacas representan el 40%","Las vacas representan el 15%","Las vacas representan el 45%", "Las vacas representan el 45%"));

        QuestionPensNumyVariLevel1.add(new ModelClass("María vive en una finca a 40 km del colegio, si ella viaja en moto y se tarda 15 minutos en recorrer 10 km, ¿cuánto tiempo requiere para hacer el recorrido desde la finca hasta el colegio?",
                "45 minutos","30 minutos","1 hora","1 hora y 30 minutos", "1 hora"));

        QuestionPensNumyVariLevel1.add(new ModelClass(" La suma de tres números es 44. El primero es el triple del segundo y 12 más que el tercero. ¿Cuáles son los números?",
                "23, 7 y 14","24, 8 y 12","26, 7 y 11","25, 9 y 10", "24, 8 y 12"));

//        QuestionPensNumyVariLevel1.add(new ModelClass("Si 2 pintores tardan 6 días en pintar un muro. ¿Cuánto tardarán 3 pintores en realizar el mismo trabajo?", R.drawable.acercade,
//                "3","4","5","1", "4"));



        Hooks();

        allQuestionsList = QuestionPensNumyVariLevel1;
        Collections.shuffle(allQuestionsList);
        modelClass = QuestionPensNumyVariLevel1.get(index);

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
//                Dialog dialog = new Dialog(QuestionRazonamientoLevel1.this, R.style.Dialogo);
                Dialog dialog = new Dialog(QuestionPensNumyVariLevel1.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogo);

                // al presionar intetar de nuevo redirige hacia .
                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionPensNumyVariLevel1.this, SubmenuRazonamiento.class);
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
                modelClass = QuestionPensNumyVariLevel1.get(index);
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
                    modelClass = QuestionPensNumyVariLevel1.get(index);
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
        Intent intent = new Intent(QuestionPensNumyVariLevel1.this, WonActivity.class);
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
            if(index < QuestionPensNumyVariLevel1.size() - 1){
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

            if(index < QuestionPensNumyVariLevel1.size() - 1){
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

            if(index < QuestionPensNumyVariLevel1.size() - 1){
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

            if(index < QuestionPensNumyVariLevel1.size() - 1){
                correct_Questions(ResponseD);
            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseD);
        }
    }

    public void irNumYVariacional(View view){
        Intent i = new Intent(QuestionPensNumyVariLevel1.this, SubmenuPensNumyVari.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}