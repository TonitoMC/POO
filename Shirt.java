/**
 * Shirt class used to store information about Shirts in the store
 * @author Jose Merida
 * @version 1.0
 * @since 28-10-2023
 */
public class Shirt extends Clothe{
    private String size;
    private String color;

    /**
     * Constructor for Shirt class
     * @param size String that stores the shirt's size
     * @param color String that stores the shirt's color
     */
    public Shirt(int id, String name, int available, int sold, String state, int price, String size, String color){
        super(id, name, available, sold, state, price, "Shirt");
        this.size = size;
        this.color = color;
    }

    /**
     * Getter method for size attribute
     * @return Size
     */
    public String getSize(){
        return size;
    }

    /**
     * Getter method for color attribute
     * @return Color
     */
    public String getColor(){
        return color;
    }

    /**
     * Method used to get relevant information about a specific collar in a way that can be shown to the user
     * @return String w/ relevant information about a specific collar
     */
    public String getData(){
        return id + " | " + name + " | " + size + " | " + color + " | " + available + " disponibles";
    }
}
