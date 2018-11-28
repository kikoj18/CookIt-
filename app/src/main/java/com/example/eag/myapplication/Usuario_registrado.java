package com.example.eag.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Usuario_registrado extends AppCompatActivity {

    private EditText usuario,pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_registrado);

        usuario = findViewById(R.id.txt_user_registrado);
        pass = findViewById(R.id.txt_pass_registrado);
    }

    public void regUser(View v){

    }

    public void nuevoUser(View v){
        Intent intent = new Intent(this,registro_usuario.class);
        startActivity(intent);
    }
}
