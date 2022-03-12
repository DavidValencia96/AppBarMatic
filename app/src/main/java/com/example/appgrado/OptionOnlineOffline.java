package com.example.appgrado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OptionOnlineOffline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_online_offline);
    }

    public void irMenuOffline(View view){
        Intent i = new Intent(OptionOnlineOffline.this, MenuActivity.class);
        startActivity(i);
    }

    public void irMenuOnline(View view){
        Intent i = new Intent(OptionOnlineOffline.this, MenuActivityOnline.class);
        startActivity(i);
    }

    public void irSubmenuAcercaDe(View view){
        Intent i = new Intent(OptionOnlineOffline.this, SubmenuAcercaDe.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}