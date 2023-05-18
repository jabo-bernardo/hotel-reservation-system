package hrs.models;

import java.util.Date;

public class Transaction {
    public static int CURRENT_ID;
    private int id;
    private int issuedBy;
    private int room;
    private int receipt;
    private int customer;
    private int amenities;
    private Date checkInDateTime;
    private Date checkOutDateTime;
    private boolean isFullPaymentMethod;
    public Date transactionDate;
    private boolean isDone;
    
    public Transaction() {
        Transaction.CURRENT_ID++;
        this.id = Transaction.CURRENT_ID;
        transactionDate = new Date();
    }
    
    public int getID() {
        return this.id;
    }

    public int getIssuedBy() {
        return issuedBy;
    }

    public Date getCheckInDateTime() {
        return checkInDateTime;
    }

    public Transaction setCheckInDateTime(Date checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
        return this;
    }

    public Date getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public Transaction setCheckOutDateTime(Date checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
        return this;
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
    
    public int getAmenities() {
        return amenities;
    }
    
    public Transaction setAmenities(int amenities) {
        this.amenities = amenities;
        return this;
    }

    public boolean isIsFullPaymentMethod() {
        return isFullPaymentMethod;
    }

    public Transaction setIsFullPaymentMethod(boolean isFullPaymentMethod) {
        this.isFullPaymentMethod = isFullPaymentMethod;
        return this;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public Transaction setIsDone(boolean isDone) {
        this.isDone = isDone;
        return this;
    }
    
    
}
