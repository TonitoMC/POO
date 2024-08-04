/**
 * This class is a superclass for Pants, Collar and Shirt, its purpose is to
 * create basic attributes and methods its subclasses have in common
 * @author Jose Merida
 * @version 1.0
 * @since 28-10-2023
 */
public class Clothe {
    protected int id;
    protected String name;
    protected int available;
    protected int sold;
    protected String state;
    protected int price;
    protected String category;

    /**
     * Constructor for a new Clothe
     * @param id A unique integer that serves as identifier for each Clothe
     * @param name A name as identifier for each clothe
     * @param available The availability (quantity available)
     * @param sold The amount that has been sold
     * @param state The state of the clothe (available or not)
     * @param price The price of the clothe
     * @param category The category (Pants, Shirt or Collar)
     */

    public Clothe(int id, String name, int available, int sold, String state, int price, String category){
        this.id = id;
        this.name = name;
        this.available = available;
        this.sold = sold;
        this.state = state;
        this.price = price;
        this.category = category;
    }

    /**
     * Method that calculates the sales of a specific item in the store
     * @return Integer representing the sales
     */
    public int getSales(){
        return sold * price;
    }

    /**
     * Getter method for Category attribute
     * @return Category
     */
    public String getCategory(){
        return category;
    }

    /**
     * Getter method for ID attribute
     * @return ID
     */
    public int getId(){
        return id;
    }

    /**
     * Getter method for name attribute
     * @return Name
     */
    public String getName(){
        return name;
    }

    /**
     * Getter method for Available attribute
     * @return Available
     */
    public int getAvailable(){
        return available;
    }

    /**
     * Getter method for Sold attribute
     * @return Sold
     */
    public int getSold(){
        return sold;
    }

    /**
     * Getter method for price attribute
     * @return Sold
     */
    public int getPrice(){
        return price;
    }

    /**
     * Getter method for state attribute
     * @return State
     */
    public String getState(){
        return state;
    }

    /**
     * This method is used to sell items, decreased items in stock and increases items sold
     * @param qty The quantity of the items to be sold
     */
    public void sell(int qty){
        if (qty <= available){
            available = available - qty;
            sold = sold + qty;
        }
    }

    /**
     * This method is used to add inventory, changed Available attribute to reflect that
     * @param toAdd Amount of inventory to be added
     */
    public void addInventory(int toAdd){
        available = available + toAdd;
    }
}
