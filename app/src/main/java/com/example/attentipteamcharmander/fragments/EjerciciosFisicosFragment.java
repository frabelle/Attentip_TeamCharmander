package com.example.attentipteamcharmander.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.attentipteamcharmander.R;
import com.example.attentipteamcharmander.fragments.fragmentsFisica.EjercicioAbsTroncoFragment;
import com.example.attentipteamcharmander.fragments.fragmentsFisica.EjercicioCuelloFragment;
import com.example.attentipteamcharmander.fragments.fragmentsFisica.EjercicioInferiorFragment;
import com.google.android.material.button.MaterialButton;


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