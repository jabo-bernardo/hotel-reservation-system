package hrs.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormTextField extends JPanel {
    public JLabel lblLabel;
    public JTextField fldField;
    public JPasswordField fldPassField;
    public boolean isPassword;
    
    public FormTextField(String label, boolean isPassword) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.isPassword = isPassword;
        
        lblLabel = new JLabel(label);
            lblLabel.setBorder(new EmptyBorder(0, 0, 4, 0));
            lblLabel.setFont(new Font("Public Sans", Font.BOLD, 14));
            lblLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        fldField = new JTextField(20);
            fldField.setFont(new Font("Public Sans", Font.PLAIN, 14));
            fldField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                    new EmptyBorder(8, 8, 8, 8)
            ));
            fldField.setAlignmentX(Component.LEFT_ALIGNMENT);

        fldPassField = new JPasswordField(20);
            fldPassField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                    new EmptyBorder(8, 8, 8, 8)
            ));
            fldPassField.setFont(new Font("Public Sans", Font.PLAIN, 14));
            fldPassField.setAlignmentX(Component.LEFT_ALIGNMENT);

        
        this.add(lblLabel);
        if (isPassword)
            this.add(fldPassField);
        else
            this.add(fldField);
    }
    
    public void setEnabled(boolean boo) {
        this.fldField.setEnabled(boo);
        this.fldPassField.setEnabled(boo);
    }
    
    public String getValue() {
        if (isPassword)
            return fldPassField.getText();
        return fldField.getText();
    }
    
    public void setValue(String value) {
        if (isPassword) {
            fldPassField.setText(value);
            return;
        }
        fldField.setText(value);
    }
}
