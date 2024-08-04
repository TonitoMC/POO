import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * This program is a tool for a museum to keep track of different specimens in different categories
 * Dinosaurs, plants and mammals are stored within this program and each category has specific attributes
 * that must be stores and accessed / displayed
 * @author Jose Merida
 * @version 1.0
 * @since 09-10-2023
 */
public class Main {
    /**
     * Main method used as Driver class for the whole program
     * Displays menus and utilizes Plant, Mammal, Dino and Species class to store information
     * Access it and displays it to the user.
     */
    public static void main(String[] args) {
        //ArrayList to store all the species added
        ArrayList<Species> speciesList = new ArrayList<>();
        /*
        While loop for main menu, displays options
         */
    while(true){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al programa, elija a la que desea ingresar:");
        System.out.println("1. Registrar un nuevo especimen");
        System.out.println("2. Mostrar todos los especimenes catalogados");
        System.out.println("3. Mostrar los 3 dinosaurios mas grandes");
        System.out.println("4. Mostrar los especimenes descubiertos por un descubridor");
        System.out.println("5. Salir del programa");
        /**
        Try - catch for miss-inputs from user, returns to main menu if there's an exception.
         */
        try {
            int mainSelect = scanner.nextInt();
            scanner.nextLine();
        /**
        Switch case for main menu selection
         */
            switch (mainSelect) {
                case 1:
                /**
                Requests user input for information about the species, followed by a selection of species type
                 */
                    System.out.println("Ingrese el nombre de la especie");
                    String currentSpeciesName = scanner.nextLine();
                    System.out.println("Ingrese el nombre del descubridor");
                    String currentSpeciesScientist = scanner.nextLine();
                    System.out.println("Ingrese la fecha de descubrimiento");
                    String currentSpeciesDate = scanner.nextLine();
                    System.out.println("Ingrese la era geologica de la especie");
                    String currentSpeciesEra = scanner.nextLine();
                    System.out.println("Ingrese el lugar de descubrimiento de la especie");
                    String currentSpeciesLocation = scanner.nextLine();
                    System.out.println("Ingrese el numero correspondiente al tipo de especimen que desea registrar");
                    System.out.println("1. Dinosaurio");
                    System.out.println("2. Planta");
                    System.out.println("3. Mamifero");
                    int typeSelect = scanner.nextInt();
                    scanner.nextLine();
                /**
                Requests specific information about the species depending on its type to the user, creates
                each type based on selection and adds to species list.
                 */
                    switch (typeSelect) {
                        case 1:
                            System.out.println("Ingrese el tipo de dinosaurio (Herbivoro o Carnivoro)");
                            String currentDinoType = scanner.nextLine();
                            System.out.println("Ingrese la altura del dinosaurio (Redondeado al entero mas cercano, en metros)");
                            int currentDinoHeight = scanner.nextInt();
                            System.out.println("Ingrese el peso del dinosaurio (Redondeado al entero mas cercano, en kilogramos)");
                            int currentDinoWeight = scanner.nextInt();
                            Dino currentDino = new Dino(currentSpeciesName, currentSpeciesScientist, currentSpeciesDate, currentSpeciesEra, currentSpeciesLocation, currentDinoType, currentDinoHeight, currentDinoWeight);
                            speciesList.add(currentDino);
                            break;
                        case 2:
                            System.out.println("Ingrese el tipo de la planta");
                            String currentPlantType = scanner.nextLine();
                            System.out.println("Ingrese el periodo de existencia de la planta");
                            String currentPlantPeriod = scanner.nextLine();
                            Plant currentPlant = new Plant(currentSpeciesName, currentSpeciesScientist, currentSpeciesDate, currentSpeciesEra, currentSpeciesLocation, currentPlantType, currentPlantPeriod);
                            speciesList.add(currentPlant);
                            break;
                        case 3:
                            System.out.println("Ingrese el tipo de dieta del mamifero (Herbivoro o Carnivoro)");
                            String currentMammalDiet = scanner.nextLine();
                            System.out.println("Ingrese el habitat del mamifero");
                            String currentMammalHabitat = scanner.nextLine();
                            Mammal currentMammal = new Mammal(currentSpeciesName, currentSpeciesScientist, currentSpeciesDate, currentSpeciesEra, currentSpeciesLocation, currentMammalDiet, currentMammalHabitat);
                            speciesList.add(currentMammal);
                            break;
                        default:
                            System.out.println("Seleccion invalida, prueba de nuevo");
                    }
                    break;
                case 2:
                /**
                *Separates Species list into 3 separate lists depending on type
                 */
                    ArrayList<Dino> tempDinoList = new ArrayList<>();
                    for (Species currentSpecies : speciesList) {
                        if (currentSpecies instanceof Dino) {
                            tempDinoList.add((Dino) currentSpecies);
                        }
                    }
                    ArrayList<Plant> tempPlantList = new ArrayList<>();
                    for (Species currentSpecies : speciesList) {
                        if (currentSpecies instanceof Plant) {
                            tempPlantList.add((Plant) currentSpecies);
                        }
                    }
                    ArrayList<Mammal> tempMammalList = new ArrayList<>();
                    for (Species currentSpecies : speciesList) {
                        if (currentSpecies instanceof Mammal) {
                            tempMammalList.add((Mammal) currentSpecies);
                        }
                    }
                /**
                *Checks if list each individual list is empty, if it's not empty then it prints out its elements
                 */
                    if (tempDinoList.isEmpty()) {
                        System.out.println("No hay dinosaurios registrados en este momento.");
                    } else {
                        System.out.println("Los dinosaurios registrados son los siguientes:");
                        for (Dino currentDino : tempDinoList) {
                            System.out.println(currentDino.getName() + " | " + currentDino.getEra() + " | " + currentDino.getHeight() + "m y " + currentDino.getWeight() + "kgs | " + currentDino.getDinosaurType() + " descubierto por " + currentDino.getScientist() + " en " + currentDino.getDiscoveryLocation() + ", " + currentDino.getDiscoveryDate());
                        }
                    }
                    if (tempPlantList.isEmpty()) {
                        System.out.println("No hay plantas registradas en este momento.");
                    } else {
                        System.out.println("Las plantas registradas son las siguientes:");
                        for (Plant currentPlant : tempPlantList) {
                            System.out.println(currentPlant.getName() + " | Periodo: " + currentPlant.getPeriod() + " | " + currentPlant.getEra() + " | " + currentPlant.getPlantType() + " descubierta por " + currentPlant.getScientist() + " en " + currentPlant.getDiscoveryLocation() + ", " + currentPlant.getDiscoveryDate());
                        }
                    }
                    if (tempMammalList.isEmpty()) {
                        System.out.println("No hay plantas registradas en este momento.");
                    } else {
                        System.out.println("Los mamiferos registrados son los siguientes:");
                        for (Mammal currentMammal : tempMammalList) {
                            System.out.println(currentMammal.getName() + " | " + currentMammal.getHabitat() + " | " + currentMammal.getEra() + " | " + currentMammal.getDiet() + " descubierto por " + currentMammal.getScientist() + " en " + currentMammal.getDiscoveryLocation() + ", " + currentMammal.getDiscoveryDate());
                        }
                    }
                    break;
                case 3:
                /**
                *Creates list of all Dinosaurs in speciesList, sorts and prints out the 3 largest.
                 **/
                    ArrayList<Dino> dinoList = new ArrayList<>();
                    for (Species currentSpecies : speciesList) {
                        if (currentSpecies instanceof Dino) {
                            dinoList.add((Dino) currentSpecies);
                        }
                    }
                    if (dinoList.size() < 3) {
                        System.out.println("No hay suficientes dinosaurios como para mostrar los 3 mas grandes");
                    } else {
                        Collections.sort(dinoList, Comparator.comparingInt(Dino::getHeight).reversed());
                        System.out.println("Los 3 dinosaurios mas altos son los siguientes:");
                        for (int i = 0; i < 3; i++) {
                            Dino currentDino = dinoList.get(i);
                            System.out.println(currentDino.getName() + " | " + currentDino.getEra() + " | " + currentDino.getHeight() + "m y " + currentDino.getWeight() + "kgs | " + currentDino.getDinosaurType() + " descubierto por " + currentDino.getScientist() + " en " + currentDino.getDiscoveryLocation() + ", " + currentDino.getDiscoveryDate());
                        }
                    }
                    break;
                case 4:
                    /**
                     * Makes a list and then prints out individual Scientists' names for the user to see, so they
                     * can then input a Scientist name and view all of their discoveries
                     */
                    System.out.println("Ingrese el nombre del descubridor deseado de manera identica a como aparece en la siguiente lista");
                    ArrayList<String> scientistList = new ArrayList<>();
                    for (Species currentSpecies : speciesList) {
                        String scientistName = currentSpecies.getScientist();
                        if (scientistName !: )
                    }
                    String currentScientist = scanner.nextLine();
                    ArrayList<Species> tempSpeciesList = new ArrayList<>();
                    for (Species currentSpecies : speciesList) {
                        if (Objects.equals(currentSpecies.getScientist(), currentScientist)) {
                            tempSpeciesList.add(currentSpecies);
                        }
                    }
                    if (tempSpeciesList.isEmpty()) {
                        System.out.println("No se encontro alguna especie con el nombre del descubridor ingresado, intentelo nuevamente");
                    } else {
                        System.out.println("Los dinosaurios descubiertos por " + currentScientist + " son los siguientes:");
                        for (Species currentSpecies : tempSpeciesList) {
                            if (currentSpecies instanceof Dino) {
                                System.out.println("Nombre: " + currentSpecies.getName() + " | Descubierto en " + currentSpecies.getDiscoveryLocation() + ", " + currentSpecies.getDiscoveryDate());
                            }
                        }
                        System.out.println("Las plantas descubiertas por " + currentScientist + " son las siguientes:");
                        for (Species currentSpecies : tempSpeciesList) {
                            if (currentSpecies instanceof Plant) {
                                System.out.println("Nombre: " + currentSpecies.getName() + " | Descubierta en " + currentSpecies.getDiscoveryLocation() + ", " + currentSpecies.getDiscoveryDate());
                            }
                        }
                        System.out.println("Los mamiferos descubiertos por " + currentScientist + " son los siguientes:");
                        for (Species currentSpecies : tempSpeciesList) {
                            if (currentSpecies instanceof Mammal) {
                                System.out.println("Nombre: " + currentSpecies.getName() + " | Descubierto en " + currentSpecies.getDiscoveryLocation() + ", " + currentSpecies.getDiscoveryDate());
                            }
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Seleccion invalida, regresando al menu principal");
            }
        }catch (java.util.InputMismatchException e) {
            System.out.println("Entrada incorrecta, regresando al menu principal. Por favor intente nuevamente");
        }
    }
        }
    }