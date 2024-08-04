/**
 * This class stores information related to mammals, also provides getters and setters
 * for mammal-specific attributes
 * @author Jose Merida
 * @version 1.0
 * @since 09-10-2023
 */
public class Mammal extends Species {
    private String diet;
    private String habitat;

    /**
     *Creates a new mammal with the specified attributes
     * @param name Sets the name of the mammal
     * @param scientistName Sets the name of the scientist who discovered it
     * @param discoveryDate Sets the date of discovery
     * @param era Sets the era
     * @param discoveryLocation Sets the location of the discovery
     * @param diet Sets the mammal's diet
     * @param habitat Sets the mammal's habitat
     */
    public Mammal(String name, String scientistName, String discoveryDate, String era, String discoveryLocation, String diet, String habitat) {
        super(name, scientistName, discoveryDate, "Mamifero", era, discoveryLocation);
        this.diet = diet;
        this.habitat = habitat;
    }

    /**
     * Getter method for Diet
     * @return String Diet
     */
    public String getDiet(){
        return diet;
    }

    /**
     * Getter method for Habitat
     * @return String Habitat
     */
    public String getHabitat(){
        return habitat;
    }
}