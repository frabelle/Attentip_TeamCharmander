package com.example.attentipteamcharmander.fragments.fragmentsFisica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EjercicioInferiorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EjercicioInferiorFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public EjercicioInferiorFragment() {
        // Required empty public constructor
    }

    public static EjercicioInferiorFragment newInstance() {
        EjercicioInferiorFragment fragment = new EjercicioInferiorFragment();
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
        return inflater.inflate(R.layout.fragment_ejercicio_inferior, container, false);
    }
}