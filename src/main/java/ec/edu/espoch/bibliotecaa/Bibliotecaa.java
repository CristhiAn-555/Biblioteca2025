/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espoch.bibliotecaa;

import ec.edu.espoch.bibliotecaa.modelo.Estanterias;
import ec.edu.espoch.bibliotecaa.modelo.Lectores;
import ec.edu.espoch.bibliotecaa.modelo.Libros;
import ec.edu.espoch.bibliotecaa.modelo.Registros;
import ec.edu.espoch.bibliotecaa.modelo.Tarjeta;
import ec.edu.espoch.bibliotecaa.modelo.estadosLibros;
import ec.edu.espoch.bibliotecaa.modelo.tiposTarjetas;
import ec.edu.espoch.bibliotecaa.modelo.zonasPermitidas;
import java.util.Scanner;

/**
 *
 * @author PERSONAL
 */
public class Bibliotecaa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" BIBLIOTECA ITINERANTE DE ORELLANA  ");

        // CREAR ESTANTERÍA 
        System.out.print("Ingrese el número de estantería: ");
        int numEst = sc.nextInt();
        Estanterias est = new Estanterias(numEst);

        System.out.print("¿Cuántos libros desea agregar?: ");
        int nLibros = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        for (int i = 0; i < nLibros; i++) {
            System.out.println("\nLibro #" + (i + 1));
            System.out.print("Código: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            System.out.print("Título: ");
            String titulo = sc.nextLine();

            System.out.print("Autor: ");
            String autor = sc.nextLine();

            System.out.print("Género: ");
            String genero = sc.nextLine();

            System.out.print("Estado (1=DISPONIBLE, 2=PRESTADO, 3=RESERVADO): ");
            int estadoOpcion = sc.nextInt();
            sc.nextLine();
            estadosLibros estado = (estadoOpcion == 1) ? estadosLibros.DISPONIBLE : estadosLibros.PRESTADO ;

            System.out.print("Número de compartimento: ");
            int comp = sc.nextInt();
            sc.nextLine();

            est.agregarLibro(new Libros(codigo, titulo, autor, genero, estado), comp);
        }

        System.out.println("\n--- Estantería inicializada ---");
        est.listarCompartimentos();

        // === REGISTROS DE LECTORES ===
        Registros registros = new Registros();
        System.out.print("\n¿Cuántos lectores desea registrar?: ");
        int nLectores = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nLectores; i++) {
            System.out.println("\nLector #" + (i + 1));
            System.out.print("Cédula: ");
            String cedula = sc.nextLine();

            System.out.print("Zona: ");
            String zona = sc.nextLine();

            System.out.print("Hora de llegada (HH:MM): ");
            String hora = sc.nextLine();

            registros.agregarLector(new Lectores(cedula, zona, hora));
        }

        System.out.println("\n-- Lista de lectores registrados ---");
        for (Lectores l : registros.listarRegistros()) {
            System.out.println(l);
        }

        registros.depurarDuplicados();
        System.out.println("\n--- Después de depurar duplicados ---");
        for (Lectores l : registros.listarRegistros()) {
            System.out.println(l);
        }

        registros.ordenarPorHoraLlegada();
        System.out.println("\n--- Ordenados por hora de llegada ---");
        for (Lectores l : registros.listarRegistros()) {
            System.out.println(l);
        }

        // === BÚSQUEDA DE LIBRO ===
        System.out.print("\nIngrese el código del libro a buscar: ");
        int codigoBuscado = sc.nextInt();
        sc.nextLine();

        Libros encontrado = est.buscarEstanteria(codigoBuscado);
        if (encontrado != null) {
            System.out.println("Libro encontrado: " + encontrado);
        } else {
            System.out.println("Libro no encontrado.");
        }

        // === CREACIÓN DE TARJETAS ===
        System.out.print("\nIngrese cantidad de tarjetas a crear: ");
        int nTarjetas = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nTarjetas; i++) {
            System.out.println("\nTarjeta #" + (i + 1));
            System.out.print("Código: ");
            String codigo = sc.nextLine();

            System.out.print("Zona permitida (1=LECTURA, 2=ADMINISTRACION): ");
            int zona = sc.nextInt();
            sc.nextLine();
            zonasPermitidas zp = (zona == 1) ? zonasPermitidas.LECTURA : zonasPermitidas.ADMINISTRACION;

            System.out.print("Tipo (1=LECTOR, 2=COORDINADOR): ");
            int tipo = sc.nextInt();
            sc.nextLine();
            tiposTarjetas tt = (tipo == 1) ? tiposTarjetas.LECTOR : tiposTarjetas.COORDINADOR;

            System.out.print("Nivel de acceso: ");
            int nivel = sc.nextInt();
            sc.nextLine();

            Tarjeta t = new Tarjeta(codigo, zp, tt, nivel);
            System.out.println("Tarjeta creada: " + t);
        }

        System.out.println("\n=== Fin del programa ===");
        sc.close();
    }
}
