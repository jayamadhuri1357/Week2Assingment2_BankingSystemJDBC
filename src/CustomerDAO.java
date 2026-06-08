import java.sql.*;
/*
 * CustomerDAO Class
 *
 * DAO stands for Data Access Object.
 * This class is responsible for performing
 * CRUD (Create, Read, Update, Delete) operations
 * on the customers table using JDBC.
 */
public class CustomerDAO {
    /*
     * Method: addCustomer()
     * Inserts a new customer record into
     * the customers table.
     */
    public void addCustomer(Customer customer)
            throws Exception {
        // SQL query for inserting customer data
        String sql ="INSERT INTO customers VALUES(?,?,?)";
        // Establish database connection
        Connection con = DBConnection.getConnection();
        // Create PreparedStatement object
        PreparedStatement ps = con.prepareStatement(sql);
        // Set values for query parameters
        ps.setInt(1, customer.getId());
        ps.setString(2, customer.getName());
        ps.setDouble(3, customer.getBalance());
        // Execute insert query
        ps.executeUpdate();
        System.out.println("Customer Added");
        // Close connection
        con.close();
    }
    /*
     * Method: customerExists()
    *
     * Checks whether a customer ID
     * already exists in the database.
     * Returns:
     * true  -> customer exists
     * false -> customer does not exist
     */
    public boolean customerExists(int id)
            throws Exception {
        // Establish database connection
        Connection con = DBConnection.getConnection();
        // SQL query to search customer by ID
        String sql =  "SELECT * FROM customers WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        // Set customer ID
        ps.setInt(1, id);
        // Execute query
        ResultSet rs =  ps.executeQuery();
        // Check if record exists
        boolean exists = rs.next();
        // Close connection
        con.close();
        return exists;
    }
    /*
     * Method: viewCustomers()
     *
     * Retrieves and displays all
     * customer records from the database.
     */
    public void viewCustomers()
            throws Exception {
        // Establish database connection
        Connection con =   DBConnection.getConnection();
        // Create Statement object
        Statement st = con.createStatement();
        // Execute SELECT query
        ResultSet rs =st.executeQuery("SELECT * FROM customers");
        // Display records one by one
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " "
                            + rs.getString("name") + " "
                            + rs.getDouble("balance")
            );
        }
        // Close connection
        con.close();
    }
    /*
     * Method: updateBalance()
     * Updates the balance of a customer
     * using customer ID.
     */
    public void updateBalance(int id,double balance)
            throws Exception {
        // SQL query for updating balance
        String sql ="UPDATE customers SET balance=? WHERE id=?";
        // Establish database connection
        Connection con =  DBConnection.getConnection();
        // Create PreparedStatement object
        PreparedStatement ps =con.prepareStatement(sql);
        // Set updated values
        ps.setDouble(1, balance);
        ps.setInt(2, id);
        // Execute update query
        ps.executeUpdate();
        System.out.println("Customer Updated");
        // Close connection
        con.close();
    }
    /*
     * Method: deleteCustomer()
     * Deletes a customer record
     * using customer ID.
     */
    public void deleteCustomer(int id)
            throws Exception {
        // SQL query for deleting customer
        String sql ="DELETE FROM customers WHERE id=?";

        // Establish database connection
        Connection con =DBConnection.getConnection();
        // Create PreparedStatement object
        PreparedStatement ps = con.prepareStatement(sql);
        // Set customer ID
        ps.setInt(1, id);
        // Execute delete query
        ps.executeUpdate();
        System.out.println("Customer Deleted");
        // Close connection
        con.close();
    }
}