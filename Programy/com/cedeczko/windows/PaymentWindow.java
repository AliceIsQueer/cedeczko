package com.cedeczko.windows;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Dimension;

public class PaymentWindow extends JFrame {

    public PaymentWindow() {
        initialize();
    }

    public PaymentWindow(JFrame previous_window) {
        initialize();
        previous_window.dispose();
    }

    public void initialize() {
        int wide = 900;
        int high = 800;
        int upper_high = 50;
        setTitle("Płatność");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(wide, high);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // góra ekranu
        JPanel up_panel = new JPanel();
        up_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        up_panel.setPreferredSize(new Dimension(wide, upper_high));
        // przycisk powrót
        JButton return_button = new JButton("<--- Powrót");
        return_button.addActionListener(e -> new BasketWindow(this));
        up_panel.add(return_button);
        add(up_panel, BorderLayout.NORTH);

        //dolna część ekranu
        JPanel bottom_panel = new JPanel();
        bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottom_panel.setPreferredSize(new Dimension(wide, upper_high));
        bottom_panel.add(new JCheckBox("Zezwalam na wykorzystanie moich danych w celu zrealizowania zamówienia"));

        add(bottom_panel, BorderLayout.SOUTH);

        // lewa część ekranu
        JPanel left_panel = new JPanel(new GridLayout(0, 2, 0, 5));
        left_panel.setPreferredSize(new Dimension(6 * wide / 10, (high - 2 * upper_high) / 2));
        left_panel.add(Box.createRigidArea(new Dimension(2 * wide / 10, 0)));
        left_panel.add(new JLabel("DANE KLIENTA"));
        left_panel.add(new JLabel("Imię:"));
        JTextField name_field = new JTextField();
        left_panel.add(name_field);
        left_panel.add(new JLabel("Nazwisko:"));
        JTextField surname_field = new JTextField();
        left_panel.add(surname_field);
        left_panel.add(new JLabel("E-mail:"));
        JTextField email_field = new JTextField();
        left_panel.add(email_field);
        left_panel.add(new JLabel("Numer telefonu:"));
        JTextField phone_no_field = new JTextField();
        left_panel.add(phone_no_field);
        left_panel.add(Box.createRigidArea(new Dimension(2 * wide / 10, 0)));
        left_panel.add(new JLabel("ADRES"));
        left_panel.add(new JLabel("Ulica:"));
        JTextField street_field = new JTextField();
        left_panel.add(street_field);
        left_panel.add(new JLabel("Numer domu:"));
        JTextField building_no_field = new JTextField();
        left_panel.add(building_no_field);
        left_panel.add(new JLabel("Numer mieszkania:"));
        JTextField local_no_field = new JTextField();
        left_panel.add(local_no_field);
        left_panel.add(new JLabel("Miasto:"));
        JTextField town_field = new JTextField();
        left_panel.add(town_field);
        left_panel.add(new JLabel("Kod pocztowy:"));
        JTextField post_code_field = new JTextField();
        left_panel.add(post_code_field);
        left_panel.add(new JLabel("Kraj:"));
        left_panel.add(new JLabel("Polska"));
        left_panel.add(Box.createRigidArea(new Dimension(2 * wide / 10, 0)));
        left_panel.add(new JLabel("DANE DO PŁATNOŚCI"));
        left_panel.add(new JLabel("Numer karty:"));
        JTextField card_no_field = new JTextField();
        left_panel.add(card_no_field);
        left_panel.add(new JLabel("Data ważności (RR/MM):"));
        JTextField expiration_date_field = new JTextField();
        left_panel.add(expiration_date_field);
        left_panel.add(new JLabel("Kod bezpieczeństwa (CVV/CVC):"));
        JTextField verification_code_field = new JTextField();
        left_panel.add(verification_code_field);
        
        add(left_panel, BorderLayout.WEST);

        // prawa część ekranu
        JPanel right_panel = new JPanel();
        right_panel.add(Box.createRigidArea(new Dimension(0, (high - 2 * upper_high) / 3)));
        right_panel.setLayout(new BoxLayout(right_panel, BoxLayout.PAGE_AXIS));
        right_panel.setPreferredSize(new Dimension(3 * wide / 10, (high - 2 * upper_high) / 2));
        JLabel r1label = new JLabel("PODSUMOWANIE");
        JLabel r2label = new JLabel("Liczba produktów:");
        JLabel r3label = new JLabel("Łączna kwota do zapłaty:");
        JButton pay_button = new JButton("Zapłać");
        pay_button.addActionListener(e -> new SuccessfulWindow(this));
        right_panel.add(r1label);
        right_panel.add(r2label);
        right_panel.add(r3label);
        right_panel.add(pay_button);
        
        add(right_panel, BorderLayout.EAST);
        
        setVisible(true);
    }
}