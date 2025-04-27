package org.mattz.data.gui;

import org.mattz.data.GSONHandler;
import org.mattz.data.Predmet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {
    GSONHandler handler = new GSONHandler();

    JComboBox<String> jComboBoxBudovy = new JComboBox<>();
    JComboBox<String> jComboBoxMistnosti = new JComboBox<>();
    JComboBox<String> jComboBoxSemestr = new JComboBox<>();
    JButton jButtonSubmit = new JButton("Zobrazit rozvrh místnosti");
    JToolBar jToolBar = new JToolBar();


    DefaultTableModel defaultTableModel = new DefaultTableModel();
    JTable jTable = new JTable(defaultTableModel);
    JScrollPane jScrollPane = new JScrollPane(jTable);


    public MainView() {
        this.setTitle("Prohlížeč rozvrhu místností");
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        this.add(jToolBar, BorderLayout.NORTH);
        this.add(jScrollPane, BorderLayout.CENTER);

        jComboBoxBudovy.addActionListener(_ -> {
            String budova = (String) jComboBoxBudovy.getSelectedItem();
            loadMistnosti(budova);
        });

        jComboBoxSemestr.addItem("ZS");
        jComboBoxSemestr.addItem("LS");

        jButtonSubmit.addActionListener(_ -> {
            String budova = (String) jComboBoxBudovy.getSelectedItem();
            String mistnost = (String) jComboBoxMistnosti.getSelectedItem();
            String semestr = (String) jComboBoxSemestr.getSelectedItem();
            loadPredmety(budova, mistnost, semestr);
        });

        jToolBar.add(jComboBoxBudovy);
        jToolBar.add(jComboBoxMistnosti);
        jToolBar.add(jComboBoxSemestr);
        jToolBar.add(jButtonSubmit);
        jToolBar.setVisible(true);

        defaultTableModel.addColumn("Zkratka předmětu");
        defaultTableModel.addColumn("Název");
        defaultTableModel.addColumn("Den");
        defaultTableModel.addColumn("Časový rozsah hodiny");
        defaultTableModel.addColumn("Vyučující");

        jScrollPane.setSize(600, 400);
        jScrollPane.setVisible(true);


        loadBudovy();
        loadMistnosti(jComboBoxBudovy.getItemAt(0));
    }

    private void loadBudovy() {
        jComboBoxBudovy.removeAllItems();
        ArrayList<String> budovy = handler.getBudovy();
        for (String budova : budovy) {
            jComboBoxBudovy.addItem(budova);
        }
    }

    private void loadMistnosti(String budova) {
        jComboBoxMistnosti.removeAllItems();
        ArrayList<String> mistnosti = handler.getMistnosti(budova);
        for (String mistnost : mistnosti) {
            jComboBoxMistnosti.addItem(mistnost);
        }
    }
    private void loadPredmety(String budova, String mistnost, String semestr) {
        ArrayList<Predmet> predmety = handler.getPredmety(budova, mistnost, semestr);
        if (predmety == null || predmety.isEmpty()) JOptionPane.showMessageDialog(null, "Nebyly nalezeny žádná data", "Upozornění", JOptionPane.INFORMATION_MESSAGE);
        else {
            defaultTableModel.setRowCount(0);
            for (Predmet predmet : predmety) {
                defaultTableModel.addRow(new Object[]{predmet.predmet(), predmet.nazev(), predmet.den(), predmet.hodinaSkutOd() + " - " + predmet.hodinaSkutDo(), predmet.vsichniUciteleJmenaTituly()});
            }
        }
    }
}
