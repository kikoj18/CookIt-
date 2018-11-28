package com.example.eag.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class Selector_receta extends AppCompatActivity {

    TextView nomUser,teleUser,direUser;
    ListView listaRecetas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_receta);
        nomUser = (TextView)findViewById(R.id.verNombreUsuario);
        teleUser = (TextView)findViewById(R.id.verTelefonoUsuario);
        direUser = (TextView)findViewById(R.id.verDireUsuario);


        nomUser.setText(getIntent().getStringExtra("nombreUser"));
        teleUser.setText(getIntent().getStringExtra("telefonoUser"));
        direUser.setText(getIntent().getStringExtra("direccionUser"));

        listaRecetas = (ListView)findViewById(R.id.lista_recetas);

        Adaptador adapter = new Adaptador(this,MainActivity.recetas);

        listaRecetas.setAdapter(adapter);

        listaRecetas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(view.getContext(),mostrar_receta.class);
                intent.putExtra("posRece", position);
               startActivity(intent);
            }
        });
    }
}
