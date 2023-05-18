package hrs.screens.application;

import hrs.components.TableRow;
import hrs.models.Room;
import hrs.models.Customer;
import hrs.models.Transaction;
import hrs.services.CustomerService;
import hrs.services.RoomService;
import hrs.services.TransactionService;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.Database;
import hrs.utils.DateUtils;
import hrs.utils.ReceiptWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HistoryScreen extends Screen {
    
    public HistoryScreen() {
        super(Constants.APPLICATION_HISTORY_SCREEN_NAME);
        
        this.renderScreen();
    }
    
    public void renderScreen() {
        this.removeAll();
        
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(16, 16, 16, 16));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
        JPanel historyHeading = createHeading("History");        
            this.add(historyHeading);
        
//        JPanel filterContainer = new JPanel();
//            filterContainer.setBackground(Color.WHITE);
//            filterContainer.setLayout(new GridLayout(1, 3));
//            
//            {
//                JLabel lblKey = new JLabel("Filter by room: ");
//                    lblKey.setFont(new Font("Public Sans", Font.PLAIN, 16));
//                filterContainer.add(lblKey);
//            }
//            
//            ArrayList<String> roomListChoices = new ArrayList<>();
//            roomListChoices.add("Showing All Rooms");
//            
//            for (Room room : Database.rooms) {
//                roomListChoices.add(room.getRoomNumber() + " | " + room.getRoomClass());
//            }
//            
//            JComboBox roomList = new JComboBox(roomListChoices.toArray());
//                roomList.setFont(new Font("Public Sans", Font.PLAIN, 16));
//            filterContainer.add(roomList);
//            filterContainer.setMaximumSize(filterContainer.getPreferredSize());
//        this.add(filterContainer);
            
        JPanel itemsContainer = new JPanel();
            itemsContainer.setLayout(new BoxLayout(itemsContainer, BoxLayout.Y_AXIS));
            itemsContainer.setBackground(Color.WHITE);
            
            JLabel lblHeaderCol1 = TableRow.createDefaultLabel("Transaction ID");
            JLabel lblHeaderCol6 = TableRow.createDefaultLabel("Status");
            JLabel lblHeaderCol2 = TableRow.createDefaultLabel("Room");
            JLabel lblHeaderCol3 = TableRow.createDefaultLabel("Customer");
            JLabel lblHeaderCol4 = TableRow.createDefaultLabel("Receipt");
            JLabel lblHeaderCol5 = TableRow.createDefaultLabel("Date");

            JLabel[] headerLabels = {
                lblHeaderCol1,
                lblHeaderCol6,
                lblHeaderCol5,
                lblHeaderCol2,
                lblHeaderCol3,
                lblHeaderCol4
            };
            TableRow headerRow = new TableRow((Component[])headerLabels);
            itemsContainer.add(headerRow);

            for (Transaction transaction : Database.transactions) {
                Room room = RoomService.getRoomById(transaction.getRoom());
                Customer customer = CustomerService.getCustomerById(transaction.getCustomer());
                JLabel lblCol1 = TableRow.createDefaultLabelPlain(transaction.getID() + "");
                JLabel lblCol2 = TableRow.createDefaultLabelPlain(room.getRoomNumber());
                JLabel lblCol6 = TableRow.createDefaultLabelPlain(TransactionService.getTransactionStatus(transaction.getID()));
                JButton btnCol3 = new JButton("View Customer");
                    btnCol3.setBackground(Color.BLACK);
                    btnCol3.setForeground(Color.WHITE);
                    btnCol3.setFont(new Font("Public Sans", Font.BOLD, 14));
                    btnCol3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            JOptionPane.showMessageDialog(null, "Name: " + customer.getFirstName() + " " + customer.getLastName() + "\nContact #: " + customer.getPhoneNumber(), "Customer Details", JOptionPane.PLAIN_MESSAGE);
                        }
                    });
                JButton btnCol4 = new JButton("View Receipt");
                    btnCol4.setBackground(Color.BLACK);
                    btnCol4.setForeground(Color.WHITE);
                    btnCol4.setFont(new Font("Public Sans", Font.BOLD, 14));
                    btnCol4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            ReceiptWindow.showReceipt(transaction.getID());
                        }
                    });
                JButton btnCol5 = new JButton("View Dates");
                    btnCol5.setBackground(Color.BLACK);
                    btnCol5.setForeground(Color.WHITE);
                    btnCol5.setFont(new Font("Public Sans", Font.BOLD, 14));
                    btnCol5.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            JOptionPane.showMessageDialog(null, "Check In Time: " + DateUtils.format(transaction.getCheckInDateTime()) + "\nCheck Out Time: " + DateUtils.format(transaction.getCheckOutDateTime()), "Customer Details", JOptionPane.PLAIN_MESSAGE);
                        }
                    });
                Component[] tableContents = {
                    lblCol1,
                    lblCol6,
                    btnCol5,
                    lblCol2,
                    btnCol3,
                    btnCol4
                };
                TableRow tableRow = new TableRow((Component[])tableContents);
                itemsContainer.add(tableRow);
            }
            itemsContainer.setMaximumSize(itemsContainer.getPreferredSize());
        this.add(itemsContainer);
            
    }
    
    public JPanel createHeading(String headingContent) {
        JPanel heading = new JPanel();
            heading.setBackground(Color.WHITE);
            heading.setLayout(new FlowLayout(FlowLayout.LEFT));
            
            JPanel mainHeading = new JPanel();
                mainHeading.setBorder(new EmptyBorder(16, 16, 16, 16));
                mainHeading.setBackground(Color.WHITE);
                mainHeading.setLayout(new BorderLayout());
            
                JLabel lblRoomInfoHeading = new JLabel(headingContent);
                    lblRoomInfoHeading.setFont(new Font("Public Sans", Font.BOLD, 24));

                mainHeading.add(lblRoomInfoHeading, BorderLayout.CENTER);
            
            heading.add(mainHeading);
            heading.setMaximumSize(new Dimension(10000, heading.getPreferredSize().height));
        return heading;
    }
    
}
