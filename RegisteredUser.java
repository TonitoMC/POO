public class RegisteredUser extends User{
    private String username;
    private String password;
    private int lastScore;
    public RegisteredUser(Transport transportEmission, Food foodEmission, Home homeEmission, String username, String password) {
        super(transportEmission, foodEmission, homeEmission, true);
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}