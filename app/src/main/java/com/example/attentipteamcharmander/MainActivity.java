package com.example.attentipteamcharmander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.attentipteamcharmander.data.UserConfig;
import com.example.attentipteamcharmander.fragments.EjerciciosFragment;
import com.example.attentipteamcharmander.fragments.EstadoAnimoFragment;
import com.example.attentipteamcharmander.fragments.HomeExerciseFragment;
import com.example.attentipteamcharmander.fragments.ProgresoFragment;
import com.example.attentipteamcharmander.models.UserModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.InvalidParameterException;

public class MainActivity extends AppCompatActivity {

    public static final String FULLNAME_KEY = "FULLNAME";
    BottomNavigationView bottomNavigation;
    public String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        SetUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.user) {
            CambiarPerfil();
        }

        return true;
    }

    private void SetUp(){
        Intent startIntent = getIntent();
        UserModel userModel = getUserModelFromSources(startIntent.getExtras());
        username = userModel.getFullname();
        openFragment(HomeExerciseFragment.newInstance(username));
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
                openFragment(EjerciciosFragment.newInstance());
                break;
        }
    }

    public void CambiarPerfil(){
        Intent intent;
        intent =  new Intent(getBaseContext(), ProfileActivity.class);
        intent.putExtra(ProfileActivity.FULLNAME_KEY, username);
        startActivity(intent);
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