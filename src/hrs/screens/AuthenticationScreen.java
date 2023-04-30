package hrs.screens;

import hrs.components.FormTextField;
import hrs.main.HotelReservationSystem;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.ScreenManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AuthenticationScreen extends Screen implements ActionListener {
    public JPanel formContainer;
    public FormTextField fldEmail;
    public FormTextField fldPassword;
    public JButton btnSubmit;
    
    public AuthenticationScreen() {
        super(Constants.AUTHENTICATION_SCREEN_NAME);
        this.setLayout(new FlowLayout()); 
        this.setBackground(Color.darkGray);
        
        formContainer = new JPanel();
            formContainer.setBorder(new EmptyBorder(32, 32, 32, 32));
            formContainer.setBackground(Color.WHITE);
            formContainer.setPreferredSize(new Dimension(400, 300));
            formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.PAGE_AXIS));
            
            fldEmail = new FormTextField("Email Address: ");
            formContainer.add(fldEmail);
            
            fldPassword = new FormTextField("Password ");
            formContainer.add(fldPassword);
            
            btnSubmit = new JButton("Log In");
                btnSubmit.addActionListener(this);
            formContainer.add(btnSubmit);
        
        this.add(formContainer, BorderLayout.CENTER);
               
    }
    
    public void actionPerformed(ActionEvent e) {
        Object src;
        src = e.getSource();
        
        boolean IS_LOG_IN_BUTTON = src.equals(btnSubmit);
        
        if (IS_LOG_IN_BUTTON) {
            ScreenManager.switchToApplicationScreen();
        }
    }
    
}
