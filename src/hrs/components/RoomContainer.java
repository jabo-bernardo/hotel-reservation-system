
package hrs.components;

import hrs.screens.ApplicationScreen;
import hrs.screens.StaticScreens;
import hrs.services.RoomService;
import hrs.models.Room;
import hrs.models.Transaction;
import hrs.utils.Constants;
import hrs.utils.CustomColors;
import hrs.utils.StateHandler;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RoomContainer extends JPanel {
    public RoomContainer(int roomId, String _roomClass, String _roomNumber, String status) {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setMaximumSize(new Dimension(10000, 300));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        String roomStatus = RoomService.checkRoomStatusById(roomId);
        
        JPanel statusContainer = new JPanel();
            statusContainer.setPreferredSize(new Dimension(64, 64));
            if (roomStatus.equals(Constants.AVAILABLE))
                statusContainer.setBackground(CustomColors.GREEN);
            if (roomStatus.equals(Constants.RESERVED))
                statusContainer.setBackground(CustomColors.YELLOW);
            if (roomStatus.equals(Constants.OCCUPIER))
                statusContainer.setBackground(CustomColors.RED);
        this.add(statusContainer);
        
        JPanel infoContainer = new JPanel();
            infoContainer.setBackground(Color.WHITE);
            infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));
            infoContainer.setBorder(new EmptyBorder(0, 8, 0, 8));
            
            JLabel roomNumber = new JLabel(_roomNumber);
                roomNumber.setFont(new Font("Public Sans", Font.BOLD, 16));
                roomNumber.setAlignmentX(Component.LEFT_ALIGNMENT);
            infoContainer.add(roomNumber);
            
            JLabel roomClass = new JLabel(_roomClass);
                roomClass.setFont(new Font("Public Sans", Font.PLAIN, 10));
                roomClass.setForeground(Color.GRAY);
                roomClass.setAlignmentX(Component.LEFT_ALIGNMENT);
            infoContainer.add(roomClass);
        this.add(infoContainer);
        
        RoomContainer that = this;
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                that.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                that.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                
                String roomStatus = RoomService.checkRoomStatusById(roomId);
                
                if (roomStatus.equals(Constants.AVAILABLE)) {
                    StateHandler.roomToReserve = roomId;
                    Room currentRoom = RoomService.getRoomById(roomId);
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
                
                Transaction transaction = RoomService.getRelevantTransaction(roomId);
                
                StateHandler.transactionToView = transaction.getID();
                ApplicationScreen.setActiveScreen(Constants.APPLICATION_ROOM_ACTIONS_SCREEN_NAME);
                
                
            }
        });
    }
}
