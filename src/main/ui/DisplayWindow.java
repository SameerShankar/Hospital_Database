package ui;

import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DisplayWindow extends JFrame {

    Record record;
    JPanel panel = new JPanel();
    JTable table;
    DefaultTableModel tableModel;
    JButton backButton = new JButton("Go back to the menu");

    //EFFECTS: Constructs a display window taking in a record as its parameter
    public DisplayWindow(Record record) {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(new Dimension(450, 300));
        setResizable(false);
        this.record = record;

        displayRecord();
        panel.setLayout(null);

        backButton.addActionListener(e -> {
//            frame.dispose();
            new RecordPanel();

        });
//        frame.setVisible(true);
    }

    //EFFECTS: Displays Record in a Grid
    private void displayRecord() {
        String[] columnNames = {"Name"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        for (Patient patient : record.getPatients()) {
            ArrayList<String> output = new ArrayList<>();
            output.add(Integer.toString(patient.getPersonalHealthNumber()));
            Object[] data = output.toArray();
            tableModel.addRow(data);
        }
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));

    }
}