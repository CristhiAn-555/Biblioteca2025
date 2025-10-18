/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.bibliotecaa.modelo;

/**
 *
 * @author PERSONAL
 */
public class Lectores {

private String cedula;
    private String barrio;
    private String horaLlegada;

    public Lectores(String cedula, String barrio, String horaLlegada) {
        this.cedula = cedula;
        this.barrio = barrio;
        this.horaLlegada = horaLlegada;
    }

    public String getCedula() { return cedula; }
    public String getBarrio() { return barrio; }
    public String getHoraLlegada() { return horaLlegada; }

    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setBarrio(String barrio) { this.barrio = barrio; }
    public void setHoraLlegada(String horaLlegada) { this.horaLlegada = horaLlegada; }

    public boolean registrarLector(tiposTarjetas tipoTarjeta) {
        return tipoTarjeta != null;
    }

    @Override
    public String toString() {
        return "Lector [Cédula=" + cedula + ", Barrio=" + barrio + ", Hora Llegada=" + horaLlegada + "]";
    }
}


