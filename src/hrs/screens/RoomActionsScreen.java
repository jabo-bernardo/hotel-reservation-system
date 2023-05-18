package hrs.screens;

import hrs.models.Transaction;
import hrs.models.Amenities;
import hrs.models.Room;
import hrs.services.AmenitiesService;
import hrs.services.RoomService;
import hrs.services.TransactionService;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.DateUtils;
import hrs.utils.ReceiptWindow;
import hrs.utils.StateHandler;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RoomActionsScreen extends Screen implements ActionListener {
    JButton newReservation, cancelReservation, checkout, receipt;
    Transaction transaction;
    
    public RoomActionsScreen() {
        super(Constants.APPLICATION_ROOM_ACTIONS_SCREEN_NAME);
        
        this.renderScreen();
    }
    
    public void renderScreen() {
        this.removeAll();
        
        transaction = TransactionService.getTransactionById(StateHandler.transactionToView);
        if (transaction == null) return;
        Room room = RoomService.getRoomById(transaction.getRoom());
        String roomStatus = RoomService.checkRoomStatusById(room.getID());
        
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(16, 16, 16, 16));
        
        JPanel reservationInfoHeading = new JPanel();
            reservationInfoHeading.setBackground(Color.WHITE);
            reservationInfoHeading.setLayout(new FlowLayout(FlowLayout.LEFT));
            
            JLabel resInfoHeading = new JLabel("Room Information");
                resInfoHeading.setHorizontalAlignment(SwingConstants.LEFT);
                resInfoHeading.setFont(new Font("Public Sans", Font.BOLD, 18));
            reservationInfoHeading.add(resInfoHeading);
            reservationInfoHeading.setMaximumSize(new Dimension(10000, reservationInfoHeading.getPreferredSize().height));
        
        this.add(reservationInfoHeading);
        
        JPanel roomDetailsHolder = new JPanel();
            roomDetailsHolder.setBackground(Color.WHITE);
            roomDetailsHolder.setLayout(new GridLayout(3, 2, 0, 8));
            roomDetailsHolder.setBorder(new EmptyBorder(8, 8, 8, 8));
            
            {
                JLabel lblLabel = new JLabel("<html>" + "<B color='#AAA'>" + "Room Number: " + "</B>" + room.getRoomNumber() + "</html>");
                    lblLabel.setFont(new Font("Public Sans", Font.PLAIN, 16));
                roomDetailsHolder.add(lblLabel);
            }
            
            {
                JLabel lblLabel = new JLabel("<html>" + "<B color='#AAA'>" + "Room Class: " + "</B>" + room.getRoomClass() + "</html>");
                    lblLabel.setFont(new Font("Public Sans", Font.PLAIN, 16));
                roomDetailsHolder.add(lblLabel);
            }
            
            {
                JLabel lblLabel = new JLabel("<html>" + "<B color='#AAA'>" + "Check In: " + "</B>" + DateUtils.format(transaction.getCheckInDateTime()) + "</html>");
                    lblLabel.setFont(new Font("Public Sans", Font.PLAIN, 16));
                roomDetailsHolder.add(lblLabel);
            }
            
            {
                JLabel lblLabel = new JLabel("<html>" + "<B color='#AAA'>" + "Check Out: " + "</B>" + DateUtils.format(transaction.getCheckOutDateTime()) + "</html>");
                    lblLabel.setFont(new Font("Public Sans", Font.PLAIN, 16));
                roomDetailsHolder.add(lblLabel);
            }
            
            {
                JLabel lblLabel = new JLabel("<html>" + "<B color='#AAA'>" + "Status: " + "</B>" + roomStatus + "</html>");
                    lblLabel.setFont(new Font("Public Sans", Font.PLAIN, 16));
                roomDetailsHolder.add(lblLabel);
            }
            
            roomDetailsHolder.setMaximumSize(new Dimension(10000, roomDetailsHolder.getPreferredSize().height));
            
        this.add(roomDetailsHolder);
        
        JPanel amenitiesHolder = new JPanel();
            amenitiesHolder.setBackground(Color.WHITE);
            amenitiesHolder.setLayout(new FlowLayout(FlowLayout.LEFT));
            amenitiesHolder.setBorder(new EmptyBorder(0, 3, 0, 0));
            
            ArrayList<String> amenitiesList = new ArrayList<>();
            
            Amenities amens = AmenitiesService.getAmenitiesById(transaction.getAmenities());
            if (amens.getExtraBed() > 0)
                amenitiesList.add(amens.getExtraBed() + " Extra Bed");
            if (amens.getPillow() > 0)
                amenitiesList.add(amens.getPillow() + " Pillow");
            if (amens.getTowel() > 0)
                amenitiesList.add(amens.getTowel() + " Towel");
            if (amens.getReadingLight() > 0)
                amenitiesList.add(amens.getReadingLight() + " Reading Light");
            if (amens.getBooks() > 0)
                amenitiesList.add(amens.getBooks() + " Books");
            if (amens.getToiletries() > 0)
                amenitiesList.add(amens.getToiletries() + " Toiletries");
            if (amens.getLuggageRack() > 0)
                amenitiesList.add(amens.getLuggageRack() + " Luggage Rack");
            if (amens.getBreakfast() > 0)
                amenitiesList.add(amens.getBreakfast() + " Breakfast");
            if (amens.getLunch() > 0)
                amenitiesList.add(amens.getLunch() + " Lunch");
            if (amens.getDinner() > 0)
                amenitiesList.add(amens.getDinner() + " Dinner");
            if (amens.getDrink() > 0)
                amenitiesList.add(amens.getDrink() + " Drink");
            if (amens.getSnack() > 0)
                amenitiesList.add(amens.getSnack() + " Snack");
            
            if (amenitiesList.isEmpty()) amenitiesHolder.setVisible(false);
            
            {
                JLabel lblLabel = new JLabel("<html>" + "<B color='#AAA'>" + "Amenities: " + "</B>" + String.join(",", amenitiesList) + "</html>");
                    lblLabel.setFont(new Font("Public Sans", Font.PLAIN, 16));
                amenitiesHolder.add(lblLabel);
            }
            
            amenitiesHolder.setMaximumSize(amenitiesHolder.getPreferredSize());
        this.add(amenitiesHolder);
        
        JPanel actionButtons = new JPanel();
            actionButtons.setBackground(Color.WHITE);
            actionButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
            
            {
                newReservation = new JButton("New Reservation for this Room");
                    newReservation.setBackground(Color.BLACK);
                    newReservation.setForeground(Color.WHITE);
                    newReservation.setFont(new Font("Public Sans", Font.BOLD, 14));
                    newReservation.addActionListener(this);
                actionButtons.add(newReservation);
            }
            
            if (roomStatus.equals(Constants.RESERVED)) {
                cancelReservation = new JButton("Cancel Reservation");
                    cancelReservation.setBackground(Color.BLACK);
                    cancelReservation.setForeground(Color.WHITE);
                    cancelReservation.setFont(new Font("Public Sans", Font.BOLD, 14));
                    cancelReservation.addActionListener(this);
                actionButtons.add(cancelReservation);
            }
            
            if (roomStatus.equals(Constants.OCCUPIER) || roomStatus.equals(Constants.OVERSTAYING)){
                checkout = new JButton("Check Out");
                    checkout.setBackground(Color.BLACK);
                    checkout.setForeground(Color.WHITE);
                    checkout.setFont(new Font("Public Sans", Font.BOLD, 14));
                    checkout.addActionListener(this);
                actionButtons.add(checkout);
            }
            
            {
                receipt = new JButton("View Receipt");
                    receipt.setBackground(Color.BLACK);
                    receipt.setForeground(Color.WHITE);
                    receipt.setFont(new Font("Public Sans", Font.BOLD, 14));
                    receipt.addActionListener(this);
                actionButtons.add(receipt);
            }
        this.add(actionButtons);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(receipt)) {
            ReceiptWindow.showReceipt(transaction.getID());
            return;
        }
        
        if (src.equals(newReservation)) {
            Room currentRoom = RoomService.getRoomById(transaction.getRoom());
            
            Date checkInDate = new Date();
            Date checkOutDate = new Date();

            Calendar cl = Calendar.getInstance();
            cl.setTime(checkOutDate);

            cl.add(Calendar.DAY_OF_YEAR, 1);

            checkOutDate = cl.getTime();

            StaticScreens.reservationScreen.updatePredefinedFields(
                            currentRoom.getRoomNumber(), 
                            currentRoom.getRoomClass(),
                            checkInDate,
                            checkOutDate);
                    ApplicationScreen.setActiveScreen(Constants.APPLICATION_RESERVATION_SCREEN_NAME);
            return;
        }
        
        if (src.equals(cancelReservation)) {
            int shouldDelete = JOptionPane.showConfirmDialog(null, "This reservation is about to be deleted, Are you sure?", "Cancel Reservation", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (shouldDelete != JOptionPane.YES_OPTION)
                return;
            TransactionService.deleteTransactionById(transaction.getID());
            ApplicationScreen.setActiveScreen(Constants.APPLICATION_DASHBOARD_SCREEN_NAME);
            return;
        }
        
        if (src.equals(checkout)) {
            TransactionService.checkoutTransactionById(transaction.getID());
            ApplicationScreen.setActiveScreen(Constants.APPLICATION_DASHBOARD_SCREEN_NAME);
            return;
        }
    }
}
