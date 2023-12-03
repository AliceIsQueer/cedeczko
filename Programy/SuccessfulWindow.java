import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Component;

public class SuccessfulWindow extends JFrame {

    public SuccessfulWindow() {
        initialize();
    }

    public SuccessfulWindow(JFrame previous_window) {
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
        //return_button.addActionListener(e -> new MainWindow(this)); tu bedzie przejści do głównego ekranu
        up_panel.add(return_button);
        add(up_panel, BorderLayout.NORTH);

        // dolna część ekranu
        JPanel bottom_panel = new JPanel();
        bottom_panel.setLayout(new BoxLayout(bottom_panel, BoxLayout.PAGE_AXIS));
        bottom_panel.add(Box.createRigidArea(new Dimension(0, high / 3)));
        JLabel label1 = new JLabel("PŁATNOŚĆ PRZEBIEGŁA POMYŚLNIE!");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottom_panel.add(label1);
        JLabel label2 = new JLabel("Na maila przesłałyśmy potwierdzenie zamówienia.");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottom_panel.add(label2);
        JLabel label3 = new JLabel("Dziękujemy za skorzystanie z naszych usług.");
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottom_panel.add(label3);
        JLabel label4 = new JLabel("Zapraszamy ponownie!");
        label4.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottom_panel.add(label4);
        
        add(bottom_panel, BorderLayout.CENTER);
        
        setVisible(true);
    }
}