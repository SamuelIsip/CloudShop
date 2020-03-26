package com.example.cloudshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class VerImagen2 extends AppCompatActivity {

    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_imagen2);

        imagen=(ImageView)findViewById(R.id.imagenCompleta);

        Bundle b = getIntent().getExtras();

        if(b!=null){
            imagen.setImageResource(b.getInt("imagen"));
        }
    }
}
