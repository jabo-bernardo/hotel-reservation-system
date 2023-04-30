package hrs.screens;

import hrs.struct.Screen;
import hrs.utils.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationScreen extends Screen {
    
    public ApplicationScreen() {
        super(Constants.APPLICATION_SCREEN_NAME);
        this.setLayout(new BorderLayout());
        
        JPanel pnlHeader = new JPanel();
            pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.Y_AXIS));
            pnlHeader.setBackground(Color.WHITE);
            
            JLabel lblHeading = new JLabel("Black Bean Company | Hotel & Resort Reservation System");
            pnlHeader.add(lblHeading);

        JPanel pnlSidebar = new JPanel();
            pnlSidebar.setLayout(new BoxLayout(pnlSidebar, BoxLayout.Y_AXIS));
            pnlSidebar.setBackground(Color.GRAY);
            
            JButton btnDashboard = new JButton("Dashboard");
            pnlSidebar.add(btnDashboard);
            
            JButton btnReport = new JButton("Reports");
            pnlSidebar.add(btnReport);
            
            JButton btnCustomer = new JButton("Customers");
            pnlSidebar.add(btnCustomer);
            
            JButton btnRoom = new JButton("Rooms");
            pnlSidebar.add(btnRoom);
            
            JButton btnUsers = new JButton("Users");
            pnlSidebar.add(btnUsers);
            
            JButton btnLogout = new JButton("Log Out");
            pnlSidebar.add(btnLogout);
            
        JPanel pnlMain = new JPanel();
            pnlMain.setBackground(Color.DARK_GRAY);
        
            JLabel lblTest = new JLabel("Hello");
            pnlMain.add(lblTest);
        
        this.add(pnlHeader, BorderLayout.NORTH);
        this.add(pnlSidebar, BorderLayout.WEST);
        this.add(pnlMain, BorderLayout.CENTER);
    }
    
}
