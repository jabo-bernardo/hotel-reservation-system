package hrs.screens.application;

import hrs.struct.Screen;
import hrs.utils.Constants;
import javax.swing.JLabel;

public class ReportsScreen extends Screen {
    
    public ReportsScreen() {
        super(Constants.APPLICATION_REPORTS_SCREEN_NAME);
        
        JLabel lblScreenLabel = new JLabel("Showing Reports Screen...");
        this.add(lblScreenLabel);
    }
    
}
