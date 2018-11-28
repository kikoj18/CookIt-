package com.example.eag.myapplication;

public class Receta {
    private int img;
    private String nombre,nacionalidad;
    private int rating,ingredientes,elaboracion;


    public Receta(int pImg,String pNombre,String nacio,int puntuacion,int ingre,int ela){
        img = pImg;
        nombre = pNombre;
        nacionalidad = nacio;
        rating= puntuacion;
        ingredientes = ingre;
        elaboracion = ela;
    }

    public int getImg() {
        return img;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getRating() {
        return rating;
    }

    public int getIngredientes(){ return ingredientes; }

    public int getElaboracion(){ return elaboracion; }
}
