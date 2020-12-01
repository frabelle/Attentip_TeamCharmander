package com.example.attentipteamcharmander.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.attentipteamcharmander.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EstadoAnimoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EstadoAnimoFragment extends Fragment {

    private static String name;

    public EstadoAnimoFragment() {
        // Required empty public constructor
    }

    public static EstadoAnimoFragment newInstance(String username) {
        EstadoAnimoFragment fragment = new EstadoAnimoFragment();
        name = username;
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
        return inflater.inflate(R.layout.fragment_estado_animo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup(view);
    }

    private void setup(@NonNull View view) {
        setupUsername(view);
    }

    private void setupUsername(View view) {
        TextView text = view.findViewById(R.id.textNombre);
        text.setText("Hola, " + name);
    }

}