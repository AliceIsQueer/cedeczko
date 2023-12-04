package com.cedeczko.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.Dimension;

public class ProductWindow extends JFrame {

    public ProductWindow() {
        initialize();
    }

    public ProductWindow(JFrame previous_window) {
        initialize();
        previous_window.dispose();
    }

    public void initialize() {
        int wide = 900;
        int high = 800;
        int bottom_high = 50;
        int upper_high = 50;
        setTitle("Informacje o produkcie");
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
        return_button.addActionListener(e -> new MovieSearchWindow());
        up_panel.add(return_button);
        // przycisk koszyk
        JButton basket_button = new JButton("Twój koszyk");
        basket_button.addActionListener(e -> new BasketWindow(this));
        up_panel.add(basket_button);

        add(up_panel, BorderLayout.NORTH);

        // lewa połowa ekranu
        JPanel left_panel = new JPanel(new GridBagLayout());
        left_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        left_panel.setPreferredSize(new Dimension(wide / 2, high - bottom_high - upper_high));
        // pole tekstowe z informacją o filmie
        String information_text = "Tytuł: \n Autor: \n Rok wydania: \n Gatunki: \n Opis: \n";
        JTextArea film_information = new JTextArea(information_text, 35, 25);
        JScrollPane scroll_text = new JScrollPane(film_information);
        left_panel.add(scroll_text);

        add(left_panel, BorderLayout.WEST);

        // prawa połowa ekranu
        JPanel right_panel = new JPanel();
        right_panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        right_panel.setPreferredSize(new Dimension(wide / 2, high - bottom_high - upper_high));
        // plakat filmu
        // byte[] imageBytes = poster.getBytes(1, (int) poster.length());
        // ByteArrayInputStream bis = nwe ByteArrayInputStream(imageBytes);
        // Image image = ImageIO.read(bis);
        // new ImageIcon(image)
        JLabel picture = new JLabel();
        picture.setForeground(Color.RED);
        right_panel.add(picture);
        add(right_panel, BorderLayout.EAST);

        // dół ekranu
        JPanel down_panel = new JPanel();
        down_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        down_panel.setPreferredSize(new Dimension(wide, bottom_high));
        // Cena
        JTextField price_field = new JTextField("Cena: ", 10);
        down_panel.add(price_field);
        // przycisk dodaj do koszyka
        JButton add_basket_button = new JButton("Dodaj do koszyka");
        down_panel.add(add_basket_button);

        add(down_panel, BorderLayout.SOUTH);
        setVisible(true);
    }
}