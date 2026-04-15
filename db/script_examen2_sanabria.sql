CREATE DATABASE examen2_sanabria;
USE examen2_sanabria;

CREATE TABLE asegurado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)
);

CREATE TABLE seguro (
    numero VARCHAR(50) PRIMARY KEY,
    fecha_expedicion VARCHAR(50),
    estado VARCHAR(50),
    id_asegurado INT,
    FOREIGN KEY (id_asegurado) REFERENCES asegurado(id)
);

CREATE TABLE seguro_vehiculo (
    numero VARCHAR(50),
    marca VARCHAR(100),
    PRIMARY KEY (numero),
    FOREIGN KEY (numero) REFERENCES seguro(numero)
);

CREATE TABLE seguro_vida (
    numero VARCHAR(50),
    beneficiario VARCHAR(100),
    PRIMARY KEY (numero),
    FOREIGN KEY (numero) REFERENCES seguro(numero)
);
