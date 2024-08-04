import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    //Labels
    private JLabel titleLabel;
    private JLabel transportLabel;
    private JLabel homeLabel;
    private JLabel foodLabel;
    private JLabel monthlyGasLabel;
    private JLabel yearlyFlightsLabel;
    private JLabel weeklyFoodLabel;

    //buttons
    private JButton registerButton;
    private JButton loginButton;
    private JButton calculateButton;

    //Transport Entries
    private JTextField carMoneyTextField;
    private JTextField bikeMoneyTextField;
    private JTextField busDistanceTextField;
    private JTextField flightHoursTextField;

    //Home entries
    private JTextField electricityConsumptionField;
    private JTextField gasConsumptionField;
    private JTextField houseMatesField;
    private JCheckBox doesRecycleBox;

    //Food entries
    private JTextField meatPortionsField;
    private JTextField chickenPortionsField;
    private JTextField porkPortionsField;
    private JTextField fishPortionsField;
    private JTextField dairyPortionsField;

    //Buttons

    public View(){
        //Sets title, size and closing operation
        this.setTitle("Calculadora de Huella de Carbono");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setVisible(true);
        this.setLayout(null);

        //Construction of elements of the GUI
        titleLabel = new JLabel("Huella de Carbono");
        transportLabel = new JLabel("Transporte");
        monthlyGasLabel = new JLabel("Gasto Mensual de Gasolina");
        yearlyFlightsLabel = new JLabel("Tiempo Anual en Vuelos");
        homeLabel = new JLabel("Casa");
        foodLabel = new JLabel("Comida");
        doesRecycleBox = new JCheckBox("Reciclo el Plastico");

        //Transport entries
        carMoneyTextField = new JTextField("Cantidad entera en Q (Carro)");
        bikeMoneyTextField = new JTextField("Cantidad entera en Q (Moto)");
        flightHoursTextField = new JTextField("Cantidad entera en Horas");

        //Home entries
        electricityConsumptionField = new JTextField("Consumo de Luz en kWH");
        gasConsumptionField = new JTextField("Consumo de Gas en LBs");
        houseMatesField = new JTextField("Numero de Personas");

        //Food entries
        meatPortionsField = new JTextField("Porciones de Carne");
        chickenPortionsField = new JTextField("Porciones de Pollo");
        porkPortionsField = new JTextField("Porciones de Cerdo");
        fishPortionsField = new JTextField("Porciones de Pescado");
        dairyPortionsField = new JTextField("Porciones de Lacteos");

        //Buttons

        loginButton = new JButton("Ingresar");
        registerButton = new JButton("Registrate");
        calculateButton = new JButton("Calcular");
        loginButton.setHorizontalAlignment(0);
        registerButton.setHorizontalAlignment(0);
        calculateButton.setHorizontalAlignment(0);

        meatPortionsField.setHorizontalAlignment(0);
        chickenPortionsField.setHorizontalAlignment(0);
        porkPortionsField.setHorizontalAlignment(0);
        fishPortionsField.setHorizontalAlignment(0);
        dairyPortionsField.setHorizontalAlignment(0);

        carMoneyTextField.setHorizontalAlignment(0);
        bikeMoneyTextField.setHorizontalAlignment(0);
        flightHoursTextField.setHorizontalAlignment(0);
        monthlyGasLabel.setHorizontalAlignment(0);
        electricityConsumptionField.setHorizontalAlignment(0);
        gasConsumptionField.setHorizontalAlignment(0);
        houseMatesField.setHorizontalAlignment(0);


        //Adding components to the GUI
        add(titleLabel);
        add(foodLabel);
        add(transportLabel);
        add(homeLabel);
        add(carMoneyTextField);
        add(bikeMoneyTextField);
        add(flightHoursTextField);
        add(monthlyGasLabel);
        add(yearlyFlightsLabel);
        add(electricityConsumptionField);
        add(gasConsumptionField);
        add(houseMatesField);
        add(meatPortionsField);
        add(chickenPortionsField);
        add(porkPortionsField);
        add(fishPortionsField);
        add(dairyPortionsField);
        add (doesRecycleBox);
        add (loginButton);
        add (registerButton);
        add (calculateButton);

        //Setting bounds and positions of the GUI components
        transportLabel.setBounds(90, 35, 70, 25);
        monthlyGasLabel.setBounds(35,60, 180, 20);
        carMoneyTextField.setBounds(35, 80, 180, 20);
        bikeMoneyTextField.setBounds(35,105,180,20);
        yearlyFlightsLabel.setBounds(55,125,140,25);
        flightHoursTextField.setBounds(35, 145, 180, 20);
        foodLabel.setBounds(100, 200, 70, 25);
        meatPortionsField.setBounds(35, 225, 180, 20);
        chickenPortionsField.setBounds(35,245, 180, 20);
        porkPortionsField.setBounds(35, 265, 180, 20);
        fishPortionsField.setBounds(35, 285, 180, 20);
        dairyPortionsField.setBounds(35, 305, 180, 20);
        homeLabel.setBounds(350, 35, 70, 25);
        electricityConsumptionField.setBounds(275, 65, 180, 20);
        gasConsumptionField.setBounds(275, 95, 180, 20);
        houseMatesField.setBounds(275, 125, 180, 20);
        doesRecycleBox.setBounds(275, 150, 180, 20);
        titleLabel.setBounds(200,10,105,25);
        loginButton.setBounds(320, 245, 100, 25);
        registerButton.setBounds(320, 280, 100, 25);
        calculateButton.setBounds(320, 315, 100, 25);
    }
    public void addActionListener(ActionListener listener){
        registerButton.addActionListener(listener);
        loginButton.addActionListener(listener);
        calculateButton.addActionListener(listener);
    }
    public JButton getRegisterButton(){
        return registerButton;
    }
    public JButton getLoginButton(){
        return loginButton;
    }
    public JButton getCalculateButton(){
        return calculateButton;
    }

}
