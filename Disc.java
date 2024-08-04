public class Disc extends Item{
    public Disc(String name, String genre, String author, int year, String editorial) {
        super(name, genre, author, year, editorial, "Disc");
    }
    public String getAPA(){
        String toReturn = author + ". (" + year + ") " + name + " [DVD]. " + editorial;
        return toReturn;
    }
}
