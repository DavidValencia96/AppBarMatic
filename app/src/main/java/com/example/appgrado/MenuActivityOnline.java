package com.example.appgrado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class MenuActivityOnline extends AppCompatActivity {

    public static ArrayList<ModelClass> listFirebase; //lista publica para consultar desde otro archivo

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_online);

        listFirebase = new ArrayList<>();

        //firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("Questions");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ModelClass modelclass = dataSnapshot.getValue(ModelClass.class);
                    listFirebase.add(modelclass);
                }
                Intent intent = new Intent(MenuActivityOnline.this, QuizTestFirebase.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }





    public void regresar(View view){
        Intent i = new Intent(MenuActivityOnline.this, OptionOnlineOffline.class);
        startActivity(i);
    }

    public void irQuestion(View view){
        Intent i = new Intent(MenuActivityOnline.this, QuizTestFirebase.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        return; //inhabilitar el boton de retroceso
    }
}