package com.example.attentipteamcharmander.fragments.fragmentsFisica;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.attentipteamcharmander.R;
import com.example.attentipteamcharmander.fragments.EjerciciosFragment;
import com.example.attentipteamcharmander.models.Ejercicio;
import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EjercicioTroncoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EjercicioTroncoFragment extends Fragment {


    public EjercicioTroncoFragment() {
        // Required empty public constructor
    }


    public static EjercicioTroncoFragment newInstance() {
        EjercicioTroncoFragment fragment = new EjercicioTroncoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setup(@NonNull View view) {
        setupGif(view);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ejercicio_tronco, container, false);
    }

    private void setupGif(View view) {
        ImageView imageView = view.findViewById(R.id.pruebaid);
        Glide.with(this).load(R.drawable.flexibilidad_tronco).into(imageView);

        MaterialButton next = view.findViewById(R.id.btnnext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(EjerciciosFragment.newInstance());
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