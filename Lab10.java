import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab10 {
    private JFrame frame;
    private JTextField nameField;
    private JComboBox<String> itemCombo;
    private JCheckBox expressDelivery;
    private JRadioButton cashPayment, cardPayment;
    private JLabel statusLabel;
    private JButton submitButton;

    public Lab10() {
        // Create main frame
        frame = new JFrame("Simple Order System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        // Add components
        createComponents();

        // Display frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createComponents() {
        // Customer Name
        frame.add(new JLabel("Customer Name:"));
        nameField = new JTextField(20);
        frame.add(nameField);

        // Item Selection
        frame.add(new JLabel("Select Item:"));
        String[] items = {"Laptop", "Phone", "Tablet"};
        itemCombo = new JComboBox<>(items);
        frame.add(itemCombo);

        // Delivery Option
        expressDelivery = new JCheckBox("Express Delivery");
        frame.add(expressDelivery);

        // Payment Options
        frame.add(new JLabel("Payment Method:"));
        cashPayment = new JRadioButton("Cash");
        cardPayment = new JRadioButton("Card");
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashPayment);
        paymentGroup.add(cardPayment);
        cashPayment.setSelected(true);
        frame.add(cashPayment);
        frame.add(cardPayment);

        // Submit Button
        submitButton = new JButton("Place Order");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
        frame.add(submitButton);

        // Status Label
        statusLabel = new JLabel("Ready to take order");
        frame.add(statusLabel);
    }

    private void placeOrder() {
        if (nameField.getText().trim().isEmpty()) {
            statusLabel.setText("Please enter customer name!");
            return;
        }

        String orderDetails = "Order Details:\n" +
                            "Name: " + nameField.getText() + "\n" +
                            "Item: " + itemCombo.getSelectedItem() + "\n" +
                            "Delivery: " + (expressDelivery.isSelected() ? "Express" : "Standard") + "\n" +
                            "Payment: " + (cashPayment.isSelected() ? "Cash" : "Card");

        JOptionPane.showMessageDialog(frame, orderDetails);
        
        // Reset form
        nameField.setText("");
        itemCombo.setSelectedIndex(0);
        expressDelivery.setSelected(false);
        cashPayment.setSelected(true);
        statusLabel.setText("Order placed successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Lab10();
            }
        });
    }
}