package hrs.main;

import hrs.models.Account;
import hrs.screens.ApplicationScreen;
import hrs.screens.AuthenticationScreen;
import hrs.screens.SplashScreen;
import hrs.screens.StaticScreens;
import hrs.screens.TestScreen;
import hrs.utils.Constants;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HotelReservationSystem extends JFrame {
    public final static String DEFAULT_WINDOW_NAME = "BBC - Black Bean Company"; 
    public final static Dimension DEFAULT_WINDOW_DIMENSION = new Dimension(800, 600);
    
    public static JPanel mainAppContainer;
    
    public static Account authenticatedUser;
    
    public static String activeScreenString = Constants.SPLASH_SCREEN_NAME;
    
    public HotelReservationSystem() {
        super(DEFAULT_WINDOW_NAME);
        this.loadScreens();
        
        CardLayout cl = (CardLayout)(mainAppContainer.getLayout());
        cl.first(mainAppContainer);
        
        this.initializeWindow();
    }
    
    private void initializeWindow() {
        this.setSize(DEFAULT_WINDOW_DIMENSION);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
//        this.setResizable(false);
        this.setVisible(true);
    }
    
    private void loadScreens() {
        mainAppContainer = new JPanel();
            mainAppContainer.setLayout(new CardLayout());
        
            StaticScreens.splashScreen = new SplashScreen();
            StaticScreens.authenticationScreen = new AuthenticationScreen();
            StaticScreens.applicationScreen = new ApplicationScreen();
            
            mainAppContainer.add(StaticScreens.splashScreen, StaticScreens.splashScreen.screenName);
            mainAppContainer.add(StaticScreens.applicationScreen, StaticScreens.applicationScreen.screenName);           
            mainAppContainer.add(StaticScreens.authenticationScreen, StaticScreens.authenticationScreen.screenName);
            
        this.add(mainAppContainer);       
    }
    
    public static void setActiveScreen(String screenName) {
        if (authenticatedUser == null && !screenName.equals(Constants.AUTHENTICATION_SCREEN_NAME))
            return;
        if (screenName.equals(Constants.APPLICATION_SCREEN_NAME))
            StaticScreens.applicationScreen.renderScreen();
        CardLayout screens = (CardLayout)(mainAppContainer.getLayout());
        screens.show(mainAppContainer, screenName);
        activeScreenString = screenName;
    }
    
    public static String getActiveScreen() {
        return activeScreenString;
    }
    
    public static Account getAuthenticatedUser() {
        return HotelReservationSystem.authenticatedUser;
    }
}
