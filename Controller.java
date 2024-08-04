import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for the program, reads information from the buttons in GUI
 * and interacts with both GUI and Model for the program to function
 * @author Jose Merida
 * @version 1.0
 * @since 07-11-2023
 */
public class Controller implements ActionListener {
    private GUI mainGUI;
    private Model mainModel;

    /**
     * Creates new Controller
     * @param mainGUI GUI used by Controller
     * @param mainModel Model used by Controller
     */
    public Controller(GUI mainGUI, Model mainModel) {
        this.mainGUI = mainGUI;
        this.mainModel = mainModel;
        mainGUI.addActionListener(this);
        this.mainModel.readCSV();
    }

    /**
     * Processes button presses in GUI, directs GUI and Model to get the necessary information
     * from the user and take the necessary actions respectively.
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        //Creates new HighPriorityTicket
        if (e.getSource() == mainGUI.getHighPriorityButton()) {
            try {
                int isWeekend = mainGUI.getIsWeekend();
                switch (isWeekend) {
                    case 0:
                        mainModel.newTicket(mainGUI.getHours(), true);
                        break;
                    case 1:
                        mainModel.newTicket(mainGUI.getHours(), false);
                        break;
                    case 2:
                        mainGUI.popUp("No fue creado ningun ticket");
                        break;
                }
            } catch (NumberFormatException ex){
                mainGUI.popUp("Debe ingresar un numero entero de horas en el campo de texto");
            }
            mainModel.writeCSV();
        }
        //Creates new MidPriorityTicket
        if (e.getSource() == mainGUI.getMidPriorityButton()) {
            try{
            int comission = mainGUI.getComission();
            mainModel.newTicket(mainGUI.getHours(), comission);
            } catch (NumberFormatException ex){
                mainGUI.popUp("Debe ingresar un numero entero de horas en el campo de texto");
            }
            mainModel.writeCSV();
        }
        //Creates new LowPriorityTicket
        if (e.getSource() == mainGUI.getLowPriorityButton()) {
            try{
            mainModel.newTicket(mainGUI.getHours());
            } catch (NumberFormatException ex){
                mainGUI.popUp("Debe ingresar un numero entero de horas en el campo de texto");
            }
            mainModel.writeCSV();
        }
        //Creates a pop-up displaying quantity by priority
        if (e.getSource() == mainGUI.getQuantityByPriorityButton()) {
            mainGUI.popUp("Prioridad Alta: " + mainModel.getQuantityByPriority("HighPriorityTicket") +
                    "\nPrioridad Media: " + mainModel.getQuantityByPriority("MidPriorityTicket") +
                    "\nPrioridad Baja: " + mainModel.getQuantityByPriority("LowPriorityTicket"));
        }
        //Creates a pop-up displaying the top earner
        if (e.getSource() == mainGUI.getTopEarnerButton()) {
            mainGUI.popUp(mainModel.getTopEarner());
        }
    }
}
