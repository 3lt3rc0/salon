package sistema_citas;

import java.sql.Date;
import java.sql.Time;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Editar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Ver Informe de Clientes");
            System.out.println("5. Agregar Empleado");
            System.out.println("6. Editar Empleado");
            System.out.println("7. Eliminar Empleado");
            System.out.println("8. Agregar Cita");
            System.out.println("9. Editar Cita");
            System.out.println("10. Eliminar Cita");
            System.out.println("11. Ver Informe de Citas");
            System.out.println("12. Agregar Servicio");
            System.out.println("13. Editar Servicio");
            System.out.println("14. Eliminar Servicio");
            System.out.println("15. Salir");

            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            try {
                switch (opcion) {
                    case 1:
                        agregarCliente(scanner);
                        break;
                    case 2:
                        editarCliente(scanner);
                        break;
                    case 3:
                        eliminarCliente(scanner);
                        break;
                    case 4:
                        verInformeClientes(scanner);
                        break;
                    case 5:
                        agregarEmpleado(scanner);
                        break;
                    case 6:
                        editarEmpleado(scanner);
                        break;
                    case 7:
                        eliminarEmpleado(scanner);
                        break;
                    case 8:
                        agregarCita(scanner);
                        break;
                    case 9:
                        editarCita(scanner);
                        break;
                    case 10:
                        eliminarCita(scanner);
                        break;
                    case 11:
                        verInformeCitas(scanner);
                        break;
                    case 12:
                        agregarServicio(scanner);
                        break;
                    case 13:
                        editarServicio(scanner);
                        break;
                    case 14:
                        eliminarServicio(scanner);
                        break;
                    case 15:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (SQLException e) {
                System.out.println("Error al interactuar con la base de datos: " + e.getMessage());
            }

        } while (opcion != 15);

        scanner.close();
    }

    // Métodos para interactuar con Clientes
    public static void agregarCliente(Scanner scanner) throws SQLException {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(0, nombre, apellido, telefono, email);
        cliente.guardar();
        System.out.println("Cliente agregado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void editarCliente(Scanner scanner) throws SQLException {
        System.out.print("ID del Cliente a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Nuevo Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Nuevo Email: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(id, nombre, apellido, telefono, email);
        cliente.actualizar();
        System.out.println("Cliente actualizado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void eliminarCliente(Scanner scanner) throws SQLException {
        System.out.print("ID del Cliente a eliminar: ");
        int id = scanner.nextInt();

        Cliente cliente = new Cliente(id, "", "", "", "");
        cliente.eliminar();
        System.out.println("Cliente eliminado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }

    }


    public static void verInformeClientes(Scanner scanner) throws SQLException {
        Informe informe = new Informe();
        informe.generarInformeClientes();

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }




    // Métodos para interactuar con Empleados
    public static void agregarEmpleado(Scanner scanner) throws SQLException {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Empleado empleado = new Empleado(0, nombre, apellido, cargo, telefono);
        empleado.guardar();
        System.out.println("Empleado agregado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void editarEmpleado(Scanner scanner) throws SQLException {
        System.out.print("ID del Empleado a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Nuevo Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Nuevo Teléfono: ");
        String telefono = scanner.nextLine();

        Empleado empleado = new Empleado(id, nombre, apellido, cargo, telefono);
        empleado.actualizar();
        System.out.println("Empleado actualizado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void eliminarEmpleado(Scanner scanner) throws SQLException {
        System.out.print("ID del Empleado a eliminar: ");
        int id = scanner.nextInt();

        Empleado empleado = new Empleado(id, "", "", "", "");
        empleado.eliminar();
        System.out.println("Empleado eliminado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }



    // Métodos para interactuar con Citas
    public static void agregarCita(Scanner scanner) throws SQLException {
        System.out.print("Fecha (año-mes-dia): ");
        Date fecha = Date.valueOf(scanner.nextLine());
        System.out.print("Hora (hora:minuto:segundos): ");
        Time hora = Time.valueOf(scanner.nextLine());
        System.out.print("ID del Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("ID del Empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Servicio: ");
        String servicio = scanner.nextLine();

        Cita cita = new Cita(0, fecha, hora, idCliente, idEmpleado, servicio);
        cita.guardar();
        System.out.println("Cita agregada exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void editarCita(Scanner scanner) throws SQLException {
        System.out.print("ID de la Cita a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nueva Fecha (YYYY-MM-DD): ");
        Date fecha = Date.valueOf(scanner.nextLine());
        System.out.print("Nueva Hora (HH:MM:SS): ");
        Time hora = Time.valueOf(scanner.nextLine());
        System.out.print("Nuevo ID del Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Nuevo ID del Empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo Servicio: ");
        String servicio = scanner.nextLine();

        Cita cita = new Cita(id, fecha, hora, idCliente, idEmpleado, servicio);
        cita.actualizar();
        System.out.println("Cita actualizada exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void eliminarCita(Scanner scanner) throws SQLException {
        System.out.print("ID de la Cita a eliminar: ");
        int id = scanner.nextInt();

        Cita cita = new Cita(id, null, null, 0, 0, "");
        cita.eliminar();
        System.out.println("Cita eliminada exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void verInformeCitas(Scanner scanner) throws SQLException {
        Informe informe = new Informe();
        informe.generarInformeCitas();

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    // Métodos para interactuar con Servicios
    public static void agregarServicio(Scanner scanner) throws SQLException {
        System.out.print("Nombre del Servicio: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción del Servicio: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio del Servicio: ");
        double precio = scanner.nextDouble();

        Servicio servicio = new Servicio(0, nombre, descripcion, precio);
        servicio.guardar();
        System.out.println("Servicio agregado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void editarServicio(Scanner scanner) throws SQLException {
        System.out.print("ID del Servicio a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo Nombre del Servicio: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva Descripción del Servicio: ");
        String descripcion = scanner.nextLine();
        System.out.print("Nuevo Precio del Servicio: ");
        double precio = scanner.nextDouble();

        Servicio servicio = new Servicio(id, nombre, descripcion, precio);
        servicio.actualizar();
        System.out.println("Servicio actualizado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }

    public static void eliminarServicio(Scanner scanner) throws SQLException {
        System.out.print("ID del Servicio a eliminar: ");
        int id = scanner.nextInt();

        Servicio servicio = new Servicio(id, "", "", 0);
        servicio.eliminar();
        System.out.println("Servicio eliminado exitosamente.");

        System.out.print("¿Desea continuar en el menú? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0); // Finalizar el programa
        }
    }


}
