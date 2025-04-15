package org.mattz.data.gui;

import org.mattz.data.DataHandler;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MainFrame extends JFrame {
    DataHandler dataHandler;

    private JToolBar jToolBar = new JToolBar();
    private JComboBox<String> jComboBoxFaculty = new JComboBox();
    private JComboBox<String> jComboBoxRooms = new JComboBox();
    private JButton jButtonSubmit = new JButton("Hledat");

    public MainFrame() throws MalformedURLException, URISyntaxException {
        dataHandler = new DataHandler();

        this.setTitle("Prohlížeč rozvrhu místností");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(jToolBar, BorderLayout.NORTH);

        jToolBar.add(jComboBoxFaculty);
        jToolBar.add(jComboBoxRooms);
        jToolBar.add(jButtonSubmit);

        fillComboBoxes(dataHandler.getRooms());

        jButtonSubmit.addActionListener(e -> {
            String selectedFaculty = (String) jComboBoxFaculty.getSelectedItem();
            String selectedRoom = (String) jComboBoxRooms.getSelectedItem();

            String[] returnData = dataHandler.getRoomData(selectedFaculty, selectedRoom);
            if (returnData == null) {
                JOptionPane.showMessageDialog(null, "Nepodařilo se získat data učebny", "Upozornění", JOptionPane.INFORMATION_MESSAGE);
            }
            else {

            }
        });
    }

    private void fillComboBoxes(String[] rooms) {
        jComboBoxFaculty.addItem("J");
        for (String room : rooms) {
            jComboBoxRooms.addItem(room);
        }
    }
}
