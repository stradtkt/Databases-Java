import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        //Connect to the JDBC jar file to connect to the database
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
//            prevents the auto commit
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Joe', 5145541231, 'joe@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Bill', 5145555555, 'bill@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Zoe', 0915541222, 'zoe@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Moe', 5222222222, 'moe@gmail.com')");
//            statement.execute("UPDATE contacts SET phone=5555555555 WHERE name='Kevin'");
            statement.execute("DELETE FROM contacts WHERE name='Kevin'");
            statement.close();
            conn.close();
        } catch(SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
