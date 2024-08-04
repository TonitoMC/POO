import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This program is a tool for an auto-repair shop, keeps track of cars,
 * the services they have come for and their details. Also keeps track of
 * the most popular services, brands and models.
 * @author Jose Merida / Sophie Cleaves
 * @version 1.0
 * @since 07-09-2023
 */
public class Main {
    /**
     * Main method that uses ArrayLists to keep track of certain analytics
     * and an ArrayList of cars to keep track of their information and services
      * @param args unused
     */
    public static void main(String[] args) {
        /**
         * Creates all the ArrayLists necessary
         */
    ArrayList<Car> carList = new ArrayList<>();
    ArrayList<String> uniqueBrandList = new ArrayList<>();
    ArrayList<String> brandList = new ArrayList<>();
    ArrayList<String> serviceNameList = new ArrayList<>();
    ArrayList<String> uniqueServiceNameList = new ArrayList<>();
    ArrayList <String> lineNameList = new ArrayList<>();
    ArrayList <String> uniqueLineNameList = new ArrayList<>();
        /**
         * Keeps the main menu in a loop
         */
    while(true){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de opción a la que desea ingresar");
        System.out.println("1. Agregar un vehículo");
        System.out.println("2. Realizar servicio a un vehículo existente");
        System.out.println("3. Información sobre un vehículo existente");
        System.out.println("4. Obtener datos analíticos");
        System.out.println("5. Salir del programa");
        int mainSelect = scanner.nextInt();
        scanner.nextLine();
        //Switch case for main menu selection
        switch (mainSelect){
            /**
             * Adding a new car, requests for user input and creates
             * a car with the parameters entered. Also adds certain values to ArrayLists
             */
            case 1:
                System.out.println("Ingrese el número de placa del carro");
                String currentPlate = scanner.nextLine();
                System.out.println("Ingrese la marca del carro");
                String currentBrand = scanner.nextLine();
                System.out.println("Ingrese la línea del carro");
                String currentLine = scanner.nextLine();
                System.out.println("Ingrese el modelo del carro");
                int currentModel = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingrese el nombre del dueño");
                String currentOwner = scanner.nextLine();
                if (!brandList.contains(currentBrand)){
                    uniqueBrandList.add(currentBrand);
                }
                brandList.add(currentBrand);
                if (!lineNameList.contains(currentLine)){
                    uniqueLineNameList.add(currentLine);
                }
                lineNameList.add(currentLine);
                carList.add(new Car(currentPlate, currentBrand, currentLine, currentModel, currentOwner));
                break;
            /**
             * Adds a service to a car. Requests for user to select a car from list
             * and details of the service providad
             */
            case 2:
                System.out.println("Elija el vehículo al que le quiere realizar el servicio de la siguiente lsita");
                for(int i = 0; i < carList.size(); ++i) {
                    Car currentCar = (Car)carList.get(i);
                    int listCount = i + 1;
                    System.out.println("" + listCount + ". " + currentCar.getDetails());
                }
                int carSelect = scanner.nextInt();
                scanner.nextLine();
                Car selectedCar = carList.get(carSelect-1);
                System.out.println("Ingrese el nombre del servicio que se le realizará al carro");
                String currentServiceName = scanner.nextLine();
                System.out.println("Ingrese la fecha de realización del servicio");
                String currentServiceDate = scanner.nextLine();
                System.out.println("Ingrese el número de factura del servicio");
                int currentServiceId = scanner.nextInt();
                if (!serviceNameList.contains(currentServiceName)){
                    uniqueServiceNameList.add(currentServiceName);
                }
                serviceNameList.add(currentServiceName);
                scanner.nextLine();
                Service currentService = new Service(currentServiceDate, currentServiceName, currentServiceId);
                selectedCar.addService(currentService);
                break;
            /**
             * Prints out information about a vehicle and the services that have been done to it
             * requests user input for selecting a specific car
             */
            case 3:
                System.out.println("Elija el vehículo sobre el cual desea obtener información");
                for(int i = 0; i < carList.size(); i++){
                    Car currentCar = (Car)carList.get(i);
                    int listCount = i+1;
                    System.out.println(" " + listCount + ". " + currentCar.getDetails());
                }
                int carSelection = scanner.nextInt();
                scanner.nextLine();
                Car selectionCar = carList.get(carSelection-1);
                System.out.println(selectionCar.getAll());
                System.out.println("Los servicios que se le han realizado al carro son los siguientes:");
                ArrayList<Service> serviceList = selectionCar.getServices();
                for (int i = 0; i < serviceList.size(); i++){
                    Service loopService = serviceList.get(i);
                    System.out.println(loopService.getDetails());
                }
                break;
            /**
             * Shows analytics, including number of cars, popularity of brands, services and models
             */
            case 4:
                System.out.println("El número de vehículos que han ingresado al taller es de " + carList.size());
                System.out.println("La popularidad de las marcas es la siguiente: ");
                ArrayList<Integer> brandCount = new ArrayList<>();
                for(String p : uniqueBrandList){
                int countCount = Collections.frequency(brandList, p);
                brandCount.add(countCount);
                }
                for(int i = 0; i<uniqueBrandList.size(); i++){
                    System.out.println(uniqueBrandList.get(i) + " " + brandCount.get(i));
                }
                ArrayList<Integer> serviceCount = new ArrayList<>();
                System.out.println("La popularidad de los servicios es la siguiente");
                for(String p : uniqueServiceNameList){
                    int countCount = Collections.frequency(serviceNameList, p);
                    serviceCount.add(countCount);
                }
                for(int i = 0; i<uniqueServiceNameList.size(); i++){
                    System.out.println(uniqueServiceNameList.get(i) + " " + serviceCount.get(i));
                }
                ArrayList<Integer> lineCount = new ArrayList<>();
                System.out.println("Las lineas más comunes son las siguientes: ");
                for(String p : uniqueLineNameList){
                    int countCount = Collections.frequency(lineNameList, p);
                    lineCount.add(countCount);
                }
                for(int i = 0; i<uniqueLineNameList.size(); i++){
                    System.out.println(uniqueServiceNameList.get(i) + " " + serviceCount.get(i));
            }
                break;
            /**
             * Exits the program
             */
            case 5:
                System.exit(0);
                break;
            /**
             * Defaults back to main menu
             */
            default:
                System.out.println("Selección inválida");
        }
    }

    }
}