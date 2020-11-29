package com.example.attentipteamcharmander.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PausaMentalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PausaMentalFragment extends Fragment {


    public PausaMentalFragment() {
        // Required empty public constructor
    }


    public static PausaMentalFragment newInstance() {
        PausaMentalFragment fragment = new PausaMentalFragment();
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
        return inflater.inflate(R.layout.fragment_pausa_mental, container, false);
    }
}