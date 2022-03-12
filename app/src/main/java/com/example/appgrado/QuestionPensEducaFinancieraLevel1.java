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

public class QuestionPensEducaFinancieraLevel1 extends AppCompatActivity {

    public static ArrayList<ModelClass> QuestionPensEducaFinancieraLevel1;

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
    String nombreNivel = "nivel 1 de Educación Financiera. ";
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pens_educa_financiera_level1);

        QuestionPensEducaFinancieraLevel1 = new ArrayList<>();

//        QuestionPensEducaFinancieraLevel1.add(new ModelClass("test8", "a","b","c","d", "ANS")); ejemplo de orden de preguntas y respuestas

//        QuestionPensEducaFinancieraLevel1.add(new ModelClass("¿Por cuántos triángulos equiláteros está compuesta la siguiente figura?",
//                "9","10","12","13", "13"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass("Juan realiza un préstamo en una entidad bancaria donde le cobran un interés del 1% mensual sobre el capital solicitado. Si el préstamo fue por un monto de $100.000, ¿Cuánto dinero debe parar al cabo de 6 meses?",
                "$110.000","$106.000","$101.000","$112.000", "$106.000"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass("María trabaja en una empresa donde tiene un salario básico de $ 1’500.000, pero le pagan unas horas extras, si por cada hora extra le pagan el 1% del sueldo y trabajo 10 horas en un mes, ¿cuánto será el devengado total?",
                "$1’650.000","$1’700.000","$1’800.000","$1’950.000", "$1’650.000"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass("Para realizar una fiesta se cuenta con un presupuesto de $1’000.000, de este monto el 50% será invertido en la comida y el 50% del resto en licor y el sobrante en otros gastos. ¿Cuánto será invertido en otros gastos?",
                "$230.000","$300.000","$250.000","$200.000", "$250.000"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass("Susana y Miguel deciden hacer un ahorro juntos, Miguel aporta $ 500.000 y Susana la mitad de lo que aporta Miguel. Si por el ahorro el banco les paga el 20% en un año ¿Cuánto tendrán ahorrado al cabo del primer año?",
                "$800.000","$850.000","$980.000","$900.000", "$900.000"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass("Samuel trabaja en una empresa donde devenga $3’000.000 mensuales, si le hacen una deducción del 8% para el pago de la salud y la pensión, ¿Cuánto dinero le queda disponible a Samuel?",
                "$2’760.000","$2’500.000","$2’450.000","$2’100.000", "$2’760.000"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass("El señor Ramírez pidió prestado al Banco Agrario la suma de $2’000.000 para ser pagados en un plazo de 6 meses. Si la tasa de interés cobrada es del 2% mensual, ¿qué cantidad debe pagar el señor Ramírez al final del plazo?",
                "$2’240.000","$2’380.000","$2’400.000","$2’530.000", "$2’240.000"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass(" Un prestamista informal realiza préstamos cobrando una tasa de interés del 10% mensual sobre el capital, si José realiza un préstamo por $1’000.000 para pagarlo en 10 meses en cuotas iguales mensuales cada mes. ¿Cuánto debe pagar mensual?",
                "$100.000","$200.000","$300.000","$400.000", "$200.000"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass("En economía, el término inflación se refiere a:",
                "La relación entre la rentabilidad y el capital en una economía","La posibilidad de invertir y generar más ingresos ","El crecimiento generalizado y continuo de los precios de los bienes y servicios de una economía.","La variación de los costos de los productos en una economía", "El crecimiento generalizado y continuo de los precios de los bienes y servicios de una economía."));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass("Si el precio de un curso de inglés es de $300.000 al contado, pero pagado al crédito se recarga en un 18% y el crédito es de 6 meses, ¿cuál es el valor de las cuotas si son todas de igual valor?",
                "$59.000","$114.000","$52.000","$54.000", "$59.000"));

        QuestionPensEducaFinancieraLevel1.add(new ModelClass(" Marcos le presta $ 800.000 a Daniel para comprar un IPhone y le pone como condición que a los cuatro meses le devuelva la suma de $960.000. En esta transacción ¿Cuál es la tasa de interés mensual que cobra Marcos?",
                "10%","5%","15%","20%", "5%"));

//        QuestionPensEducaFinancieraLevel1.add(new ModelClass("Si 2 pintores tardan 6 días en pintar un muro. ¿Cuánto tardarán 3 pintores en realizar el mismo trabajo?", R.drawable.acercade,
//                "3","4","5","1", "4"));



        Hooks();

        allQuestionsList = QuestionPensEducaFinancieraLevel1;
        Collections.shuffle(allQuestionsList);
        modelClass = QuestionPensEducaFinancieraLevel1.get(index);

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
//                Dialog dialog = new Dialog(QuestionPensEducaFinancieraLevel1.this, R.style.Dialogo);
                Dialog dialog = new Dialog(QuestionPensEducaFinancieraLevel1.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogo);

                // al presionar intetar de nuevo redirige hacia .
                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionPensEducaFinancieraLevel1.this, SubmenuPensEducaFinanciera.class);
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
                modelClass = QuestionPensEducaFinancieraLevel1.get(index);
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
                    modelClass = QuestionPensEducaFinancieraLevel1.get(index);
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
        Intent intent = new Intent(QuestionPensEducaFinancieraLevel1.this, WonActivity.class);
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
            if(index < QuestionPensEducaFinancieraLevel1.size() - 1){
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

            if(index < QuestionPensEducaFinancieraLevel1.size() - 1){
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

            if(index < QuestionPensEducaFinancieraLevel1.size() - 1){
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

            if(index < QuestionPensEducaFinancieraLevel1.size() - 1){
                correct_Questions(ResponseD);
            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseD);
        }
    }

    public void irEdufinanciera(View view){
        Intent i = new Intent(QuestionPensEducaFinancieraLevel1.this, SubmenuPensEducaFinanciera.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}