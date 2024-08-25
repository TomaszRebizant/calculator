import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

import static java.awt.Color.red;

public class create {
    JFrame frame;
    HashMap<String, JButton> buttons = new HashMap<String, JButton>();
    JLabel number = new JLabel("0");
    JLabel tempNumber = new JLabel("0");
    String actualOperator = "";
    JLabel operator = new JLabel("");
    String[] operators = {"+", "-", "*", "/"};
    JPanel numPad;
    JPanel operatorPad;
    GridBagConstraints c = new GridBagConstraints();
    JPanel equals = new JPanel();
    GridBagLayout frameLay = new GridBagLayout();
    GridBagConstraints frameC = new GridBagConstraints();

 void setFrame (){
     frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(300, 300);
     frame.setVisible(true);
 }
 void setKeyboard(){
        JPanel keyboard = createPanel();
        keyboard.add(numPad);
        keyboard.add(equals);
        keyboard.add(operatorPad);
        keyboard.setLayout(new GridLayout(1,3));
        frame.add(keyboard);
    }
    public create() {
        setFrame();
        frameC.fill = GridBagConstraints.BOTH;
        frameC.weightx = 1;
        frameC.weighty = 1;
        frameC.gridx = 0;
        frameC.gridy = 0;
        frameC.anchor = GridBagConstraints.PAGE_START;
        frame.setLayout(frameLay);
        createNumPad();
        JButton equal = new JButton("=");
        equals.add(equal);
        equal.addActionListener(a -> {
            calculate();
        });
        frameC.gridx = 1;
        frameC.gridy = 0;
        frame.add(equals,frameC);
        frameC.gridx = 2;
        frameC.gridy = 0;
        createOperatorPad();
        frame.pack();
        number.setFont(new Font("Arial", Font.PLAIN, 48));
        frameC.gridx = 0;
        frameC.gridy = 1;
        frameC.gridwidth = 3;
        frame.add(number,frameC);
        frame.add(operator);
        operator.setFont(new Font("Arial", Font.PLAIN, 48));
        tempNumber.setFont(new Font("Arial", Font.PLAIN, 48));
        frame.setSize(new Dimension(600,500));
        numPad.setBackground(new Color(169, 107, 107));
        equals.setBackground(new Color(67, 160, 71));
        operatorPad.setBackground(new Color(41, 155, 213));
        number.setBackground(new Color(207, 213, 41));

    }
    public void createButton(String text, JPanel panel){
        JButton button = new JButton(text);
        panel.add(button,c);
        button.addActionListener(e -> {
            numberOperator(text);
        });
    }
    public boolean isNumber(String operator){
        Integer[] cyf = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 0; i < cyf.length; i++){
            if (operator.equals(Integer.toString(cyf[i]))){
                return true;
            }
        }
        return false;
    }
    public boolean isOperator(String operator){
        for (int i = 0; i < operators.length; i++){
            if (operator.equals(operators[i])){
                return true;
            }
        }
        return false;
    }
    public void calculate() {
        if (!number.getText().equals("")) {
            String[] numbers = new String[2];
            String[] Operators = new String[2];
            String opertaredNumber = "";
            int counter = 0;
            for (int i = 0; i < number.getText().length(); i++) {
                for (String s : operators) {
                    if(number.getText().charAt(i)!=s.charAt(0)){
                        opertaredNumber += number.getText().charAt(i);
                        break;
                    }
                    else
                    {
                        numbers[counter] = opertaredNumber;
                        Operators[counter] = String.valueOf(number.getText().charAt(i));
                        opertaredNumber = "";
                        counter++;
                        break;
                    }
                }
            }
            numbers[counter] = opertaredNumber;
        }
    }
    public void numberOperator(String operator){
            if (number.getText().equals("0")){
                number.setText(operator);
            } else {
                number.setText(number.getText() + operator);
            }
        }

    public void createNumPad(){
        numPad =  createPanel();
        numPad.setLayout(new GridBagLayout());
        for (int i = 1; i < 10; i++) {
            c.fill = GridBagConstraints.BOTH;
            c.gridy = (i-1)/3;
            c.gridx = (i-1)%3;
            createButton(Integer.toString(i), numPad);
        }
    }
    public void createOperatorPad(){
        operatorPad = createPanel();
        int coutner = 0;
        operatorPad.setLayout(new GridBagLayout());
        for (String operator : operators) {
            c.gridx = coutner%2;
            c.gridy = coutner/2;
            createButton(operator, operatorPad);
            coutner++;
        }
    }
    public JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.add(panel, frameC);
        return panel;
    }

}
