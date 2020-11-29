package com.example.attentipteamcharmander.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PausaFisicaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PausaFisicaFragment extends Fragment {


    public PausaFisicaFragment() {
        // Required empty public constructor
    }

    public static PausaFisicaFragment newInstance() {
        PausaFisicaFragment fragment = new PausaFisicaFragment();
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
        return inflater.inflate(R.layout.fragment_pausa_fisica, container, false);
    }
}