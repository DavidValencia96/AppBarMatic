package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubmenuPensNumyVari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_pens_numy_vari);
    }

    public void irPensNumyVarilevel1(View view){
        Intent i = new Intent(SubmenuPensNumyVari.this, QuestionPensNumyVariLevel1.class);
        startActivity(i);
    }

    public void irPensNumyVarilevel2(View view){
        Intent i = new Intent(SubmenuPensNumyVari.this, QuestionPensNumyVariLevel2.class);
        startActivity(i);
    }

    public void irinicio(View view){
        Intent i = new Intent(SubmenuPensNumyVari.this, MenuActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}