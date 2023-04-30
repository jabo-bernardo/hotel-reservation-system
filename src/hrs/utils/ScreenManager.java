package hrs.utils;

import hrs.main.HotelReservationSystem;

public class ScreenManager {
    public static void switchToApplicationScreen() {
        HotelReservationSystem.setScreen(Constants.APPLICATION_SCREEN_NAME);
    }
    
    public static void switchToSplashScreen() {
        HotelReservationSystem.setScreen(Constants.SPLASH_SCREEN_NAME);
    }
    
    public static void switchToAuthenticationScreen() {
        HotelReservationSystem.setScreen(Constants.AUTHENTICATION_SCREEN_NAME);
    }
}
