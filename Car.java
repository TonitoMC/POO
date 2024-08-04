import java.util.List;
import java.util.ArrayList;

/**
 * This class stores information about a specific car and its services
 * used in ArrayList in driver class.
 * @Author Jose Merida / Sophie Cleaves
 */
public class Car {
    private String plate;
    private String brand;
    private String line;
    private int model;
    private String owner;
    private ArrayList<Service>  serviceList;

    /**
     * Constructor for Car class, creates car with specified parameters and creates an empty ArrayList for services
     * @param plate Sets the car's number plate
     * @param brand Sets the car's brand
     * @param line Sets the car's line
     * @param model Sets the car's model
     * @param owner Sets the car owner's name
     */
    public Car(String plate, String brand, String line, int model, String owner){
        this.plate = plate;
        this.brand = brand;
        this.line = line;
        this.model = model;
        this.owner = owner;
        this.serviceList = new ArrayList<>();
    }

    /**
     * Adds a service object to the car's service ArrayList
     * @param service the specific service to be added
     */
    public void addService(Service service){
        serviceList.add(service);
    }

    /**
     * Method to get some details of a car
     * @return returns the details in a string separated by "-"
     */
    public String getDetails(){
        String details = this.brand + " - " + this.line + " - " + this.plate;
        return details;
    }

    /**
     * Method to get all the information about a car
     * @return All the information on a car in different lines
     */
    public String getAll(){
        String All = "Número de Placa: " + this.plate + "\n" +
                "Marca: " + this.brand + "\n" +
                "Linea: " + this.line + "\n" +
                "Modelo: " + this.model + "\n" +
                "Dueño: " + this.owner + "\n";
        return All;
}

    /**
     * Method to access the serviceList of a specific Car
     * @return the serviceList attribute
     */
    public ArrayList getServices(){
        return this.serviceList;
}

}
