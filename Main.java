import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;

/**
 * This program is a tool for a library to keep track of its inventory / collection
 * of different bibliographic items.
 * @author Jose Merida
 * @version 1.0
 * @since 18-10-2023
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Creates scanner and CSV-Class object, reads CSV file
         * to update information after last use.
         */
        Scanner scanner = new Scanner(System.in);
        CSV readWriter = new CSV();
        readWriter.readCSV();
        while(true){
            /**
             * Main menu in while loop to keep the program running
             */
            System.out.println("Bienvenido al programa");
            System.out.println("Ingrese el numero de la opcion a la que desea ingresar");
            System.out.println("1. Mostrar conteo por categoria");
            System.out.println("2. Mostrar catalogo disponible");
            System.out.println("3. Mostrar conteo por autor, genero y año de publicación");
            System.out.println("4. Mostrar catalogo de una categoria");
            System.out.println("5. Agregar un nuevo item");
            System.out.println("6. Actualizar el archivo CSV y salir del programa");
            try {
                int mainSelect = scanner.nextInt();
                switch (mainSelect) {
                    case 1:
                        /**
                         * Prints out the 5 different types of items and how many of them are present
                         * in the library's collection
                         */
                        System.out.println("Actualmente la biblioteca cuenta con la siguiente cantidad de items:");
                        System.out.println("Libros: " + readWriter.getCountOf("Book"));
                        System.out.println("DVD: " + readWriter.getCountOf("Disc"));
                        System.out.println("Articulos Cientificos: " + readWriter.getCountOf("Article"));
                        System.out.println("Periodicos: " + readWriter.getCountOf("Newspaper"));
                        System.out.println("Tesis: " + readWriter.getCountOf("Thesis"));
                        break;
                    case 2:
                        /**
                         * Prints out every item out of the library's collection and creates an APA citation
                         * for each one.
                         */
                        System.out.println("El catalogo disponible es el siguiente");
                        ArrayList<Item> printList = readWriter.getItemList();
                        for (Item currentItem : printList) {
                            String itemName = currentItem.getName();
                            String itemApa = currentItem.getApa();
                            System.out.println(itemName + " | " + itemApa);
                        }
                        break;
                    case 3:
                        /**
                         * Prints out each author name, genre and year of publication
                         * as well as how many items are present in the library's
                         * with the specific attribute.
                         */
                        ArrayList<String> authorCountList = readWriter.countByAuthor();
                        ArrayList<String> genreCountList = readWriter.countByGenre();
                        ArrayList<String> yearCountList = readWriter.countByYear();
                        System.out.println("Conteo por autor:");
                        for (String p : authorCountList) {
                            System.out.println(p);
                        }
                        System.out.println("Conteo por genero");
                        for (String p : genreCountList) {
                            System.out.println(p);
                        }
                        System.out.println("Conteo por año");
                        for (String p : yearCountList) {
                            System.out.println(p);
                        }
                        break;
                    case 4:
                        /**
                         * Gets user input to select new item type. Prints out each item's name and APA citation.
                         */
                        System.out.println("Ingrese el numero de la categoria de la cual desea ver los items");
                        System.out.println("1. Libros");
                        System.out.println("2. DVD");
                        System.out.println("3. Articulos Cientificos");
                        System.out.println("4. Periodicos");
                        System.out.println("5. Tesis");
                        int typeSelect = scanner.nextInt();
                        switch (typeSelect) {
                            case 1:
                                /**
                                 * Gets list of all the Book objects, prints out name and APA citation
                                 */
                                ArrayList<Item> bookList = readWriter.getItemList("Book");
                                if (bookList.isEmpty()) {
                                    System.out.println("No hay ningun libro");
                                } else {
                                    for (Item currentItem : bookList) {
                                        String itemName = currentItem.getName();
                                        String itemApa = currentItem.getApa();
                                        System.out.println(itemName + " | " + itemApa);
                                    }
                                }
                                break;
                            case 2:
                                /**
                                 * Gets list of all the Disc objects, prints out name and APA citation
                                 */
                                ArrayList<Item> discList = readWriter.getItemList("Disc");
                                if (discList.isEmpty()) {
                                    System.out.println("No hay ningun DVD");
                                } else {
                                    for (Item currentItem : discList) {
                                        String itemName = currentItem.getName();
                                        String itemApa = currentItem.getApa();
                                        System.out.println(itemName + " | " + itemApa);
                                    }
                                }
                                break;
                            case 3:
                                /**
                                 * Gets list of all Article objects, prints out name and APA citation
                                 */
                                ArrayList<Item> articleList = readWriter.getItemList("Article");
                                if (articleList.isEmpty()) {
                                    System.out.println("No hay ningun articulo cientifico");
                                } else {
                                    for (Item currentItem : articleList) {
                                        String itemName = currentItem.getName();
                                        String itemApa = currentItem.getApa();
                                        System.out.println(itemName + " | " + itemApa);
                                    }
                                }
                                break;
                            case 4:
                                /**
                                 * Gets list of all Newspaper objects, prints out name and APA citation
                                 */
                                ArrayList<Item> newspaperList = readWriter.getItemList("Newspaper");
                                if (newspaperList.isEmpty()) {
                                    System.out.println("No hay ningun periodico");
                                } else {
                                    for (Item currentItem : newspaperList) {
                                        String itemName = currentItem.getName();
                                        String itemApa = currentItem.getApa();
                                        System.out.println(itemName + " | " + itemApa);
                                    }
                                }
                                break;
                            case 5:
                                /**
                                 * Gets list of all Thesis objects, prints out name and APA citation
                                 */
                                ArrayList<Item> thesisList = readWriter.getItemList("Thesis");
                                if (thesisList.isEmpty()) {
                                    System.out.println("No hay ninguna tesis");
                                }
                                for (Item currentItem : thesisList) {
                                    String itemName = currentItem.getName();
                                    String itemApa = currentItem.getApa();
                                    System.out.println(itemName + " | " + itemApa);
                                }
                                break;
                            default:
                                System.out.println("Seleccion invalida, regresando al menu principal");
                                break;
                        }
                        break;
                    case 5:
                        /**
                         * Requests user input and creates a new object of the specifies Class
                         */
                        System.out.println("Ingrese el numero de la categoria del item que desea agregar");
                        System.out.println("1. Libros");
                        System.out.println("2. DVD");
                        System.out.println("3. Articulos Cientificos");
                        System.out.println("4. Periodicos");
                        System.out.println("5. Tesis");
                        int varSelect = scanner.nextInt();
                        scanner.nextLine();
                        switch (varSelect) {
                            case 1:
                                System.out.println("Ingrese el nombre del libro");
                                String currentBookName = scanner.nextLine();
                                System.out.println("Ingrese el genero");
                                String currentBookGenre = scanner.nextLine();
                                System.out.println("Ingrese el autor");
                                String currentBookAuthor = scanner.nextLine();
                                System.out.println("Ingrese el año de publicacion");
                                int currentBookYear = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Ingrese la editorial");
                                String currentBookEditorial = scanner.nextLine();
                                readWriter.addItem(new Book(currentBookName, currentBookGenre, currentBookAuthor, currentBookYear, currentBookEditorial));
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre del DVD");
                                String currentDiscName = scanner.nextLine();
                                System.out.println("Ingrese el genero");
                                String currentDiscGenre = scanner.nextLine();
                                System.out.println("Ingrese el director");
                                String currentDiscAuthor = scanner.nextLine();
                                System.out.println("Ingrese el año de publicacion");
                                int currentDiscYear = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Ingrese la productora");
                                String currentDiscEditorial = scanner.nextLine();
                                readWriter.addItem(new Disc(currentDiscName, currentDiscGenre, currentDiscAuthor, currentDiscYear, currentDiscEditorial));
                                break;
                            case 3:
                                System.out.println("Ingrese el nombre del articulo");
                                String currentArticleName = scanner.nextLine();
                                System.out.println("Ingrese el genero o tema");
                                String currentArticleGenre = scanner.nextLine();
                                System.out.println("Ingrese el autor");
                                String currentArticleAuthor = scanner.nextLine();
                                System.out.println("Ingrese el año de publicacion");
                                int currentArticleYear = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Ingrese la revista de publicacion o editorial");
                                String currentArticleEditorial = scanner.nextLine();
                                readWriter.addItem(new Article(currentArticleName, currentArticleGenre, currentArticleAuthor, currentArticleYear, currentArticleEditorial));
                                break;
                            case 4:
                                System.out.println("Ingrese el titulo del periodico");
                                String currentNewspaperName = scanner.nextLine();
                                System.out.println("Ingrese el genero o tema");
                                String currentNewspaperGenre = scanner.nextLine();
                                System.out.println("Ingrese el autor");
                                String currentNewspaperAuthor = scanner.nextLine();
                                System.out.println("Ingrese el año de publicacion");
                                int currentNewspaperYear = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Ingrese el periodico que lo publico o editorial");
                                String currentNewspaperEditorial = scanner.nextLine();
                                readWriter.addItem(new Newspaper(currentNewspaperName, currentNewspaperGenre, currentNewspaperAuthor, currentNewspaperYear, currentNewspaperEditorial));
                                break;
                            case 5:
                                System.out.println("Ingrese el titulo de la tesis");
                                String currentThesisName = scanner.nextLine();
                                System.out.println("Ingrese el genero o tema");
                                String currentThesisGenre = scanner.nextLine();
                                System.out.println("Ingrese el autor");
                                String currentThesisAuthor = scanner.nextLine();
                                System.out.println("Ingrese el año de publicacion");
                                int currentThesisYear = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Ingrese la editorial o institucion academica");
                                String currentThesisEditorial = scanner.nextLine();
                                readWriter.addItem(new Thesis(currentThesisName, currentThesisGenre, currentThesisAuthor, currentThesisYear, currentThesisEditorial));
                                break;
                            default:
                                System.out.println("Seleccion incorrecta, volviendo al menu principal");
                                break;
                        }
                        break;
                    case 6:
                        /**
                         * Updates CSV file and closes the program
                         */
                        readWriter.writeCSV();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Seleccion incorrecta, regresando al menu principal");
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("Entrada incorrecta, regresando al menu principal. Por favor intente nuevamente");
            }
        }

        }
    }