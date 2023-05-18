package hrs.models;

public class Room {
    public static enum ROOM_CLASS { TOURIST, DELUXE, AMBASSADOR, CORPORATE, ANNEX };
    public static int CURRENT_ID = 0;
    private int id;
    private String roomClass;
    private String roomNumber;
    private int roomPrice;
    private int promoPrice;
    
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
    
    public int getRoomPrice() {
        return roomPrice;
    }

    public Room setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
        return this;
    }

    public int getPromoPrice() {
        return promoPrice;
    }

    public Room setPromoPrice(int promoPrice) {
        this.promoPrice = promoPrice;
        return this;
    }
    
    
}
