package hrs.services;

import hrs.models.Transaction;
import hrs.utils.Database;
import java.util.ArrayList;

public class TransactionService {

    public static void createTransaction(int customerId, int roomId, int receiptId, int employeeId) {
        Transaction transaction = new Transaction()
                .setCustomer(customerId)
                .setRoom(roomId)
                .setReceipt(receiptId)
                .setIssuedBy(employeeId);
        Database.transactions.add(transaction);
    }

    public static Transaction getTransactionById(int transactionId) {
        Transaction transaction = Database.transactions.stream()
                .filter(t -> t.getID() == transactionId)
                .findFirst()
                .orElse(null);
        return transaction;
    }

    public static ArrayList<Transaction> getTransactions() {
        return Database.transactions;
    }

    public static void deleteTransactionById(int transactionId) {
        Transaction transaction = TransactionService.getTransactionById(transactionId);
        Database.transactions.remove(transaction);
    }
}
