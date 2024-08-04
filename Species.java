/**
 * This class is a parent Class for Plant, Mammal and Dino. It's purpose is to create basic
 * attributes and methods the 3 sublcasses have in common.
 * @author Jose Merida
 * @version 1.0
 * @since 09-10-2023
 */
public class Species {
    protected String name;
    protected String scientistName;
    protected String discoveryDate;
    protected String speciesType;

    protected String era;
    protected String discoveryLocation;

    /**
     * Creates a species with the specified attributes
     * @param name Sets the species name
     * @param scientistName Sets the scientist who discovered its name
     * @param discoveryDate Sets the discovery date
     * @param speciesType Sets the species type
     * @param era Sets the era
     * @param discoveryLocation Sets the location of discovery
     */
    public Species(String name, String scientistName, String discoveryDate, String speciesType, String era, String discoveryLocation) {
        this.name = name;
        this.scientistName = scientistName;
        this.discoveryDate = discoveryDate;
        this.era = era;
        this.discoveryLocation = discoveryLocation;
    }
    /**
     * Getter method for name
     * @return String name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter method for scientistName
     * @return String scientistName
     */
    public String getScientist() {
        return scientistName;
    }
    /**
     * Getter method for discoveryLocation
     * @return String discoveryLocation
     */
    public String getDiscoveryLocation() {
        return discoveryLocation;
    }
    /**
     * Getter method for discoveryDate
     * @return String discoveryDate
     */
    public String getDiscoveryDate() {
        return discoveryDate;
    }
    /**
     * Getter method for era
     * @return String era
     */
    public String getEra(){
        return era;
    }
}