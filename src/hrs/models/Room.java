package hrs.models;

public class Room {
    public static int CURRENT_ID = 0;
    private int id;
    private String roomClass;
    private String roomNumber;
    private String roomPrice;
    
    public Room() {
        Room.CURRENT_ID++;
        this.id = Room.CURRENT_ID;
    }
    
    public int getID() {
        return this.id;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public Room setRoomClass(String roomClass) {
        this.roomClass = roomClass;
        return this;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Room setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }
    
    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }
}
