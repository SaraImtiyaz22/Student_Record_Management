import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection{
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:students.db";
            conn = DriverManager.getConnection(url);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}