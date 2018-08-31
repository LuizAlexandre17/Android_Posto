package com.example.comp8.app_postogasolina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ListaActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


    }

    public void onClick (View view){
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(ListaActivity.this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("PROP", "40:1");
        edit.apply();
        Intent it = new Intent(ListaActivity.this, MainActivity.class);
        startActivity(it);

    }

    public void onClick1 (View view){
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(ListaActivity.this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("PROP", "25:1");
        edit.apply();
        Intent it = new Intent(ListaActivity.this, MainActivity.class);
        startActivity(it);


    }
    public void onClick2 (View view){
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(ListaActivity.this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("PROP", "20:1");
        edit.apply();
        Intent it = new Intent(ListaActivity.this, MainActivity.class);
        startActivity(it);

    }
}

