package com.example.pec1ejercicio1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.pec1ejercicio1.modelo.BookItem;
import com.example.pec1ejercicio1.modelo.BookModel;
import com.example.pec1ejercicio1.ordenar.ordenAutor;
import com.example.pec1ejercicio1.ordenar.ordenTitle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/*
Esta aplicación se realizo teniendo como base el modelo Maestro/detalle previamente definido, pero hemos adaptado
dicho modelo a nuestras necesidades, como objeto que demos de construir, informacion a mostrar, etc.
 */
/*
La actividad BookListActivity, sera nuestra pantalla principal del proyecto, aqui se cargaran
nuestras listas de libros, y mediante un adaptador personalizado mostraremos los datos deseados por pantalla
de una vista concreta.
 */
public class BookListActivity extends AppCompatActivity {

    /*
    En primer lugar necesitaremos 3 atributos, nuestro adaptador, un conjunto de libros y una variable boolean
    para saber en que tipo de pantalla estamos, si estamos en un ancho mayor de 900 nuestra aplicacion mostrara
    una visual algo cambiada.
     */

    /*
    La activity se modificara desde el ejercicio 2 en adelante para que la aplicacion, pueda manejar los nuevos
    cambios añadidos en las clases que se encuentran en el paquete modelo.
     */
    private RecyclerView recyclerView;
    private List<BookItem> listaLibros;
    private boolean detailFragment;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        /*
        Si detectamos que el FrameLayout para las pantalla mayores de 900db, no es null, estaremos ante una
        pantalla de una table, por lo que el boolean declarado en los atributos sera true.
         */
        if (findViewById(R.id.item_detail_container) != null) {
            detailFragment = true;
        }

        /*
        Cargamos nuestra lista de libros con la variable static declarada y cargada con la informacion de la clase
        java BookModel.
         */
        listaLibros = BookModel.ITEMS;

        /*
        Una vez sepamos en que clase de pantalla se esta ejecutando la aplicacion, y tengamos cargada nuestra
        lista de libros, es necesarios enviar la informacion a nuestro adaptador, para que visualice los datos,
        por lo que lanzamos el adaptador.
         */
        /*
        Como se puede observar, nuestro adaptador lo hemos hecho en una clase java independiente, esto es debido a que en el
        ejercicio 1 se implemento de forma independente a esta activity, por lo que seguimos con la misma dinamica.
         */
        recyclerView = findViewById(R.id.item_list);
        BookRecyclerViewAdapter view = new BookRecyclerViewAdapter(listaLibros, detailFragment, this);
        /*
        Añadimos un GridLayoutManager y lo modificamos en el recycleView, de esta forma, podremos obtenermo todas
        las filas que queramos con un solo elemento para todos los libros (con elemento me refiero a un titulo,
        un autor, y una imagen).
         */
        if(!detailFragment){
            //El gridLayoutManager conserva los huecos, pero para este ejemplo necesitamos el StaggeredGridLayoutManager
            /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(gridLayoutManager);*/

            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        }
        recyclerView.setVerticalFadingEdgeEnabled(true);
        recyclerView.setFadingEdgeLength(100);

        recyclerView.setAdapter(view);
        /*
        requiresFadingEdge="vertical"
    android:fadingEdgeLength="400dp"
         */
    }

    /*
    Con este metodo, llamamos al xml que contiene los objetos para crear nuestro menu.
     */
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu_list,menu);
        return true;
    }

    /*
    Este metodo capturaremos las iteraciones de un usuario con el menu, para saber que funcion desea
    realizar, en este caso, que tipo de ordenacion desea ver en pantalla. (ojo, es obligatorio poner default)

    Se realizara una reordenacion de la lista de libros, y luego se lo enviaremos al adaptador, para que vuelva a cargar
    la pantalla con dicho orden, para ello nos ayudaremos de dos clases javas que hemos creado en el paquete ordenar.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean onOptionsItemSelected(MenuItem item) {
        BookRecyclerViewAdapter view;
        switch (item.getItemId()) {
            case R.id.order_by_title:
                listaLibros.sort(new ordenTitle());
                view = new BookRecyclerViewAdapter(listaLibros, detailFragment, this);
                recyclerView.setAdapter(view);
                return true;

            default:
                listaLibros.sort(new ordenAutor());
                view = new BookRecyclerViewAdapter(listaLibros, detailFragment, this);
                recyclerView.setAdapter(view);
                return true;
        }
    }

}
