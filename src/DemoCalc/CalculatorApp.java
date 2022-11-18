package DemoCalc;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp implements ActionListener{
    JFrame frame;
    ImageIcon image;
    JTextField textField;
    Border border = BorderFactory.createLineBorder(Color.black, 3, true);

    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;

    JPanel panel;

    Font myFont = new Font("Dialog", Font.BOLD, 20);

    double num1=0.0, num2=0.0, result=0.0;
    char operator;

    CalculatorApp(){
        // Frame Specifications
        frame = new JFrame("CALCULATOR");
        image = new ImageIcon("logo.png");
        frame.getContentPane().setBackground(new Color(200,200,255));
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // TextField Specifications
        textField = new JTextField();
        textField.setBounds(33, 25, 340, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBorder(border);

        // Buttons Specifications
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        for (int i=0; i<9; i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }
        for (int i=0; i<10; i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }
        // Location and Size of Buttons
        negButton.setBounds(50, 430, 96, 50);
        delButton.setBounds(154, 430, 96, 50);
        clrButton.setBounds(258, 430, 96, 50);

        // Making a 4 x 4 Grid Layout for numbers and some function buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 305, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // First Row
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);

        // Second Row
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);

        // Third Row
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);

        // Fourth Row
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add this panel to the main Frame
        frame.add(textField);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Action performed when any number button is clicked
        for (int i=0; i<10; i++){
            if (e.getSource() == numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // Action performed when decimal button is clicked
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        // Action performed when addition button is clicked
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        // Action performed when subtract button is clicked
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        // Action performed when multiply button is clicked
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        // Action performed when division button is clicked
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        // Action performed when equal to button is clicked
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            // Add logic as per operator used
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result; // Store the previous result in num1 variable
        }
        // Action performed when clear button is clicked
        if (e.getSource() == clrButton){
            textField.setText("");
        }
        if (e.getSource() == delButton){
            String str = textField.getText();
            textField.setText("");
            for (int i=0; i<str.length()-1; i++){
                textField.setText(textField.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }

    public static void main(String[] args) {
        CalculatorApp calc = new CalculatorApp();
    }
}
