/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.bibliotecaa.modelo;

/**
 *
 * @author PERSONAL
 */
public class Libros {
     private int codigo;
    private String titulo;
    private String autor;
    private String genero;
    private estadosLibros estado;

    public Libros(int codigo, String titulo, String autor, String genero, estadosLibros estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.estado = estado;
    }

    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public estadosLibros getEstado() { return estado; }

    public void setEstado(estadosLibros estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Libro [Código=" + codigo + ", Título=" + titulo + ", Autor=" + autor +
               ", Género=" + genero + ", Estado=" + estado + "]";
    }
}
