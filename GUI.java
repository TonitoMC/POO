import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates a user inferface for the user to interact with
 * @author Jose Merida
 * @version 1.0
 * @since 07-11-2023
 */

public class GUI extends JFrame{
    private JLabel titleLabel;
    private JLabel subLabel;
    private JTextField hoursTextField;
    private JButton highPriorityButton;
    private JButton midPriorityButton;
    private JButton lowPriorityButton;
    private JButton quantityByPriorityButton;
    private JButton topEarnerButton;

    /**
     * Creates the GUI
     */
    public GUI() {
        //Sets title, size and closing operation
        this.setTitle("Sistema de Manejo de Tickets");
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(375,265);
        this.setVisible(true);
        this.setLayout(null);

        //Construct compoments for the GUI
        titleLabel = new JLabel ("Manejo de Tickets");
        subLabel = new JLabel ("Crear un Nuevo Ticket");
        hoursTextField = new JTextField (5);
        highPriorityButton = new JButton ("Alta");
        midPriorityButton = new JButton ("Media");
        lowPriorityButton = new JButton ("Baja");
        quantityByPriorityButton = new JButton ("Cantidad de Tickets por Prioridad");
        topEarnerButton = new JButton ("Prioridad con Mayor Ingreso");

        //Adds components to the GUI
        add (titleLabel);
        add (subLabel);
        add (hoursTextField);
        add (highPriorityButton);
        add (midPriorityButton);
        add (lowPriorityButton);
        add (quantityByPriorityButton);
        add (topEarnerButton);

        //Sets the bounds and positions of the GUI components
        titleLabel.setBounds (140, 15, 105, 30);
        subLabel.setBounds (125, 50, 130, 30);
        hoursTextField.setBounds (70, 85, 240, 25);
        highPriorityButton.setBounds (70, 115, 70, 25);
        midPriorityButton.setBounds (155, 115, 80, 25);
        lowPriorityButton.setBounds (245, 115, 65, 25);
        quantityByPriorityButton.setBounds (70, 150, 240, 25);
        topEarnerButton.setBounds (70, 185, 240, 25);
    }

    /**
     * Used to access the text in hoursTextField
     * @return Text in hoursTextField
     */
    public int getHours(){
        return Integer.parseInt(hoursTextField.getText());
    }

    /**
     * Used to create a popup message
     * @param text the text to be shown
     */
    public void popUp(String text){
        JOptionPane.showMessageDialog(this, text);
    }

    /**
     * Creates action listener for JButtons
     */
    public void addActionListener(ActionListener listener){
        highPriorityButton.addActionListener(listener);
        midPriorityButton.addActionListener(listener);
        lowPriorityButton.addActionListener(listener);
        quantityByPriorityButton.addActionListener(listener);
        topEarnerButton.addActionListener(listener);
    }

    /**
     * Getter for HighPriorityButton
     * @return HighPriorityButton
     */
    public JButton getHighPriorityButton(){
        return highPriorityButton;
    }

    /**
     * Getter for MidPriorityButton
     * @return MidPriorityButton
     */
    public JButton getMidPriorityButton(){
        return midPriorityButton;
    }

    /**
     * Getter for LowPriorityButton
     * @return LowPriorityButton
     */
    public JButton getLowPriorityButton(){
        return lowPriorityButton;
    }

    /**
     * Getter for QuantityByPriorityButton
     * @return QuantityByPriorityButton
     */
    public JButton getQuantityByPriorityButton(){
        return quantityByPriorityButton;
    }

    /**
     * Getter for TopEarnerButton
     * @return TopEarnerButton
     */
    public JButton getTopEarnerButton(){
        return topEarnerButton;
    }

    /**
     * Creates a pop-up for user to enter comission
     * @return int comission
     */
    public int getComission(){
        int currentComission = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la comision del empleado (5-10%, unicamente numeros enteros"));
        return currentComission;
    }

    /**
     * Creates a pop-up for user to select whether its the weekend or not, or return
     * @return An integer representing user choice
     */
    public int getIsWeekend(){
        String[] options = {"Si", "No", "Regresar"};
        int weekendOption = JOptionPane.showOptionDialog(null,"Es fin de semana?", "Conformation", JOptionPane.WARNING_MESSAGE, 0, null, options, options[2]);
        return weekendOption;
    }
}