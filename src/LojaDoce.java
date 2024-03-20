import java.awt.event.*;
import javax.swing.*;

public class LojaDoce extends JFrame {
    private JTextField chocolateField, cookieField, pudimField;
    private JButton orderButton;
    private JLabel priceLabelChocolate, priceLabelCookie, priceLabelPudim, titleLabelChocolate, titleLabelCookie, titleLabelPudim;
    private ImageIcon icon;
    double total = 0.0;

    public LojaDoce() {
        super("Doces Shop");
        JPanel panel = new JPanel(null);

        icon = new ImageIcon(getClass().getResource("brigadeiropedro.jpg"));
        JLabel label = new JLabel(icon);
        label.setBounds(5, 5, 128, 128);
        panel.add(label);

        icon = new ImageIcon(getClass().getResource("cookiepedro.jpg"));
        label = new JLabel(icon);
        label.setBounds(5, 138, 128, 128);
        panel.add(label);

        icon = new ImageIcon(getClass().getResource("pudimpedro.jpg"));
        label = new JLabel(icon);
        label.setBounds(5, 271, 128, 128);
        panel.add(label);

        titleLabelChocolate = new JLabel("Brigadeiro");
        titleLabelChocolate.setBounds(167, 50, 160, 20);

        priceLabelChocolate = new JLabel("$ 10,00");
        priceLabelChocolate.setBounds(167, 120, 50, 20);

        chocolateField = new JTextField(9);
        chocolateField.setBounds(250, 120, 70, 20);

        titleLabelCookie = new JLabel("Cookie");
        titleLabelCookie.setBounds(167, 165, 160, 20);

        priceLabelCookie = new JLabel("$ 15,00");
        priceLabelCookie.setBounds(167, 210, 50, 20);

        cookieField = new JTextField(9);
        cookieField.setBounds(250, 210, 70, 20);

        titleLabelPudim = new JLabel("Pudim");
        titleLabelPudim.setBounds(167, 255, 180, 20);

        priceLabelPudim = new JLabel("$ 25,00");
        priceLabelPudim.setBounds(167, 300, 50, 20);

        pudimField = new JTextField(9);
        pudimField.setBounds(250, 300, 70, 20);

        orderButton = new JButton("Finalizar");
        orderButton.setBounds(140, 450, 100, 25);

        panel.add(titleLabelChocolate);
        panel.add(titleLabelCookie);
        panel.add(titleLabelPudim);

        panel.add(priceLabelChocolate);
        panel.add(priceLabelCookie);
        panel.add(priceLabelPudim);

        panel.add(chocolateField);
        panel.add(cookieField);
        panel.add(pudimField);

        panel.add(orderButton);
        add(panel);

        OrderHandler handler = new OrderHandler();
        orderButton.addActionListener(handler);
    }

    private class OrderHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == orderButton) {
                total = 0.0;
                try {
                    total += (Float.parseFloat(chocolateField.getText()) * 10.00);
                } catch (NumberFormatException e) {
                    total += 0;
                }
                try {
                    total += (Float.parseFloat(cookieField.getText()) * 15.00);
                } catch (NumberFormatException e) {
                    total += 0;
                }
                try {
                    total += (Float.parseFloat(pudimField.getText()) * 25.00);
                } catch (NumberFormatException e) {
                    total += 0;
                }

                JOptionPane.showMessageDialog(
                        null,
                        "Total da compra: " + total,
                        "Compra realizada",
                        JOptionPane.INFORMATION_MESSAGE,
                        null
                );
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        LojaDoce shop = new LojaDoce();
        shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shop.setSize(400, 550);
        shop.setVisible(true);
    }
}
