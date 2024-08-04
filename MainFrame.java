import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;
import java.util.Random;

/**
 * The MainFrame class displays the GUI and also handles most operations inside of this program
 *@author Jose Merida
 *@version 1.1
 @since 28-10-2023
 */
public class MainFrame extends JFrame implements ActionListener {
    JLabel titleLabel = new JLabel();
    JButton searchButton = new JButton();
    JButton newClotheButton = new JButton();
    JButton sellButton = new JButton();
    JTextField idTextField = new JTextField();
    JButton addButton = new JButton();
    JButton currentSalesButton = new JButton();
    JButton categoryButton = new JButton();
    private ArrayList<Clothe> clothesList;

    /**
     * Constructor for mainframe class, creates a JFrame and also creates the clothesList
     */
    public MainFrame() {
        this.setTitle("Sistema de Manejo de Inventario");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(950, 575);
        this.setVisible(true);
        this.setLayout(null);
        addElements();
        this.clothesList = new ArrayList<Clothe>();
    }

    /**
     * Adds elements to the GUI
     */
    public void addElements() {
        //Creates the components & sets bounds
        titleLabel = new JLabel();
        titleLabel.setBounds(415, 25, 300, 25);
        searchButton = new JButton();
        searchButton.setBounds(260, 185, 100, 20);
        newClotheButton = new JButton();
        newClotheButton.setBounds(255, 70, 395, 50);
        sellButton = new JButton();
        sellButton.setBounds(380, 185, 140, 20);
        idTextField = new JTextField();
        idTextField.setBounds(255, 145, 395, 25);
        addButton = new JButton();
        addButton.setBounds(545, 185, 100, 20);
        currentSalesButton = new JButton();
        currentSalesButton.setBounds(385, 230, 130, 35);
        categoryButton = new JButton();
        categoryButton.setBounds(365, 285, 170, 30);

        //Sets the text
        titleLabel.setText("Tu outfit ideal");
        searchButton.setText("Buscar");
        newClotheButton.setText("Nueva prenda");
        sellButton.setText("Vender");
        addButton.setText("Agregar");
        currentSalesButton.setText("Ventas Actuales");
        categoryButton.setText("Buscar por categoria");
        idTextField.setText("ID de la prenda");

        //Adds action listeners
        searchButton.addActionListener(this);
        newClotheButton.addActionListener(this);
        sellButton.addActionListener(this);
        addButton.addActionListener(this);
        currentSalesButton.addActionListener(this);
        categoryButton.addActionListener(this);

        //Adds the components
        this.add(titleLabel);
        this.add(searchButton);
        this.add(newClotheButton);
        this.add(sellButton);
        this.add(idTextField);
        this.add(addButton);
        this.add(currentSalesButton);
        this.add(categoryButton);
    }

    /**
     * Checks for botton presses inside of the GUI
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            //Searches current clothes for ID inside of a textbox, prints out clothe name and availability
            int currentId = Integer.parseInt(idTextField.getText());
            Clothe currentClothe = searchId(currentId);
            titleLabel.setText(currentClothe.getName() + " | " + currentClothe.getAvailable() + " Disponibles");
        }
        if (e.getSource() == sellButton) {
            //Sells the amount of clothes entered after the sell button has been pressed
            int currentId = Integer.parseInt(idTextField.getText());
            Clothe currentClothe = searchId(currentId);
            int toSell = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de objetos que se vendieron"));
            currentClothe.sell(toSell);
            writeCSV();
        }
        if (e.getSource() == addButton) {
            //Adds the amount of clothes entered after the add inventory button has been pressed
            int currentId = Integer.parseInt(idTextField.getText());
            Clothe currentClothe = searchId(currentId);
            int toAdd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de objetos que ingresaron"));
            currentClothe.addInventory(toAdd);
            writeCSV();
        }
        if (e.getSource() == newClotheButton) {
            //Prints out an Option Dialogue for the user to choose which type of item they're adding
            String[] categories = {"Pantalones", "Camisas", "Collares", "Regresar"};
            int category = JOptionPane.showOptionDialog(null,"Haga click en la categoria", "Confirmation", JOptionPane.WARNING_MESSAGE, 0, null, categories, categories[3]);
            switch(category){
                //Requests user input, creates new item and adds it to the clothesList
                case 0:
                    int id = generateId();
                    String name = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                    int available = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible"));
                    int sold = 0;
                    String state = JOptionPane.showInputDialog("Ingrese el estado");
                    int price = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                    int size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la talla del producto"));
                    String type = JOptionPane.showInputDialog("Ingrese el tipo de pantalones");
                    addClothe(new Pants(id, name, available, sold, state, price, size, type));
                    writeCSV();
                    break;
                case 1:
                    int shirtId = generateId();
                    String shirtName = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                    int shirtAvailable = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible"));
                    int shirtSold = 0;
                    String shirtState = JOptionPane.showInputDialog("Ingrese el estado");
                    int shirtPrice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                    String shirtSize = JOptionPane.showInputDialog("Ingrese la talla");
                    String shirtColor = JOptionPane.showInputDialog("Ingrese el color de la camisa");
                    addClothe(new Shirt(shirtId, shirtName, shirtAvailable, shirtSold, shirtState, shirtPrice,shirtSize, shirtColor));
                    writeCSV();
                    break;
                case 2:
                    int collarId = generateId();
                    String collarName = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                    int collarAvailable = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible"));
                    int collarSold = 0;
                    String collarState = JOptionPane.showInputDialog("Ingrese el estado");
                    int collarPrice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                    String collarSize = JOptionPane.showInputDialog("Ingrese la talla");
                    String collarMaterial = JOptionPane.showInputDialog("Ingrese el material del collar");
                    addClothe(new Collar(collarId, collarName, collarAvailable, collarSold, collarState, collarPrice, collarSize, collarMaterial));
                    writeCSV();
                    break;
            }
        }
        if (e.getSource() == currentSalesButton) {
            //Prints out a message dialogue showing sales per category
            int pantsSales = getSalesByCategory("Pants");
            int shirtSales = getSalesByCategory("Shirt");
            int collarSales = getSalesByCategory("Collar");
            JOptionPane.showMessageDialog(null, "Pantalones: " + pantsSales + "\n" + "Camisas: " + shirtSales + "\n" + "Collares: " + collarSales);
        }
        if (e.getSource() == categoryButton) {
            //Shows list of product per category
            String[] categories = {"Pantalones", "Camisas", "Collares", "Regresar"};
            //Displays pop-up for user to select category
            int category = JOptionPane.showOptionDialog(null,"Haga click en la categoria", "Confirmation", JOptionPane.WARNING_MESSAGE, 0, null, categories, categories[3]);
            switch(category){
                case 0:
                    ArrayList<Pants> pantsList = getCategoryList("Pants");
                    ArrayList<String> showList = new ArrayList<>();
                    for (Pants currentPants : pantsList){
                        showList.add(currentPants.getData()+"\n");
                    }
                    JOptionPane.showMessageDialog(null, "Pantalones:\n" + showList);
                    break;
                case 1:
                    ArrayList<Shirt> shirtList = getCategoryList("Shirt");
                    ArrayList<String> shirtShowList = new ArrayList<>();
                    for (Shirt currentShirt : shirtList){
                        shirtShowList.add(currentShirt.getData()+"\n");
                    }
                    JOptionPane.showMessageDialog(null, "Camisas:\n" + shirtShowList);
                    break;
                case 2:
                    ArrayList<Collar> collarList = getCategoryList("Collar");
                    ArrayList<String> collarShowList = new ArrayList<>();
                    for (Collar currentCollar : collarList){
                        collarShowList.add(currentCollar.getData()+"\n");
                    }
                    JOptionPane.showMessageDialog(null, "Collares:\n" + collarShowList);
                    break;
            }
        }
    }
    /**
     * Generates ID to be used for a specific clothe (new)
     * @return int ID, a random number between 1-200 that isn't repeated in the current Clothes database
     */
    public int generateId(){
        ArrayList<Integer> idList = new ArrayList<>();
        for (Clothe currentClothe : clothesList){
            idList.add(currentClothe.getId());
        }
        Random random = new Random();
        int randomInt;
        do {
            randomInt = random.nextInt(200) + 1;
        } while (idList.contains(randomInt));
        return randomInt;
    }

    /**
     * Reads CSV file and adds data to ArrayList clothesList
     */
    public void readCSV(){
        String line;
        try (
                BufferedReader br = new BufferedReader(new FileReader("inventario.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ArrayList<String> tempList = new ArrayList<>();
                for (String field : data) {
                    tempList.add(field);
                }
                int currentId = Integer.parseInt(tempList.get(0));
                String currentName = tempList.get(1);
                int currentAvailable = Integer.parseInt(tempList.get(2));
                int currentSold = Integer.parseInt(tempList.get(3));
                String currentState = tempList.get(4);
                int currentPrice = Integer.parseInt(tempList.get(5));
                String currentCategory = tempList.get(6);
                switch (currentCategory) {
                    case "Pants":
                        int pantsSize = Integer.parseInt(tempList.get(7));
                        String pantsType = tempList.get(8);
                        Pants newPants = new Pants(currentId, currentName, currentAvailable, currentSold, currentState, currentPrice, pantsSize, pantsType);
                        clothesList.add(newPants);
                        break;
                    case "Shirt":
                        String shirtSize = tempList.get(7);
                        String shirtColor = tempList.get(9);
                        Shirt newShirt = new Shirt(currentId, currentName, currentAvailable, currentSold, currentState, currentPrice, shirtSize, shirtColor);
                        clothesList.add(newShirt);
                        break;
                    case "Collar":
                        String collarSize = tempList.get(7);
                        String collarMaterial = tempList.get(10);
                        Collar newCollar = new Collar(currentId, currentName, currentAvailable, currentSold, currentState, currentPrice, collarSize, collarMaterial);
                        clothesList.add(newCollar);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads ArrayList clothesList and updates data in CSV file.
     */
    public void writeCSV(){
        ArrayList<Pants> pantsList = getCategoryList("Pants");
        ArrayList<Shirt> shirtList = getCategoryList("Shirt");
        ArrayList<Collar> collarList = getCategoryList("Collar");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.csv"))) {
            for (Pants currentPants : pantsList) {
                String itemData = currentPants.getId() + ","
                        + currentPants.getName() + ","
                        + currentPants.getAvailable() + ","
                        + currentPants.getSold() + ","
                        + currentPants.getState() + ","
                        + currentPants.getPrice() + ",Pants,"
                        + currentPants.getSize() + ","
                        + currentPants.getType() + ",,,";
                bw.write(itemData);
                bw.newLine();
            }
            for (Shirt currentShirt : shirtList){
                String idemData = currentShirt.getId() + ","
                        + currentShirt.getName() + ","
                        + currentShirt.getAvailable() + ","
                        + currentShirt.getSold() + ","
                        + currentShirt.getState() + ","
                        + currentShirt.getPrice() + ",Shirt,"
                        + currentShirt.getSize() + ",,"
                        + currentShirt.getColor() + ",,";
            }
            for (Collar currentCollar : collarList){
                String itemData = currentCollar.getId() + ","
                        + currentCollar.getName() + ","
                        + currentCollar.getAvailable() + ","
                        + currentCollar.getSold() + ","
                        + currentCollar.getState() + ","
                        + currentCollar.getPrice() + ",Collar"
                        + currentCollar.getSize() + ",,,"
                        + currentCollar.getMaterial() + ",";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns an ArrayList with all objects of a certain category
     * @param category The class name / category
     * @return ArrayList containing all the objects of the specified category
     */
    public ArrayList getCategoryList(String category){
        ArrayList<Clothe> tempList = new ArrayList<>();
        for (Clothe currentClothe : clothesList){
            if (Objects.equals(currentClothe.getCategory(), category)){
                tempList.add(currentClothe);
            }
        }
        return tempList;
    }

    /**
     * Returns an integer specifying sales by category
     * @param category The category we want infomration from
     * @return The sales of the specified category
     */
    public int getSalesByCategory(String category){
        int sales = 0;
        ArrayList<Clothe> tempList = getCategoryList(category);
        for (Clothe tempClothe : tempList){
            sales = sales + tempClothe.getSales();
        }
        return sales;
    }

    /**
     * Adds a clothe to clothesList
     * @param toAdd the Clothe to be added
     */
    public void addClothe(Clothe toAdd){
        clothesList.add(toAdd);
    }

    /**
     * Searches for a specific Clothe ID in clothesList
     * @param Id the ID of the clothe we're looking for
     * @return The Clothe with the specified ID
     */
    public Clothe searchId(int Id){
        for (Clothe currentClothe : clothesList){
            if (currentClothe.getId() == Id){
                return currentClothe;
            }
        }
        return null;
    }
}
