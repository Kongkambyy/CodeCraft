import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Metode som opretter forbindelse til vores database og returnere connection objektet.
    public static Connection getConnection() {
        Properties props = new Properties();
        try {

            // herunder indlæser koden properties fra den lokale tekstfil
            FileInputStream input = new FileInputStream("db_config.properties");
            props.load(input);
            input.close();

            // Herunder hentes oplysningerne fra tekstfilen
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // DriverManager laver forbindelse til databasen
            return DriverManager.getConnection(url, user, password);

        } catch (IOException e) {
            // Exception handling når properties filen læses
            System.err.println("Fejl ved indlæsning af konfigurationsfil: " + e.getMessage());
        } catch (SQLException e) {
            // Exception handling ved database forbindelse
            System.err.println("Fejl ved oprettelse af databaseforbindelse: " + e.getMessage());
        }
        return null; // Returner null, hvis forbindelsen mislykkes.
    }

    // Test forbindelse til databasen
    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Forbindelse oprettet med succes!");
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Fejl ved lukning af forbindelse: " + e.getMessage());
            }
        } else {
            System.out.println("Kunne ikke oprette forbindelse til databasen.");
        }
    }
}
