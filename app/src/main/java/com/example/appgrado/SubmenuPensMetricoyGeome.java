package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubmenuPensMetricoyGeome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_pens_metricoy_geome);
    }

    public void irPensPensMetricoyGeomelevel1(View view){
        Intent i = new Intent(SubmenuPensMetricoyGeome.this, QuestionRazonamientoLevel1.class);
        startActivity(i);
    }

    public void irinicio(View view){
        Intent i = new Intent(SubmenuPensMetricoyGeome.this, MenuActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}