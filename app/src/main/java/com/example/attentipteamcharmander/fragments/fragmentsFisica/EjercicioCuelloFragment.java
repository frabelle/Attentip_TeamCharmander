package com.example.attentipteamcharmander.fragments.fragmentsFisica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EjercicioCuelloFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EjercicioCuelloFragment extends Fragment {


    public EjercicioCuelloFragment() {
        // Required empty public constructor
    }

    public static EjercicioCuelloFragment newInstance() {
        EjercicioCuelloFragment fragment = new EjercicioCuelloFragment();
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
        return inflater.inflate(R.layout.fragment_ejercicio_cuello, container, false);
    }
}