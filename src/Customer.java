/*
 * Customer Class
 *
 * This class represents a customer in the Banking System.
 * It stores customer details such as ID, name, and account balance.
 */
public class Customer {
    // Unique customer ID
    private int id;
    // Customer name
    private String name;
    // Customer account balance
    private double balance;
    /*
     * Parameterized Constructor
     *
     * Initializes customer details when a Customer object is created.
     */
    public Customer(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    /*
     * Getter Method
     * Returns the customer ID.
     */
    public int getId() {
        return id;
    }
    /*
     * Getter Method
     * Returns the customer name.
     */
    public String getName() {
        return name;
    }
    /*
     * Getter Method
     * Returns the customer account balance.
     */
    public double getBalance() {
        return balance;
    }
}