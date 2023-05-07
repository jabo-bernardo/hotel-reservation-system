package hrs.services;

import hrs.models.Room;
import hrs.utils.Database;
import java.util.ArrayList;

public class RoomService {
    public static void createRoom(String roomClass, String roomNumber, String roomPrice) {
        Room room = new Room();
        room
                .setRoomClass(roomClass)
                .setRoomNumber(roomNumber)
                .setRoomPrice(roomPrice);
        Database.rooms.add(room);
    }
    
    public static Room getRoomById(int id) {
        Room room = Database.rooms.stream()
                .filter(rm -> rm.getID() == id)
                .findFirst()
                .orElse(null);
        return room;
    }
    
    public static void updateRoom(int roomId, String roomClass, String roomNumber, String roomPrice) {
        Room room = RoomService.getRoomById(roomId);
        if (room == null) return;
        room
                .setRoomClass(roomClass)
                .setRoomNumber(roomNumber)
                .setRoomPrice(roomPrice);
    }
    
    public static void deleteRoom(int roomId) {
        Room room = RoomService.getRoomById(roomId);
        if (room == null) return;
        Database.rooms.remove(room);
    }
}