/**
 * Clase comprador Clase para almacenar y mostrar los datos del comprador actual
 * @param dpi El dpi del comprador
 * @param nombre el nombre del comprador
 */

import java.util.Scanner;
public class Comprador {
    private String dpi;
    private String nombre;
    public Comprador(){

    }

    /**
     * Obtiene el nombre y el DPI del comprador
     */
    public void getDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del comprador");
        this.nombre = scanner.nextLine();
        System.out.println("Ingrese el DPI del comprador");
        this.dpi = scanner.nextLine();
    }

    /**
     * Muestra los datos del comprador
     */
    public void showDetails(){
        System.out.println("El comprador actual es " + this.nombre + " con número de DPI " + this.dpi);
    }
    }