package hrs.models;

import java.util.ArrayList;

public class Receipt {
    public static int CURRENT_ID = 0;
    private int id;
    private int issuedBy;
    private ArrayList<ReceiptItem> items = new ArrayList<>();
    private ArrayList<DiscountItem> discountItems = new ArrayList<>();
    
    
    public Receipt() {
        Receipt.CURRENT_ID++;
        this.id = Receipt.CURRENT_ID;
    }
    
    public int getID() {
        return this.id;
    }
    
    public int getIssuedBy() {
        return this.issuedBy;
    }
    
    public Receipt setIssuedBy(int issuedBy) {
        this.issuedBy = issuedBy;
        return this;
    }
    
    public Receipt addItem(ReceiptItem item) {
        if (item.getItemQuantity() == 0) return this;
        this.items.add(item);
        return this;
    }
    
    public Receipt addDiscountItem(DiscountItem item) {
        this.discountItems.add(item);
        return this;
    }
    
    public double getTotalPrice() {
        double totalPrice = 0;
        for (ReceiptItem item : this.items) {
            totalPrice += item.getItemPrice() * item.getItemQuantity();
        }
        return totalPrice;
    }
    
    public ArrayList<ReceiptItem> getItems() {
        return items;
    }
    
    public ArrayList<DiscountItem> getDiscountItems() {
        return this.discountItems;
    }
}
