package hrs.screens;

import hrs.components.NavigationItem;
import hrs.main.HotelReservationSystem;
import hrs.screens.application.AboutScreen;
import hrs.screens.application.CustomersScreen;
import hrs.screens.application.DashboardScreen;
import hrs.screens.application.HistoryScreen;
import hrs.screens.application.ReportsScreen;
import hrs.screens.application.ReservationScreen;
import hrs.screens.application.RoomsScreen;
import hrs.screens.application.UsersScreen;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.DateUtils;
import hrs.utils.ScreenManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ApplicationScreen extends Screen implements ActionListener {
    
    public JPanel   sidebarContentContainer,
                    headerContentContainer;
    public static JPanel mainContentContainer;
    
    public JButton  customersNavButton, 
                    dashboardNavButton,
                    reportsNavButton,
                    roomsNavButton,
                    usersNavButton;
    
    public NavigationItem   dashboardButton,
                            reportsButton,
                            historyButton,
                            aboutButton,
                            logoutButton;
    
    public JLabel lblUsername, lblDate;
    
    public ApplicationScreen() {
        super(Constants.APPLICATION_SCREEN_NAME);
        this.renderScreen();
    }
    
    public void renderScreen() {
        this.removeAll();
        
        this.setLayout(new BorderLayout());
        
        updateHeaderHandler();
        
        headerContentContainer = new JPanel();
            headerContentContainer.setLayout(new GridLayout(1, 2));
            headerContentContainer.setBackground(Color.WHITE);
            headerContentContainer.setBorder(new EmptyBorder(16, 16, 16, 16));
            
            JPanel headerContainerLeft = new JPanel();
                headerContainerLeft.setBackground(Color.WHITE);
                headerContainerLeft.setLayout(new BoxLayout(headerContainerLeft, BoxLayout.Y_AXIS));
                JLabel lblHeading = new JLabel("Black Bean Company");
                    lblHeading.setFont(new Font("Public Sans", Font.BOLD, 20));
                    headerContainerLeft.add(lblHeading);
                JLabel lblSubHeader = new JLabel("Hotel & Resort Reservation System");
                    lblSubHeader.setFont(new Font("Public Sans", Font.PLAIN, 12));
                    headerContainerLeft.add(lblSubHeader);
            headerContentContainer.add(headerContainerLeft);
            
            JPanel headerContainerRight = new JPanel();
                headerContainerRight.setBackground(Color.WHITE);
                headerContainerRight.setLayout(new BoxLayout(headerContainerRight, BoxLayout.Y_AXIS));
                lblUsername = new JLabel("Logged in: admin");
                    lblUsername.setAlignmentX(Component.RIGHT_ALIGNMENT);
                    lblUsername.setFont(new Font("Public Sans", Font.PLAIN, 14));
                    headerContainerRight.add(lblUsername);
                lblDate = new JLabel(DateUtils.format(new Date()));
                    lblDate.setAlignmentX(Component.RIGHT_ALIGNMENT);
                    lblDate.setFont(new Font("Public Sans", Font.PLAIN, 14));
                    headerContainerRight.add(lblDate);
            headerContentContainer.add(headerContainerRight);

        sidebarContentContainer = new JPanel();
            sidebarContentContainer.setLayout(new BoxLayout(sidebarContentContainer, BoxLayout.Y_AXIS));
            sidebarContentContainer.setBackground(Color.WHITE);
            
            dashboardButton = new NavigationItem("/dashboard_icon.png", "Dashboard", Constants.APPLICATION_DASHBOARD_SCREEN_NAME);
                sidebarContentContainer.add(dashboardButton);
                
            reportsButton = new NavigationItem("/report_icon.png", "Reports", Constants.APPLICATION_REPORTS_SCREEN_NAME);
                if (HotelReservationSystem.authenticatedUser != null && HotelReservationSystem.authenticatedUser.isStaff())
                    reportsButton.setVisible(false);
                sidebarContentContainer.add(reportsButton);
                
            historyButton = new NavigationItem("/history_icon.png", "History", Constants.APPLICATION_HISTORY_SCREEN_NAME);
                sidebarContentContainer.add(historyButton);
                
            aboutButton = new NavigationItem("/about_icon.png", "About", Constants.APPLICATION_ABOUT_SCREEN_NAME);
                sidebarContentContainer.add(aboutButton);
                
            logoutButton = new NavigationItem("/logout_icon.png", "Log Out", "LOGOUT");
                sidebarContentContainer.add(logoutButton);
            
        mainContentContainer = new JPanel();
            mainContentContainer.setLayout(new CardLayout());
            mainContentContainer.setBackground(Color.DARK_GRAY);
            
            StaticScreens.customersScreen = new CustomersScreen();
            StaticScreens.reservationScreen = new ReservationScreen();
            StaticScreens.dashboardScreen = new DashboardScreen();
            StaticScreens.reportsScreen = new ReportsScreen();
            StaticScreens.roomsScreen = new RoomsScreen();
            StaticScreens.usersScreen = new UsersScreen();
            StaticScreens.aboutScreen = new AboutScreen();
            StaticScreens.roomActionsScreen = new RoomActionsScreen();
            StaticScreens.historyScreen = new HistoryScreen();
            
            JScrollPane dashboardScrollPane = panelToScrollPane(StaticScreens.dashboardScreen);
            JScrollPane reservationScrollPane = panelToScrollPane(StaticScreens.reservationScreen);
            JScrollPane roomActionsScrollPane = panelToScrollPane(StaticScreens.roomActionsScreen);
            JScrollPane reportsScrollPane = panelToScrollPane(StaticScreens.reportsScreen);
            JScrollPane historyScrollPane = panelToScrollPane(StaticScreens.historyScreen);
            
            mainContentContainer.add(dashboardScrollPane, StaticScreens.dashboardScreen.screenName);
            mainContentContainer.add(roomActionsScrollPane, StaticScreens.roomActionsScreen.screenName);
            mainContentContainer.add(reservationScrollPane, StaticScreens.reservationScreen.screenName);
            mainContentContainer.add(historyScrollPane, StaticScreens.historyScreen.screenName);
            mainContentContainer.add(StaticScreens.aboutScreen, StaticScreens.aboutScreen.screenName);
            mainContentContainer.add(StaticScreens.customersScreen, StaticScreens.customersScreen.screenName);
            mainContentContainer.add(reportsScrollPane, StaticScreens.reportsScreen.screenName);
            mainContentContainer.add(StaticScreens.roomsScreen, StaticScreens.roomsScreen.screenName);
            mainContentContainer.add(StaticScreens.usersScreen, StaticScreens.usersScreen.screenName);
        
        this.add(headerContentContainer, BorderLayout.NORTH);
        this.add(sidebarContentContainer, BorderLayout.WEST);
        this.add(mainContentContainer, BorderLayout.CENTER);
    }
    
    public JScrollPane panelToScrollPane(JPanel panel) {
        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
            scrollPane.getVerticalScrollBar().setBorder(new EmptyBorder(0, 0, 0, 0));
            scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.getVerticalScrollBar().setUnitIncrement(24);
       return scrollPane;
    }
    
    public static void setActiveScreen(String screenName) {
        CardLayout screens = (CardLayout)(mainContentContainer.getLayout());
        if (screenName.equals(Constants.APPLICATION_DASHBOARD_SCREEN_NAME))
            StaticScreens.dashboardScreen.renderScreen();
        if (screenName.equals(Constants.APPLICATION_ROOM_ACTIONS_SCREEN_NAME))
            StaticScreens.roomActionsScreen.renderScreen();
        if (screenName.equals(Constants.APPLICATION_REPORTS_SCREEN_NAME))
            StaticScreens.reportsScreen.renderScreen();
        if (screenName.equals(Constants.APPLICATION_HISTORY_SCREEN_NAME))
            StaticScreens.historyScreen.renderScreen();
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
    
    public void updateHeaderHandler() {
        Thread headerUpdaterThread = new Thread() {
            public void run() {
                while(true) {
                    try {
                        String authenticatedUser = "Logged in: Guest";
                        if (HotelReservationSystem.getAuthenticatedUser() != null)
                            authenticatedUser = "Logged in: " + HotelReservationSystem.getAuthenticatedUser().getUsername();
                        if (lblUsername != null)
                            lblUsername.setText(authenticatedUser);
                        if (lblDate != null) 
                            lblDate.setText(DateUtils.format(new Date()));
                        Thread.sleep(1000);
                    } catch(InterruptedException err) {
                        
                    }
                }
            }
        };
        headerUpdaterThread.start();
    }
}
