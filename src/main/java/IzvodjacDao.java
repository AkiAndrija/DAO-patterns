import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IzvodjacDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public List<Izvodjac> dohvatiIzvodjace() {
        List<Izvodjac> izvodjaci = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM izvodjac")) {
            while (resultSet.next()) {
                Izvodjac izvodjac = new Izvodjac();
                izvodjac.setID(resultSet.getInt("id"));
                izvodjac.setNazivIzvodjaca(resultSet.getString("nazivIzvodjaca"));
                izvodjac.setTipIzvodjaca(resultSet.getString("tipIzvodjaca"));
                izvodjac.setGodinaFormacije(resultSet.getInt("godinaFormacije"));
                izvodjac.setGodinaRaspada(resultSet.getInt("godinaRaspada"));
                izvodjac.setZvanicanSajt(resultSet.getString("zvanicanSajt"));
                izvodjaci.add(izvodjac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return izvodjaci;
    }

    public void dodajIzvodjaca(Izvodjac izvodjac) {
        String sql = "INSERT INTO izvodjac (nazivIzvodjaca, tipIzvodjaca, godinaFormacije, godinaRaspada, zvanicanSajt) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, izvodjac.getNazivIzvodjaca());
            statement.setString(2, izvodjac.getTipIzvodjaca());
            statement.setInt(3, izvodjac.getGodinaFormacije());
            statement.setInt(4, izvodjac.getGodinaRaspada());
            statement.setString(5, izvodjac.getZvanicanSajt());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void azurirajIzvodjaca(Izvodjac izvodjac) {
        String sql = "UPDATE izvodjac SET nazivIzvodjaca = ?, tipIzvodjaca = ?, godinaFormacije = ?, godinaRaspada = ?, zvanicanSajt = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, izvodjac.getNazivIzvodjaca());
            statement.setString(2, izvodjac.getTipIzvodjaca());
            statement.setInt(3, izvodjac.getGodinaFormacije());
            statement.setInt(4, izvodjac.getGodinaRaspada());
            statement.setString(5, izvodjac.getZvanicanSajt());
            statement.setInt(6, izvodjac.getID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void obrisiIzvodjaca(int ID) {
        String sql = "DELETE FROM izvodjac WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
