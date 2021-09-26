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

public class QuestionPensAleatorioLevel2 extends AppCompatActivity {

    public static ArrayList<ModelClass> QuestionPensAleatorioLevel2;

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
    String nombreNivel = "nivel 2 de Pensamiento Aleatorio. ";
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pens_aleatorio_level2);

        QuestionPensAleatorioLevel2 = new ArrayList<>();

//        QuestionPensAleatorioLevel2.add(new ModelClass("test8", "a","b","c","d", "ANS")); ejemplo de orden de preguntas y respuestas

//        QuestionPensAleatorioLevel2.add(new ModelClass("¿Por cuántos triángulos equiláteros está compuesta la siguiente figura?",
//                "9","10","12","13", "13"));

        QuestionPensAleatorioLevel2.add(new ModelClass("Con los dígitos 1,2,3,4,5,6 y 9 ¿cuántos números de tres cifras se pueden formar si los números deben empezar por 2, ser múltiplos de 5 y no tener cifras repetidas?",
                "10","15","5","7", "5"));

        QuestionPensAleatorioLevel2.add(new ModelClass("Las notas de otro estudiante en los dos primeros exámenes fueron 2,0 y 3,0 respectivamente. El estudiante aprobó el curso ¿Cuál fue la nota mínima que este estudiante pudo obtener en el tercer examen?",
                "2,0","3,0","4,0","5,0", "4,0"));

        QuestionPensAleatorioLevel2.add(new ModelClass("La siguiente gráfica muestra el número de animales de cada especie que hay en un parque ecológico. ¿Cuál de las siguientes afirmaciones sobre los animales que hay en el parque ecológico no es correcta?",
                "Hay menos aves que reptiles","Hay menos mamíferos que anfibios","Hay más reptiles que anfibios","Hay más mamíferos que aves", "Hay más reptiles que anfibios"));

        QuestionPensAleatorioLevel2.add(new ModelClass("Un colegio necesita enviar 5 estudiantes como representantes a un foro sobre la contaminación del medio ambiente. Se decidió que 2 estudiantes sean de grado décimo y 3 de grado undécimo. En décimo hay 5 estudiantes preparados para el foro y en undécimo hay 4. ¿Cuántos grupos diferentes pueden formarse para enviar al foro?",
                "9","14","20","40", "40"));

        QuestionPensAleatorioLevel2.add(new ModelClass("Diego necesita encontrar la media aritmética de las notas que sacó en el primer período, para esto el procedimiento que debería realizar es: ",
                "Sumar todos los datos y luego dividirlos entre la cantidad total de datos","Multiplicar los datos y luego dividirlos entre la cantidad total de datos","Sumar todos los datos y luego dividirlos entre 10","Multiplicar todos los datos y luego dividirlos entre 10", "Sumar todos los datos y luego dividirlos entre la cantidad total de datos"));

        QuestionPensAleatorioLevel2.add(new ModelClass("Emiliano lanza dos monedas al aire, ¿cuál es la probabilidad de que en el lanzamiento se obtengan dos sellos?",
                "1/4","1/2","4","2", "1/4"));

        QuestionPensAleatorioLevel2.add(new ModelClass("¿Cuál de estos números no puede ser una probabilidad?",
                "20%","1/4","0,001","1,25", "1,25"));

        QuestionPensAleatorioLevel2.add(new ModelClass("Una baraja contiene 3 cartas rojas, 7 cartas verdes y 10 cartas blancas. Si se extrae una carta de la baraja al azar, ¿cuál es la probabilidad de que esta sea blanca?",
                "1/3","1/4","1/2","1/2", "1/2"));

        QuestionPensAleatorioLevel2.add(new ModelClass("En estadística, la medida de centralización que divide a la muestra en dos partes iguales de denomina:",
                "Moda","Media","Mediana","Cuartil", "Mediana"));

        QuestionPensAleatorioLevel2.add(new ModelClass("Decir que dos sucesos son excluyentes es decir que son:",
                "Independientes","Complementarios","Incompatibles","Dependientes", "Incompatibles"));

//        QuestionPensAleatorioLevel2.add(new ModelClass("Si 2 pintores tardan 6 días en pintar un muro. ¿Cuánto tardarán 3 pintores en realizar el mismo trabajo?", R.drawable.acercade,
//                "3","4","5","1", "4"));



        Hooks();

        allQuestionsList = QuestionPensAleatorioLevel2;
        Collections.shuffle(allQuestionsList);
        modelClass = QuestionPensAleatorioLevel2.get(index);

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
                Dialog dialog = new Dialog(QuestionPensAleatorioLevel2.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogo);

                // al presionar intetar de nuevo redirige hacia .
                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionPensAleatorioLevel2.this, SubmenuRazonamiento.class);
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
                modelClass = QuestionPensAleatorioLevel2.get(index);
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
                    modelClass = QuestionPensAleatorioLevel2.get(index);
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
        Intent intent = new Intent(QuestionPensAleatorioLevel2.this, WonActivity.class);
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
            if(index < QuestionPensAleatorioLevel2.size() - 1){
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

            if(index < QuestionPensAleatorioLevel2.size() - 1){
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

            if(index < QuestionPensAleatorioLevel2.size() - 1){
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

            if(index < QuestionPensAleatorioLevel2.size() - 1){
                correct_Questions(ResponseD);
            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseD);
        }
    }

    public void irPensamiento(View view){
        Intent i = new Intent(QuestionPensAleatorioLevel2.this, SubmenuPensAleatorio.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}