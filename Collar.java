/**
 * Collar class used to store information about Collar objects in the store
 * @author Jose Merida
 * @version 1.0
 * @since 28-10-2023
 */
public class Collar extends Clothe{
    private String size;
    private String material;

    /**
     * Constructor for collar class
     * @param size String (XS, S, M... etc.) that stores the collar's size
     * @param material String that stores the collar's material
     */
    public Collar(int id, String name, int available, int sold, String state, int price, String size, String material){
        super(id, name, available, sold, state, price, "Collar");
        this.size = size;
        this.material = material;
    }

    /**
     * Getter method for size attribute
     * @return Size
     */
    public String getSize(){
        return size;
    }

    /**
     * Getter method for material attribute
     * @return Material
     */
    public String getMaterial(){
        return material;
    }

    /**
     * This method returns relevant information about a specific collar, used to display information to the user
     * in a more friendly manner
     * @return String w/ information about a specific collar
     */
    public String getData(){
        return id + " | " + name + " | " + size + " | " + material + " | " + available + " Disponibles";
    }
}
