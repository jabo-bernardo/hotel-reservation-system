package hrs.screens.application;

import hrs.components.FormTextField;
import hrs.models.ReceiptItem;
import hrs.screens.ApplicationScreen;
import hrs.services.AmenitiesService;
import hrs.services.CustomerService;
import hrs.services.ReceiptService;
import hrs.services.RoomService;
import hrs.services.TransactionService;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.DateUtils;
import hrs.utils.StateHandler;
import hrs.models.Room;
import hrs.models.Amenities;
import hrs.models.DiscountItem;
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
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ReservationScreen extends Screen implements ActionListener {
    
    private FormTextField roomNumber;
    private FormTextField roomClass;
    private FormTextField checkInDate;
    private FormTextField checkInTime;
    private FormTextField checkOutDate;
    private FormTextField checkOutTime;
    private FormTextField firstName;
    private FormTextField lastName;
    private FormTextField phoneNumber;
    private FormTextField extraBed;
    private FormTextField pillow;
    private FormTextField towel;
    private FormTextField readingLight;
    private FormTextField books;
    private FormTextField toiletries;
    private FormTextField luggageRack;
    private FormTextField breakfast;
    private FormTextField lunch;
    private FormTextField dinner;
    private FormTextField drink;
    private FormTextField snack;
    private JButton sendButton;
    private JRadioButton fullPayment, downPayment;
    private JRadioButton seniorDiscount, summerDiscount, blackBeanCardDiscount;
    private JButton checkForAvailabilityButton;
    
    public ReservationScreen() {
        super(Constants.APPLICATION_RESERVATION_SCREEN_NAME);
        
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(16, 16, 16, 16));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel roomInfoHeading = this.createHeading("Room Information");            
        this.add(roomInfoHeading);
        
        JPanel roomInfo = new JPanel();
            roomInfo.setBackground(Color.WHITE);
            roomInfo.setBorder(new EmptyBorder(16, 16, 16, 16));
            roomInfo.setLayout(new GridLayout(3, 1, 8, 8));
            
            JPanel roomInfoRow1 = new JPanel();
                roomInfoRow1.setBackground(Color.WHITE);
                roomInfoRow1.setLayout(new GridLayout(1, 2, 8, 8));
                
                roomNumber = new FormTextField("Room #", false);
                    roomNumber.setEnabled(false);
                roomInfoRow1.add(roomNumber);
                
                roomClass = new FormTextField("Room Class Type", false);
                    roomClass.setEnabled(false);
                roomInfoRow1.add(roomClass);
            roomInfo.add(roomInfoRow1);
            
            JPanel roomInfoRow2 = new JPanel();
                roomInfoRow2.setBackground(Color.WHITE);
                roomInfoRow2.setLayout(new GridLayout(1, 4, 8, 8));
                
                checkInDate = new FormTextField("Check In Date", false);
                roomInfoRow2.add(checkInDate);
                
                checkInTime = new FormTextField("Check In Time", false);
                roomInfoRow2.add(checkInTime);
                
                checkOutDate = new FormTextField("Check Out Date", false);
                roomInfoRow2.add(checkOutDate);
                
                checkOutTime = new FormTextField("Check Out Time", false);
                roomInfoRow2.add(checkOutTime);
            roomInfo.add(roomInfoRow2);
            
            JPanel roomInfoRow3 = new JPanel();
                roomInfoRow3.setBackground(Color.WHITE);
                roomInfoRow3.setLayout(new GridLayout(1, 1, 8, 8));
                
                checkForAvailabilityButton = new JButton("Check for Availability");
                    checkForAvailabilityButton.setBackground(Color.BLACK);
                    checkForAvailabilityButton.setBorder(new EmptyBorder(0,0 ,0 ,0));
                    checkForAvailabilityButton.setForeground(Color.WHITE);
                    checkForAvailabilityButton.setFont(new Font("Public Sans", Font.BOLD, 16));
                    checkForAvailabilityButton.addActionListener(this);
                roomInfoRow3.add(checkForAvailabilityButton);
            roomInfo.add(roomInfoRow3);
        this.add(roomInfo);
        
        JPanel cusInfoHeading = this.createHeading("Customer Information");            
        this.add(cusInfoHeading);
        
        JPanel cusInfo = new JPanel();
            cusInfo.setBackground(Color.WHITE);
            cusInfo.setBorder(new EmptyBorder(16, 16, 16, 16));
            cusInfo.setLayout(new GridLayout(2, 1, 8, 8));
            
            JPanel cusInfoRow1 = new JPanel();
                cusInfoRow1.setBackground(Color.WHITE);
                cusInfoRow1.setLayout(new GridLayout(1, 2, 8, 8));
                
                firstName = new FormTextField("First Name", false);
                cusInfoRow1.add(firstName);
                
                lastName = new FormTextField("Last Name", false);
                cusInfoRow1.add(lastName);
            cusInfo.add(cusInfoRow1);
            
            JPanel cusInfoRow2 = new JPanel();
                cusInfoRow2.setBackground(Color.WHITE);
                cusInfoRow2.setLayout(new GridLayout(1, 1, 8, 8));
                
                phoneNumber = new FormTextField("Phone Number", false);
                cusInfoRow2.add(phoneNumber);
                
            cusInfo.add(cusInfoRow2);
        this.add(cusInfo);
        
        JPanel amenitiesHeading = this.createHeading("Additional Amenities");            
        this.add(amenitiesHeading);
        
        JPanel amenInfo = new JPanel();
            amenInfo.setBackground(Color.WHITE);
            amenInfo.setBorder(new EmptyBorder(16, 16, 16, 16));
            amenInfo.setLayout(new GridLayout(3, 1, 8, 8));
            
            JPanel amenInfoRow1 = new JPanel();
                amenInfoRow1.setBackground(Color.WHITE);
                amenInfoRow1.setLayout(new GridLayout(1, 4, 8, 8));
                
                extraBed = new FormTextField("Extra Bed", false);
                    extraBed.setValue("0");
                amenInfoRow1.add(extraBed);
                
                pillow = new FormTextField("Pillow", false);
                    pillow.setValue("0");
                amenInfoRow1.add(pillow);
                
                towel = new FormTextField("Towel", false);
                    towel.setValue("0");
                amenInfoRow1.add(towel);
                
                readingLight = new FormTextField("Reading Light", false);
                    readingLight.setValue("0");
                amenInfoRow1.add(readingLight);
            amenInfo.add(amenInfoRow1);
            
            JPanel amenInfoRow2 = new JPanel();
                amenInfoRow2.setBackground(Color.WHITE);
                amenInfoRow2.setLayout(new GridLayout(1, 3, 8, 8));
                
                books = new FormTextField("Books/Magazines", false);
                    books.setValue("0");
                amenInfoRow2.add(books);
                
                toiletries = new FormTextField("Toiletries", false);
                    toiletries.setValue("0");
                amenInfoRow2.add(toiletries);
                
                luggageRack = new FormTextField("Luggage Rack", false);
                    luggageRack.setValue("0");
                amenInfoRow2.add(luggageRack);
                
            amenInfo.add(amenInfoRow2);
                
            JPanel amenInfoRow3 = new JPanel();
                amenInfoRow3.setBackground(Color.WHITE);
                amenInfoRow3.setLayout(new GridLayout(1, 5, 8, 8));
                
                breakfast = new FormTextField("Breakfast", false);
                    breakfast.setValue("0");
                amenInfoRow3.add(breakfast);
                
                lunch = new FormTextField("Lunch", false);
                    lunch.setValue("0");
                amenInfoRow3.add(lunch);
                
                dinner = new FormTextField("Dinner", false);
                    dinner.setValue("0");
                amenInfoRow3.add(dinner);
                
                drink = new FormTextField("Drink", false);
                    drink.setValue("0");
                amenInfoRow3.add(drink);
                
                snack = new FormTextField("Snack", false);
                    snack.setValue("0");
                amenInfoRow3.add(snack);
                
            amenInfo.add(amenInfoRow3);
        this.add(amenInfo);
        
        JPanel discountHeading = this.createHeading("Discounts");            
        this.add(discountHeading);
        
        JPanel discountInfo = new JPanel();
            discountInfo.setBackground(Color.WHITE);
            discountInfo.setBorder(new EmptyBorder(16, 16, 16, 16));
            discountInfo.setLayout(new GridLayout(3, 1, 8, 8));
            
            JPanel discountInfoRow1 = new JPanel();
                discountInfoRow1.setBackground(Color.WHITE);
                discountInfoRow1.setLayout(new GridLayout(4, 1, 8, 8));
                
                ButtonGroup discountGroup = new ButtonGroup();
                    seniorDiscount = new JRadioButton("Senior Citizen (20%)");
                        seniorDiscount.setBackground(Color.WHITE);
                        seniorDiscount.setFont(new Font("Public Sans", Font.PLAIN, 16));
                    discountGroup.add(seniorDiscount);
                    
                    summerDiscount = new JRadioButton("Summer (10%)");
                        summerDiscount.setFont(new Font("Public Sans", Font.PLAIN, 16));
                        summerDiscount.setBackground(Color.WHITE);
                    discountGroup.add(summerDiscount);
                    
                    blackBeanCardDiscount = new JRadioButton("Black Bean Loyalty Card (5%)");
                        blackBeanCardDiscount.setFont(new Font("Public Sans", Font.PLAIN, 16));
                        blackBeanCardDiscount.setBackground(Color.WHITE);
                    discountGroup.add(blackBeanCardDiscount);
                    
                    JRadioButton noneDiscount = new JRadioButton("None");
                        noneDiscount.setFont(new Font("Public Sans", Font.PLAIN, 16));
                        noneDiscount.setBackground(Color.WHITE);
                        noneDiscount.setSelected(true);
                    discountGroup.add(noneDiscount);
                    
                discountInfoRow1.add(noneDiscount);
                discountInfoRow1.add(seniorDiscount);
                discountInfoRow1.add(summerDiscount);
                discountInfoRow1.add(blackBeanCardDiscount);
                discountInfoRow1.setPreferredSize(new Dimension(10000, 80));
            discountInfo.add(discountInfoRow1);
        this.add(discountInfo);
        
        JPanel formActions = new JPanel();
            formActions.setBorder(new EmptyBorder(16, 16, 16, 16));        
            formActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
            
            ButtonGroup btnGroup = new ButtonGroup();
                fullPayment = new JRadioButton("Full Payment");
                    fullPayment.setSelected(true);
                    fullPayment.setFont(new Font("Public Sans", Font.PLAIN, 16));
                btnGroup.add(fullPayment);
                
                downPayment = new JRadioButton("Down Payment");
                    downPayment.setFont(new Font("Public Sans", Font.PLAIN, 16));
                btnGroup.add(downPayment);
            formActions.add(fullPayment);
            formActions.add(downPayment);
                
            
            sendButton = new JButton("Finish Reservation / Check In");
                sendButton.setBackground(Color.BLACK);
                sendButton.setForeground(Color.WHITE);
                sendButton.setFont(new Font("Public Sans", Font.BOLD, 16));
                sendButton.addActionListener(this);
            formActions.add(sendButton);
            
        this.add(formActions);
                    
        this.setPreferredSize(new Dimension(500, this.getPreferredSize().height));
    }
    
    public void resetInputFields() {
        this.roomClass.setValue("");
        this.roomNumber.setValue("");
        this.checkInDate.setValue("");
        this.checkInTime.setValue("");
        this.checkOutDate.setValue("");
        this.checkOutTime.setValue("");
        this.firstName.setValue("");
        this.lastName.setValue("");
        this.phoneNumber.setValue("");
        this.extraBed.setValue("0");
        this.pillow.setValue("0");
        this.towel.setValue("0");
        this.readingLight.setValue("0");
        this.books.setValue("0");
        this.toiletries.setValue("0");
        this.luggageRack.setValue("0");
        this.breakfast.setValue("0");
        this.lunch.setValue("0");
        this.dinner.setValue("0");
        this.drink.setValue("0");
        this.snack.setValue("0");
        this.seniorDiscount.setSelected(false);
        this.summerDiscount.setSelected(false);
        this.blackBeanCardDiscount.setSelected(false);
        
    }
    
    public void updatePredefinedFields(String _roomNumber, String _roomClass, Date checkIn, Date checkOut) {
        roomNumber.setValue(_roomNumber);
        roomClass.setValue(_roomClass);
        String _checkInDate = DateUtils.formatDate(checkIn);
        String _checkInTime = DateUtils.formatTime(checkIn);
        String _checkOutDate = DateUtils.formatDate(checkOut);
        String _checkOutTime = DateUtils.formatTime(checkOut);
        this.checkInDate.setValue(_checkInDate);
        this.checkInTime.setValue(_checkInTime);
        this.checkOutDate.setValue(_checkOutDate);
        this.checkOutTime.setValue(_checkOutTime);
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

    public void createReservation() {
        boolean isFullPayment = fullPayment.isSelected();
        
        int roomId = StateHandler.roomToReserve;
        
        Room room = RoomService.getRoomById(roomId);
        
        String checkInDate = this.checkInDate.getValue();
        String checkInTime = this.checkInTime.getValue();
        String checkOutDate = this.checkOutDate.getValue();
        String checkOutTime = this.checkOutTime.getValue();
        
        // Check in Time
        Date checkInDateTime = new Date(checkInDate + " " + checkInTime);
        Date checkOutDateTime = new Date(checkOutDate + " " + checkOutTime);
        
        Date currentDate = new Date();
        currentDate.setMinutes(currentDate.getMinutes() - 5);
        
        if (checkInDateTime.before(currentDate)) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Invalid check in time! You should set it to now or a future date", 
                    "Input Error!", 
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        if (checkInDateTime.after(checkOutDateTime)) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Please fix the check in & out time", 
                    "Input Error!", 
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        if (!RoomService.isRoomAvailableForDates(StateHandler.roomToReserve, checkInDateTime, checkOutDateTime)) {
            JOptionPane.showMessageDialog(null, "Selected dates are unavailable for this room", "Room Unavailable!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        long multiplier = DateUtils.getRoundedDaysBetweenDates(checkInDateTime, checkOutDateTime);
        
        if (room.getRoomClass().indexOf("Annex") >= 0) {
            if (!fullPayment.isSelected()) {
                JOptionPane.showMessageDialog(null, "Annex Rooms requires full payment method", "Invalid Payment Method!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        // Customer Details
        String firstName = this.firstName.getValue();
        String lastName = this.lastName.getValue();
        String phoneNumber = this.phoneNumber.getValue();
        
        if (firstName == null || firstName.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Please provide a First Name", 
                    "Input Error!", 
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        if (lastName == null || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Please provide a Last Name", 
                    "Input Error!", 
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Please provide a Phone Number", 
                    "Input Error!", 
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        // Amenities        
        int extraBed = parseIntOrZero(this.extraBed.getValue());
        int pillow = parseIntOrZero(this.pillow.getValue());
        int towel = parseIntOrZero(this.towel.getValue());
        int readingLight = parseIntOrZero(this.readingLight.getValue());
        int books = parseIntOrZero(this.books.getValue());
        int toiletries = parseIntOrZero(this.toiletries.getValue());
        int luggageRack = parseIntOrZero(this.luggageRack.getValue());
        int breakfast = parseIntOrZero(this.breakfast.getValue());
        int lunch = parseIntOrZero(this.lunch.getValue());
        int dinner = parseIntOrZero(this.dinner.getValue());
        int drink = parseIntOrZero(this.drink.getValue());
        int snack = parseIntOrZero(this.snack.getValue());
        
        int customerId = CustomerService.createCustomer(firstName, lastName, phoneNumber);
        int amenitiesId = AmenitiesService.createAmenities(
                extraBed,
                pillow,
                towel,
                readingLight,
                books,
                toiletries,
                luggageRack,
                breakfast,
                lunch,
                dinner,
                drink,
                snack
        );
        
        ArrayList<ReceiptItem> receiptItems = new ArrayList<>();
            receiptItems.add(new ReceiptItem(room.getRoomClass() + "", isFullPayment ? room.getPromoPrice() : room.getRoomPrice(), (int) multiplier));
            receiptItems.add(new ReceiptItem("Additional: Extra Bed", Amenities.EXTRA_BED_PRICE, extraBed));
            receiptItems.add(new ReceiptItem("Additional: Pillow", Amenities.PILLOW_PRICE, pillow));
            receiptItems.add(new ReceiptItem("Additional: Towel", Amenities.TOWEL_PRICE, towel));
            receiptItems.add(new ReceiptItem("Additional: Reading Light", Amenities.READING_LIGHT_PRICE, readingLight));
            receiptItems.add(new ReceiptItem("Additional: Books/ Magazines", Amenities.BOOKS_PRICE, books));
            receiptItems.add(new ReceiptItem("Additional: Toiletries", Amenities.TOILETRIES_PRICE, toiletries));
            receiptItems.add(new ReceiptItem("Additional: Luggage Rack", Amenities.LUGGAGE_RACK_PRICE, luggageRack));
            receiptItems.add(new ReceiptItem("Food: Breakfast", Amenities.BREAKFAST_PRICE, breakfast));
            receiptItems.add(new ReceiptItem("Food: Lunch", Amenities.LUNCH_PRICE, lunch));
            receiptItems.add(new ReceiptItem("Food: Dinner", Amenities.DINNER_PRICE, dinner));
            receiptItems.add(new ReceiptItem("Food: Drink", Amenities.DRINK_PRICE, drink));
            receiptItems.add(new ReceiptItem("Food: Snack", Amenities.SNACK_PRICE, snack));
        
        int receiptId = ReceiptService.createReceipt(0, receiptItems);
        
        ArrayList<DiscountItem> discountItems = new ArrayList<>();
            discountItems.add(new DiscountItem("12% VAT", "Value Added Tax", 12));
        
        if (seniorDiscount.isSelected())
            discountItems.add(new DiscountItem("Senior Citizen Disc. (20%)", "", -20));
        
        if (summerDiscount.isSelected())
            discountItems.add(new DiscountItem("Summer Disc. (10%)", "", -10));
        
        if (blackBeanCardDiscount.isSelected())
            discountItems.add(new DiscountItem("Loyalty Card Disc. (5%)", "", -5));
            
        ReceiptService.addDiscountItemsToReceiptWithId(receiptId, discountItems);
            
        int transactionId = TransactionService.createTransaction(
                customerId,
                roomId, 
                0, // TO DO:
                amenitiesId, 
                receiptId,
                checkInDateTime, 
                checkOutDateTime, 
                isFullPayment
        );
        
        StateHandler.createdTransactionId = transactionId;
        ReceiptWindow.showReceipt(transactionId);
        StateHandler.transactionToView = transactionId;
        ApplicationScreen.setActiveScreen(Constants.APPLICATION_ROOM_ACTIONS_SCREEN_NAME);
        resetInputFields();
    }
    
    public void handleCheckForAvailabilityButton() {
        String checkInDate = this.checkInDate.getValue();
        String checkInTime = this.checkInTime.getValue();
        String checkOutDate = this.checkOutDate.getValue();
        String checkOutTime = this.checkOutTime.getValue();
        
        // Check in Time
        Date checkInDateTime = new Date(checkInDate + " " + checkInTime);
        Date checkOutDateTime = new Date(checkOutDate + " " + checkOutTime);
        
        if (RoomService.isRoomAvailableForDates(StateHandler.roomToReserve, checkInDateTime, checkOutDateTime)) {
            JOptionPane.showMessageDialog(null, "Selected dates are available for this room", "Room Available!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Selected dates are unavailable for this room", "Room Unavailable", JOptionPane.ERROR_MESSAGE);
    }
    
    private static int parseIntOrZero(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src.equals(sendButton))
            createReservation();
        
        if (src.equals(checkForAvailabilityButton))
            handleCheckForAvailabilityButton();
            
    }
    
}
