package com.example.pec1ejercicio1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pec1ejercicio1.modelo.BookItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
En esta clase java, se desarrolla nuestro adaptador personalizado para la aplicacion, que mostrara
en forma de lista los libros cargados que son pasado a esta clase, este adaptador es muy util ya que
ademas de expresar la informacion en formato lista siendo muy comun para las aplicaciones moviles, nos
indica con que elemento esta interactuando el usuario, por lo que lo identificamos rapidamente para poder
visualizar en este caso dicha informacion.
 */
public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder> {
/*
Declaramos los 3 atributos necesarios, en este caso una lsita de libros, un boolean para comprobar si estamos
en una pantalla con un ancho mayor de 900dp, y la actividad padre al que invoca este adaptador.
 */
    private List<BookItem> listaLibros;
    private boolean detailFragment;
    private final BookListActivity bookListActivity;

    /*
    Aqui tenemos el contructor del adaptador.
     */
    public BookRecyclerViewAdapter(List<BookItem> libros, boolean detailF, BookListActivity listActivity){
        listaLibros = libros;
        detailFragment = detailF;
        bookListActivity = listActivity;
    }

    /*
    En este metodo cargamos la el layout deseado para visualizar los datos deseados, y mandarlos a cada
    elemento correspondiente.
     */
    /*
    Hemos modificado el layaout que apuntaba la actividad de book_list_content a book_list_content_row
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_content_row, parent, false);
        return new ViewHolder(view);
    }

    /*
    Este elemento quizas sea el mas util de todos lo que tenemos aquim ya que nos indica que elemento esta
    teniendo alguna iteracion con el usuario, y podemos mandar dicha informacion alguna actividad para que
    gestiones esta informacion.
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final BookItem book = listaLibros.get(position);
        holder.image.setImageResource(imagen(book.getIdentificador()));
        holder.titulo.setText(book.getTitulo());
        holder.autor.setText(book.getAutor());
        holder.itemView.setTag(listaLibros.get(position));


        /*
        Añadimos un color diferente si la posicion es impar o par.
         */
        /*if (position % 2 == 0){
            holder.card.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
        }else {
            holder.card.setCardBackgroundColor(Color.parseColor("#C3C9EF"));
        }*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookItem aux = (BookItem) view.getTag();
                if(detailFragment) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", aux.getIdentificador());
                    bundle.putString("titulo", aux.getTitulo());
                    bundle.putString("autor", aux.getAutor());
                    DateFormat dateFormat =  new SimpleDateFormat( "dd-MM-yyyy");
                    bundle.putString("fecha", dateFormat.format(aux.getFecha()));
                    bundle.putString("descripcion", aux.getDescripcion());
                    BookDetailFragment fragment = new BookDetailFragment();
                    fragment.setArguments(bundle);
                    bookListActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                }else{
                    Intent intent = new Intent(view.getContext(), BookDetailActivity.class);
                    intent.putExtra("id", aux.getIdentificador());
                    intent.putExtra("titulo", aux.getTitulo());
                    intent.putExtra("autor", aux.getAutor());
                    DateFormat dateFormat =  new SimpleDateFormat( "dd-MM-yyyy");
                    intent.putExtra("fecha", dateFormat.format(aux.getFecha()));
                    intent.putExtra("descripcion", aux.getDescripcion());
                    view.getContext().startActivity(intent);
                }
            }
        });
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

    /*
    El adaptador como toda buena lista, necesita conocer cual sera el numero de lineas que necesita representar,
    por lo que solamente miramos (en este caso) el numero de libros que tenemos cargado en el atributo lista.
     */
    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    /*
    Aqui tenemos una clase vista, y es donde se inicializa en el adaptador los elementos de layout, para
    poder cargar y mostrar la informacion de los libros.
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView titulo;
        final TextView autor;
        final CardView card;

        ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.image_book);
            titulo = (TextView) view.findViewById(R.id.titulo_book);
            autor = (TextView) view.findViewById(R.id.autor_book);
            card = (CardView) view.findViewById(R.id.linea);
        }
    }
}
