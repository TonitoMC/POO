/**
 * @author José Mérida y Sophié Cleaves
 * @version 1.0
 * Fecha de creación: 13-08-2023
 * Última actualización: 15-08-2023
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Se crean las localidades y el comprador
        Localidad loc1 = new Localidad(400, 20);
        Localidad loc5 = new Localidad(695, 20);
        Localidad loc10 = new Localidad(2350, 20);
        Comprador compradorActual = new Comprador();
        boolean inProgram = true;
        //Loop para que el programa regrese al menu principal
        while (inProgram) {
            //Print del menu
            System.out.println("Seleccione el número de opción a la que desea acceder");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            //Scanner para la seleccion de opciones
            Scanner scanner = new Scanner(System.in);
            System.out.println("6. Salir");
            int introValue = scanner.nextInt();
            //Switch case para cada seleccion
            switch (introValue) {
                case 1:
                    //Toma detalles del comprador actual
                    compradorActual.getDetails();
                    break;
                case 2:
                    //Crea una nueva solicitud, se toman los datos y se valida
                    Solicitud soli = new Solicitud();
                    soli.getDetails();
                    soli.validate();
                    //Cuentas de tickets comprados por venta
                    int loc1count = 0;
                    int loc5count = 0;
                    int loc10count = 0;
                    System.out.println(soli.valid);
                    //Si la solicitud es valida
                    if (soli.valid == true) {
                        //Loop hasta que no haya boletos
                        while (soli.boletos > 0) {
                            //Escoge una localidad al azar
                            int randomLocation = (int) Math.floor(Math.random() * (3) + 1);
                            switch (randomLocation) {
                                //Verifica si hay lugares y presupuesto
                                case 1:
                                    if (loc1.lugares > 0 && (soli.presupuesto > loc1.precio)) {
                                        loc1count++;
                                        soli.vender(loc1.precio);
                                        loc1.vender();
                                    }
                                    else {
                                        soli.end();
                                        //Termina la solicitud de lo contrario
                                    }
                                    break;
                                case 2:
                                    if (loc5.lugares > 0 && (soli.presupuesto > loc5.precio)) {
                                        loc5count++;
                                        soli.vender(loc5.precio);
                                        loc5.vender();
                                    } else
                                    {
                                        soli.end();
                                    }
                                    break;
                                case 3:
                                    if (loc10.lugares > 0 && (soli.presupuesto > loc10.precio)) {
                                        loc10count++;
                                        soli.vender(loc10.precio);
                                        loc10.vender();
                                        soli.presupuesto = soli.presupuesto-loc1.precio;
                                    }
                                    else {
                                        soli.end();
                                    }
                                    break;
                            }
                        }
                        //Imprime los datos de la transacción
                        int totalTransaccion = ((loc1count * loc1.precio) + (loc5count * loc5.precio) + (loc10count * loc10.precio));
                        System.out.println("Se vendieron");
                        System.out.println(loc1count + " boletos de la locación 1,");
                        System.out.println(loc5count + " boletos de la locación 5");
                        System.out.println("Y " + loc10count + " boletos de la locación 10");
                        System.out.println("Por un total de " + totalTransaccion);
                        compradorActual.showDetails();
                    } else {
                        System.out.println("El ticket no fue validado con éxito, regresando al menú principal");
                    }
                    break;
                case 3:
                    //Imprime los datos de disponibilidad
                    System.out.println("En la localidad 1 se han vendido " + (20 - loc1.lugares) + " boletos");
                    System.out.println("En la localidad 5 se han vendido " + (20 - loc5.lugares) + " boletos");
                    System.out.println("En la localidad 10 se han vendido " + (20 - loc10.lugares) + " boletos");
                    System.out.println("Quedan " + (loc1.lugares + loc5.lugares + loc10.lugares) + " boletos disponibles en total");
                    break;
                case 4:
                    //Scanner para determinar la localidad
                    System.out.println("Ingrese el número de localidad sobre la cual desea información (1, 5, 10)");
                    int numLocalidad = scanner.nextInt();
                    switch (numLocalidad){
                        case 1:
                            //Mostrar disponibilidad en cada localidad
                        loc1.showAvailability();
                            break;
                        case 5:
                            loc5.showAvailability();
                            break;
                        case 10:
                            loc10.showAvailability();
                            break;
                        default:
                            System.out.println("Número de localidad inválido");
                    }
                    break;
                case 5:
                    //Muestra los ingresos de cada localidad
                    int ingresosTotales = loc1.ingresos + loc5.ingresos + loc10.ingresos;
                    System.out.println("La localidad 5 ha generado $" + loc5.ingresos);
                    System.out.println("La localidad 10 ha generado $" + loc10.ingresos);
                    System.out.println("En total se han generado $" + ingresosTotales);
                    break;
                case 6:
                    //Termina el programa
                    System.exit(0);
                    break;
                default:
                    //Regresa al menu en caso de seleccion invalida
                    System.out.println("Selección inválida");
                    break;
            }
        }
    }
}
