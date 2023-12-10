package com.example.photoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button profile_Btn;
    private TextView userName;
    private final static String PREFERENCES = "preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferencias = getSharedPreferences(PREFERENCES, 0);

        profile_Btn = findViewById(R.id.profileBtn);
        userName = findViewById(R.id.userName);

        String nome = preferencias.getString("nome", "Fulano(a)");
        userName.setText(nome);


    }

    public void goToProfile(View view) {
        Intent i = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(i);
    }

}