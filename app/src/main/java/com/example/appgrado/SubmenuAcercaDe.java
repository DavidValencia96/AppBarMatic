package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubmenuAcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu_acerca_de);

    }

    public void irinicio(View view){
        Intent i = new Intent(SubmenuAcercaDe.this, MenuActivity.class);
        startActivity(i);
    }

//    @Override
//    public void onBackPressed() {
//        return; //inhabilitar el boton de retroceso
//    }
}