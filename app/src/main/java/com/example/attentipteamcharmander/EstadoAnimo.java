package com.example.attentipteamcharmander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.attentipteamcharmander.data.UserConfig;
import com.example.attentipteamcharmander.model.UserModel;

import java.security.InvalidParameterException;

public class EstadoAnimo extends AppCompatActivity {

    public static final String FULLNAME_KEY = "FULLNAME";
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_animo);
        SetUp();
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

    private void SetUp(){
        Intent startIntent = getIntent();
        text = findViewById(R.id.textNombre);

        UserModel userModel = getUserModelFromSources(startIntent.getExtras());
        text.setText("Hola, " + userModel.getFullname());
    }




}