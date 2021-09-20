package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubmenuPensEducaFinanciera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_pens_educa_financiera);
    }

    public void irQuestionPensEducaFinancieraLevel1(View view){
        Intent i = new Intent(SubmenuPensEducaFinanciera.this, QuestionPensEducaFinancieraLevel1.class);
        startActivity(i);
    }

    public void irQuestionPensEducaFinancieraLevel2(View view){
        Intent i = new Intent(SubmenuPensEducaFinanciera.this, QuestionPensEducaFinancieraLevel2.class);
        startActivity(i);
    }

    public void irinicio(View view){
        Intent i = new Intent(SubmenuPensEducaFinanciera.this, MenuActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}