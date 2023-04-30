package hrs.screens;

import hrs.screens.application.CustomersScreen;
import hrs.screens.application.DashboardScreen;
import hrs.screens.application.ReportsScreen;
import hrs.screens.application.RoomsScreen;
import hrs.screens.application.UsersScreen;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.ScreenManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationScreen extends Screen implements ActionListener {
    
    public CustomersScreen customersScreen;
    public DashboardScreen dashboardScreen;
    public ReportsScreen reportsScreen;
    public RoomsScreen roomsScreen;
    public UsersScreen usersScreen;
    
    public JPanel   sidebarContentContainer,
                    headerContentContainer;
    public static JPanel mainContentContainer;
    
    public JButton  customersNavButton, 
                    dashboardNavButton,
                    reportsNavButton,
                    roomsNavButton,
                    usersNavButton;
    
    public JButton logoutButton;
    
    public ApplicationScreen() {
        super(Constants.APPLICATION_SCREEN_NAME);
        this.setLayout(new BorderLayout());
        
        headerContentContainer = new JPanel();
            headerContentContainer.setLayout(new BoxLayout(headerContentContainer, BoxLayout.Y_AXIS));
            headerContentContainer.setBackground(Color.WHITE);
            
            JLabel lblHeading = new JLabel("Black Bean Company | Hotel & Resort Reservation System");
            headerContentContainer.add(lblHeading);

        sidebarContentContainer = new JPanel();
            sidebarContentContainer.setLayout(new BoxLayout(sidebarContentContainer, BoxLayout.Y_AXIS));
            sidebarContentContainer.setBackground(Color.GRAY);
            
            dashboardNavButton = new JButton("Dashboard");
            dashboardNavButton.addActionListener(this);
            sidebarContentContainer.add(dashboardNavButton);
            
            reportsNavButton = new JButton("Reports");
            reportsNavButton.addActionListener(this);
            sidebarContentContainer.add(reportsNavButton);
            
            customersNavButton = new JButton("Customers");
            customersNavButton.addActionListener(this);
            sidebarContentContainer.add(customersNavButton);
            
            roomsNavButton = new JButton("Rooms");
            roomsNavButton.addActionListener(this);
            sidebarContentContainer.add(roomsNavButton);
            
            usersNavButton = new JButton("Users");
            usersNavButton.addActionListener(this);
            sidebarContentContainer.add(usersNavButton);
            
            logoutButton= new JButton("Log Out");
            sidebarContentContainer.add(logoutButton);
            
        mainContentContainer = new JPanel();
            mainContentContainer.setLayout(new CardLayout());
            mainContentContainer.setBackground(Color.DARK_GRAY);
            
            customersScreen = new CustomersScreen();
            dashboardScreen = new DashboardScreen();
            reportsScreen = new ReportsScreen();
            roomsScreen = new RoomsScreen();
            usersScreen = new UsersScreen();
            
            mainContentContainer.add(dashboardScreen, dashboardScreen.screenName);
            mainContentContainer.add(customersScreen, customersScreen.screenName);
            mainContentContainer.add(reportsScreen, reportsScreen.screenName);
            mainContentContainer.add(roomsScreen, roomsScreen.screenName);
            mainContentContainer.add(usersScreen, usersScreen.screenName);
        
        this.add(headerContentContainer, BorderLayout.NORTH);
        this.add(sidebarContentContainer, BorderLayout.WEST);
        this.add(mainContentContainer, BorderLayout.CENTER);
    }
    
    public static void setActiveScreen(String screenName) {
        CardLayout screens = (CardLayout)(mainContentContainer.getLayout());
        screens.show(mainContentContainer, screenName);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        boolean IS_DASHBOARD_BUTTON = src.equals(dashboardNavButton);
        boolean IS_CUSTOMERS_BUTTON = src.equals(customersNavButton);
        boolean IS_USERS_BUTTON = src.equals(usersNavButton);
        boolean IS_REPORTS_BUTTON = src.equals(reportsNavButton);
        boolean IS_ROOMS_BUTTON = src.equals(roomsNavButton);
        
        if (IS_DASHBOARD_BUTTON) ScreenManager.switchToApplicationDashboardScreen();
        if (IS_CUSTOMERS_BUTTON) ScreenManager.switchToApplicationCustomersScreen();
        if (IS_USERS_BUTTON) ScreenManager.switchToApplicationUsersScreen();
        if (IS_REPORTS_BUTTON) ScreenManager.switchToApplicationReportsScreen();
        if (IS_ROOMS_BUTTON) ScreenManager.switchToApplicationRoomsScreen();
    }
}
