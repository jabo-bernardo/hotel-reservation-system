
package hrs.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class FontLoader {
    public static void loadTtfFile(String filePath) {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font createdFont = Font.createFont(Font.TRUETYPE_FONT, new File(FontLoader.class.getResource(filePath).toURI() ));
            ge.registerFont(createdFont);
            
        } catch(IOException|FontFormatException|URISyntaxException err) {
            err.printStackTrace();
        }
    }
}
