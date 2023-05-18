package hrs.screens;

import hrs.components.FormTextField;
import hrs.components.ImageContainer;
import hrs.main.HotelReservationSystem;
import hrs.models.Account;
import hrs.services.AccountService;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.ScreenManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AuthenticationScreen extends Screen implements ActionListener {
    public JPanel formContainer;
    public FormTextField fldEmail;
    public FormTextField fldPassword;
    public JButton btnSubmit;
    public int authenticationTries;
    
    public AuthenticationScreen() {
        super(Constants.AUTHENTICATION_SCREEN_NAME);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
        this.setBackground(Color.WHITE);
        
        JPanel headerContainer = new JPanel();
            headerContainer.setMaximumSize(new Dimension(1000, 200));
            headerContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
            headerContainer.setBorder(new EmptyBorder(32, 0, 0, 0));
            headerContainer.setLayout(new BoxLayout(headerContainer, BoxLayout.Y_AXIS));
            headerContainer.setBackground(Color.WHITE);
            
             ImageContainer logoContainer = new ImageContainer("/logo.jpeg", 80, 80);
                logoContainer.setBackground(Color.WHITE);
            headerContainer.add(logoContainer);
            
            JPanel textContainers = new JPanel();
                textContainers.setBorder(new EmptyBorder(16, 0, 0, 0));
                textContainers.setLayout(new BoxLayout(textContainers, BoxLayout.Y_AXIS));
                textContainers.setBackground(Color.WHITE);
                
                JLabel lblHeading = new JLabel("Black Bean Company");
                    lblHeading.setFont(new Font("Public Sans", Font.BOLD, 32));
                    lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
                textContainers.add(lblHeading);
                
                JLabel lblSubheading = new JLabel("Please authenticate to use the system.");
                    lblSubheading.setFont(new Font("Public Sans", Font.PLAIN, 12));
                    lblSubheading.setAlignmentX(Component.CENTER_ALIGNMENT);
                textContainers.add(lblSubheading);
                
            headerContainer.add(textContainers);
            
        this.add(headerContainer);
        
        formContainer = new JPanel();
            formContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
            formContainer.setBorder(new EmptyBorder(32, 32, 32, 32));
            formContainer.setBackground(Color.WHITE);
            formContainer.setMaximumSize(new Dimension(400, 250));
            formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.PAGE_AXIS));
            
            fldEmail = new FormTextField("Username ", false);
                fldEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
            formContainer.add(fldEmail);
            
            fldPassword = new FormTextField("Password ", true);
                fldPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
                fldPassword.setBorder(new EmptyBorder(16, 0, 0, 0));
            formContainer.add(fldPassword);
            
            JPanel actionButtonsContainer = new JPanel();
                actionButtonsContainer.setLayout(new BorderLayout());
                actionButtonsContainer.setBackground(Color.WHITE);
                actionButtonsContainer.setBorder(new EmptyBorder(16, 0, 0, 0));
                btnSubmit = new JButton("Log In");
                    btnSubmit.setBackground(Color.BLACK);
                    btnSubmit.setForeground(Color.WHITE);
                    btnSubmit.setFont(new Font("Public Sans", Font.BOLD, 16));
                    btnSubmit.addActionListener(this);
                actionButtonsContainer.add(btnSubmit, BorderLayout.CENTER);
            formContainer.add(actionButtonsContainer);
        
        this.add(formContainer, BorderLayout.CENTER);
               
    }
    
    public void authenticateUser() {
        String username = fldEmail.getValue();
        String password = fldPassword.getValue();
        Account account = AccountService.getAccountByUsername(username);
        if (account == null) {
            JOptionPane.showMessageDialog(
                    formContainer, 
                    "Account does not exists", 
                    "Authentication Failed", 
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        authenticationTries++;
        if (!account.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(
                    formContainer, 
                    "Password does not match (" + (3 - authenticationTries) + " tries left)", 
                    "Authentication Failed", 
                    JOptionPane.ERROR_MESSAGE
            );
            if (authenticationTries >= 3)
                System.exit(0);
            return;
        }
        authenticationTries = 0;
        HotelReservationSystem.authenticatedUser = account;
        HotelReservationSystem.setActiveScreen(Constants.APPLICATION_SCREEN_NAME);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object src;
        src = e.getSource();
        
        boolean IS_LOG_IN_BUTTON = src.equals(btnSubmit);
        
        if (IS_LOG_IN_BUTTON) {
            authenticateUser();
        }
    }
    
}
