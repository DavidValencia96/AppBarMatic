package com.example.appgrado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//   public static ArrayList<ModelClass> listOfflineQuestion2;

//   DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //preguntas  de la app local
//        listOfflineQuestion2 = new ArrayList<>();

//        databaseReference = FirebaseDatabase.getInstance().getReference("Questions");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    ModelClass modelclass = dataSnapshot.getValue(ModelClass.class);
//                    listOfflineQuestion.add(modelclass);
//                }
//                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

//        Preguntas locales
//        listOfflineQuestion2.add(new ModelClass("imagen", "9","b","c","d", "ANS"));
//        listOfflineQuestion2.add(new ModelClass("test1", "a","b","c","d", "ANS"));
//        listOfflineQuestion2.add(new ModelClass("test2", "a","b","c","d", "ANS"));
//        listOfflineQuestion2.add(new ModelClass("test3", "a","b","c","d", "ANS"));
//        listOfflineQuestion2.add(new ModelClass("test4", "a","b","c","d", "ANS"));
//        listOfflineQuestion2.add(new ModelClass("test5", "a","b","c","d", "ANS"));
//        listOfflineQuestion2.add(new ModelClass("test6", "a","b","c","d", "ANS"));
//        listOfflineQuestion2.add(new ModelClass("test7", "a","b","c","d", "ANS"));
//        listOfflineQuestion2.add(new ModelClass("test8", "a","b","c","d", "ANS"));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();  //evitar que se muestra la vista principal
            }
        }, 2500);
    }
}
