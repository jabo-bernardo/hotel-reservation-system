package hrs.utils;

import hrs.main.HotelReservationSystem;
import hrs.screens.ApplicationScreen;

public class ScreenManager {
    public static void switchToApplicationScreen() {
        HotelReservationSystem.setActiveScreen(Constants.APPLICATION_SCREEN_NAME);
    }
    
    public static void switchToSplashScreen() {
        HotelReservationSystem.setActiveScreen(Constants.SPLASH_SCREEN_NAME);
    }
    
    public static void switchToAuthenticationScreen() {
        HotelReservationSystem.setActiveScreen(Constants.AUTHENTICATION_SCREEN_NAME);
    }
    
    public static void switchToApplicationDashboardScreen() {
        ApplicationScreen.setActiveScreen(Constants.APPLICATION_DASHBOARD_SCREEN_NAME);
    }
    
    public static void switchToApplicationCustomersScreen() {
        ApplicationScreen.setActiveScreen(Constants.APPLICATION_CUSTOMERS_SCREEN_NAME);
    }
    
    public static void switchToApplicationReportsScreen() {
        ApplicationScreen.setActiveScreen(Constants.APPLICATION_REPORTS_SCREEN_NAME);
    }
    
    public static void switchToApplicationRoomsScreen() {
        ApplicationScreen.setActiveScreen(Constants.APPLICATION_ROOMS_SCREEN_NAME);
    }
    
    public static void switchToApplicationUsersScreen() {
        ApplicationScreen.setActiveScreen(Constants.APPLICATION_USERS_SCREEN_NAME);
    }
    
    
}
