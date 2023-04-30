package hrs.main;

import hrs.screens.ApplicationScreen;
import hrs.screens.AuthenticationScreen;
import hrs.screens.SplashScreen;
import hrs.screens.TestScreen;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HotelReservationSystem extends JFrame {
    public final static String DEFAULT_WINDOW_NAME = "BBC - Black Bean Company"; 
    public final static Dimension DEFAULT_WINDOW_DIMENSION = new Dimension(800, 600);
    
    public static JPanel mainAppContainer;
    
    // Screens
    SplashScreen splashScreen;
    TestScreen testScreen;
    AuthenticationScreen authenticationScreen;
    ApplicationScreen applicationScreen;
    
    public HotelReservationSystem() {
        super(DEFAULT_WINDOW_NAME);
        this.initializeWindow();
        this.loadScreens();
        
        CardLayout cl = (CardLayout)(mainAppContainer.getLayout());
        cl.first(mainAppContainer);
    }
    
    private void initializeWindow() {
        this.setSize(DEFAULT_WINDOW_DIMENSION);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    private void loadScreens() {
        mainAppContainer = new JPanel();
            mainAppContainer.setLayout(new CardLayout());
        
            splashScreen = new SplashScreen();
            testScreen = new TestScreen();
            authenticationScreen = new AuthenticationScreen();
            applicationScreen = new ApplicationScreen();
            
            mainAppContainer.add(authenticationScreen, authenticationScreen.screenName);
            mainAppContainer.add(splashScreen, splashScreen.screenName);
            mainAppContainer.add(testScreen, testScreen.screenName);
            mainAppContainer.add(applicationScreen, applicationScreen.screenName);           
            
        this.add(mainAppContainer);       
    }
    
    public static void setActiveScreen(String screenName) {
        CardLayout screens = (CardLayout)(mainAppContainer.getLayout());
        screens.show(mainAppContainer, screenName);
    }
}
