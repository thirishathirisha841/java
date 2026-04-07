import java.sql.*;

public class app {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world", "root", "password"
            );

            Statement stmt = con.createStatement();

            String query = "SELECT Name FROM country WHERE population < 10000";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}