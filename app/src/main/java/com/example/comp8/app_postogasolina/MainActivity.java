package com.example.comp8.app_postogasolina;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_consultar;
    private Button btn_calcula;
    private EditText et_quant;
    private EditText et_prop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView Image = (ImageView) findViewById(R.id.img);
        Image.setImageResource(R.drawable.img_combustivel);

        et_quant = (EditText) findViewById(R.id.main_quant);
        et_prop = (EditText) findViewById(R.id.main_prop);
        btn_calcula = (Button) findViewById(R.id.btn_calc);
        btn_consultar = (Button) findViewById(R.id.btn_tips);

        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        et_prop.setText(preferences.getString("PROP",""));

        btn_calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et_prop.getText().toString().isEmpty() && !et_quant.getText().toString().isEmpty()){
                    float prop_value_1 = 0;
                    float prop_value_2 = 0;
                    float qt =  Float.valueOf(et_quant.getText().toString());
                    float resp = -1;

                    String prop_split = et_prop.getText().toString();
                    String split_parts[] = prop_split.split(":");
                    prop_value_1 = Float.valueOf(split_parts[0].toString());
                    prop_value_2 = Float.valueOf(split_parts[1].toString());
                    resp = qt / (prop_value_1/prop_value_2);
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Informação");
                    alertDialog.setMessage("Quantidade de Oleo: " + resp + " l");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Realizar outro Calculo",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("ERRO");
                    alertDialog.setMessage("Existem Campos Vazios...");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Realizar outro Calculo",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }


            }
        });

        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ListaActivity.class);
                startActivity(it);
            }
        });
    }
}
