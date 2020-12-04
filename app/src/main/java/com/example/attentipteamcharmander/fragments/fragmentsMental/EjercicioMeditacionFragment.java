package com.example.attentipteamcharmander.fragments.fragmentsMental;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.attentipteamcharmander.R;
import com.example.attentipteamcharmander.fragments.EjerciciosFragment;


public class EjercicioMeditacionFragment extends Fragment {


    public EjercicioMeditacionFragment() {
        // Required empty public constructor
    }

    public static EjerciciosFragment newInstance() {
        EjerciciosFragment fragment = new EjerciciosFragment();
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
        return inflater.inflate(R.layout.fragment_ejercicios, container, false);
    }

    private void setup(@NonNull View view) {
        setupGif(view);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup(view);
    }

    private void setupGif(View view) {
        ImageView imageView = view.findViewById(R.id.pruebaid);
        Glide.with(this).load(R.drawable.meditacion).into(imageView);
    }
}