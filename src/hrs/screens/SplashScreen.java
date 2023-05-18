package hrs.screens;

import hrs.components.ImageContainer;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.ScreenManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends Screen {
    public JProgressBar progressBar;
    
    public SplashScreen() {
        super(Constants.SPLASH_SCREEN_NAME);
        
        this.setBackground(Color.WHITE);
        
        JPanel centerContainer = new JPanel();
            centerContainer.setBorder(new EmptyBorder(64, 0, 0, 0));
            centerContainer.setLayout(new BoxLayout(centerContainer, BoxLayout.Y_AXIS));
            centerContainer.setBackground(Color.WHITE);
            
            ImageContainer logoContainer = new ImageContainer("/logo.jpeg", 128, 128);
                logoContainer.setBackground(Color.WHITE);
            centerContainer.add(logoContainer);
            
            JPanel textContainers = new JPanel();
                textContainers.setBorder(new EmptyBorder(16, 0, 0, 0));
                textContainers.setLayout(new BoxLayout(textContainers, BoxLayout.Y_AXIS));
                textContainers.setBackground(Color.WHITE);
                
                JLabel lblHeading = new JLabel("Black Bean Company");
                    lblHeading.setFont(new Font("Public Sans", Font.BOLD, 32));
                    lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
                textContainers.add(lblHeading);
                
                JLabel lblSubheading = new JLabel("Hotel & Resort Reservation System");
                    lblSubheading.setFont(new Font("Public Sans", Font.PLAIN, 12));
                    lblSubheading.setAlignmentX(Component.CENTER_ALIGNMENT);
                textContainers.add(lblSubheading);
                
            centerContainer.add(textContainers);
            
            progressBar = new JProgressBar(0, 100);
                progressBar.setBackground(Color.WHITE);
                progressBar.setForeground(Color.BLACK);
                progressBar.setBorder(new EmptyBorder(16, 0, 0, 0));
                progressBar.setValue(0);
                progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerContainer.add(progressBar);
            
            JLabel cc = new JLabel("Copyright © 2023 Joel & Stewart Inc. All rights reserved");
                cc.setFont(new Font("Public Sans", Font.PLAIN, 10));
                cc.setBorder(new EmptyBorder(32, 0, 0, 0));
                cc.setForeground(Color.GRAY);
                cc.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerContainer.add(cc);
            
        this.add(centerContainer);
        
        this.startProgress();
    }
    
    public void startProgress() {
        if (!ScreenManager.getCurrentScreen().equals(Constants.SPLASH_SCREEN_NAME))
            return;
        var progressThread = new Thread() {
            public void run() {
                for (int x = 0; x < 100; x++) {
                    try {
                        progressBar.setValue(x);
                        Thread.sleep(5000 / 100);
                    } catch(InterruptedException err) {
                        System.out.println(err);
                    }
                }
                ScreenManager.switchToAuthenticationScreen();
            }
        };
        progressThread.start();
        
    }
}
