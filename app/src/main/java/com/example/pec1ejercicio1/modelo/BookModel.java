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

        //Añadimos mas libros
        BookItem book3 = new BookItem(2, "Title5", "Author3", new Date(), "Description3", null);
        BookItem book4 = new BookItem(3, "Title3", "Author6", new Date(), "Description6", null);
        BookItem book5 = new BookItem(4, "Title6", "Author4", new Date(), "Description4", null);
        BookItem book6 = new BookItem(5, "Title4", "Author5", new Date(), "Description5", null);
        ITEMS.add (book3);
        ITEMS.add (book4);
        ITEMS.add (book5);
        ITEMS.add (book6);

        BookItem book7 = new BookItem(6, "Title6", "Author3", new Date(), "Description6", null);
        BookItem book8 = new BookItem(7, "Title8", "Author6", new Date(), "Description7", null);
        BookItem book9 = new BookItem(8, "Title9", "Author6", new Date(), "Description8", null);
        BookItem book10 = new BookItem(9, "Title7", "Author5", new Date(), "Description9", null);
        ITEMS.add (book7);
        ITEMS.add (book8);
        ITEMS.add (book9);
        ITEMS.add (book10);
    }

}
