package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection con = null;
    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }

    public void connect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=KaraokeAPLUS"; 
        String user = "sa";
<<<<<<< HEAD
        String password = "sa031103";
=======
        String password = "0934119430";
>>>>>>> a1b72c07957d765a32bfa1fb2c36f88e34d704e7
        con = DriverManager.getConnection(url, user, password);
    }

    public void disconnect() {
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static Connection getConnection() {
        return con;
    }

    public boolean isConnected() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

  
}
