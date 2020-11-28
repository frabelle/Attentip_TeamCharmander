package com.example.attentipteamcharmander.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistorialEstadoAFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistorialEstadoAFragment extends Fragment {



    public HistorialEstadoAFragment() {
        // Required empty public constructor
    }



    public static HistorialEstadoAFragment newInstance(String param1, String param2) {
        HistorialEstadoAFragment fragment = new HistorialEstadoAFragment();
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
        return inflater.inflate(R.layout.fragment_historial_estado_a, container, false);
    }
}