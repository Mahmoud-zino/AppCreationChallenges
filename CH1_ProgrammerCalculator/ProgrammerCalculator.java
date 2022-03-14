import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class ProgrammerCalculator extends Frame implements ActionListener {

    TextField decimalField, binaryField, hexaField, octalField;

    public ProgrammerCalculator() {
        setSize(500, 350);
        setResizable(false);
        setTitle("Programmer Calculator");
        setVisible(true);

        //text boxes & Labels
        //decimal
        Label decimalLabel = new Label("Decimal: ");
        decimalLabel.setBounds(30, 100, 50, 25);
        decimalField = new TextField();
        decimalField.setBounds(100, 100, 350, 25);
        
        //Binary
        Label binaryLabel = new Label("Binary: ");
        binaryLabel.setBounds(30, 150, 50, 25);
        binaryField = new TextField();
        binaryField.setBounds(100, 150, 350, 25);
        
        //Hexa
        Label hexaLabel = new Label("Hexa: ");
        hexaLabel.setBounds(30, 200, 50, 25);
        hexaField = new TextField();
        hexaField.setBounds(100, 200, 350, 25);
        
        //Octal
        Label octalLabel = new Label("Octal: ");
        octalLabel.setBounds(30, 250, 50, 25);
        octalField = new TextField();
        octalField.setBounds(100, 250, 350, 25);

        decimalField.addActionListener(this);
        binaryField.addActionListener(this);
        hexaField.addActionListener(this);
        octalField.addActionListener(this);
        
        add(decimalLabel);
        add(decimalField);
        add(binaryLabel);
        add(binaryField);
        add(hexaLabel);
        add(hexaField);
        add(octalLabel);
        add(octalField);
        Label empty = new Label("");
        add(empty);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = 0;
        if(e.getSource() == decimalField) {
            try {            
                result = Integer.parseInt(decimalField.getText());
            }
            catch(NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Error: Decimal numbers can only have the following numbers: 0 1 2 3 4 5 6 7 8 9");
            }
        }
        else if(e.getSource() == binaryField) {
            try {            
                result = Integer.parseInt(binaryField.getText(), 2);
            }
            catch(NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Error: Binary numbers can only have the following numbers: 0 1");
            }
        }
        else if(e.getSource() == hexaField) {
            try {            
                result = Integer.parseInt(hexaField.getText(), 16);
            }
            catch(NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Error: Hexa numbers can only have the following numbers/characters: 0 1 2 3 4 5 6 7 8 9 A B C D E F");
            }
        }
        else if (e.getSource() == octalField) {
            try {            
                result = Integer.parseInt(octalField.getText(), 8);
            }
            catch(NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Error: Octal numbers can only have the following numbers: 0 1 2 3 4 5 6 7");
            }
        }
        
        decimalField.setText(Integer.toString(result));
        binaryField.setText(Integer.toBinaryString(result));
        hexaField.setText(Integer.toHexString(result));
        octalField.setText(Integer.toOctalString(result));
    }

    public static void main(String args[]){
        new ProgrammerCalculator();
    }

}