 package com.example.eag.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {
    private boolean muteado;
    private ImageButton botonMute;
    private Button regUserbtn,invibtn,comenzarbtn;
    public AdminSQLiteopenHelper admin;
    public static SQLiteDatabase BaseDeDatos;

    public static Cursor cursor;
    public static ArrayList<Receta> recetas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, BackgroundSoundService .class));
        admin = new AdminSQLiteopenHelper(this,"administracion",null,1);    //Creamos la base de datos

        botonMute = (ImageButton)findViewById(R.id.btnMute);
        botonMute.setImageResource(R.drawable.soundon);
        muteado = false;

        regUserbtn = (Button)findViewById(R.id.boton_usuario);
        invibtn = (Button)findViewById(R.id.boton_invitado);
        comenzarbtn = (Button)findViewById(R.id.boton_comenzar_main);

        meterRecetasDefault();

        cursor = cargarCursorRecetas();

        //Recoge todos los elementos del cursor y los mete en un array(recetas)
        Receta recetaAux;
        cursor.moveToFirst();
        for(int i=0; i<cursor.getCount();i++){
            recetaAux = new Receta(cursor.getInt(1),cursor.getString(2),
                    cursor.getString(3),cursor.getInt(4),
                    cursor.getInt(5),cursor.getInt(6));

            recetas.add(recetaAux);

            cursor.moveToNext();
        }
    }

    //funcion transicion al pulsar comenzar
    public void start(View view){
        comenzarbtn.setVisibility(View.INVISIBLE);

        regUserbtn.setVisibility(View.VISIBLE);
        invibtn.setVisibility(View.VISIBLE);
    }


    public void mute(View view){
        if(!muteado){
            stopService(new Intent(this, BackgroundSoundService .class));
            botonMute.setImageResource(R.drawable.soundoff);
            muteado = true;

        }else{
            startService(new Intent(this, BackgroundSoundService .class));
            botonMute.setImageResource(R.drawable.soundon);
            muteado = false;
        }
    }

    //silencia la aplicacion al destruir
    public void onDestroy(){
        super.onDestroy();
        stopService(new Intent(this, BackgroundSoundService .class));
    }


     public void regUser(View view){
         Intent intent = new Intent(this,Usuario_registrado.class);
         startActivity(intent);
     }

     public void invitado(View view){
         Intent intent = new Intent(this,Selector_receta.class);
         startActivity(intent);
     }

     //Carga todas las recetas de la base de datos en un Cursor
     public Cursor cargarCursorRecetas(){
        BaseDeDatos = admin.getWritableDatabase();
        String[] columnas = {"codigo","img","nombre","nacio","puntuacion","ingre","ela"};
        return BaseDeDatos.query("recetas",columnas,null,null,null,null,null);
     }



     //Se ejecuta una sola vez en la vida de la aplicacion y mete todas las recetas "default" en la base de datos
     public void meterRecetasDefault(){
         ArrayList<Receta> recetasDefault = new ArrayList<>();
         int contador = 1;

         //Creamos todas las recetas por defecto y las pasamos al array
         Receta r1 = new Receta(R.drawable.ensaladaescarola,"Ensalada de escarola y lentejas","España",7,R.string.IngreEnsalada,R.string.ElaEnsalada);
         Receta r2 = new Receta(R.drawable.bacalaotxakoli,"Bacalao asado con salsa de txakoli","España",5,R.string.IngreBacalao,R.string.ElaBacalao);
         Receta r3 = new Receta(R.drawable.rissotocalabaza,"Risotto de Calabaza","Italia",9,R.string.IngreRissoto,R.string.ElaRissoto);
         Receta r4 = new Receta(R.drawable.pastasetas,"Pasta con salsa de setas","Italia",7,R.string.IngrePasta,R.string.ElaPasta);
         Receta r5 = new Receta(R.drawable.revueltohongos,"Revuelto de hongos","Hindu",8,R.string.IngreHongo,R.string.ElaHongo);
         Receta r6 = new Receta(R.drawable.pastaespinaca,"Pasta con espinacas y tomate","Italia",7,R.string.IngreEspinaca,R.string.ElaEspinaca);

         recetasDefault.add(r1);
         recetasDefault.add(r2);
         recetasDefault.add(r3);
         recetasDefault.add(r4);
         recetasDefault.add(r5);
         recetasDefault.add(r6);

         //Creamos la conexion con la base de datos
         BaseDeDatos = admin.getWritableDatabase();

         ContentValues contenedor;

         //Meto recetas en el contenedor
         for(Receta receAux: recetasDefault){
             contenedor = new ContentValues();

             contenedor.put("codigo",contador);
             contenedor.put("img",receAux.getImg());
             contenedor.put("nombre",receAux.getNombre());
             contenedor.put("nacio",receAux.getNacionalidad());
             contenedor.put("puntuacion",receAux.getRating());
             contenedor.put("ingre",receAux.getIngredientes());
             contenedor.put("ela",receAux.getElaboracion());

             BaseDeDatos.insert("recetas",null,contenedor);
             contador++;
         }
         BaseDeDatos.close();
     }
}


