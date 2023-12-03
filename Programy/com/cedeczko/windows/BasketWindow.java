package com.cedeczko.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Dimension;

public class BasketWindow extends JFrame {


    private DefaultTableModel model;
    private JTable products_table;

    public BasketWindow() {
        initialize();
    }

    public BasketWindow(JFrame previous_window) {
        initialize();
          previous_window.dispose();
    }

    public void initialize() {
        int wide = 900;
        int high = 800;
        int upper_high = 50;
        setTitle("Koszyk");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(wide, high);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // góra ekranu
        JPanel up_panel = new JPanel();
        up_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        up_panel.setPreferredSize(new Dimension(wide, upper_high));
        // przycisk powrót
        JButton return_button = new JButton("<--- Powrót");
        return_button.addActionListener(e -> new ProductWindow(this)); //tu bedzie przejści do głównego ekranu albo nie
        up_panel.add(return_button);

        add(up_panel, BorderLayout.NORTH);

        // lewa część ekranu
        JPanel left_panel = new JPanel(new GridBagLayout());
        left_panel.setPreferredSize(new Dimension((6 * wide / 10), high - upper_high));
        left_panel.setLayout(new BoxLayout(left_panel, BoxLayout.PAGE_AXIS));
        JLabel llabel = new JLabel("Lista zakupów:");

        model = new DefaultTableModel() {
          @Override
          public boolean isCellEditable(int row, int column) {
             return false;
          }
        };;

        model.addColumn("Nazwa produktu");
        model.addColumn("Cena");
        model.addColumn("");

        products_table = new JTable(model);
        products_table.getColumnModel().getColumn(0).setPreferredWidth(4 * wide / 10);
        products_table.getColumnModel().getColumn(1).setPreferredWidth(2 * wide / 20);
        products_table.getColumnModel().getColumn(2).setPreferredWidth(2 * wide / 20);
        Object[] przykladowyProdukt1 = {"Laptop", 2000.0, "Usuń produkt"}; //przykład, żeby sprawdzić, czy działa usuwanie
        model.addRow(przykladowyProdukt1);

        products_table.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              int column = products_table.columnAtPoint(e.getPoint());
              int row = products_table.rowAtPoint(e.getPoint());

              if (column == model.findColumn("") && row != -1) {
                  model.removeRow(row);
              }
          }
        });

        JScrollPane scrollPane = new JScrollPane(products_table);
        scrollPane.setPreferredSize(new Dimension(6 * wide / 10, high - upper_high));
        left_panel.add(scrollPane);

        left_panel.add(llabel);

        left_panel.add(scrollPane);

        add(left_panel, BorderLayout.WEST);
        
        // prawa część ekranu
        JPanel right_panel = new JPanel();
        right_panel.add(Box.createRigidArea(new Dimension(0, (high - upper_high) / 3)));
        right_panel.setLayout(new BoxLayout(right_panel, BoxLayout.PAGE_AXIS));
        right_panel.setPreferredSize(new Dimension(3 * wide / 10, (high - upper_high) / 2));
        JLabel r1label = new JLabel("PODSUMOWANIE");
        JLabel r2label = new JLabel("Liczba produktów:");
        JLabel r3label = new JLabel("Łączna kwota do zapłaty:");
        JButton pay_button = new JButton("Przejdź do kasy");
        pay_button.addActionListener(e -> new PaymentWindow(this));
        right_panel.add(r1label);
        right_panel.add(r2label);
        right_panel.add(r3label);
        right_panel.add(pay_button);
        
        add(right_panel, BorderLayout.EAST);
        
        setVisible(true);
    }
}