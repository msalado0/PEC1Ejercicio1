package com.example.pec1ejercicio1.modelo;

import java.util.ArrayList;
import java.util.List;

/*
La clase BookModel es una clase de utilidades para el objeto BookItem, y recogeran todos los metodos auxiliares necesarios
para nuestra aplicacion movil.
 */
public class BookModel {

    /*
    El metodo rellenarListaLibros, se diseña para crear un numero determinados de BookItem, en este caso
    el numero de libros que devolvera sera en la que se defina en la variable "numeroLibros", dichos BookItem
    se crean mediante un numero del 1 a n.
     */
    public static List<BookItem> rellenarListaLibros(){
        List<BookItem> res = new ArrayList<>();
        int numeroLibros = 15;
        for(int i = 0; i < numeroLibros; i++){
            Integer j = i;
            j++;
            res.add(new BookItem(j.toString(), "Item "+j.toString()));
        }
        return res;
    }
}
