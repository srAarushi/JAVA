import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumCalculatorUsingLayout extends JFrame implements ActionListener {
    private JTextField textField1, textField2, resultField;
    private JButton sumButton;

    public SumCalculatorUsingLayout() {
        setTitle("Sum Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        sumButton = new JButton("Sum");
        sumButton.addActionListener(this);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Value 1:"), gbc);

        gbc.gridx = 1;
        panel.add(textField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Value 2:"), gbc);

        gbc.gridx = 1;
        panel.add(textField2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(sumButton, gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Result:"), gbc);

        gbc.gridx = 2;
        panel.add(resultField, gbc);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sumButton) {
            try {
                int value1 = Integer.parseInt(textField1.getText());
                int value2 = Integer.parseInt(textField2.getText());
                int sum = value1 + value2;
                resultField.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid integers.");
            }
        }
    }

    public static void main(String[] args) {
		
        SumCalculatorUsingLayout calculator = new SumCalculatorUsingLayout();
        calculator.setVisible(true);
    }
}