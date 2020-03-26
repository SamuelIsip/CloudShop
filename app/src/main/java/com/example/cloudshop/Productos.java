package com.example.cloudshop;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Productos {
    static ArrayList<String> listaElementos = new ArrayList<String>();
    static double precioTotal;
    //Creamos matriz con todos los datos de los productos
    String [][]productos = {
            {"Mars Gaming MK5","5.80","100","Tamaño completo, ultra delgado y compacto. Con cable y 105 teclas con teclado numérico.\n" +
                    "Conexión USB Plug&Play. Con membrana silenciosa y cómoda de pulsar.\n" +
                    "Teclado ideal para trabajo y ofimática. Con teclas multimedia dedicadas. Construcción robusta de larga durabilidad.\n" +
                    "Teclas con perfil bajo para una pulsación más cómoda y silenciosa.\n" +
                    "Compatible con todos los Sistemas Operativos. Linux, Windows, Mac, Raspberry, etc."},
            {"LeadsaiL Ratón","4.99","56","【Exacto del control 】 del dise?ó con una viruta avanzada del juego, él proporciona un reconocimiento móvil más exacto para la colocación exacta y el seguimiento confiable. Satisfaga el uso diario de la oficina y de la hospitalidad del juego.\n" +
                    "【12 DPI Professional 】 200-400-600-800-1000-1200-1600-2000-2400-3200-4000-4800DPI, 12 DPI ajustables para varias necesidades. El sensor óptico superior proporciona una aceleración máxima de 4800 dpi y 20g. Puede utilizar el disco del controlador para obtener más ajustes.\n" +
                    "【 Dynamic RGB reiluminación 】 5 opciones de modo de luz RGB: al azar, mezcla, deportes, colores del CPI, apagado. Los colores también se pueden modificar entre 16,8 millones colores. Hay varios colores disponibles a través del controlador. La exquisita iluminación le traerá el disfrute visual en la noche."},
            {"LG UM69G Monitor","15.67","456","Panel TN que permite 1ms (GtG) de velocidad de respuesta para poder disfrutar de tus juegos a máxima velocidad\n" +
                    "Tecnología RADEON FreeSync para disfrutar la acción sin parpadeos\n" +
                    "Estabilizador de Negros (Tecnología Black Stabilizer) que permite colores oscuros diferenciados\n" +
                    "Mejora de la productividad con hasta en 4 pantallas gracias al modo ScreenSplit Multipantalla"},
            {"Lavolta Cargador","6.54","88","Potencia de salida: 19V 3,42A , Tamaño del conectors:5,5*2,5mm, cable de alimentación europeo incluido Estilo ( NO para ASUS X540SA, X556U UX32VD UX303L UX21E UX31E Series, which needs 4.0mm*1.35mm))!!"},
            {"Asus K543UA","455.99","1854","Pantalla de 15,6\" - 39,62 cm\n" +
                    "Procesador intel celeron n4000 (2 núcleos, 4mb caché, 110ghz hasta 26ghz)\n" +
                    "Memoria ram de 4 gb lpddr4 2400mhz\n" +
                    "Almacenamiento: 256gb ssd sata3\n" +
                    "Endless os (en inglés)"},
            {"Logitech Altavoces","13.78","345","Para una reproducción más nítida de los efectos de sonido y la música\n" +
                    "Botones de control para encendido y ajuste de volumen\n" +
                    "Conexión frontal para auriculares\n" +
                    "Alimentado por USB - no requiere alimentación eléctrica"},
            {"Proyector APEMAN","429.99","764","【DISFRUTA VISUAL SUPERIOR】El proyector 1080P nativo de 6000 lúmenes puede dar imagenes de colores vivos incluso en habitaciones luminosas. Su relación de contraste llega a 8000:1, significa que se ve claramente los detalles y la parte oscura de imagenes. Le ofrece una experiencia mejor con los proyectores en el mismo precio.\n" +
                    "【CORRECIÓN DE GRAN ÁGULO Y DE MULTI-MODOS】Tiene la corrección trapezoidal horizontal y vertical de ±50°y la de giro de ±50°, el águlo es mucho más que lo de otros proyectores. No necesita ponerlo enfrente a la pantalla durante el uso, se puede colocar libremente según su necesidad. Soporta la función de reducción y ampliación de proporción igual de 50%. Además, tiene la función de Reset.\n" +
                    "【CINE PRIVADO DE USTED】El BOMAKER proyector 1080p le ofrece una gran imgen de 50-300 pulgadas y el efecto de audio HiFi, convierte su domitorio, salón o jardín en el teatro inmersivo exclusivo de usted. Gracias a los receptores IR en ambos del frente y el detrás, soporta instalación frontal, trasera y en techo. ¡Diviértase de nuestro producto!"},
            {"EMPIRE GAMING","1989.99","144","Ordenador de sobremesa HP 8300 SFF (Intel Core i5-3470 @ 3,2GHz (Quad Core), Memoria 8GB, Disco Duro de 500HDD DVD, WINDOWS 10 PRO ES 64)\n" +
                    "Tarjeta grafica Intel Graphics HD, Sonido High DEF Audio, Tarjeta de RED - LAN: Gigabit Ethernet, Expansion: (1) PCI; (1) PCIe x1; (1) PCIe x4; (1) PCIe x16, Puertos: (4) USB 3.0 (6) USB 2.0 (1) RJ45 (1) PUERTO SERIE (1) Displayport (1) VGA\n" +
                    "Contenido de la caja : El articulo + Adaptador de corriente/cable de corriente; factura\n" +
                    "Dimensiones: 10.0 x 33.8 x 37.9 cm (4.0 x 13.3 x 14.9 in), Peso 7.6 kg (16.7 lb)"},
            {"Kingston A400 SSD","29.99","1566","La unidad A400 de estado sólido de Kingston ofrece enormes mejoras en la velocidad de respuesta, sin actualizaciones adicionales del hardware. Brinda lapsos de arranque, carga y de transferencia de archivos increíblemente más breves en comparación con las unidades de disco duro mecánico." +
                    "Arranques, cargas y transferencias de archivos todos con mayor rapidez\n" +
                    "Más fiable y duradera que las unidades de disco duro\n" +
                    "Varias capacidades, para almacenar las aplicaciones o sustituir del todo unidades de disco duro."}
    };

    //Creamos array con todas las imágenes
    int[] imagenesP={R.drawable.teclado,R.drawable.mouse,R.drawable.monitor,R.drawable.cargador,
            R.drawable.portatil,R.drawable.altavoces,R.drawable.proyector,R.drawable.torre,R.drawable.ssd};

    public String[][] getProductos(){
        return this.productos;
    }

    public int[] getImagenesP(){
        return this.imagenesP;
    }

    public static void aniadirElem (String titulo, String precio){
        listaElementos.add(titulo+": "+precio+"€");
        double pr = Double.parseDouble(precio);
        precioTotal+=pr;
    }

    public static ArrayList<String> recogerElem(){
        return listaElementos;
    }

    public static double PrecioTotal(){

        DecimalFormat decimales = new DecimalFormat("#.##");
        decimales.format(precioTotal);
        return precioTotal;
    }

}
