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

public class QuestionPensNumyVariLevel2 extends AppCompatActivity {

    public static ArrayList<ModelClass> QuestionPensNumyVariLevel2;

    CountDownTimer countDownTimer;
    int timerValue = 600; //contador de tiempo 5 min == 600000 milsg
    RoundedHorizontalProgressBar progressBar;
    List<ModelClass> allQuestionsList; //importamos la lista de preguntas en caso de que este en otra vista
    ModelClass modelClass;
    int index = 0;
    //    ImageView imagen;
    TextView preguntas, optionA, optionB, optionC, optionD;
    CardView ResponseA, ResponseB, ResponseC, ResponseD;
    int correctCount = 0;
    int incorrectCount = 0;
    String nombreNivel = "nivel 2 de Pensamiento Numérico y Variacional. ";
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_pens_numy_vari_level2);

        QuestionPensNumyVariLevel2 = new ArrayList<>();

//        listOfflineQuestion2.add(new ModelClass("test8", "a","b","c","d", "ANS")); ejemplo de orden de preguntas y respuestas

//        QuestionPensNumyVariLevel1.add(new ModelClass("¿Por cuántos triángulos equiláteros está compuesta la siguiente figura?",
//                "9","10","12","13", "13"));

        QuestionPensNumyVariLevel2.add(new ModelClass("Al calcular el 20% del 50% de 800, se obtiene:",
                "40","50","80","60", "80"));

        QuestionPensNumyVariLevel2.add(new ModelClass("5 cuadernos y 8 lápices cuestan $11500 y 3 cuadernos y 5 lápices cuestan $7000. ¿Cuánto cuesta cada lápiz y cada cuaderno?",
                "Cada cuaderno $1300 y cada lápiz $750","Cada cuaderno $1500 y cada lápiz $500","Cada cuaderno $1850 y cada lápiz $700","Cada cuaderno $1700 y cada lápiz $ 800", "Cada cuaderno $1500 y cada lápiz $500"));

        QuestionPensNumyVariLevel2.add(new ModelClass("Un estudiante de grado décimo presenta las siguientes 5 notas en matemáticas: Nota 1: 3,6. Nota 2: 4,4. Nota 3: 3,2. Nota 4: 5,0. Nota 5: 3,8. Si todas las notas tienen el mismo porcentaje sobre la nota final, ¿Cuál es la nota definitiva del estudiante?",
                "3,8","3,6","4,0","4,2", "4,0"));

        QuestionPensNumyVariLevel2.add(new ModelClass("Para construir una pared de 12 m de largo y 5 m de alto se necesitan 400 ladrillos. ¿qué altura tendrá la pared, si tuviera 4m de largo y se contara solo con 400 ladrillos?",
                "Tendrá una altura de 7,5 m","Tendrá una altura de 6,8 m","Tendrá una altura de 9,4 m","Tendrá una altura de 8,2 m", "Tendrá una altura de 7,5 m"));

        QuestionPensNumyVariLevel2.add(new ModelClass("Al resolver la operación: 2 + {3 – [(5 + 6) * (3 – 7)]}",
                "52","60","38","49", "49"));

        QuestionPensNumyVariLevel2.add(new ModelClass("El número que continúa en la sucesión 1, 1, 1, 3, 5, 9, 17… es",
                "26","20","31","38", "31"));

        QuestionPensNumyVariLevel2.add(new ModelClass("El triple de un número más 8, es igual a siete veces el número. ¿Cuál es el número?",
                "2","3","4","5", "2"));

        QuestionPensNumyVariLevel2.add(new ModelClass("5 autobuses transportan 800 pasajeros en 4 viajes. ¿Cuántos viajes son necesarios para transportar 400 pasajeros usando 2 autobuses?",
                "3 viajes","7 viajes","5 viajes","6 viajes", "5 viajes"));

        QuestionPensNumyVariLevel2.add(new ModelClass("Mónica se monta en el ascensor en la planta baja de su edificio, el ascensor sube 5 pisos, después baja 3, sube 5, baja 8, sube 10, sube 5 y baja 6. ¿En qué piso está Mónica?",
                "Quinto piso","Sexto piso","Séptimo piso","Octavo piso", "Octavo piso"));

        QuestionPensNumyVariLevel2.add(new ModelClass(" En un museo, la visita es guiada y entran 25 personas cada 25 minutos. La visita dura 90 minutos. El primer grupo entra a las 9:00 am ¿Cuántos visitantes hay dentro del museo a las 10:00 am?",
                "75 personas","80 personas","70 personas","85 personas", "75 personas"));

//        QuestionPensNumyVariLevel1.add(new ModelClass("Si 2 pintores tardan 6 días en pintar un muro. ¿Cuánto tardarán 3 pintores en realizar el mismo trabajo?", R.drawable.acercade,
//                "3","4","5","1", "4"));



        Hooks();

        allQuestionsList = QuestionPensNumyVariLevel2;
        Collections.shuffle(allQuestionsList);
        modelClass = QuestionPensNumyVariLevel2.get(index);

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
//                Dialog dialog = new Dialog(QuestionPensNumyVariLevel2.this, R.style.Dialogo);
                Dialog dialog = new Dialog(QuestionPensNumyVariLevel2.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialogo);

                // al presionar intetar de nuevo redirige hacia .
                dialog.findViewById(R.id.btn_intentarNew).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionPensNumyVariLevel2.this, SubmenuPensNumyVari.class);
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
                modelClass = QuestionPensNumyVariLevel2.get(index);
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
                    modelClass = QuestionPensNumyVariLevel2.get(index);
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
        Intent intent = new Intent(QuestionPensNumyVariLevel2.this, WonActivity.class);
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
            if(index < QuestionPensNumyVariLevel2.size() - 1){
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

            if(index < QuestionPensNumyVariLevel2.size() - 1){
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

            if(index < QuestionPensNumyVariLevel2.size() - 1){
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

            if(index < QuestionPensNumyVariLevel2.size() - 1){
                correct_Questions(ResponseD);
            } else{
                GameWon();
            }
        }else{
            incorrect_Questions(ResponseD);
        }
    }

    public void irNumYVariacional(View view){
        Intent i = new Intent(QuestionPensNumyVariLevel2.this, SubmenuPensNumyVari.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}