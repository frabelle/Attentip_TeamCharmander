package com.example.attentipteamcharmander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.example.attentipteamcharmander.data.UserConfig;
import com.example.attentipteamcharmander.fragments.EstadoAnimoFragment;
import com.example.attentipteamcharmander.fragments.HomeExerciseFragment;
import com.example.attentipteamcharmander.fragments.ProgresoFragment;
import com.example.attentipteamcharmander.fragments.RemindersFragment;
import com.example.attentipteamcharmander.model.UserModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.InvalidParameterException;

public class MainActivity extends AppCompatActivity {

    public static final String FULLNAME_KEY = "FULLNAME";
    BottomNavigationView bottomNavigation;
    private ViewGroup rootView;
    public String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        rootView = findViewById(R.id.ly_root);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        SetUp();

        openFragment(HomeExerciseFragment.newInstance(username));

    }

    private void SetUp(){
        Intent startIntent = getIntent();
        UserModel userModel = getUserModelFromSources(startIntent.getExtras());
        username = userModel.getFullname();
    }

    @NonNull
    private UserModel getUserModelFromSources(Bundle extras) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        final UserModel user = userConfig.getUser();
        if(user != null) {
            return user;
        }
        if(extras == null) {
            throw new InvalidParameterException("Extras");
        }
        return new UserModel(extras.getString(FULLNAME_KEY));
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
                    SelectItemMenu(item);
                    return true;
                }
            };

    private void SelectItemMenu(MenuItem item){
        item.setCheckable(true);
        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.exercise:
                openFragment(HomeExerciseFragment.newInstance(username));
                break;

            case R.id.mood:
                openFragment(EstadoAnimoFragment.newInstance(username));
                break;

            case R.id.goals:
                openFragment(ProgresoFragment.newInstance());
                break;

            case R.id.reminders:
                openFragment(RemindersFragment.newInstance());
                break;
        }
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = bottomNavigation.getMenu().getItem(0);

        if (!bottomNavigation.equals(homeItem.getItemId())) {
            SelectItemMenu(homeItem);
            bottomNavigation.setSelectedItemId(homeItem.getItemId());
        } else {
            super.onBackPressed();
        }
    }

}