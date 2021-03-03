package com.example.pec1ejercicio1.modelo;

/*
La clase BookItem es donde tendremos nuestro objeto libro, el cual recogera sus atributos para poder construir
el objeto.
 */
public class BookItem {

    public String id;
    public String contenido;
    public BookItem(String id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }
    public String toString() {
        return contenido;
    }

}
