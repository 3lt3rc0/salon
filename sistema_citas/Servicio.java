package sistema_citas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Servicio implements Gestionable {
    private int idServicio;
    private String nombre;
    private String descripcion;
    private double precio;

    public Servicio(int idServicio, String nombre, String descripcion, double precio) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y setters
    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Implementación de los métodos de la interfaz Gestionable
    @Override
    public void guardar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO Producto (nombre, descripcion, precio) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.nombre);
        stmt.setString(2, this.descripcion);
        stmt.setDouble(3, this.precio);
        stmt.executeUpdate();
    }

    @Override
    public void actualizar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "UPDATE Producto SET nombre = ?, descripcion = ?, precio = ? WHERE id_producto = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.nombre);
        stmt.setString(2, this.descripcion);
        stmt.setDouble(3, this.precio);
        stmt.setInt(4, this.idServicio);
        stmt.executeUpdate();
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "DELETE FROM Producto WHERE id_producto = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, this.idServicio);
        stmt.executeUpdate();
    }
}
