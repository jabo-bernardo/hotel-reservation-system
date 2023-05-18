package hrs.screens.application;

import hrs.components.TableRow;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.Database;
import hrs.models.Room;
import hrs.screens.ApplicationScreen;
import hrs.screens.StaticScreens;
import hrs.services.RoomService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ReportsScreen extends Screen implements ActionListener {
    
    public Date currentDate = new Date();
    public String year = currentDate.getYear() + "";
    public int month = currentDate.getMonth();
    public JComboBox yearComboBox, monthComboBox ;
    public JPanel annualSalesContainer, annualSalesHeaderContainer, yearSelector, annualTableContainer;
    
    public ReportsScreen() {
        super(Constants.APPLICATION_REPORTS_SCREEN_NAME);
        
        this.renderScreen();
    }
    
    public void renderScreen() {
        this.removeAll();
        
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(64, 128, 64, 128));
        this.setLayout(new GridLayout(2, 1));
        
        annualSalesContainer = new JPanel();
            annualSalesContainer.setBackground(Color.WHITE);
            annualSalesContainer.setLayout(new BoxLayout(annualSalesContainer, BoxLayout.Y_AXIS));
            
            annualSalesHeaderContainer = new JPanel();
                annualSalesHeaderContainer.setBackground(Color.WHITE);
                JLabel annualSalesHeader = new JLabel("Annual Sales");
                    annualSalesHeader.setFont(new Font("Public Sans", Font.BOLD, 20));
                annualSalesHeaderContainer.add(annualSalesHeader);
                annualSalesHeaderContainer.setMaximumSize(new Dimension(10000, annualSalesHeaderContainer.getPreferredSize().height));
            annualSalesContainer.add(annualSalesHeaderContainer);
            
            yearSelector = new JPanel();
                yearSelector.setBorder(new EmptyBorder(16, 0, 16, 0));
                yearSelector.setBackground(Color.WHITE);
                yearSelector.setLayout(new GridLayout(1, 1));
                
                String[] yearList = { "2022", "2023" };
                yearComboBox = new JComboBox(yearList);
                    yearComboBox.setSelectedItem((Integer.parseInt(year) + 1900) + "");
                yearComboBox.addActionListener(this);
                
                yearSelector.add(yearComboBox);
                
            annualSalesContainer.add(yearSelector);
            
            annualTableContainer = new JPanel();
                annualTableContainer.setLayout(new BoxLayout(annualTableContainer, BoxLayout.Y_AXIS));
                annualTableContainer.setBackground(Color.WHITE);
                
                JLabel lblHeaderKey = TableRow.createDefaultLabel("Room Number | Room Class");
                JLabel lblHeaderValue = TableRow.createDefaultLabel("Sales Made");
                    lblHeaderValue.setHorizontalAlignment(SwingConstants.RIGHT);
                
                JLabel[] headerLabels = {
                    lblHeaderKey,
                    lblHeaderValue
                };
                TableRow headerRow = new TableRow((Component[])headerLabels);
                annualTableContainer.add(headerRow);
                
                for (Room room : Database.rooms) {
                    JLabel lblKey = TableRow.createDefaultLabelPlain(room.getRoomNumber() + " | " + room.getRoomClass());
                    JLabel lblValue = TableRow.createDefaultLabelPlain(String.format("%2.02f", RoomService.getRoomAnnualSalesByYear(room.getID(), Integer.parseInt(year))) + "");
                        lblValue.setHorizontalAlignment(SwingConstants.RIGHT);
                    JLabel[] tableContents = {
                        lblKey,
                        lblValue
                    };
                    TableRow tableRow = new TableRow((Component[])tableContents);
                    annualTableContainer.add(tableRow);
                }
                
            annualSalesContainer.setMaximumSize(new Dimension(10000, annualSalesContainer.getPreferredSize().height));
            annualSalesContainer.add(annualTableContainer);
        this.add(annualSalesContainer);
        
        JPanel monthlySalesContainer = new JPanel();
            monthlySalesContainer.setBackground(Color.WHITE);
            monthlySalesContainer.setLayout(new BoxLayout(monthlySalesContainer, BoxLayout.Y_AXIS));
            monthlySalesContainer.setBorder(new EmptyBorder(32, 0, 0, 0));
            
            JPanel monthlySalesHeaderContainer = new JPanel();
                monthlySalesHeaderContainer.setBackground(Color.WHITE);
                annualSalesHeader = new JLabel("Monthly Sales");
                    annualSalesHeader.setFont(new Font("Public Sans", Font.BOLD, 20));
                monthlySalesHeaderContainer.add(annualSalesHeader);
                monthlySalesHeaderContainer.setMaximumSize(new Dimension(10000, annualSalesHeaderContainer.getPreferredSize().height));
            monthlySalesContainer.add(monthlySalesHeaderContainer);
            
            JPanel monthSelector = new JPanel();
                monthSelector.setBorder(new EmptyBorder(16, 0, 16, 0));
                monthSelector.setBackground(Color.WHITE);
                monthSelector.setLayout(new GridLayout(1, 1));
                
                String[] monthList = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
                monthComboBox = new JComboBox(monthList);
                    monthComboBox.setSelectedIndex(month);
                monthComboBox.addActionListener(this);
                
                monthSelector.add(monthComboBox);
                
            monthlySalesContainer.add(monthSelector);
            
            JPanel monthlyTableContainer = new JPanel();
                monthlyTableContainer.setLayout(new BoxLayout(monthlyTableContainer, BoxLayout.Y_AXIS));
                monthlyTableContainer.setBackground(Color.WHITE);
                
                lblHeaderKey = TableRow.createDefaultLabel("Room Number | Room Class");
                lblHeaderValue = TableRow.createDefaultLabel("Sales Made");
                    lblHeaderValue.setHorizontalAlignment(SwingConstants.RIGHT);
                
                JLabel[] monthlyHeaderLabels = {
                    lblHeaderKey,
                    lblHeaderValue
                };
                TableRow monthlyheaderRow = new TableRow((Component[])monthlyHeaderLabels);
                monthlyTableContainer.add(monthlyheaderRow);
                
                for (Room room : Database.rooms) {
                    JLabel lblKey = TableRow.createDefaultLabelPlain(room.getRoomNumber() + " | " + room.getRoomClass());
                    JLabel lblValue = TableRow.createDefaultLabelPlain(String.format("%2.02f", RoomService.getRoomMonthlySales(room.getID(), Integer.parseInt(year), month)) + "");
                        lblValue.setHorizontalAlignment(SwingConstants.RIGHT);
                    JLabel[] tableContents = {
                        lblKey,
                        lblValue
                    };
                    TableRow tableRow = new TableRow((Component[])tableContents);
                    monthlyTableContainer.add(tableRow);
                }
                
            monthlySalesContainer.setMaximumSize(new Dimension(10000, monthlySalesContainer.getPreferredSize().height));
            monthlySalesContainer.add(monthlyTableContainer);
        this.add(monthlySalesContainer);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ApplicationScreen.setActiveScreen(Constants.APPLICATION_DASHBOARD_SCREEN_NAME);
        year = (Integer.parseInt(yearComboBox.getSelectedItem().toString()) - 1900) + "";
        month = monthComboBox.getSelectedIndex();
        ApplicationScreen.setActiveScreen(Constants.APPLICATION_REPORTS_SCREEN_NAME);
    }
    
}
