package com.example.attentipteamcharmander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.fragments.EstadoAnimoFragment;
import com.example.attentipteamcharmander.fragments.HomeExerciseFragment;
import com.example.attentipteamcharmander.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        rootView = findViewById(R.id.ly_root);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        openFragment(HomeFragment.newInstance());

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home:
                            openFragment(HomeFragment.newInstance());
                            return true;

                        case R.id.mood:
                            openFragment(EstadoAnimoFragment.newInstance());
                             return true;

                        case R.id.exercise:
                            openFragment(HomeExerciseFragment.newInstance());
                             return true;

                        case R.id.goals:
                            openFragment(HomeFragment.newInstance());
                            return true;

                        case R.id.reminders:
                            openFragment(HomeFragment.newInstance());
                            return true;
                    }
                    return false;
                }
            };

}