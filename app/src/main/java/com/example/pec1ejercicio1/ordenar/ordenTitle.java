package com.example.pec1ejercicio1.ordenar;

import com.example.pec1ejercicio1.modelo.BookItem;

import java.util.Comparator;

/*
La clase ordenTitle sirve para ordenar un objeto BookItem de forma natural y por el atributo Titulo.
 */
public class ordenTitle implements Comparator<BookItem> {

    @Override
    public int compare(BookItem b1, BookItem b2) {
        return b1.getTitulo().compareTo(b2.getTitulo());
    }
}
