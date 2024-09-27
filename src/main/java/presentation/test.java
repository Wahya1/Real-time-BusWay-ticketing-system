import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test extends JFrame {
    private JPanel mainPanel;
    private JComboBox<String> busComboBox;
    private JButton showAvailableBusesButton;
    private JTextField departureStationField;
    private JTextField arrivalStationField;
    private JTextField dateField;
    private JButton searchAvailableTripsButton;

    public test() {
        setTitle("Transportation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        mainPanel = new JPanel(new CardLayout());

        // Panel for showing available buses
        JPanel busesPanel = new JPanel(new BorderLayout());
        busComboBox = new JComboBox<>();
        showAvailableBusesButton = new JButton("Show Available Buses");
        showAvailableBusesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to fetch available buses and populate the combo box
                List<String> availableBuses = Arrays.asList("Bus 1", "Bus 2", "Bus 3");
                busComboBox.removeAllItems();
                for (String bus : availableBuses) {
                    busComboBox.addItem(bus);
                }
            }
        });
        busesPanel.add(new JLabel("Available Buses:"), BorderLayout.NORTH);
        busesPanel.add(busComboBox, BorderLayout.CENTER);
        busesPanel.add(showAvailableBusesButton, BorderLayout.SOUTH);

        // Panel for searching available trips
        JPanel tripsPanel = new JPanel(new GridLayout(4, 2));
        departureStationField = new JTextField();
        arrivalStationField = new JTextField();
        dateField = new JTextField();
        searchAvailableTripsButton = new JButton("Search Available Trips");
        searchAvailableTripsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to search for available trips based on departure station, arrival station, and date
                // and display them in a new window
                displayAvailableTrips();
            }
        });
        tripsPanel.add(new JLabel("Departure Station:"));
        tripsPanel.add(departureStationField);
        tripsPanel.add(new JLabel("Arrival Station:"));
        tripsPanel.add(arrivalStationField);
        tripsPanel.add(new JLabel("Date:"));
        tripsPanel.add(dateField);
        tripsPanel.add(new JPanel()); // Empty panel for alignment
        tripsPanel.add(searchAvailableTripsButton);

        mainPanel.add(busesPanel, "buses");
        mainPanel.add(tripsPanel, "trips");
        add(mainPanel);
    }

    private void displayAvailableTrips() {
        // Code to fetch available trips and display them in a new window
        List<String> availableTrips = Arrays.asList("Trip 1", "Trip 2", "Trip 3");
        JOptionPane.showMessageDialog(this, "Available Trips: " + availableTrips);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new test();
            }
        });
    }
}
