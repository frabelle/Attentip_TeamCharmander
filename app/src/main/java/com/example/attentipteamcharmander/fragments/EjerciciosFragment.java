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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.attentipteamcharmander.MainActivity;
import com.example.attentipteamcharmander.R;
import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EjerciciosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EjerciciosFragment extends Fragment {


    public EjerciciosFragment() {
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
        Glide.with(this).load(R.drawable.neckgif).into(imageView);

        MaterialButton end = view.findViewById(R.id.btnCheck);

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(PausaFisicaFragment.newInstance());
            }
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}