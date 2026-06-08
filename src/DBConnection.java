import java.sql.Connection;
import java.sql.DriverManager;
/*
 * DBConnection Class
 * This class is responsible for establishing
 * a connection between the Java application
 * and the MySQL database using JDBC.
 */
public class DBConnection {
    // Database URL
    // localhost -> MySQL server running on local machine
    // 3306      -> Default MySQL port number
    // banking_db -> Database name
    private static final String URL ="jdbc:mysql://localhost:3306/banking_db";
    // MySQL username
    private static final String USER = "root";
    // MySQL password
    private static final String PASSWORD ="jaya@413";
    /*
     * Method: getConnection()
     * Loads the MySQL JDBC Driver and
     * returns a database connection object.
     */
    public static Connection getConnection() throws Exception {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Create and return database connection
        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}