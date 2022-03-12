package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivityOnline extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultTest;
    int correcta, incorrecta;
    String nombreNivel;
    LinearLayout btn_Share, Btn_Shared_WP;
    private TextView wp;
    //    private Button Btn_Shared_WP;
    String _url_wp = "https://chat.whatsapp.com/D7oiGfS9ZCtAe9euBhwZRP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_online);

        correcta = getIntent().getIntExtra("correcta",0);
        incorrecta = getIntent().getIntExtra("incorrecta",0);
        nombreNivel = getIntent().getStringExtra("nombre_nivel");


        circularProgressBar = findViewById(R.id.circularProgressBar);
        resultTest = findViewById(R.id.resultTest);
        btn_Share = findViewById(R.id.btn_Share);

        circularProgressBar.setProgress(correcta);
        resultTest.setText(correcta + "/10");

        btn_Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "BarMaTic");
                    String shareMessage= "\nMi puntuación fue: "+ correcta + " respuesta(s) correcta(s) de 10, en el " + nombreNivel;
                    shareMessage = shareMessage + "https://chat.whatsapp.com/D7oiGfS9ZCtAe9euBhwZRP" ;
//                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";

                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Compartir en"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        Btn_Shared_WP = findViewById(R.id.Btn_Shared_WP);
        Btn_Shared_WP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _url = Uri.parse(_url_wp);
                Intent i = new Intent(Intent.ACTION_VIEW,_url);
                startActivity(i);
            }
        });
    }

    public void irMenu(View view){
        Intent i = new Intent(WonActivityOnline.this, MenuActivityOnline.class);
        startActivity(i);

    }
    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}