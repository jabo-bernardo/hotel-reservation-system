package hrs.screens.application;

import hrs.struct.Screen;
import hrs.utils.Constants;
import javax.swing.JLabel;

public class DashboardScreen extends Screen {    
    public DashboardScreen() {
        super(Constants.APPLICATION_DASHBOARD_SCREEN_NAME);
        
        JLabel lblScreenLabel = new JLabel("Showing Dashboard Screen...");
        this.add(lblScreenLabel);
    }    
}
