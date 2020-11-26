DROP DATABASE videojuegos;
CREATE DATABASE videojuegos;
USE videojuegos;

CREATE TABLE productos(
clave int UNIQUE,
nombre varchar(50),
genero varchar(50),
plataforma varchar(50),
precio varchar(50)
);

CREATE TABLE proveedores(
clave int UNIQUE,
nombre varchar(50),
direccion varchar(50),
email varchar(50),
paginaWeb varchar(50)
);

CREATE TABLE clientes(
clave int UNIQUE,
nombre varchar(50),
email varchar(50),
ciudad varchar(50),
rfc varchar(50)
);

CREATE TABLE usuarios(
clave int UNIQUE,
nombre varchar(50),
usuario varchar(50),
email varchar(50),
telefono varchar(50)
);

insert into existencias values (1,"prueba","accion","PS5","$2400");
select * from existencias;

SET GLOBAL time_zone = '-6:00';