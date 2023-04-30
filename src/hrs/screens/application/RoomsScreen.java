package hrs.screens.application;

import hrs.struct.Screen;
import hrs.utils.Constants;
import javax.swing.JLabel;

public class RoomsScreen extends Screen {
    
    public RoomsScreen() {
        super(Constants.APPLICATION_ROOMS_SCREEN_NAME);
        
        JLabel lblScreenLabel = new JLabel("Showing Rooms Screen...");
        this.add(lblScreenLabel);
    }
    
}
