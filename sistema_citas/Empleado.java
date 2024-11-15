package sistema_citas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Empleado extends Persona implements Gestionable {
    private String cargo;
    private String telefono;

    public Empleado(int id, String nombre, String apellido, String cargo, String telefono) {
        super(id, nombre, apellido);
        this.cargo = cargo;
        this.telefono = telefono;
    }

    // Getters y setters
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public void guardar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO Empleado (nombre, apellido, cargo, telefono) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.nombre);
        stmt.setString(2, this.apellido);
        stmt.setString(3, this.cargo);
        stmt.setString(4, this.telefono);
        stmt.executeUpdate();
    }

    @Override
    public void actualizar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "UPDATE Empleado SET nombre = ?, apellido = ?, cargo = ?, telefono = ? WHERE id_empleado = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.nombre);
        stmt.setString(2, this.apellido);
        stmt.setString(3, this.cargo);
        stmt.setString(4, this.telefono);
        stmt.setInt(5, this.id);
        stmt.executeUpdate();
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "DELETE FROM Empleado WHERE id_empleado = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, this.id);
        stmt.executeUpdate();
    }
}
