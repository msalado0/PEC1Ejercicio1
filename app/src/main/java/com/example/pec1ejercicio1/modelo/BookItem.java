package com.example.pec1ejercicio1.modelo;

import java.util.Date;

/*
La clase BookItem es donde tendremos nuestro objeto libro, el cual recogera sus atributos para poder construir
el objeto.
 */
/*
Para la segunda parte del codigo (ejercicios 2 en adelante), actualizaremos la clase BookItem con los atributos
solicitados.
 */
public class BookItem {
    //En primer lugar declaramos los atributos del objeto.
    private int identificador;
    private String titulo;
    private String autor;
    private Date fecha;
    private String descripcion;
    private String url;

    /*
    Continuamos crearemos un  constructor que permita construir el libro con todos
    los atributos anteriores.
     */
    public BookItem(int identificador, String titulo, String autor, Date fecha, String descripcion, String url) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.url = url;
    }

    /*
    Crearemos los metodos get de los atributos.
     */

    public int getIdentificador() {
        return this.identificador;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getUrl() {
        return this.url;
    }

    /*
    Crearemos elmetodo toString para visualizar un libro.
    */
    public String toString() {
        return "Identificador: "+this.getIdentificador()+
                "Titulo: "+this.getTitulo()+
                "Autor: "+this.getAutor()+
                "Fecha: "+this.getFecha()+
                "Descripcion: "+this.getDescripcion()+
                "URL: "+this.getUrl();
    }

}
