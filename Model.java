import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;
import java.util.Random;

/**
 * Model class reads and writes information on a CSV file, keeps it stored in an ArrayList and tells GUI to interact with
 * the user in different manners
 * @author Jose Merida
 * @version 1.0
 * @since 07-11-2023
 */
public class Model {
    private ArrayList<Ticket> ticketList;

    /**
     * Creates a new Model
     */
    public Model(){
        ticketList = new ArrayList<Ticket>();
    }

    /**
     * Reads information from CSV file, creates different Tickets and stores them in ticketList.
     */
    public void readCSV(){
        String line;
        try (
                BufferedReader br = new BufferedReader(new FileReader("tickets.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ArrayList<String> tempList = new ArrayList<>();
                for (String field : data) {
                    tempList.add(field);
                }
                int currentHours = Integer.parseInt(tempList.get(0));
                /**
                 * Verifies what type of ticket is stored in each line, creates & stores the corresponding ticket based
                 * on priority
                 */
                if (tempList.size() == 1){
                    ticketList.add(new LowPriorityTicket(currentHours));
                } else if (tempList.size() == 3){
                    int currentComission = Integer.parseInt(tempList.get(2));
                    ticketList.add(new MidPriorityTicket(currentHours, currentComission));
                } else{
                    if (Objects.equals(tempList.get(1), "true")){
                        ticketList.add(new HighPriorityTicket(currentHours, true));
                    }
                    else {
                        ticketList.add(new HighPriorityTicket(currentHours, false));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Writes information into CSV file, takes ArrayLists of the different ticket priorities
     * and writes a line formatted appropriately.
     */
    public void writeCSV(){
        ArrayList<HighPriorityTicket> highPriorityList= getPriorityList("HighPriorityTicket");
        ArrayList<MidPriorityTicket> midPriorityList = getPriorityList("MidPriorityTicket");
        ArrayList<LowPriorityTicket> lowPriorityList = getPriorityList("LowPriorityTicket");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tickets.csv"))) {
            for (HighPriorityTicket currentHighPriorityTicket : highPriorityList){
                String highData = currentHighPriorityTicket.getHours() + "," + currentHighPriorityTicket.getIsWeekend()+ ",,";
                bw.write(highData);
                bw.newLine();
            }
            for (MidPriorityTicket currentMidPriorityTicket : midPriorityList){
                String midData = currentMidPriorityTicket.getHours() + ",," + currentMidPriorityTicket.getEmployeeComission() + ",";
                bw.write(midData);
                bw.newLine();
            }
            for (LowPriorityTicket currentLowPriorityTicket : lowPriorityList){
                String lowData = currentLowPriorityTicket.getHours() + ",,,";
                bw.write(lowData);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to get an ArrayList of Tickets based on priority
     * @param priority High, Mid, or Low priority tickets
     * @return The ArrayList of the corresponding Tickets based on priority
     */
    public ArrayList getPriorityList(String priority){
        ArrayList<Ticket> tempList = new ArrayList<>();
        for (Ticket currentTicket : ticketList){
            if (currentTicket.getClass().getSimpleName().equals(priority)){
                tempList.add(currentTicket);
            }
        }
        return tempList;
    }

    /**
     * Returns quantity of tickets based on Priority
     * @param priority High, Mid or Low priority tickets
     * @return Integer, number of tickers corresponding to Priority
     */
    public int getQuantityByPriority(String priority){
        ArrayList<Ticket> tempList = getPriorityList(priority);
        return tempList.size();
    }

    /**
     * Compares total income of each ticket priority
     * @return String with the priority and income for the top earner.
     */
    public String getTopEarner(){
        double highEarnings = getIncomeByPriority("HighPriorityTicket");
        double midEarnings = getIncomeByPriority("MidPriorityTicket");
        double lowEarnings = getIncomeByPriority("LowPriorityTicket");
        double highest = Math.max(Math.max(lowEarnings, midEarnings), highEarnings);
        if (highest == lowEarnings){
            return ("Baja prioridad, $" + lowEarnings);
        }
        if (highest == midEarnings){
            return ("Media prioridad, $" + midEarnings);
        }
        else{
            return ("Alta prioridad, $" + highEarnings);
        }
    }

    /**
     * Calculates the income for each ticket priority
     * @param priority High, Mid or Low priority ticket
     * @return Double, income for each priority
     */
    public double getIncomeByPriority(String priority){
        double income = 0;
        ArrayList<Ticket> tempList = getPriorityList(priority);
        for (Ticket currentTicket : tempList){
            income = income + currentTicket.getIncome();
        }
        return income;
    }

    /**
     * Creates a new low priority ticket and adds it to ticketList
     * @param hours the hours for the new ticket
     */
    public void newTicket(int hours){
        ticketList.add(new LowPriorityTicket(hours));
    }

    /**
     * Creates a new mid priority ticket and adds it to ticketList
     * @param hours the hours for the new ticket
     * @param comission the comission rate for the employee
     */
    public void newTicket(int hours, int comission){
        ticketList.add(new MidPriorityTicket(hours, comission));
    }

    /**
     * Creates a new high priority ticket and adds it to ticketList
     * @param hours the hours for the new ticket
     * @param isWeekend boolean representing whether its the weekend or not
     */
    public void newTicket(int hours, boolean isWeekend){
        ticketList.add(new HighPriorityTicket(hours, isWeekend));
    }
}