package com.example.cloudshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ListView lista;
    Productos produc = new Productos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos la toolbar
        toolbar =(Toolbar)findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);

        //Creamos la lista con productos
        lista = findViewById(R.id.lvProductos);

        lista.setAdapter(new Adaptador(this,produc.getProductos(),produc.getImagenesP())); //Un nuevo Adaptador


    }

    //Creamos el menú
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu,mimenu);
        return true;
    }

    //Se le da una función específica a cada botón
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.carrito:
                Intent intent = new Intent(MainActivity.this, Carrito.class);

                startActivity(intent);
                break;
            case R.id.buscar:
                Toast.makeText(this,"**CloudShop** es la tienda online de componentes informáticos" +
                        " mejor valorada por los usuarios. Busque lo que necesite y cómprelo" +
                        " buscando las mejores ofertas. ¡Que disfrute de sus compras!" +
                        " Nr. Contacto: +34 642 200 428", Toast.LENGTH_LONG).show();
                Uri uri = Uri.parse("http://www.google.es/");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

        }
        return true;
    }



}
