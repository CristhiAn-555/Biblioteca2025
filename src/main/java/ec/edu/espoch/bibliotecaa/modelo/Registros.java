/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.bibliotecaa.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author PERSONAL
 */
public class Registros {
    
 private ArrayList<Lectores> lectores;

    public Registros() {
        lectores = new ArrayList<>();
    }

    public void agregarLector(Lectores lector) {
        lectores.add(lector);
    }

    public boolean eliminarRegistro(String cedula) {
        return lectores.removeIf(l -> l.getCedula().equals(cedula));
    }

    public ArrayList<Lectores> buscarRegistros(String cedula) {
        ArrayList<Lectores> resultado = new ArrayList<>();
        for (Lectores l : lectores) {
            if (l.getCedula().equals(cedula)) resultado.add(l);
        }
        return resultado;
    }

    public ArrayList<Lectores> buscarRegistrosPorBarrio(String barrio) {
        ArrayList<Lectores> resultado = new ArrayList<>();
        for (Lectores l : lectores) {
            if (l.getBarrio().equalsIgnoreCase(barrio)) resultado.add(l);
        }
        return resultado;
    }

    public void depurarDuplicados() {
        ArrayList<String> vistos = new ArrayList<>();
        ArrayList<Lectores> depurados = new ArrayList<>();

        for (Lectores l : lectores) {
            if (!vistos.contains(l.getCedula())) {
                depurados.add(l);
                vistos.add(l.getCedula());
            }
        }
        lectores = depurados;
    }

    public void ordenarPorHoraLlegada() {
        Collections.sort(lectores, Comparator.comparing(Lectores::getHoraLlegada));
    }

    public int contarRegistros(String barrio) {
        int contador = 0;
        for (Lectores l : lectores)
            if (l.getBarrio().equalsIgnoreCase(barrio)) contador++;
        return contador;
    }

    public ArrayList<Lectores> listarRegistros() {
        return lectores;
    }
}

