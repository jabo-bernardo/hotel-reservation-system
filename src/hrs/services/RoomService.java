package hrs.services;

import hrs.models.Room;
import hrs.utils.Database;
import hrs.models.Transaction;
import hrs.utils.Constants;
import java.util.Date;

public class RoomService {
    public static void createRoom(String roomClass, String roomNumber, int roomPrice, int promoPrice) {
        Room room = new Room();
        room
                .setRoomClass(roomClass)
                .setRoomNumber(roomNumber)
                .setRoomPrice(roomPrice)
                .setPromoPrice(promoPrice);
        Database.rooms.add(room);
    }
    
    public static Room[] getAllRooms() {
        Room[] rooms = new Room[Database.rooms.size()];
        return Database.rooms.toArray(rooms);
    }
    
    public static Room getRoomById(int id) {
        Room room = Database.rooms.stream()
                .filter(rm -> rm.getID() == id)
                .findFirst()
                .orElse(null);
        return room;
    }
    
    public static boolean isRoomAvailableForDates(int roomId, Date checkInDate, Date checkOutDate) {
        boolean isAvailable = Database.transactions.stream()
                .anyMatch(trans -> {
                    if (trans.getRoom() != roomId) return false;
                    if (trans.isIsDone()) return false;
                    if (trans.getCheckOutDateTime().compareTo(checkInDate) <= 0 || trans.getCheckInDateTime().compareTo(checkOutDate) >= 0) return false;
                    return true;
                });
        return !isAvailable;
    }
    
    public static void updateRoom(int roomId, String roomClass, String roomNumber, int roomPrice) {
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
    
    public static String checkRoomStatusById(int roomId) {
        Date currentDate = new Date();
        Transaction recentTransaction = Database.transactions.stream()
                .filter(rm -> rm.getRoom() == roomId && !rm.isIsDone())
                .findFirst()
                .orElse(null);
        if (recentTransaction == null)
            return Constants.AVAILABLE;
        if (currentDate.before(recentTransaction.getCheckInDateTime()))
            return Constants.RESERVED;
        if (currentDate.after(recentTransaction.getCheckOutDateTime()))
            return Constants.OVERSTAYING;
        return Constants.OCCUPIER;
    }
    
    public static double getRoomAnnualSalesByYear(int roomId, int year) {
        double totalAmountOfSales = 0;
        
        for (Transaction transact : Database.transactions) {
            if (transact.getRoom() != roomId)
                continue;
            if (transact.getTransactionDate().getYear() != year)
                continue;
            double amount = ReceiptService.getTotalAmountOfReceipt(transact.getReceipt());
            totalAmountOfSales += amount;
        }
        
        return totalAmountOfSales;
    }
    
    public static double getRoomMonthlySales(int roomId, int year, int month) {
        double totalAmountOfSales = 0;
        
        for (Transaction transact : Database.transactions) {
            if (transact.getRoom() != roomId)
                continue;
            if (transact.getTransactionDate().getYear() != year)
                continue;
            if (transact.getTransactionDate().getMonth() != month)
                continue;
            double amount = ReceiptService.getTotalAmountOfReceipt(transact.getReceipt());
            totalAmountOfSales += amount;
        }
        
        return totalAmountOfSales;
    }
    
    public static Transaction getRelevantTransaction(int roomId) {
        Transaction recentTransaction = Database.transactions.stream()
                .filter(rm -> rm.getRoom() == roomId && !rm.isIsDone())
                .findFirst()
                .orElse(null);
        return recentTransaction;
    }
}