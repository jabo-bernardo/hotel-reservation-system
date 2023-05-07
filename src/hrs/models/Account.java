package hrs.models;

public class Account {
    public static enum ACCOUNT_TYPE { STAFF, ADMINISTRATION };
    public static int CURRENT_ID = 0;
    private int id;
    private ACCOUNT_TYPE accountType;
    private String username, password;
    
    public Account() {
        Account.CURRENT_ID++;
        this.id = Account.CURRENT_ID;
    }
    
    public int getID() {
        return this.id;
    }

    public ACCOUNT_TYPE getAccountType() {
        return accountType;
    }

    public Account setAccountType(ACCOUNT_TYPE accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }
}
