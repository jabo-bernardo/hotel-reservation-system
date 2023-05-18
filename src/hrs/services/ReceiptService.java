package hrs.services;

import hrs.models.DiscountItem;
import hrs.models.Receipt;
import hrs.models.ReceiptItem;
import hrs.utils.Database;

import java.util.ArrayList;

public class ReceiptService {
    
    public static int createReceipt(int issuedBy, ArrayList<ReceiptItem> items) {
        Receipt receipt = new Receipt();
        receipt.setIssuedBy(issuedBy);
        for (ReceiptItem item : items) {
            receipt.addItem(item);
        }
        Database.receipts.add(receipt);
        return receipt.getID();
    }
    
    public static int addDiscountItemsToReceiptWithId(int receiptId, ArrayList<DiscountItem> items) {
        Receipt receipt = getReceiptById(receiptId);
        for (DiscountItem item : items) {
            receipt.addDiscountItem(item);
        }
        return receipt.getID();
    }
    
    public static Receipt getReceiptById(int id) {
        Receipt receipt = Database.receipts.stream()
                .filter(r -> r.getID() == id)
                .findFirst()
                .orElse(null);
        return receipt;
    }
    
    public static double getTotalAmountOfReceipt(int receiptId) {
        Receipt receipt = getReceiptById(receiptId);
        
        double totalAmount = receipt.getTotalPrice();
        
        for (DiscountItem discountItem : receipt.getDiscountItems()) {
            float percentage = ((float) discountItem.getDiscountPercentage()) / 100 ;
            totalAmount += percentage * totalAmount;
        }
        
        return totalAmount;
    };
    
    public static void updateReceipt() {
        // TODO
    }
    
    public static void deleteReceipt(int id) {
        Receipt receipt = ReceiptService.getReceiptById(id);
        if (receipt != null) {
            Database.receipts.remove(receipt);
        }
    }
}