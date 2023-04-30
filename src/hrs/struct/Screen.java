
package hrs.struct;

import javax.swing.JPanel;

public abstract class Screen extends JPanel {
    public String screenName;
    
    public Screen(String screenName) {
        this.screenName = screenName;
    }
}
