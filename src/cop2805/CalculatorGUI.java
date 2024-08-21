package cop2805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

	private JTextField textField1;
    private JTextField textField2;
    private JComboBox<String> comboBox;
    private JButton calculateButton;
    private JLabel resultLabel;
    
    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new GridLayout(5, 1));

        JLabel label1 = new JLabel("Number 1:");
        textField1 = new JTextField();
        add(label1);
        add(textField1);

        JLabel label2 = new JLabel("Number 2:");
        textField2 = new JTextField();
        add(label2);
        add(textField2);

        JLabel emptyLabel = new JLabel();

        String[] operators = {"Add", "Subtract", "Multiply", "Divide"};
        comboBox = new JComboBox<>(operators);
        add(emptyLabel);
        add(comboBox);

        calculateButton = new JButton("Calculate");
        add(emptyLabel);
        add(calculateButton);

        resultLabel = new JLabel("Result: ");
        add(emptyLabel);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                String operator = (String) comboBox.getSelectedItem();
                double result = 0.0;

                switch (operator) {
                    case "Add":
                        result = num1 + num2;
                        break;
                    case "Subtract":
                        result = num1 - num2;
                        break;
                    case "Multiply":
                        result = num1 * num2;
                        break;
                    case "Divide":
                        result = num1 / num2;
                        break;
                }

                resultLabel.setText("Result: " + result);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}
