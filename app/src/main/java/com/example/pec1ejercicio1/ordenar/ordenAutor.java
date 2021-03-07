package com.example.pec1ejercicio1.ordenar;

import com.example.pec1ejercicio1.modelo.BookItem;

import java.util.Comparator;

/*
La clase ordenAutor sirve para ordenar un objeto BookItem de forma natural y por el atributo Autor.
 */
public class ordenAutor implements Comparator<BookItem> {

    @Override
    public int compare(BookItem b1, BookItem b2) {
        return b1.getAutor().compareTo(b2.getAutor());
    }
}
