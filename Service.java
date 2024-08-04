/**
 * This class stores information about a specific service provided to a car
 * used in ArrayList in Car class
 * @author Jose Merida / Sophie Cleaves
 */
public class Service {
    private String date;
    private String name;
    private int id;
    public Service(String date, String name, int id){
        this.date = date;
        this.name = name;
        this.id = id;
    }
    public String getDetails(){
        String details = this.name + " " + this.date + " " + this.id;
        return details;
    }
    public String getName(){
        return this.name;
    }
        {
    }
}
