package sistema_citas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente extends Persona implements Gestionable {
    private String telefono;
    private String email;

    public Cliente(int id, String nombre, String apellido, String telefono, String email) {
        super(id, nombre, apellido);
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y setters
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Implementación de los métodos de la interfaz Gestionable
    @Override
    public void guardar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO Cliente (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.nombre);
        stmt.setString(2, this.apellido);
        stmt.setString(3, this.telefono);
        stmt.setString(4, this.email);
        stmt.executeUpdate();
    }

    @Override
    public void actualizar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "UPDATE Cliente SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE id_cliente = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.nombre);
        stmt.setString(2, this.apellido);
        stmt.setString(3, this.telefono);
        stmt.setString(4, this.email);
        stmt.setInt(5, this.id);
        stmt.executeUpdate();
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, this.id);
        stmt.executeUpdate();
    }
}
