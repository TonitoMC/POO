public class User {
    private boolean registered;
    private Transport transportEmission;
    private Food foodEmission;
    private Home homeEmission;
    private double transportScore;
    private double foodScore;
    private double homeScore;
    private double footPrint;
    public User(Transport transportEmission, Food foodEmission, Home homeEmission, boolean registered){
        this.transportEmission = transportEmission;
        this.foodEmission = foodEmission;
        this.homeEmission = homeEmission;
        this.registered = registered;
        this.transportScore = transportEmission.getFootprint();
        this.foodScore = foodEmission.getFootprint();
        this.homeScore = homeEmission.getFootprint();
        this.footPrint = transportScore + foodScore + homeScore;
    }
    public boolean getRegistered(){
        return registered;
    }
    public Transport getTransportEmission(){
        return transportEmission;
    }
    public Food getFoodEmission(){
        return foodEmission;
    }
    public Home getHomeEmission(){
        return homeEmission;
    }
    public double getFootprint(){
        return transportScore + foodScore + homeScore;
    }

}
