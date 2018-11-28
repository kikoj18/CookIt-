package com.example.eag.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter
{
    private static LayoutInflater inflater = null;

    Context contexto;
    ArrayList<Receta> recetas;

    public  Adaptador(Context cont, ArrayList<Receta> rece){
        contexto = cont;
        recetas = rece;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elementolista,null);

        ImageView img = (ImageView)vista.findViewById(R.id.imgRecetaElementoLista);

        TextView nombreComida = (TextView)vista.findViewById(R.id.nombreComidaElementoLista);
        TextView nacioComida = (TextView)vista.findViewById(R.id.nacioComidaElementoLista);

        RatingBar ratingBar = (RatingBar)vista.findViewById(R.id.ratingBarElementoLista);

        Receta receta = recetas.get(position);

        nombreComida.setText(receta.getNombre());
        nacioComida.setText(receta.getNacionalidad());
        img.setImageResource(receta.getImg());
        ratingBar.setProgress(Integer.valueOf(receta.getRating()));

        return vista;
    }

    @Override
    public int getCount() {
        return recetas.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
