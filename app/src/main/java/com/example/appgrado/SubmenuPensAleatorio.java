package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubmenuPensAleatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_pens_aleatorio);
    }

    public void irPensPensAleatoriolevel1(View view){
        Intent i = new Intent(SubmenuPensAleatorio.this, QuestionRazonamientoLevel1.class);
        startActivity(i);
    }

    public void irinicio(View view){
        Intent i = new Intent(SubmenuPensAleatorio.this, MenuActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}