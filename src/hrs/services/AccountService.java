package hrs.services;

import hrs.models.Account;
import hrs.models.Account.ACCOUNT_TYPE;
import hrs.utils.Constants;
import hrs.utils.Database;

public class AccountService {
    
    
    public static int createAccount(String username, String password, ACCOUNT_TYPE accountType) {
        Account account = new Account();
        account
                .setUsername(username)
                .setPassword(password)
                .setAccountType(accountType);
        Database.accounts.add(account);
        return account.getID();
    }
    
    public static Account getAccountById(int id) {
        Account account = Database.accounts.stream()
                .filter(acc -> acc.getID() == id)
                .findFirst()
                .orElse(null);
        return account;
    }
    
    public static Account getAccountByUsername(String username) {
        Account account = Database.accounts.stream()
                .filter(acc -> acc.getUsername().equals(username))
                .findFirst()
                .orElse(null);
        return account;
    }
    
    public static void updateAccountPasswordById(int id, String newPassword) {
        Account account = AccountService.getAccountById(id);
        if (account == null) return;
        account.setPassword(newPassword);
    }
    
    public static void deleteAccountById(int id) {
        Account account = AccountService.getAccountById(id);
        if (account == null) return;
        Database.accounts.remove(account);
    }
}
