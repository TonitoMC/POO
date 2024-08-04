/**
 * Driver class for ticket / income tracking. Initializas GUI, Model and Controller
 * @author Jose Merida
 * @version 1.0
 * @since 07-11-2023
 */
public class Main {
    public static void main(String[] args) {
        GUI mainGUI = new GUI();
        Model mainModel = new Model();
        new Controller(mainGUI, mainModel);
    }
}