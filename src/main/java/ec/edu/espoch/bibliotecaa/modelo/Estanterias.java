/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.bibliotecaa.modelo;

/**
 *
 * @author PERSONAL
 */
public class Estanterias {
   
private Libros[] compartimentos;
    private int codigo;

    public Estanterias(int codigo) {
        this.codigo = codigo;
        compartimentos = new Libros[30];
    }

    public boolean agregarLibro(Libros libro, int posicion) {
        if (posicion < 1 || posicion > 30) return false;
        compartimentos[posicion - 1] = libro;
        return true;
    }

    public Libros buscarEstanteria(int codigoLibro) {
        for (Libros l : compartimentos) {
            if (l != null && l.getCodigo() == codigoLibro) return l;
        }
        return null;
    }

    public void listarCompartimentos() {
        for (int i = 0; i < compartimentos.length; i++) {
            if (compartimentos[i] != null) {
                System.out.println("Posición " + (i+1) + ": " + compartimentos[i]);
            } else {
                System.out.println("Posición " + (i+1) + ": Vacía");
            }
        }
    }
}


