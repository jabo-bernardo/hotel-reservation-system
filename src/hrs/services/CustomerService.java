package hrs.services;

import hrs.models.Customer;
import hrs.utils.Database;

public class CustomerService {
    public static int createCustomer(String firstName, String lastName, String phoneNumber) {
        Customer customer = new Customer();
        customer
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber);
        return customer.getID();
    }
    
    public static Customer getCustomerById(int id) {
        Customer customer = Database.customers.stream()
                                .filter(cus -> cus.getID() == id)
                                .findFirst()
                                .orElse(null);
        return customer;
    }
    
    public static void updateCustomerById() {
        // TODO 
    }
    
    public static void deleteCustomerById(int id) {
        Customer customer = CustomerService.getCustomerById(id);
        if (customer == null) return;
        Database.customers.remove(customer);
    }
    
    public static void getBookings() {
        // TODO
    }
}
