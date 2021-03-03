package com.example.pec1ejercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pec1ejercicio1.modelo.BookItem;

import java.util.List;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder> {

    private List<BookItem> listaLibros;
    private boolean detailFragment;
    private final BookListActivity bookListActivity;

    public BookRecyclerViewAdapter(List<BookItem> libros, boolean detailF, BookListActivity listActivity){
        listaLibros = libros;
        detailFragment = detailF;
        bookListActivity = listActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final BookItem book = listaLibros.get(position);
        holder.mIdView.setText(book.id);
        holder.mContentView.setText(book.contenido);
        holder.itemView.setTag(listaLibros.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookItem aux = (BookItem) view.getTag();
                if(detailFragment) {
                    Bundle bundle = new Bundle();
                    bundle.putString("id", aux.id);
                    BookDetailFragment fragment = new BookDetailFragment();
                    fragment.setArguments(bundle);
                    bookListActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                }else{
                    Intent intent = new Intent(view.getContext(), BookDetailActivity.class);
                    intent.putExtra("id", aux.id);
                    view.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mIdView;
        final TextView mContentView;

        ViewHolder(View view) {
            super(view);
            mIdView = (TextView) view.findViewById(R.id.id_text);
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}
