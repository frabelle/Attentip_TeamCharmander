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
import android.widget.Toast;

import com.example.attentipteamcharmander.R;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeExerciseFragment extends Fragment {

    private static String name;

    public HomeExerciseFragment() {
        // Required empty public constructor
    }

    public static HomeExerciseFragment newInstance(String username) {
        HomeExerciseFragment fragment = new HomeExerciseFragment();
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
        return inflater.inflate(R.layout.fragment_home_exercise, container, false);
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
        TextView text = view.findViewById(R.id.text1);
        text.setText("Buen día " + name + ",");

        CardView fisico = view.findViewById(R.id.btnFisica);
        CardView mental = view.findViewById(R.id.btnmental);

        fisico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(PausaFisicaFragment.newInstance());
            }
        });

        mental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(PausaMentalFragment.newInstance());
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