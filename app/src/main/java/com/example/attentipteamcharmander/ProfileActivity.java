package com.example.attentipteamcharmander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.attentipteamcharmander.data.UserConfig;
import com.example.attentipteamcharmander.models.UserModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.security.InvalidParameterException;

public class ProfileActivity extends AppCompatActivity {

    //FloatingActionButton fab = findViewById(R.id.fab);
    public static final String FULLNAME_KEY = "FULLNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Setup();
    }

    private void Setup(){
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        UserSet();
    }

    private void UserSet(){
        Intent startIntent = getIntent();
        UserModel userModel = getUserModelFromSources(startIntent.getExtras());
        String username = userModel.getFullname();
        TextView user = findViewById(R.id.usernameP);
        user.setText(username);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homebar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {
            CambiarHome();
        }

        return true;
    }

    public void CambiarHome(){
        Intent intent;
        intent =  new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }


}