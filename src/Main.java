import java.util.Scanner;
/*
 * Main Class
 * This is the entry point of the Banking System application.
 * It accepts customer details from the user,
 * validates the customer ID, and performs
 * customer insertion and display operations.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Scanner object for reading user input
            Scanner sc = new Scanner(System.in);
            // Create CustomerDAO object
            // to perform database operations
            CustomerDAO dao =new CustomerDAO();
            // Display application title
            System.out.println(
                    "===== Banking System ====="
            );
            // Accept customer ID from user
            System.out.print(
                    "Enter Customer ID: "
            );
            int id = sc.nextInt();
           // Consume newline character
            sc.nextLine();
            /*
             * Check whether the entered
             * customer ID already exists
             * in the database.
             */
            if (dao.customerExists(id)) {
                System.out.println(
                        "Customer ID already exists!"
                );
                sc.close();
                return;
            }
            // Accept customer name
            System.out.print(
                    "Enter Customer Name: "
            );
            String name =
                    sc.nextLine();
            // Accept initial account balance
            System.out.print(
                    "Enter Initial Balance: "
            );
           double balance =
                    sc.nextDouble();
            /*
             * Create Customer object
             * using entered details.
             */
            Customer customer =
                    new Customer(
                            id,
                            name,
                            balance
                    );
            /*
             * Add customer record
             * into the database.
             */
            dao.addCustomer(customer);
            // Display all customer records
            System.out.println(
                    "\nCustomer Records:"
            );

            dao.viewCustomers();
            // Close Scanner object
            sc.close();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}