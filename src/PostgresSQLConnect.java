import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresSQLConnect {

    private static final String url = "jdbc:postgresql://localhost:5432/htmlgen";
    private static final String user = "postgres";
    private static final String password = "8520";

    public Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (connection != null){
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }
        return connection;
    }

}
