package sistema_citas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection conexion;
    private static final String URL = "jdbc:mysql://localhost:3306/SalonBelleza";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "root912";

    private ConexionDB() {}

    public static Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        }
        return conexion;
    }
}
