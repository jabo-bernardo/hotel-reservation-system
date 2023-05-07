package hrs.models;

public class Transaction {
    public static int CURRENT_ID;
    private int id;
    private int issuedBy;
    private int room;
    private int receipt;
    private int customer;
    
    public Transaction() {
        Transaction.CURRENT_ID++;
        this.id = Transaction.CURRENT_ID;
    }
    
    public int getID() {
        return this.id;
    }

    public int getIssuedBy() {
        return issuedBy;
    }

    public Transaction setIssuedBy(int issuedBy) {
        this.issuedBy = issuedBy;
        return this;
    }

    public int getRoom() {
        return room;
    }

    public Transaction setRoom(int room) {
        this.room = room;
        return this;
    }

    public int getReceipt() {
        return receipt;
    }

    public Transaction setReceipt(int receipt) {
        this.receipt = receipt;
        return this;
    }

    public int getCustomer() {
        return customer;
    }

    public Transaction setCustomer(int customer) {
        this.customer = customer;
        return this;
    }
}
