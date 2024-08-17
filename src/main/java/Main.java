import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost:3306/test1";
        String DB_USER = "root";
        String DB_PASSWORD = "root";


        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement st = conn.prepareStatement("INSERT INTO izvodjac (id, nazivIzvodjaca, tipIzvodjaca, godinaFormacije, godinaRaspada, zvanicanSajt) VALUES (?, ?, ?, ?, ?, ?)")) {

            st.setInt(1, 1);
            st.setString(2, "John Bon Jovi");
            st.setString(3, "Band");
            st.setInt(4, 1980);
            st.setNull(5, 2000);
            st.setString(6, "https://www.bonjovi.com/");

            int rows = st.executeUpdate();
            if (rows > 0) {
                System.out.println("User successfully added");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greška u konekciji sa bazom:\n" + ex.getMessage());
        }
    }

}