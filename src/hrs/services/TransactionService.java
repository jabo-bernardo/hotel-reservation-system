package hrs.services;

import hrs.models.Transaction;
import hrs.utils.Constants;
import hrs.utils.Database;
import java.util.ArrayList;
import java.util.Date;

public class TransactionService {

    public static int createTransaction(
            int customerId,
            int roomId,
            int employeeId,
            int amenitiesId,
            int receiptId,
            Date checkInDate,
            Date checkOutDate,
            boolean isFullPayment
    ) {
        Transaction transaction = new Transaction()
                .setCustomer(customerId)
                .setRoom(roomId)
                .setIssuedBy(employeeId)
                .setCheckInDateTime(checkInDate)
                .setCheckOutDateTime(checkOutDate)
                .setAmenities(amenitiesId)
                .setIsFullPaymentMethod(isFullPayment)
                .setReceipt(receiptId);
                
        Database.transactions.add(transaction);
        return transaction.getID();
    }

    public static Transaction getTransactionById(int transactionId) {
        Transaction transaction = Database.transactions.stream()
                .filter(t -> t.getID() == transactionId)
                .findFirst()
                .orElse(null);
        return transaction;
    }
    
    public static void checkoutTransactionById(int transactionId) {
        Transaction transaction = getTransactionById(transactionId);
        transaction.setIsDone(true);
    }

    public static ArrayList<Transaction> getTransactions() {
        return Database.transactions;
    }

    public static void deleteTransactionById(int transactionId) {
        Transaction transaction = TransactionService.getTransactionById(transactionId);
        Database.transactions.remove(transaction);
    }
    
    public static String getTransactionStatus(int transactionId) {
        Date currentDate = new Date();
        Transaction transaction = getTransactionById(transactionId);
        if (transaction.isIsDone())
            return "Done";
        if (currentDate.before(transaction.getCheckInDateTime()))
            return Constants.RESERVED;
        if (currentDate.after(transaction.getCheckOutDateTime()) && !transaction.isIsDone())
            return Constants.OVERSTAYING;
        return "In Progress";
    }
}
