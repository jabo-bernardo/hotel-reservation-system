package hrs.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class DataContainer extends JPanel {
    private JLabel lblTop, lblData;    
    
    public DataContainer(String topText, String dataText) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(12, 12, 12,12));
        this.setBackground(Color.WHITE);
        
        JPanel upperContainer = new JPanel();
            upperContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
            upperContainer.setBackground(Color.WHITE);
            lblData = new JLabel(dataText);
                lblData.setFont(new Font("Public Sans", Font.BOLD, 32));
            upperContainer.add(lblData);
        JPanel lowerContainer = new JPanel();
            lowerContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
            lowerContainer.setBackground(Color.WHITE);
            lblTop = new JLabel(topText);
                lblTop.setFont(new Font("Public Sans", Font.BOLD, 12));
                lblTop.setForeground(Color.LIGHT_GRAY);
            lowerContainer.add(lblTop);
        
        this.add(upperContainer);        
        this.add(lowerContainer);
    }
    
    public void setTopText(String topText) {
        lblTop.setText(topText);
    }
    
    public void setDataText(String dataText) {
        lblData.setText(dataText);
    }
    
}
