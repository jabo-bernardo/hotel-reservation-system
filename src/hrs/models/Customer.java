package hrs.models;

public class Customer {
    public static int CURRENT_ID = 0;
    private int id;
    private String firstName, lastName;
    private String phoneNumber;
    
    public Customer() {
        Customer.CURRENT_ID++;
        this.id = Customer.CURRENT_ID;
    }   
    
    public int getID() {
        return this.id;
    }
    
    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    
    public Customer setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
