package com.example.u4ejercicioparacelable1402;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 14/02/2018.
 */

public class Persona implements Parcelable {

    String nombre;
    int edad;
    double sueldo;

    //CREATOR
    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>(){

    public Persona createFromParcel(Parcel in) {
        return new Persona(in);
    }

    public Persona[] newArray(int size) {
        return new Persona[size];
    }

};

    //Crear constructor que reciba por parámetos un parcel
    public Persona(Parcel p){
        //Llamamos al método readfromparcel() y le pasamos el parcelable
        readfromParcel(p);
    }

    public Persona(String nombre, int edad, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    //Métodos implementados
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.edad);
        dest.writeDouble(this.sueldo);
    }

    //Creamos un método readFromParcel que usaremos para llamarlo en el constructor parcelable
    private void readfromParcel (Parcel p){
        this.nombre = p.readString();
        this.edad = p.readInt();
        this.sueldo = p.readDouble();
    }
}
