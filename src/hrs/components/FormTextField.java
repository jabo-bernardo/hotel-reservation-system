package hrs.components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormTextField extends JPanel {
    public JLabel lblLabel;
    public JTextField fldField;
    
    public FormTextField(String label) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        lblLabel = new JLabel(label);
        fldField = new JTextField();
        fldField.setMaximumSize(new Dimension(1000, 32));
        
        this.add(lblLabel);
        this.add(fldField);
    }
}
