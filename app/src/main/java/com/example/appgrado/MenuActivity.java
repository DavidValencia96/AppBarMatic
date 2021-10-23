package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void irRazonamientoLog(View view){
        Intent i = new Intent(MenuActivity.this, SubmenuRazonamiento.class);
        startActivity(i);
    }

    public void irSubmenuPensNumyVari(View view){
        Intent i = new Intent(MenuActivity.this, SubmenuPensNumyVari.class);
        startActivity(i);
    }

    public void irSubmenuPensMetricoyGeome(View view){
        Intent i = new Intent(MenuActivity.this, SubmenuPensMetricoyGeome.class);
        startActivity(i);
    }

    public void irSubmenuPensAleatorio(View view){
        Intent i = new Intent(MenuActivity.this, SubmenuPensAleatorio.class);
        startActivity(i);
    }

    public void irSubmenuPensProcesos(View view){
        Intent i = new Intent(MenuActivity.this, SubmenuPensProcesos.class);
        startActivity(i);
    }

    public void irSubmenuPensEducaFinanciera(View view){
        Intent i = new Intent(MenuActivity.this, SubmenuPensEducaFinanciera.class);
        startActivity(i);
    }

    public void irSubmenuAcercaDe(View view){
        Intent i = new Intent(MenuActivity.this, SubmenuAcercaDe.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }

}