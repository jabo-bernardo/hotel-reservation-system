package hrs.screens;

import hrs.struct.Screen;
import hrs.utils.Constants;
import javax.swing.JLabel;

public class SplashScreen extends Screen {
    public SplashScreen() {
        super(Constants.SPLASH_SCREEN_NAME);
        
        this.add(new JLabel("Showing Splash Screen..."));
    }
}
