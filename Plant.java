/**
 * This class stores information related to plants, also provides getters and setters
 * for mammal-specific attributes
 * @author Jose Merida
 * @version 1.0
 * @since 09-10-2023
 */
public class Plant extends Species {
    private String plantType;
    private String period;
    /**
     * Creates a new plant with the specified attributes
     * @param name Sets the name of the plant
     * @param scientistName Sets name of the person who discovered it
     * @param discoveryDate Sets the discovery date
     * @param era Sets the era
     * @param discoveryLocation Sets the discovery location
     * @param plantType Sets the plant type
     * @param period Sets the period
     */
    public Plant(String name, String scientistName, String discoveryDate, String era, String discoveryLocation, String plantType, String period) {
        super(name, scientistName, discoveryDate, "Planta", era, discoveryLocation);
        this.plantType = plantType;
        this.period = period;
    }
    /**
     * Getter method for plantType
     * @return String plantType
     */
    public String getPlantType(){
        return plantType;
    }
    /**
     * Getter method for Period
     * @return String Period
     */
    public String getPeriod(){
        return period;
    }
}