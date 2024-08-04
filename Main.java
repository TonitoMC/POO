import javax.swing.*;
import java.awt.event.WindowAdapter;

/**
 *
 * Driver class for inventory-keeping program, initializes MainFrame (Which is in charge of the UI and reading a CSV
 * file and also reads the CSV file to start.
 * @author Jose Merida
 * @version 1.0
 * @since 28-10-2023
 */
public class Main {
public static void main(String[] args){
    MainFrame main = new MainFrame();
    main.readCSV();
}
}