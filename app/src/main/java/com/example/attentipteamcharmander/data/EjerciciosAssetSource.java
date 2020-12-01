package com.example.attentipteamcharmander.data;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import java.util.List;

import com.example.attentipteamcharmander.helper.FileHelper;
import com.example.attentipteamcharmander.models.Categoria;
import com.example.attentipteamcharmander.models.CategoriasResult;
import com.example.attentipteamcharmander.models.Ejercicio;
import com.example.attentipteamcharmander.models.SubCategoria;

public class EjerciciosAssetSource {

    private final Gson parser;
    private final Context mContext;
    private static final String FILE_NAME = "ejercicios.json";

    public EjerciciosAssetSource(@NonNull Context context) {
        mContext = context;
        parser = new Gson();
    }

    public CategoriasResult obtenerCategorias() {
        String json = FileHelper.getJsonFromAssets(mContext, FILE_NAME);
        CategoriasResult listResult = parser.fromJson(json, CategoriasResult.class);
        if(listResult == null) return null;
        return listResult;
    }

}
