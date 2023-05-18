package hrs.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageContainer extends JPanel {
    private BufferedImage bufferedImage;
    private int width, height;
    
    public ImageContainer(String filePath, int width, int height) {
        try {
            Dimension preferredSize = new Dimension(width, height);
                    
            bufferedImage = ImageIO.read(ImageContainer.class.getResource(filePath));
            
            JLabel imageContainer = new JLabel();
                imageContainer.setIcon(new ImageIcon(bufferedImage.getScaledInstance(width, height, 0)));   
            this.add(imageContainer);
        } catch (IOException err) {}
        
        
    }
}
