
package hrs.screens.application;

import hrs.struct.Screen;
import hrs.utils.Constants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class AboutScreen extends Screen {
    public AboutScreen() {
        super(Constants.APPLICATION_ABOUT_SCREEN_NAME);
        
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(16, 16, 16, 16));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel lblAboutHeader = new JLabel("About the Developers");
            lblAboutHeader.setFont(new Font("Public Sans", Font.PLAIN, 32));
            lblAboutHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(lblAboutHeader);
        
        JLabel lblPresBy = new JLabel("Presented by");
            lblPresBy.setBorder(new EmptyBorder(32, 0, 0, 0));
            lblPresBy.setFont(new Font("Public Sans", Font.PLAIN, 16));
            lblPresBy.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(lblPresBy);
        
        JLabel joel = new JLabel("Bernardo, Joel-Vincent G. | BSM CS 2A | 2nd Year | Group 8 | 09560564142");
            joel.setBorder(new EmptyBorder(16, 0, 0, 0));
            joel.setFont(new Font("Public Sans", Font.PLAIN, 16));
            joel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(joel);
        
        JLabel stewart = new JLabel("Buluran, Denzel Stewart | BSM CS 2A | 2nd Year | Group 8 | 09560564142");
            stewart.setBorder(new EmptyBorder(8, 0, 0, 0));
            stewart.setFont(new Font("Public Sans", Font.PLAIN, 16));
            stewart.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(stewart);
        
        JLabel lblPresTo = new JLabel("Presented to");
            lblPresTo.setBorder(new EmptyBorder(32, 0, 0, 0));
            lblPresTo.setFont(new Font("Public Sans", Font.PLAIN, 16));
            lblPresTo.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(lblPresTo);
        
        JLabel evelyn = new JLabel("Engr. Evelyn C. Samson");
            evelyn.setBorder(new EmptyBorder(16, 0, 0, 0));
            evelyn.setFont(new Font("Public Sans", Font.BOLD, 16));
            evelyn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(evelyn);
        
        JLabel position = new JLabel("Instructor, MCS 203");
            position.setBorder(new EmptyBorder(0, 0, 0, 0));
            position.setFont(new Font("Public Sans", Font.PLAIN, 16));
            position.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(position);
        
    }
}
