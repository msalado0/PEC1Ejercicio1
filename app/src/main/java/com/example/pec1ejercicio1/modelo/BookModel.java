package com.example.pec1ejercicio1.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
La clase BookModel es una clase de utilidades para el objeto BookItem, y recogeran todos los metodos auxiliares necesarios
para nuestra aplicacion movil.
 */
/*
Para la segunda parte del codigo (ejercicios 2 en adelante), actualizaremos la clase BookModel con un
atributo static, y se cargara los datos mediante un metodo tambien static.
 */
public class BookModel {

    /*
    Se declara una lista de tipo BookItem, el cual contendra nuestros libros que son los que se visualizaran
    en nuestra app.
     */
    public static final List <BookItem> ITEMS = new ArrayList <> ();
    /*
    A continuacion, se crea un metodo static que permitira cargar nuestro atributo anterior de libros.
     */
    static {
        BookItem book1 = new BookItem(0, "Title1", "Author1", new Date(), "Description", null);
        BookItem book2 = new BookItem(1, "Title2", "Author2", new Date(), "Description2", null);
        ITEMS.add (book1);
        ITEMS.add (book2);
    }

}
