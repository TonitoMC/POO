/**
 * Pants class used to store information about Pants in the store
 * @author Jose Merida
 * @version 1.0
 * @since 28-10-2023
 */
public class Pants extends Clothe{
    private int size;
    private String type;

    /**
     * Constructor for Pants class
     * @param size Integer that stores the pants' size
     * @param type String that stores the pants' type
     */
    public Pants(int id, String name, int available, int sold, String state, int price, int size, String type){
        super(id, name, available, sold, state, price, "Pants");
        this.size = size;
        this.type = type;
    }

    /**
     * Getter method for size attribute
     * @return Size
     */
    public int getSize(){
    return size;
    }

    /**
     * Getter method for type attribute
     * @return Type
     */
    public String getType(){
        return type;
    }

    /**
     * This method returns information about specific pants for it to be able to be displayed to the user
     * @return String w/ relevant information about pants
     */
    public String getData(){
        return id + " | " + name + " | " + size + " | " + type + " | " + available + " disponibles";
    }
}