package com.example.cloudshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context context;
    String[][] productos;
    int[]imagenesP;
    TextView nombre;
    TextView precio;
    TextView opiniones;
    ImageView imagen;
    ImageButton botonEnv;
    ImageButton botonInf;
    Productos produc;

    public Adaptador(Context contexto, String[][] productos, int[] imagenesP) {
        this.context=contexto;
        this.productos=productos;
        this.imagenesP=imagenesP;

        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagenesP.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.item_lista_productos,null);

        nombre=(TextView)vista.findViewById(R.id.txtNombre);
        precio = (TextView)vista.findViewById(R.id.txtPrecio);
        opiniones =(TextView)vista.findViewById(R.id.txtOpiniones);

        botonEnv = vista.findViewById(R.id.botonEnviar);
        botonInf = vista.findViewById(R.id.botonInfo);

        imagen = (ImageView)vista.findViewById(R.id.ivimagen);

        nombre.setText(productos[i][0]);
        precio.setText("Precio: "+productos[i][1]+"€");
        opiniones.setText("Opiniones: "+productos[i][2]);
        imagen.setImageResource(imagenesP[i]);

        //+++++
        produc = new Productos();

        imagen.setTag(i);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen = new Intent(context,VerImagen2.class);
                visorImagen.putExtra("imagen",imagenesP[(Integer)v.getTag()]);
                context.startActivity(visorImagen);
            }
        });

        botonEnv.setTag(i);

        botonEnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "¡Añadido a Carrito!", Toast.LENGTH_SHORT).show();
                Intent carritoCompras = new Intent(v.getContext(), Carrito.class);
                //++++++
                produc.aniadirElem(productos[(Integer)v.getTag()][0],productos[(Integer)v.getTag()][1]);

                carritoCompras.putExtra("titulo", productos[(Integer)v.getTag()][0]);
                carritoCompras.putExtra("precio", productos[(Integer)v.getTag()][1]);
               // context.startActivity(carritoCompras);

            }
        });

        botonInf.setTag(i);

        botonInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorDetalles = new Intent(v.getContext(), DatosItems.class);
                visorDetalles.putExtra("titulo", productos[(Integer)v.getTag()][0]);
                visorDetalles.putExtra("detalles", productos[(Integer)v.getTag()][3]);
                context.startActivity(visorDetalles);
            }
        });

        return vista;
    }
}
