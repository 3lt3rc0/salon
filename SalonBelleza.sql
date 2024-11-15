CREATE DATABASE SalonBelleza;
USE SalonBelleza;

CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    telefono VARCHAR(15),
    email VARCHAR(50)
);

CREATE TABLE Empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    cargo VARCHAR(50),
    telefono VARCHAR(15)
);

CREATE TABLE Producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion TEXT,
    precio DECIMAL(10, 2),
    stock INT
);

CREATE TABLE Cita (
    id_cita INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    hora TIME,
    id_cliente INT,
    id_empleado INT,
    servicio VARCHAR(50),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
);

CREATE TABLE Cita_Producto (
    id_cita_producto INT AUTO_INCREMENT PRIMARY KEY,
    id_cita INT,
    id_producto INT,
    cantidad INT,
    FOREIGN KEY (id_cita) REFERENCES Cita(id_cita),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);