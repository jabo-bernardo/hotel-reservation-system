package hrs.models;

public class ReceiptItem {
    public static int CURRENT_ID = 0;
    private int id;
    private String itemTitle;
    private String itemDescription;
    private double itemPrice;
    
    public ReceiptItem() {
        ReceiptItem.CURRENT_ID++;
        this.id = ReceiptItem.CURRENT_ID;
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
}
