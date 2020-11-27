package com.example.attentipteamcharmander;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.attentipteamcharmander.data.UserConfig;


import com.example.attentipteamcharmander.model.UserModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class OnBoarding extends AppCompatActivity {


    EditText EtNombre;
    TextInputLayout editText;
    MaterialButton botonContinuar;
    UserModel userModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        setUp();
    }


    private void setUp(){

        editText = findViewById(R.id.editText1);
        EtNombre= editText.getEditText();
        botonContinuar= findViewById(R.id.botonContinuar);


        botonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               signUp();
            }
        });

        loadDefaultDataIfDebug();
    }

    @SuppressLint("SetTextI18n")
    private void loadDefaultDataIfDebug() {
        EtNombre.setText("");
    }

    private void saveUser(UserModel user) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setUser(user);
    }

    private void navigateToMain(UserModel user) {
        Intent intent = new Intent(this, MainActivity.class);

        //la proxima activity ahora será la primera en el back stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(MainActivity.FULLNAME_KEY, user.getFullname());
        startActivity(intent);
    }

    private void signUp() {
        userModel = new UserModel(EtNombre.getText().toString());
        saveUser(userModel);
        navigateToMain(userModel);
    }

}