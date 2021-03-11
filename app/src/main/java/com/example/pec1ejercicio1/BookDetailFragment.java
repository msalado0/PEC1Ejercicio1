package com.example.pec1ejercicio1;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
/*
el Fragment BookDetailFragment, sera una de nuestras pantallas segundarias del proyecto, aqui se enviaran
al layout para pantallas con un ancho mayor de 900db y mostrando una lista de libros, y en la misma pantalla
la informacion del libro seleccionado.
 */

public class BookDetailFragment extends Fragment {

    /*
    Debemos de declarar una variable para poder construir la informacion del libro (en este caso se necesita un atributo,
    ya que la el nombre se puede construir a partir de este valor).
     */
    private int id = -1;
    private String titulo;
    private String autor;
    private String fecha;
    private String descripcion;

    /*
    Implementamos un constructor vacio, para cuando se selecciona un segundo libro, este pueda limpiar la informacion del libro
    anterior (sino lo hicieramos el texto se solaparian).
     */
    public BookDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Se recoge la informacion provenientes del adaptador, y se actualizara el layout del Toolbar para que muestre
        el nombre del libro.
         */
        id = getArguments().getInt("id");
        titulo = getArguments().getString("titulo");
        autor = getArguments().getString("autor");
        fecha = getArguments().getString("fecha");
        descripcion = getArguments().getString("descripcion");

        Activity activity = this.getActivity();
        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(titulo);
        }
    }
    /*
    En este metodo se construira la informacion que se quiere mostrar por pantalla y se enviara al elemento corrspondiente
    del layout que corresponde al del propio Frament.
     */
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_detail, container, false);
        if(id != -1){
            ((ImageView) rootView.findViewById(R.id.imagen_detail_book)).setBackgroundResource(imagen(id));
        }

        if (autor != null) {
            ((TextView) rootView.findViewById(R.id.autor_detail_book)).setText(autor);
        }

       if (fecha != null) {
           ((TextView) rootView.findViewById(R.id.fecha_detail_book)).setText(fecha);
       }

       if (descripcion != null) {
           ((TextView) rootView.findViewById(R.id.descripcion_detail_book)).setText(descripcion);
       }

        return rootView;
    }

    public int imagen(int id){
        int res = 0;
        switch (id%5 ){
            case 0: res = R.mipmap.ender; break;
            case 1: res = R.mipmap.hobby; break;
            case 2: res = R.mipmap.harry; break;
            case 3: res = R.mipmap.juego; break;
            case 4: res = R.mipmap.trono; break;
        }
        return res;
    }
}
