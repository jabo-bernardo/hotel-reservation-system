package hrs.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableRow extends JPanel {
    public TableRow(Component[] components) {
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(1, components.length, 4, 4));
        
        for (Component component : components) {            
            this.add(component);
        }
    }
    
    public static JLabel createDefaultLabel(String labelString) {
        JLabel lblHeader = new JLabel(labelString);
            lblHeader.setFont(new Font("Public Sans", Font.BOLD, 16));
        return lblHeader;    
    }
    
    public static JLabel createDefaultLabelPlain(String labelString) {
        JLabel lblHeader = new JLabel(labelString);
            lblHeader.setFont(new Font("Public Sans", Font.PLAIN, 16));
        return lblHeader;    
    }
}
