package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultTest;
    int correcta, incorrecta;
    String nombreNivel;
    LinearLayout btn_Share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correcta = getIntent().getIntExtra("correcta",0);
        incorrecta = getIntent().getIntExtra("incorrecta",0);
        nombreNivel = getIntent().getStringExtra("nombre_nivel");


        circularProgressBar = findViewById(R.id.circularProgressBar);
        resultTest = findViewById(R.id.resultTest);
        btn_Share = findViewById(R.id.btn_Share);

        circularProgressBar.setProgress(correcta);
        resultTest.setText(correcta + "/11");

        btn_Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "BarMaTic");
                    String shareMessage= "\nMi puntuación fue: "+ correcta + " respuesta(s) correcta(s) de 11, en el " + nombreNivel;
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Compartir en"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

    }
    public void irSubmenuRazonamiento(View view){
        Intent i = new Intent(WonActivity.this, MenuActivity.class);
        startActivity(i);

    }
    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}