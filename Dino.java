/**
 * This class stores information related to dinosaurs, also provides getters and setters
 * for dinosaur-specific attributes
 * @author Jose Merida
 * @version 1.0
 * @since 09-10-2023
 */
public class Dino extends Species{
    private String dinosaurType;
    private int height;
    private int weight;
    /**
     * Creates a new dinosaur with the specified attributes
     * @param name Sets the dinosaur's name
     * @param scientistName Sets the scientist who discovered it's name
     * @param discoveryDate Sets the date of discovery
     * @param era Sets the era
     * @param discoveryLocation Sets the location of its discovery
     * @param dinosaurType Sets the type of dinosaur
     * @param height Sets the height of the dinosaur
     * @param weight Sets the weight of the dinosaur
     */
    public Dino(String name, String scientistName, String discoveryDate, String era, String discoveryLocation, String dinosaurType, int height, int weight){
        super(name, scientistName, discoveryDate, "Dinosaurio", era, discoveryLocation);
        this.dinosaurType = dinosaurType;
        this.height = height;
        this.weight = weight;
    }
    /**
     * Getter method for dinosaurType
     * @return String dinosaurType
     */
    public String getDinosaurType(){
        return dinosaurType;
    }
    /**
     * Getter method for Height
     * @return Int Height
     */
    public int getHeight(){
        return height;
    }
    /**
     * Getter method for Weight
     * @return Int weight
     */
    public int getWeight(){
        return weight;
    }
}
