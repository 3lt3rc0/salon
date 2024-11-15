package sistema_citas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

public class Cita implements Gestionable {
    private int idCita;
    private Date fecha;
    private Time hora;
    private int idCliente;
    private int idEmpleado;
    private String servicio;

    public Cita(int idCita, Date fecha, Time hora, int idCliente, int idEmpleado, String servicio) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.servicio = servicio;
    }

    // Getters y setters
    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHora() { return hora; }
    public void setHora(Time hora) { this.hora = hora; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

    // Implementación de los métodos de la interfaz Gestionable
    @Override
    public void guardar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "INSERT INTO Cita (fecha, hora, id_cliente, id_empleado, servicio) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDate(1, this.fecha);
        stmt.setTime(2, this.hora);
        stmt.setInt(3, this.idCliente);
        stmt.setInt(4, this.idEmpleado);
        stmt.setString(5, this.servicio);
        stmt.executeUpdate();
    }

    @Override
    public void actualizar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "UPDATE Cita SET fecha = ?, hora = ?, id_cliente = ?, id_empleado = ?, servicio = ? WHERE id_cita = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDate(1, this.fecha);
        stmt.setTime(2, this.hora);
        stmt.setInt(3, this.idCliente);
        stmt.setInt(4, this.idEmpleado);
        stmt.setString(5, this.servicio);
        stmt.setInt(6, this.idCita);
        stmt.executeUpdate();
    }

    @Override
    public void eliminar() throws SQLException {
        Connection conn = ConexionDB.getConexion();
        String sql = "DELETE FROM Cita WHERE id_cita = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, this.idCita);
        stmt.executeUpdate();
    }
}
