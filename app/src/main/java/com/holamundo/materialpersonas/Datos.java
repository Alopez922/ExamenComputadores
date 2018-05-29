package com.holamundo.materialpersonas;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 30/04/2018.
 */

public class Datos {
    private static String db = "Personas";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Computador> personas  = new ArrayList();

    /*public static void guardar(Persona p){
        personas.add(p);
    }*/

    public static void guardar(Computador p){
        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    public static ArrayList<Computador> obtener(){
        return personas;
    }

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return  fotos.get(fotoSeleccionada);
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setPersonas(ArrayList<Computador> personas){
        Datos.personas = personas;
    }

    public static void eliminarPersona(Computador p){
        databaseReference.child(db).child(p.getId()).removeValue();
    }

    public static void modificarPersona(Computador p){
        databaseReference.child(db).child(p.getId()).setValue(p);
    }



}
