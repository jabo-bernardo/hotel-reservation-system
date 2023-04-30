package hrs.screens.application;

import hrs.struct.Screen;
import hrs.utils.Constants;
import javax.swing.JLabel;

public class CustomersScreen extends Screen {
    public CustomersScreen() {
        super(Constants.APPLICATION_CUSTOMERS_SCREEN_NAME);
        
        JLabel lblScreenLabel = new JLabel("Showing Customers Screen...");
        this.add(lblScreenLabel);
    }
}
