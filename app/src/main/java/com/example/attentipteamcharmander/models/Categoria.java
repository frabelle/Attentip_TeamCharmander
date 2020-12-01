package com.example.attentipteamcharmander.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Categoria implements Parcelable {

    String nombre;
    @SerializedName("subcategorias")
    List<SubCategoria> subCategorias;

    public Categoria(String nombre, List<SubCategoria> subCategorias) {
        this.nombre = nombre;
        this.subCategorias = subCategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<SubCategoria> subCategorias) {
        this.subCategorias = subCategorias;
    }

    protected Categoria(Parcel in) {
        nombre = in.readString();
        if (in.readByte() == 0x01) {
            subCategorias = new ArrayList<SubCategoria>();
            in.readList(subCategorias, SubCategoria.class.getClassLoader());
        } else {
            subCategorias = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        if (subCategorias == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(subCategorias);
        }
    }

    public static final Parcelable.Creator<Categoria> CREATOR = new Parcelable.Creator<Categoria>() {
        @Override
        public Categoria createFromParcel(Parcel in) {
            return new Categoria(in);
        }

        @Override
        public Categoria[] newArray(int size) {
            return new Categoria[size];
        }
    };
}
