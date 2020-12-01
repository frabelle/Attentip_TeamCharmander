package com.example.attentipteamcharmander.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class SubCategoria implements Parcelable {
    String nombre;
    List<Ejercicio> ejercicios;

    public SubCategoria(String nombre, List<Ejercicio> ejercicios) {
        this.nombre = nombre;
        this.ejercicios = ejercicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    protected SubCategoria(Parcel in) {
        nombre = in.readString();
        if (in.readByte() == 0x01) {
            ejercicios = new ArrayList<Ejercicio>();
            in.readList(ejercicios, Ejercicio.class.getClassLoader());
        } else {
            ejercicios = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        if (ejercicios == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(ejercicios);
        }
    }

    public static final Parcelable.Creator<SubCategoria> CREATOR = new Parcelable.Creator<SubCategoria>() {
        @Override
        public SubCategoria createFromParcel(Parcel in) {
            return new SubCategoria(in);
        }

        @Override
        public SubCategoria[] newArray(int size) {
            return new SubCategoria[size];
        }
    };
}
