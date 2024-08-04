/**
 * This class is a superclass for Book, Disc, Article, Newspaper and Thesis. Its purpose is to
 * create basic attributes and methods that its subclasses have in common
 * @author Jose Merida
 * @version 1.0
 * @since 18-10-2023
 */
public class Item {
    protected String name;
    protected String genre;
    protected String author;
    protected int year;
    protected String editorial;
    protected String type;

    /**
     * Constructor for a new item
     * @param name 
     * @param genre
     * @param author
     * @param year
     * @param editorial
     * @param type
     */
    public Item(String name, String genre, String author, int year, String editorial, String type){
    this.name = name;
    this.genre = genre;
    this.author = author;
    this.year = year;
    this.editorial = editorial;
    this.type = type;
}
public String getName(){
    return name;
}
public String getGenre(){
    return genre;
}
public String getAuthor() {
    return author;
}
public int getYear(){
    return year;
}
public String getEditorial() {
    return editorial;
}
public String getType(){
    return type;
}
    public String getApa(){
        String toReturn = author + " (" + year + ") " + name + ". " + editorial;
        return toReturn;
    }
}