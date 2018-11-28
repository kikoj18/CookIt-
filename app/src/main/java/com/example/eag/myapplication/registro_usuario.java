package com.example.eag.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class registro_usuario extends AppCompatActivity {

    EditText textoUser,textoTele,textoDire;
    RadioButton rbHombre,rbMujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        textoUser = (EditText)findViewById(R.id.usuario);
        textoTele = (EditText)findViewById(R.id.telefono);
        textoDire = (EditText)findViewById(R.id.direccion);

        rbHombre = (RadioButton)findViewById(R.id.rbHombre);
        rbMujer = (RadioButton)findViewById(R.id.rbMujer);
    }

    public  void registar(View view){
        Intent intent = new Intent(this,Selector_receta.class);
        intent.putExtra("nombreUser",textoUser.getText().toString());
        intent.putExtra("telefonoUser",textoTele.getText().toString());
        intent.putExtra("direccionUser",textoDire.getText().toString());
        startActivity(intent);

        if(rbHombre.isChecked()){
            Toast.makeText(this, "Bienvenido "+textoUser.getText().toString(),
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Bienvenida "+textoUser.getText().toString(),
                    Toast.LENGTH_LONG).show();
        }
    }
}
