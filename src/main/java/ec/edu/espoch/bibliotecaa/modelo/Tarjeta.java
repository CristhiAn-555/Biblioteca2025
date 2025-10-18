/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.bibliotecaa.modelo;

/**
 *
 * @author PERSONAL
 */
public record Tarjeta(
    
        String prefijoCodigo,
        zonasPermitidas zonasPermitidas,
        tiposTarjetas tipoTarjeta,
        int limitePrestamos
) {}
