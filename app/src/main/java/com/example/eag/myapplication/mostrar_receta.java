package com.example.eag.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class mostrar_receta extends AppCompatActivity {
    private Receta receta;
    private ImageView imgReceta;
    private TextView ingreRece, elaRece,nomReceta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta1);

        receta = MainActivity.recetas.get(getIntent().getIntExtra("posRece",0));

        imgReceta = (ImageView)findViewById(R.id.imageRece);
        ingreRece = (TextView)findViewById(R.id.ingreReceta);
        elaRece = (TextView)findViewById(R.id.elaRece);
        nomReceta = (TextView)findViewById(R.id.nombreReceta);

        imgReceta.setImageResource(receta.getImg());
        nomReceta.setText(receta.getNombre());
        ingreRece.setText(receta.getIngredientes());
        elaRece.setText(receta.getElaboracion());
    }
}
