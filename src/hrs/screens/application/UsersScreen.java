package hrs.screens.application;

import hrs.struct.Screen;
import hrs.utils.Constants;
import javax.swing.JLabel;

public class UsersScreen extends Screen {
    
    public UsersScreen() {
        super(Constants.APPLICATION_USERS_SCREEN_NAME);
        
        JLabel lblScreenLabel = new JLabel("Showing Users Screen...");
        this.add(lblScreenLabel);
    }
    
}
