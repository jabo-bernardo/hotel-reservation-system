package hrs.models;

public class ReceiptItem {
    public static int CURRENT_ID = 0;
    private int id;
    private String itemTitle;
    private String itemDescription;
    private double itemPrice;
    private int itemQuantity;
    
    public ReceiptItem() {
        ReceiptItem.CURRENT_ID++;
        this.id = ReceiptItem.CURRENT_ID;
    }

    public ReceiptItem(String itemTitle, double itemPrice, int itemQuantity) {
        ReceiptItem.CURRENT_ID++;
        this.id = ReceiptItem.CURRENT_ID;
        
        this.itemTitle = itemTitle;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public int getID() {
        return this.id;
    }
    
    public String getItemTitle() {
        return itemTitle;
    }

    public ReceiptItem setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
        return this;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public ReceiptItem setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public ReceiptItem setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
