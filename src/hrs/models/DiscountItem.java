package hrs.models;

public class DiscountItem {
    public static int CURRENT_ID = 0;
    private int id;
    
    private String discountTitle;
    private String discountDescription;
    private int discountPercentage;
    
    public DiscountItem() {
        DiscountItem.CURRENT_ID++;
        this.id = DiscountItem.CURRENT_ID;
    }

    public DiscountItem(String discountTitle, String discountDescription, int discountPercentage) {
        this.discountTitle = discountTitle;
        this.discountDescription = discountDescription;
        this.discountPercentage = discountPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscountTitle() {
        return discountTitle;
    }

    public void setDiscountTitle(String discountTitle) {
        this.discountTitle = discountTitle;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    
    
}
