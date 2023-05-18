package hrs.screens.application;

import hrs.components.DataContainer;
import hrs.components.ImageContainer;
import hrs.components.RoomClassContainer;
import hrs.models.Room;
import hrs.components.RoomContainer;
import hrs.main.HotelReservationSystem;
import hrs.main.Launcher;
import hrs.screens.ApplicationScreen;
import hrs.screens.StaticScreens;
import hrs.services.RoomService;
import hrs.struct.Screen;
import hrs.utils.Constants;
import hrs.utils.Database;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class DashboardScreen extends Screen {    
    public DashboardScreen() {
        super(Constants.APPLICATION_DASHBOARD_SCREEN_NAME);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(8, 8, 8, 8));
        
        this.renderScreen();
    }    
    
    public void renderScreen() {
        this.removeAll();
        
        int availableRooms = 0, occupiedRooms = 0, reservedRooms = 0;
        
        for (Room room : Database.rooms) {
            if (RoomService.checkRoomStatusById(room.getID()).equals(Constants.AVAILABLE))
                availableRooms++;
            if (RoomService.checkRoomStatusById(room.getID()).equals(Constants.OCCUPIER))
                occupiedRooms++;
            if (RoomService.checkRoomStatusById(room.getID()).equals(Constants.RESERVED))
                reservedRooms++;
        }
        
        JPanel headerContainer = new JPanel();
            headerContainer.setLayout(new BoxLayout(headerContainer, BoxLayout.Y_AXIS));
            headerContainer.setMaximumSize(new Dimension(100000, 80)); 
            
            JPanel headerContainerTop = new JPanel();
                headerContainerTop.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel lblGreetings = new JLabel("Good morning!");
                    lblGreetings.setFont(new Font("Public Sans", Font.PLAIN, 18));
                headerContainerTop.add(lblGreetings);
            
            headerContainer.add(headerContainerTop);
            
            JPanel headerContainerBottom = new JPanel();
                headerContainerBottom.setMaximumSize(new Dimension(100000, 80)); 
                headerContainerBottom.setLayout(new GridLayout(1, 3, 8, 8));

                DataContainer roomsAvailable = new DataContainer("Rooms Available", availableRooms + "");
                headerContainerBottom.add(roomsAvailable);

                DataContainer reservationCount = new DataContainer("Occupied Rooms", occupiedRooms + "");
                headerContainerBottom.add(reservationCount);

                DataContainer roomsReserved = new DataContainer("Reserved Rooms", reservedRooms + "");
                headerContainerBottom.add(roomsReserved);
            headerContainer.add(headerContainerBottom);
            
        JPanel bodyContainer = new JPanel();
            bodyContainer.setLayout(new BoxLayout(bodyContainer, BoxLayout.Y_AXIS));
            
            JPanel bodyContainerTop = new JPanel();
                bodyContainerTop.setBorder(new EmptyBorder(16, 0, 0, 0));
                bodyContainerTop.setLayout(new FlowLayout(FlowLayout.LEFT));
                bodyContainerTop.setMaximumSize(new Dimension(100000, 100)); 
                
                JLabel lblRoomsHeading = new JLabel("Rooms");
                    lblRoomsHeading.setFont(new Font("Public Sans", Font.PLAIN, 18));
                bodyContainerTop.add(lblRoomsHeading);
                
            bodyContainer.add(bodyContainerTop);
            
            JPanel bodyContainerMain = new JPanel();
                bodyContainerMain.setLayout(new FlowLayout(FlowLayout.CENTER));
                bodyContainerMain.setPreferredSize(new Dimension(400, 800));
                
                Room[] rooms = RoomService.getAllRooms();
                
                for (int x = 0; x < rooms.length; x++) {
                    Room currentRoom = rooms[x];
                    
                    JPanel rowContainer = new JPanel();
                        rowContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
                        rowContainer.setBorder(new EmptyBorder(4, 0, 0, 0));
                        
                        String roomStatus = RoomService.checkRoomStatusById(currentRoom.getID());
                        
                        RoomContainer room_1 = new RoomContainer(
                                currentRoom.getID(),
                                currentRoom.getRoomClass(),
                                currentRoom.getRoomNumber(), 
                                roomStatus
                        );
                        rowContainer.add(room_1);
                    bodyContainerMain.add(rowContainer);
                }
                
                bodyContainerMain.setMaximumSize(new Dimension(10000, bodyContainerMain.getPreferredSize().height));
            
            bodyContainer.add(bodyContainerMain);
                
            
        this.add(headerContainer);
        this.add(bodyContainer);
    }
}
