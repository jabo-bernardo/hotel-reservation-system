
package hrs.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RoomClassContainer extends JPanel {
    private JButton actionButton;
    
    public RoomClassContainer() {       
        
        actionButton = new JButton("Room 69");
            actionButton.setBackground(Color.WHITE);
            actionButton.setPreferredSize(new Dimension(150, 150));
        this.add(actionButton);
    }
}
