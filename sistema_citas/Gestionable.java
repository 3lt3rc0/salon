package sistema_citas;

import java.sql.SQLException;

public interface Gestionable {
    void guardar() throws SQLException;
    void actualizar() throws SQLException;
    void eliminar() throws SQLException;
}
