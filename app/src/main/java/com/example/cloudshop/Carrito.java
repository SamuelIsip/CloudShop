package com.example.cloudshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class Carrito extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    private Toolbar toolbar;
    private ArrayAdapter adaptador;
    private ArrayList<String> listaElementos;
    //+++++
    private ArrayList<String> listaElementos2;
    String titulo, precio;
    //+++++
    Productos produc;
    Button btnComp;
    TextView precioTot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        //Creamos la toolbar
        toolbar =(Toolbar)findViewById(R.id.toolbar1);
        btnComp = findViewById(R.id.btnComprar);
        precioTot = findViewById(R.id.txtPrecio);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para añadir la flecha de "atrás"

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //+++++++
        produc = new Productos();
        listaElementos2 = new ArrayList<String>(produc.recogerElem());
        precioTot.setText("Precio : "+String.valueOf(produc.PrecioTotal())+"€");

        if(!listaElementos2.isEmpty()){
            ListView listaProduc = findViewById(R.id.lvPCarrito);
            adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, listaElementos2);
            listaProduc.setAdapter(adaptador);
            listaProduc.setOnItemLongClickListener(this);

        }
        else{
            listaElementos = new ArrayList<String>();

            Bundle b = getIntent().getExtras();

            if(b!= null){

                titulo = (b.getString("titulo"));
                precio = (b.getString("precio"));
            }else
            {
                titulo = "Vacío";
                precio =" ";
            }

            listaElementos.add(titulo+" "+precio+"€..");

            ListView listaProduc = findViewById(R.id.lvPCarrito);
            adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, listaElementos);
            listaProduc.setAdapter(adaptador);
        }


    }

    public void RealizarCompra(View vista) {
        Toast.makeText(this,
                "¡Productos Comprados!", Toast.LENGTH_SHORT).show();
        listaElementos2.removeAll(listaElementos2);
        precioTot.setText(R.string.precioTot);
        adaptador.notifyDataSetChanged();
    }

    //Creamos el menú
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu,mimenu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem register = menu.findItem(R.id.aniadir);
            register.setVisible(true);
        register = menu.findItem(R.id.carrito);
            register.setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.aniadir:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.buscar:
                Toast.makeText(this,R.string.info, Toast.LENGTH_LONG).show();
                Uri uri = Uri.parse("http://www.google.es/");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

        }
        return true;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        listaElementos2.remove(position);
        adaptador.notifyDataSetChanged();

        Toast.makeText(this,
                R.string.elim, Toast.LENGTH_SHORT).show();
        return false;
    }
}
