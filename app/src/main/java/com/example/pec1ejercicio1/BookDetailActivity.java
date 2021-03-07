package com.example.pec1ejercicio1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

/*
La actividad BookDetailActivity, sera una de nuestras pantallas segundarias del proyecto, aqui se enviaran
al layout para pantallas con un ancho menor de 900db la informacion del libro seleccionado, y pudiendo volver
a la pantalla anterior a traves de un metodo ya diseñado del propio android.
 */
public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        /*
        Cargamos el bar de la pantalla
         */
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /*
        Se recoge la informacion provenientes del adaptador, y se enviara al Layout correspondiente a esta actividad.
         */
        Bundle bundle = new Bundle();
        bundle.putString("titulo",
                getIntent().getStringExtra("titulo"));
        bundle.putString("autor",
                getIntent().getStringExtra("autor"));
        bundle.putString("fecha",
                getIntent().getStringExtra("fecha"));
        bundle.putString("descripcion",
                getIntent().getStringExtra("descripcion"));

        BookDetailFragment bookFragment = new BookDetailFragment();
        bookFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.item_detail_container, bookFragment)
                .commit();
    }

    /*
    Este metodo esta previamente definido en el android, por lo que definimos la navegacion a una pantalla concreta,
    en este caso volvemos a la actividad principal o pantalla anterior.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, BookListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
