package hrs.components;

import hrs.main.HotelReservationSystem;
import hrs.screens.ApplicationScreen;
import hrs.utils.Constants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class NavigationItem extends JPanel {
    public JPanel iconContainer;
    public JPanel labelContainer;
    public ImageContainer iconImage;
    public String screenName;
    
    public NavigationItem(String iconPathName, String label, String screenName) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.screenName = screenName;
        
        
        iconContainer = new JPanel();
            iconContainer.setBackground(Color.WHITE);
            iconImage = new ImageContainer(iconPathName, 32, 32);
                iconImage.setBackground(Color.WHITE);
            iconContainer.add(iconImage);
        labelContainer = new JPanel();
            labelContainer.setBackground(Color.WHITE);
            JLabel iconLabel = new JLabel(label);
                iconLabel.setFont(new Font("Public Sans", Font.PLAIN, 12));
            labelContainer.add(iconLabel);
            
        this.add(iconContainer);
        this.add(labelContainer);
        this.setMaximumSize(new Dimension(128, (int)(this.getPreferredSize().getHeight())));
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                iconContainer.setBackground(Color.LIGHT_GRAY);
                labelContainer.setBackground(Color.LIGHT_GRAY);
                iconImage.setBackground(Color.LIGHT_GRAY);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                iconContainer.setBackground(Color.WHITE);
                labelContainer.setBackground(Color.WHITE);
                iconImage.setBackground(Color.WHITE);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if (screenName.equals("LOGOUT")) {
                    HotelReservationSystem.authenticatedUser = null;
                    HotelReservationSystem.setActiveScreen(Constants.AUTHENTICATION_SCREEN_NAME);
                    return;
                }
                ApplicationScreen.setActiveScreen(screenName);
            }
        });
    }
    
}
