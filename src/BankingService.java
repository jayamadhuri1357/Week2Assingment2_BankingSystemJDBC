import java.sql.Connection;
import java.sql.PreparedStatement;
/*
 * BankingService Class
 * This class handles banking-related operations.
 * It demonstrates JDBC Transaction Management by
 * transferring money from one customer account
 * to another.
 */
public class BankingService {
    /*
     * Method: transferMoney()
     * senderId   -> Customer sending money
     * receiverId -> Customer receiving money
     * amount     -> Amount to transfer
     */
    public void transferMoney(
            int senderId,
            int receiverId,
            double amount) {
        try {
            // Establish database connection
            Connection con =
                    DBConnection.getConnection();
            // Disable auto-commit mode
            // so that both operations execute
            // as a single transaction
            con.setAutoCommit(false);
            /*
             * Debit amount from sender account
             */
            String debitSql =
                    "UPDATE customers SET balance = balance - ? WHERE id = ?";
            PreparedStatement debit =
                    con.prepareStatement(debitSql);
            debit.setDouble(1, amount);
            debit.setInt(2, senderId);
            debit.executeUpdate();
            /*
             * Credit amount to receiver account
             */
            String creditSql =
                    "UPDATE customers SET balance = balance + ? WHERE id = ?";
            PreparedStatement credit =
                    con.prepareStatement(creditSql);

            credit.setDouble(1, amount);
            credit.setInt(2, receiverId);
            credit.executeUpdate();
            /*
             * Commit transaction
             * Both debit and credit operations
             * are permanently saved to the database.
             */
            con.commit();
            System.out.println(
                    "Transaction Successful"
            );
            // Close database connection
            con.close();
        } catch (Exception e) {
            /*
             * If any error occurs,
             * transaction fails.
             */
            System.out.println(
                    "Transaction Failed"
            );
            e.printStackTrace();
        }
    }
}