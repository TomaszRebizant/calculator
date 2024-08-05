import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class create {
    JFrame frame;
    GridLayout grid = new GridLayout(3, 3);
    HashMap<String, JButton> buttons = new HashMap<String, JButton>();
    JLabel number = new JLabel("0");
    JLabel tempNumber = new JLabel("0");
    String actualOperator = "";
    JLabel operator = new JLabel("");
    public create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
        createNumPad();
        JPanel equals = new JPanel();
        createButton("=", equals);
        frame.add(equals);
        createOperatorPad();
        frame.pack();
        frame.setLayout(new GridLayout(2, 3));
        number.setFont(new Font("Arial", Font.PLAIN, 48));
        frame.add(number);
        frame.add(operator);
        operator.setFont(new Font("Arial", Font.PLAIN, 48));
        frame.add(tempNumber);
        tempNumber.setFont(new Font("Arial", Font.PLAIN, 48));

    }
    public void createButton(String text, JPanel panel){
        JButton button = new JButton(text);
        panel.add(button);
        button.addActionListener(e -> {
            numberOperator(text);
        });
    }
    public void numberOperator(String operator){
        if (Integer.parseInt(operator)>=0 && Integer.parseInt(operator)<=9 && actualOperator.isEmpty()){
            number.setText(String.valueOf(Integer.parseInt(number.getText().concat(operator))));
        }

    }
    public void createNumPad(){
        JPanel numPad =  createPanel("numPad", 3, 3);
        for (int i = 1; i < 10; i++) {
            createButton(Integer.toString(i), numPad);
        }
    }
    public void createOperatorPad(){
        JPanel operatorPad = createPanel("operatorPad", 1, 4);
        createButton("+", operatorPad);
        createButton("-", operatorPad);
        createButton("*", operatorPad);
        createButton("/", operatorPad);
    }
    public JPanel createPanel(String name, Integer rows, Integer cols){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        frame.add(panel);
        return panel;
    }

}
