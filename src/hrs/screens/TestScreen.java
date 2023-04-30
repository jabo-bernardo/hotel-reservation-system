package hrs.screens;

import hrs.struct.Screen;
import hrs.utils.Constants;
import javax.swing.JLabel;

public class TestScreen extends Screen {
    public TestScreen() {
        super(Constants.TEST_SCREEN_NAME);
        
        this.add(new JLabel("Showing Test Screen..."));
    }
}
