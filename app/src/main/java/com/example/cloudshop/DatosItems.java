package com.example.cloudshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DatosItems extends AppCompatActivity {

    private Toolbar toolbar;
    TextView nombreP;
    TextView detalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_items);

        //Creamos la toolbar
        toolbar =(Toolbar)findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para añadir la flecha de "atrás"

        nombreP = findViewById(R.id.tvTituloDescripcion);
        detalles = findViewById(R.id.tvdescripcion);

        Bundle b = getIntent().getExtras();

        if(b!= null){

            nombreP.setText(b.getString("titulo"));
            detalles.setText(b.getString("detalles"));
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
