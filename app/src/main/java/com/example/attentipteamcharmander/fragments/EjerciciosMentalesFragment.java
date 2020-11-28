package com.example.attentipteamcharmander.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EjerciciosMentalesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EjerciciosMentalesFragment extends Fragment {

    public EjerciciosMentalesFragment() {
        // Required empty public constructor
    }



    public static EjerciciosMentalesFragment newInstance(String param1, String param2) {
        EjerciciosMentalesFragment fragment = new EjerciciosMentalesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ejercicios_mentales, container, false);
    }
}