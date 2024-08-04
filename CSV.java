import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is in-charge of all the calculations, CSV file management and data storage in the progra
 * @author Jose Merida
 * @version 1.0
 * @since 18-10-2023
 */

public class CSV {
    private ArrayList<Item> itemList;
    private String csvFile;

    /**
     * Constructor for CSV class, creates empty itemList
     */
    public CSV() {
        this.csvFile = "data.csv";
        this.itemList = new ArrayList<>();
    }

    /**
     * Reads CSV file and stores information in itemList
     */

    public void readCSV() {
        String line;
        try (
                BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ArrayList<String> tempList = new ArrayList<>();
                for (String field : data) {
                    tempList.add(field);
                }
                String currentName = tempList.get(0);
                String currentGenre = tempList.get(1);
                String currentAuthor = tempList.get(2);
                int currentYear = Integer.parseInt(tempList.get(3));
                String currentEditorial = tempList.get(4);
                String currentType = tempList.get(5);
                if (currentType.equals("Book")) {
                    Book newBook = new Book(currentName, currentGenre, currentAuthor, currentYear, currentEditorial);
                    itemList.add(newBook);
                } else if (currentType.equals("Disc")) {
                    Disc newDisc = new Disc(currentName, currentGenre, currentAuthor, currentYear, currentEditorial);
                    itemList.add(newDisc);
                } else if (currentType.equals("Article")) {
                    Article newArticle = new Article(currentName, currentGenre, currentAuthor, currentYear, currentEditorial);
                    itemList.add(newArticle);
                } else if (currentType.equals("Newspaper")) {
                    Newspaper newNewspaper = new Newspaper(currentName, currentGenre, currentAuthor, currentYear, currentEditorial);
                    itemList.add(newNewspaper);
                } else if (currentType.equals("Thesis")) {
                    Thesis newThesis = new Thesis(currentName, currentGenre, currentAuthor, currentYear, currentEditorial);
                    itemList.add(newThesis);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes information from itemList and writes it into a CSV file
     */
    public void writeCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (Item currentItem : itemList) {
                String itemData = currentItem.getName() + ","
                        + currentItem.getGenre() + ","
                        + currentItem.getAuthor() + ","
                        + currentItem.getYear() + ","
                        + currentItem.getEditorial() + ","
                        + currentItem.getType() + ",";
                bw.write(itemData);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is used to get the count of how many objects of a specific class exist in itemList
     * @param className Name of the class we want to get the count of
     * @return The count of how many objects of a specific class name exist
     */
    public int getCountOf(String className) {
        ArrayList<Item> typeList = getItemList(className);
        return typeList.size();
    }

    /**
     * This method is used to get a list of all the objcts of a specific class in itemList
     * @param className Name of the class we want to get the objects of
     * @return ArrayList of Item containing the objects of a Class
     */
    public ArrayList<Item> getItemList(String className) {
        ArrayList<Item> typeList = new ArrayList<>();
        for (Item currentItem : itemList) {
            String currentItemClass = currentItem.getClass().getSimpleName();
            if (currentItemClass.equals(className)) {
                typeList.add(currentItem);
            }
        }
        return typeList;
    }

    /**
     * Getter for itemList
     * @return ArrayList itemList
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * This method counts how many objects have been "authored" by the same person
     * @return ArrayList consisting of strings with each author and their corresponding number of items
     */
    public ArrayList<String> countByAuthor() {
        ArrayList<String> uniqueAuthorList = new ArrayList<>();
        ArrayList<Integer> uniqueAuthorCount = new ArrayList<>();
        ArrayList<String> returnList = new ArrayList<>();
        for (Item currentItem : itemList) {
            String currentAuthor = currentItem.getAuthor();
            if (!uniqueAuthorList.contains(currentAuthor)) {
                uniqueAuthorList.add(currentAuthor);
            }
        }
        for (String currentAuthor : uniqueAuthorList) {
            int currentAuthorCount = 0;
            for (Item currentItem : itemList) {
                String currentItemAuthor = currentItem.getAuthor();
                if (Objects.equals(currentItemAuthor, currentAuthor)) {
                    currentAuthorCount++;
                }
            }
            uniqueAuthorCount.add(currentAuthorCount);
        }
        for (int i = 0; i < uniqueAuthorList.size(); i++) {
            String toAdd = uniqueAuthorList.get(i) + " | " + uniqueAuthorCount.get(i);
            returnList.add(toAdd);
        }
        return returnList;
    }

    /**
     * This method counts how many items belong to each genre
     * @return ArrayList consisting of strings with each genre and their corresponding number of items
     */
    public ArrayList<String> countByGenre() {
        ArrayList<String> uniqueGenreList = new ArrayList<>();
        ArrayList<Integer> uniqueGenreCount = new ArrayList<>();
        ArrayList<String> returnList = new ArrayList<>();
        for (Item currentItem : itemList) {
            String currentGenre = currentItem.getGenre();
            if (!uniqueGenreList.contains(currentGenre)) {
                uniqueGenreList.add(currentGenre);
            }
        }
        for (String currentGenre : uniqueGenreList) {
            int currentGenreCount = 0;
            for (Item currentItem : itemList) {
                String currentItemGenre = currentItem.getGenre();
                if (Objects.equals(currentItemGenre, currentGenre)) {
                    currentGenreCount++;
                }
            }
            uniqueGenreCount.add(currentGenreCount);
        }
        for (int i = 0; i < uniqueGenreList.size(); i++) {
            String toAdd = uniqueGenreList.get(i) + " | " + uniqueGenreCount.get(i);
            returnList.add(toAdd);
        }
        return returnList;
    }

    /**
     * This method counts how many items were published each year
     * @return ArrayList consisting of strings with each year and their corresponding number of items
     */
    public ArrayList<String> countByYear() {
        ArrayList<Integer> uniqueYearList = new ArrayList<>();
        ArrayList<Integer> uniqueYearCount = new ArrayList<>();
        ArrayList<String> returnList = new ArrayList<>();
        for (Item currentItem : itemList) {
            int currentYear = currentItem.getYear();
            if (!uniqueYearList.contains(currentYear)) {
                uniqueYearList.add(currentYear);
            }
        }
        for (int currentYear : uniqueYearList) {
            int currentYearCount = 0;
            for (Item currentItem : itemList) {
                int currentItemYear = currentItem.getYear();
                if (currentItemYear == currentYear) {
                    currentYearCount++;
                }
            }
            uniqueYearCount.add(currentYearCount);
        }
        for (int i = 0; i < uniqueYearList.size(); i++) {
            String toAdd = uniqueYearList.get(i) + " | " + uniqueYearCount.get(i);
            returnList.add(toAdd);
        }
        return returnList;
    }

    /**
     * Adds an object to itemList
     * @param toAdd Object to be added
     */
    public void addItem(Item toAdd){
        itemList.add(toAdd);
    }
}
