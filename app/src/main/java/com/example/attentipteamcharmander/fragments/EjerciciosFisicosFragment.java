package com.example.attentipteamcharmander.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EjerciciosFisicosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EjerciciosFisicosFragment extends Fragment {


    public EjerciciosFisicosFragment() {
        // Required empty public constructor
    }


    public static EjerciciosFisicosFragment newInstance(String param1, String param2) {
        EjerciciosFisicosFragment fragment = new EjerciciosFisicosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ejercicios_fisicos, container, false);
    }



}