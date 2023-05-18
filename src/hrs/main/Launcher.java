package hrs.main;

import hrs.models.Account;
import hrs.models.ReceiptItem;
import hrs.models.Transaction;
import hrs.models.Room;
import hrs.services.AccountService;
import hrs.services.AmenitiesService;
import hrs.services.CustomerService;
import hrs.services.ReceiptService;
import hrs.services.RoomService;
import hrs.services.TransactionService;
import hrs.utils.FontLoader;
import java.util.ArrayList;
import java.util.Date;

public class Launcher {
    public static HotelReservationSystem hrs;
    
    public static void main(String[] args) {
        FontLoader.loadTtfFile("/PublicSans-Regular.ttf");
        FontLoader.loadTtfFile("/PublicSans-SemiBold.ttf");
        FontLoader.loadTtfFile("/PublicSans-Bold.ttf");
        
        // Pre-made Accounts
        AccountService.createAccount("joel", "admin", Account.ACCOUNT_TYPE.ADMINISTRATION);
        AccountService.createAccount("stewart", "staff", Account.ACCOUNT_TYPE.STAFF);
        
        // Pre-made Rooms
        RoomService.createRoom("Tourist Class", "TC-918", 1000, 900);
        RoomService.createRoom("Deluxe Class", "DC-817", 1200, 930);
        RoomService.createRoom("Ambassador Class", "AC-716", 1300, 1030);
        RoomService.createRoom("Corporate Class", "CC-615", 1500, 1300);
        RoomService.createRoom("Annex Room (5 Persons)", "AR-5", 1500, 1500);
        RoomService.createRoom("Annex Room (3 Persons)", "AR-3", 900, 900);
        
        // Pre-made order records (For demonstration purposes)
        int customerId = CustomerService.createCustomer("Stewart", "Buluran", "+63956789456");
        int amenitiesId = AmenitiesService.createAmenities(0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        ArrayList<ReceiptItem> receiptItems = new ArrayList<>();
        receiptItems.add(new ReceiptItem("Deluxe Class", 1200, 2));
        receiptItems.add(new ReceiptItem("Additional: Pillow", 150, 2));
        
        int receiptId = ReceiptService.createReceipt(0, receiptItems);
        
        int transactionId = TransactionService.createTransaction(customerId, 1, 0, amenitiesId, receiptId, new Date(122,5,18), new Date(122,5,20), true);
        Transaction transaction = TransactionService.getTransactionById(transactionId);
        transaction.transactionDate = new Date(122, 5, 17);
        
        hrs = new HotelReservationSystem();
    }
}
