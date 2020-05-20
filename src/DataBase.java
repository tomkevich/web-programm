import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/servlet";
        connection = DriverManager.getConnection(url, "postgres", "root");
        return connection;
    }

    public static void createUser(String login, String password) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users values (?,?)");
        statement.setString(1, login);
        statement.setString(2, password);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    public static void sendFile(InputStream file) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into files values(?)");
        statement.setBinaryStream(1, file); 
        statement.executeUpdate();
        connection.close();

    }
}
