package com.example.photoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameField;
    private TextView emailField;
    private TextView phoneField;
    private Button saveChangesBtn;
    private Button backBtn;
    private final static String PREFERENCES = "preferencias";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences preferencias = getSharedPreferences(PREFERENCES, 0);
        SharedPreferences.Editor editor = preferencias.edit();

        nameField = findViewById(R.id.nameField);
        emailField = findViewById(R.id.emailField);
        phoneField = findViewById(R.id.phoneField);
        saveChangesBtn = findViewById(R.id.saveChangesBtn);
        backBtn = findViewById(R.id.backBtn);

        saveChangesBtn.setOnClickListener((v) -> {
            if (
                nameField.getText().toString().equals("")
                || emailField.getText().toString().equals("")
                || phoneField.getText().toString().equals("")
            ) {
                Toast.makeText(getApplicationContext(), "Preencha os Campos Vazios", Toast.LENGTH_SHORT).show();
            } else {
                editor.putString("nome", nameField.getText().toString());
                editor.putString("email", emailField.getText().toString());
                editor.putString("fone", phoneField.getText().toString());
                editor.commit();

                Toast.makeText(getApplicationContext(), "Dados Cadastrados com Sucesso", Toast.LENGTH_SHORT).show();
            }
        });


        String nome = preferencias.getString("nome", "");
        String email = preferencias.getString("email", "");
        nameField.setText(nome);
        emailField.setText(email);

    }

    public void backToHome(View view) {
        Intent home = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(home);
    }
}