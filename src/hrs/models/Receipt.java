package hrs.models;

import java.util.ArrayList;

public class Receipt {
    public static int CURRENT_ID = 0;
    private int id;
    private int issuedBy;
    private ArrayList<ReceiptItem> items = new ArrayList<>();
    
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
        this.items.add(item);
        return this;
    }
    
    public ArrayList<ReceiptItem> getItems() {
        return items;
    }
}
