package hrs.utils;

import hrs.models.Account;
import hrs.models.Amenities;
import hrs.models.Customer;
import hrs.models.Receipt;
import hrs.models.ReceiptItem;
import hrs.models.Room;
import hrs.models.Transaction;
import java.util.ArrayList;

public class Database {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Receipt> receipts = new ArrayList<>();
    public static ArrayList<ReceiptItem> receiptItems = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Transaction> transactions = new ArrayList<>();
    public static ArrayList<Amenities> amenities = new ArrayList<>();
}
