package sistema_citas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Informe {

    public void generarInformeClientes() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "SELECT * FROM Cliente";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id_cliente") + ", Nombre: " + rs.getString("nombre") + ", Apellido: " + rs.getString("apellido"));
        }
    }

    public void generarInformeCitas() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "SELECT * FROM Cita";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("ID Cita: " + rs.getInt("id_cita") + ", Fecha: " + rs.getDate("fecha") + ", Servicio: " + rs.getString("servicio"));
        }
    }


}
