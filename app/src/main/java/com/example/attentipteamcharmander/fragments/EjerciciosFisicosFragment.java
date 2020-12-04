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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup(view);
    }

    private void setup(@NonNull View view) {
        setupinit(view);
    }

    private void setupinit(View view) {
        MaterialButton btn1, btn2, btn3;

        btn1 = view.findViewById(R.id.btnFd);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EjercicioInferiorFragment.newInstance());
            }
        });

        btn2 = view.findViewById(R.id.btnAc);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EjercicioAbsTroncoFragment.newInstance());
            }
        });

        btn3 = view.findViewById(R.id.btnMa);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EjercicioCuelloFragment.newInstance());
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